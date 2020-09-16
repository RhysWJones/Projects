using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Encodings.Web;
using System.Threading.Tasks;
using AnimalCareSystem.Data;
using AnimalCareSystem.Models;
using AnimalCareSystem.Repositories;
using AnimalCareSystem.ViewModels;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Identity.UI.Services;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.WebUtilities;

namespace AnimalCareSystem.Controllers
{
    [Route("account")]
    public class AccountController : Controller
    {
        private readonly UserManager<ApplicationUser> _userManager;
        private readonly SignInManager<ApplicationUser> _signInManager;
        private readonly ApplicationDbContext _dbContext;
        private readonly AccountRepository _accountRepository;
        private readonly IEmailSender _emailSender;

        public AccountController(UserManager<ApplicationUser> userManager, SignInManager<ApplicationUser> signInManager, ApplicationDbContext dbContext, IEmailSender emailSender)
        {
            _userManager = userManager;
            _signInManager = signInManager;
            _dbContext = dbContext;
            _accountRepository = new AccountRepository(userManager, signInManager, dbContext);
            _emailSender = emailSender;
        }

        [HttpGet, Route("login")]
        public IActionResult Login()
        {
            return View(new LoginViewModel());
        }

        [HttpPost, Route("login")]
        public async Task<IActionResult> Login(LoginViewModel loginViewModel)
        {
            if (ModelState.IsValid)
            {
                KeyValuePair<string, object> loginKeyValuePair = new KeyValuePair<string, object>("login", loginViewModel);

                Microsoft.AspNetCore.Identity.SignInResult success = (Microsoft.AspNetCore.Identity.SignInResult)await _accountRepository.Get(loginKeyValuePair);

                if (success.Succeeded)
                {
                    TempData["successmessage"] = "Logged in Successfully!";
                    return RedirectToAction("Index", "Home");
                }
                else if (success.IsNotAllowed)
                {
                    ModelState.AddModelError("", "Please verify your email.");
                    return View();
                }
            }
            return View();
        }

        [HttpGet, Route("register")]
        public IActionResult Register()
        {
            return View(new RegisterViewModel());
        }

        [HttpPost, Route("register")]
        public async Task<IActionResult> Register(RegisterViewModel registerViewModel)
        {
            if (ModelState.IsValid)
            {
                KeyValuePair<string, object> registerKeyValuePair = new KeyValuePair<string, object>("register", registerViewModel);

                ApplicationUser user = (ApplicationUser)await _accountRepository.Create(registerKeyValuePair);

                if (user != null)
                {
                    KeyValuePair<string, object> emailConfirmTokenKeyValuePair = new KeyValuePair<string, object>("getEmailConfirmationToken", user);

                    string code = (string)await _accountRepository.Get(emailConfirmTokenKeyValuePair);
                    code = WebEncoders.Base64UrlEncode(Encoding.UTF8.GetBytes(code));
                    string callbackUrl = Url.Action(
                        "ConfirmEmail",
                        "Account",
                        values: new { userId = user.Id, code = code },
                        protocol: Request.Scheme);

                    await _emailSender.SendEmailAsync("j016984c@student.staffs.ac.uk", "Confirm your email",
                        $"Please confirm your account by <a href='{HtmlEncoder.Default.Encode(callbackUrl)}'>clicking here</a>.");

                    if (_userManager.Options.SignIn.RequireConfirmedAccount)
                    {
                        TempData["successmessage"] = "Registered Successfully!";
                        return View("RegisterConfirmation", new { email = user.Email });
                    }

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

        [HttpGet, Route("registerConfirmation")]
        public IActionResult RegisterConfirmation(string email)
        {
            if (email == null)
            {
                return RedirectToAction("Index", "Home");
            }

            return View();
        }

        [HttpGet, Route("confirmEmail")]
        public async Task<IActionResult> ConfirmEmail(string userId, string code)
        {
            if (userId == null || code == null)
            {
                TempData["errormessage"] = "Email Confirmation Failed.";
                return RedirectToAction("Index", "Home");
            }

            KeyValuePair<string, object> getUserByIdKeyValuePair = new KeyValuePair<string, object>("getUserById", userId);

            ApplicationUser user = (ApplicationUser)await _accountRepository.Get(getUserByIdKeyValuePair);
            if (user == null)
            {
                return NotFound($"Unable to load user with ID '{userId}'.");
            }

            code = Encoding.UTF8.GetString(WebEncoders.Base64UrlDecode(code));
            Dictionary<string, object> confirmEmailDictionary = new Dictionary<string, object>();
            confirmEmailDictionary.Add("user", user);
            confirmEmailDictionary.Add("code", code);
            KeyValuePair<string, object> confirmEmailValuePair = new KeyValuePair<string, object>("confirmEmail", confirmEmailDictionary);

            IdentityResult result = (IdentityResult)await _accountRepository.Update(confirmEmailValuePair);

            if (result.Succeeded)
            {
                TempData["emailconfirmed"] = "Thank you for confirming your email.";
                RedirectToAction("Index", "Home");
            }
            else
            {
                TempData["emailconfirmerror"] = "Error confirming your email.";
                RedirectToAction("Index", "Home");
            }

            return View();
        }
    }
}
