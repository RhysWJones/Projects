using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;

namespace EIRLSS_Assignment2_J016984C_Rhys_Jones.Controllers
{
    public class FileUploadController : Controller
    {
        private readonly ApplicationDbContext DbContext;
        private UserManager<ApplicationUser> UserManager;

        public FileUploadController(ApplicationDbContext dbContext, UserManager<ApplicationUser> userManager)
        {
            DbContext = dbContext;
            UserManager = userManager;
        }

        [HttpGet]
        public async Task<IActionResult> FileUpload()
        {
            await AuthenticateUserLogin(true);
            FileUploadViewModel fileUploadViewModel = new FileUploadViewModel();

            return View(fileUploadViewModel);
        }

        [HttpPost]
        public async Task<IActionResult> FileUpload(FileUploadViewModel fileUploadViewModel)
        {
            await AuthenticateUserLogin(true);
            bool fileUploadedSuccessfully = false;

            if (ModelState.IsValid)
            {
                if(!Path.GetExtension(fileUploadViewModel.DVLADataFile.FileName).Equals(".csv", StringComparison.InvariantCultureIgnoreCase))
                {
                    TempData["errormessage"] = "Incorrect File Type. Please try again!";
                    return View(fileUploadViewModel);
                }

                fileUploadedSuccessfully = UploadFile(fileUploadViewModel.DVLADataFile).Result;

                if (fileUploadedSuccessfully)
                {
                    TempData["successmessage"] = "File(s) Added Successfully!";
                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    TempData["errormessage"] = "Failed to upload file. Please try again!";
                    return View(fileUploadViewModel);
                }

                return View();
            }
            else
            {
                TempData["errormessage"] = "Failed to upload file. Please try again!";
                return View(fileUploadViewModel);
            }
        }

        public async Task<bool> UploadFile(IFormFile file)
        {
            string fileName = "";
            string filePath = "";
            fileName = Path.GetFileName(file.FileName);
            filePath = Path.Combine(Directory.GetCurrentDirectory(), "Files", fileName);
            try
            {
                using (FileStream fileStream = new FileStream(filePath, FileMode.Create))
                {
                    await file.CopyToAsync(fileStream);
                }
                return true;
            }
            catch (Exception e)
            {
                TempData["errormessage"] = "File failed to upload. Please try again!";
                return false;
            }
        }


        public async Task<IActionResult> AuthenticateUserLogin(bool adminRequired)
        {
            ApplicationUser CurrentUser = await UserManager.GetUserAsync(HttpContext.User);
            bool IsAdmin = await UserManager.IsInRoleAsync(CurrentUser, "Admin");

            if (CurrentUser == null)
            {
                TempData["errormessage"] = "You need to be logged in to upload files." + Environment.NewLine + " If you do not have an account, please navigate to the registration page by clicking on 'Register' at the top of the screen.";
                return RedirectToAction("Login", "Account");
            }
            if (adminRequired && IsAdmin == false)
            {
                TempData["errormessage"] = "You require admin privileges to view that page.";
                return RedirectToAction("Index", "Home");
            }
            else return null;
        }
    }
}