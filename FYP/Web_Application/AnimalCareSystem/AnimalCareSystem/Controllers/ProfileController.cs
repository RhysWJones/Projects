using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using AnimalCareSystem.Data;
using AnimalCareSystem.Models;
using AnimalCareSystem.Repositories;
using AnimalCareSystem.ViewModels;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Identity.UI.Services;
using Microsoft.AspNetCore.Mvc;

namespace AnimalCareSystem.Controllers
{
    [Route("profile")]
    public class ProfileController : Controller
    {
        private readonly UserManager<ApplicationUser> _userManager;
        private readonly SignInManager<ApplicationUser> _signInManager;
        private readonly ApplicationDbContext _dbContext;
        private readonly ProfileRepository _profileRepository;
        private readonly IEmailSender _emailSender;

        public ProfileController(UserManager<ApplicationUser> userManager, SignInManager<ApplicationUser> signInManager, ApplicationDbContext dbContext, IEmailSender emailSender)
        {
            _userManager = userManager;
            _signInManager = signInManager;
            _dbContext = dbContext;
            _profileRepository = new ProfileRepository(userManager, signInManager, dbContext);
            _emailSender = emailSender;
        }

        [HttpGet]
        public async Task<IActionResult> EditProfile(string userId)
        {
            KeyValuePair<string, object> editUserProfileKeyValuePair = new KeyValuePair<string, object>("editProfile", userId);
            UserProfileEditViewModel userProfileEditViewModel = (UserProfileEditViewModel)await _profileRepository.Get(editUserProfileKeyValuePair);

            return View(userProfileEditViewModel);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> EditProfile(UserProfileEditViewModel userProfileEditViewModel)
        {
            if (ModelState.IsValid)
            {
                if (userProfileEditViewModel.ProfilePhoto != null)
                {
                    if (!Path.GetExtension(userProfileEditViewModel.ProfilePhoto.FileName).Equals(".png", StringComparison.InvariantCultureIgnoreCase) && !Path.GetExtension(userProfileEditViewModel.ProfilePhoto.FileName).Equals(".jpg", StringComparison.InvariantCultureIgnoreCase))
                    {
                        TempData["errormessage"] = "Incorrect Image File Type. Please try again!";
                        return View(userProfileEditViewModel);
                    }
                }

                KeyValuePair<string, object> editUserProfileKeyValuePair = new KeyValuePair<string, object>("editProfile", userProfileEditViewModel);
                int profileUpdateResult = (int)await _profileRepository.Update(editUserProfileKeyValuePair);

                if (profileUpdateResult > 0)
                {
                    TempData["successmessage"] = "Updated successfully!";
                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    TempData["errormessage"] = "Failed to Update. Please try again.";
                    return View(userProfileEditViewModel);
                }
            }
            return View(userProfileEditViewModel);
        }

        [HttpGet, Route("ownProfile")]
        public IActionResult OwnProfile()
        {
            string loggedInUserId = User.FindFirst(ClaimTypes.NameIdentifier).Value;
            return RedirectToAction("UserProfile", "Profile", new { userId = loggedInUserId });
        }

        [HttpGet, Route("userProfile")]
        public async Task<IActionResult> UserProfile(string userId)
        {
            KeyValuePair<string, object> getUserKeyValuePair = new KeyValuePair<string, object>("getUserProfile", userId);
            UserProfileViewModel userProfileViewModel = (UserProfileViewModel)await _profileRepository.Get(getUserKeyValuePair);
            string loggedInUserId = User.FindFirstValue(ClaimTypes.NameIdentifier);
            if (loggedInUserId.Equals(userProfileViewModel.UserId))
            {
                userProfileViewModel.IsPersonalProfile = true;
            }

            return View(userProfileViewModel);
        }

        [HttpPost, Route("contactUser")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> ContactUser(UserProfileViewModel userProfileViewModel)
        {
            if(!ModelState.IsValid)
            {
                TempData["errormessage"] = "Failed to send email. A Subject is required.";
                return RedirectToAction("UserProfile", "profile", new { userId = userProfileViewModel.UserId });
            }

            //If this was the business version of the app i would get the user of the profile and the logged in user using their id's and then use their emails to send this email.
            //However since this is a demo, they will be hard coded.

            userProfileViewModel.EmailBody = userProfileViewModel.EmailBody.Replace(Environment.NewLine, "<br/>");

            await _emailSender.SendEmailAsync("j016984c@student.staffs.ac.uk", userProfileViewModel.EmailSubject, userProfileViewModel.EmailBody);

            return RedirectToAction("UserProfile", "profile", new { userId = userProfileViewModel.UserId });
        }
    }
}
