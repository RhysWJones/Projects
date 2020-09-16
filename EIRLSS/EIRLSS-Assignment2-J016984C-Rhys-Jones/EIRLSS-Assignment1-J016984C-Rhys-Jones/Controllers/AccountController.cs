using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Controllers
{
    [Route("account")]
    public class AccountController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        private readonly UserManager<ApplicationUser> _userManager;
        private readonly SignInManager<ApplicationUser> _signInManager;
        private String Email;
        private String Password;
        private bool RememberMe;
        private ApplicationDbContext DbContext;

        public AccountController(ILogger<HomeController> logger, UserManager<ApplicationUser> userManager, SignInManager<ApplicationUser> signInManager, ApplicationDbContext dbContext)
        {
            _logger = logger;
            _userManager = userManager;
            _signInManager = signInManager;
            DbContext = dbContext;
        }

        [HttpGet, Route("login")]
        public async Task<IActionResult> Login()
        {
            return View(new LoginViewModel());
        }

        [HttpPost, Route("login")]
        public async Task<IActionResult> Login(LoginViewModel loginViewModel)
        {
            ViewResult viewResult = View();
            if (ModelState.IsValid)
            {
                Email = loginViewModel.Email;
                Password = loginViewModel.Password;
                RememberMe = loginViewModel.RememberMe;

                Microsoft.AspNetCore.Identity.SignInResult loginResult = (Microsoft.AspNetCore.Identity.SignInResult)await CommandFactory.CreateCommand(CommandFactory.LOGIN, Email, Password, RememberMe, _signInManager).Execute();

                if (loginResult.Succeeded)
                {
                    TempData["successmessage"] = "Logged in Successfully!";
                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    ModelState.AddModelError("", "Login Failure. Please check your login details.");
                    return View();
                }
            }
            return viewResult;
        }

        [HttpGet, Route("register")]
        public async Task<IActionResult> Register()
        {
            return View(new RegisterViewModel());
        }


        [HttpPost, Route("register")]
        public async Task<IActionResult> Register(RegisterViewModel registerViewModel)
        {
            if (ModelState.IsValid)
            {
                ApplicationUser newUser = ConvertToApplicationUser(registerViewModel);

                IdentityResult registrationResult = (IdentityResult)await CommandFactory.CreateCommand(CommandFactory.REGISTER, newUser, _userManager, _signInManager).Execute();

                if (registrationResult.Succeeded)
                {
                    TempData["successmessage"] = "Registered Successfully!";
                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    TempData["errormessage"] = "Registration Failure";
                    return View();
                }
            }
            return View();
        }

        public async Task<IActionResult> BlacklistUser(string? id)
        {
            IActionResult authenticationResult = await AuthenticateUserLogin(true);
            if (authenticationResult != null)
            {
                return authenticationResult;
            }

            string userId = (string)id;

            int userBlacklisted = (int)await CommandFactory.CreateCommand(CommandFactory.BLACKLIST_USER, userId, DbContext, _userManager).Execute();
            if(userBlacklisted < 1 || userBlacklisted > 1)
            {
                TempData["errormessage"] = "Failed To Blacklist User!";
                return RedirectToAction("Index", "Home");
            }
            else
            {
                TempData["successmessage"] = "User Blacklisted!";
                return RedirectToAction("Index", "Home");
            }
        }

        public async Task<IActionResult> AuthenticateUserLogin(bool adminRequired)
        {
            ApplicationUser CurrentUser = await _userManager.GetUserAsync(HttpContext.User);
            bool IsAdmin = false;

            if (CurrentUser == null)
            {
                TempData["errormessage"] = "You need to be logged in to book a vehicle." + Environment.NewLine + " If you do not have an account, please navigate to the registration page by clicking on 'Register' at the top of the screen.";
                return RedirectToAction("Login", "Account");
            }
            else
            {
                IsAdmin = await _userManager.IsInRoleAsync(CurrentUser, "Admin");
            }
            if (adminRequired && IsAdmin == false)
            {
                TempData["errormessage"] = "You require admin privileges to view that page.";
                return RedirectToAction("Index", "Home");
            }
            else return null;
        }

        public ApplicationUser ConvertToApplicationUser(RegisterViewModel registerViewModel)
        {
            ApplicationUser newUser = new ApplicationUser();
            newUser.UserName = registerViewModel.Email;
            newUser.Email = registerViewModel.Email;
            newUser.PasswordHash = registerViewModel.Password;
            newUser.PhoneNumber = registerViewModel.PhoneNumber;
            newUser.Forename = registerViewModel.Forename;
            newUser.Surname = registerViewModel.Surname;
            newUser.AddressLine1 = registerViewModel.AddressLine1;
            newUser.AddressLine2 = registerViewModel.AddressLine2;
            newUser.Postcode = registerViewModel.Postcode;
            newUser.DateOfBirth = registerViewModel.DateOfBirth;
            newUser.Blacklisted = false;
            newUser.LicenseNumber = registerViewModel.LicenseNumber;
            return newUser;
        }

        [Route("error")]
        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}