using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.ScreenScraper;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;

namespace EIRLSS_Assignment2_J016984C_Rhys_Jones.Controllers
{
    public class PriceMatchController : Controller
    {
        private readonly ApplicationDbContext DbContext;
        private UserManager<ApplicationUser> UserManager;

        public PriceMatchController(ApplicationDbContext dbContext, UserManager<ApplicationUser> userManager)
        {
            DbContext = dbContext;
            UserManager = userManager;
        }

        [HttpGet]
        public async Task<IActionResult> UpdateVehicleComparisonSource(long? id)
        {
            await AuthenticateUserLogin(true);

            UpdateVehicleComparisonSourceViewModel updateVehicleComparisonSourceViewModel = new UpdateVehicleComparisonSourceViewModel();
            updateVehicleComparisonSourceViewModel.VehicleId = (int)id;

            return View(updateVehicleComparisonSourceViewModel);
        }

        [HttpPost]
        public async Task<IActionResult> UpdateVehicleComparisonSource(UpdateVehicleComparisonSourceViewModel updateVehicleComparisonSourceViewModel)
        {
            await AuthenticateUserLogin(true);
            int vehicleId = updateVehicleComparisonSourceViewModel.VehicleId;
            string vehicleComparisonSourceString = updateVehicleComparisonSourceViewModel.VehicleComparisonSource;

            int sourceUpdated = (int)await CommandFactory.CreateCommand(CommandFactory.UPDATE_VEHICLE_COMPARISON_SOURCE, DbContext, vehicleId, vehicleComparisonSourceString).Execute();

            if(sourceUpdated < 1)
            {
                TempData["errormessage"] = "Failed to update. Please try again!";
                return View(updateVehicleComparisonSourceViewModel);
            }
            else
            {
                TempData["successmessage"] = "Comparison Source Updated Successfully!";
                return RedirectToAction("Index", "Home");
            }
        }

        [HttpGet]
        public async Task<IActionResult> PriceMatch()
        {
            await AuthenticateUserLogin(true);
            PriceMatchViewModel priceMatchViewModel = new PriceMatchViewModel();
            priceMatchViewModel.PriceMatchVehicles = new List<PriceMatchVehiclesViewModel>();

            List<Vehicle> vehicles = (List<Vehicle>)await CommandFactory.CreateCommand(CommandFactory.GET_VEHICLES, DbContext).Execute();

            foreach (Vehicle vehicle in vehicles)
            {
                if(!String.IsNullOrEmpty(vehicle.VehicleComparisonSourceURL))
                {
                    PriceMatchScraper priceMatchScraper = new PriceMatchScraper(vehicle.VehicleComparisonSourceURL);
                    await priceMatchScraper.StartAsync();
                    if(!String.IsNullOrEmpty(priceMatchScraper.PriceString))
                    {
                        PriceMatchVehiclesViewModel priceMatchVehiclesViewModel = new PriceMatchVehiclesViewModel();
                        priceMatchVehiclesViewModel.VehicleId = (int) vehicle.Id;
                        priceMatchVehiclesViewModel.VehicleDescription = (vehicle.Manufacturer + " " + vehicle.Model);
                        priceMatchVehiclesViewModel.VehicleTypeCostPerDay = (Decimal.ToInt32(vehicle.CostPerDay).ToString() + " GBP");
                        priceMatchVehiclesViewModel.PriceToMatch = priceMatchScraper.PriceString;

                        priceMatchViewModel.PriceMatchVehicles.Add(priceMatchVehiclesViewModel);
                    }
                }
            }

            if(priceMatchViewModel.PriceMatchVehicles.Count > 0)
            {
                return View(priceMatchViewModel);
            }
            else
            {
                TempData["errormessage"] = "No Price Match Data Available.";
                return RedirectToAction("Index", "Home");
            }
        }

        [HttpPost]
        public async Task<IActionResult> PriceMatch(long? id)
        {
            await AuthenticateUserLogin(true);

            long vehicleId = (long)id;
            Vehicle vehicle = (Vehicle)await CommandFactory.CreateCommand(CommandFactory.GET_VEHICLE, vehicleId, DbContext).Execute();
            int newCostPerDay = -1;

            if (!String.IsNullOrEmpty(vehicle.VehicleComparisonSourceURL))
            {
                PriceMatchScraper priceMatchScraper = new PriceMatchScraper(vehicle.VehicleComparisonSourceURL);
                await priceMatchScraper.StartAsync();
                if (!String.IsNullOrEmpty(priceMatchScraper.PriceString))
                {
                    string priceStringToConvert = priceMatchScraper.PriceString.Replace("GBP", "");
                    priceStringToConvert = priceStringToConvert.Trim();
                    newCostPerDay = Int32.Parse(priceStringToConvert);
                }
            }

            if(newCostPerDay <= 0)
            {
                TempData["errormessage"] = "Unable to update vehicle cost per day. Please try again.";
                return RedirectToAction("Index", "Home");
            }

            int vehicleCostUpdated = (int)await CommandFactory.CreateCommand(CommandFactory.UPDATE_VEHICLE_COST_PER_DAY, DbContext, vehicleId, newCostPerDay).Execute();

            if(vehicleCostUpdated < 1)
            {
                TempData["errormessage"] = "Unable to update vehicle cost per day. Please try again.";
                return RedirectToAction("Index", "Home");
            }
            else
            {
                TempData["successmessage"] = "Vehicle Cost Updated!";
                return RedirectToAction("Index", "Home");
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