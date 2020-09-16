using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Controllers
{
    public class VehicleController : Controller
    {
        private readonly ApplicationDbContext DbContext;
        private AddVehicleViewModel AddVehicleViewModel;
        private UserManager<ApplicationUser> UserManager;

        public VehicleController(ApplicationDbContext dbContext, UserManager<ApplicationUser> userManager)
        {
            DbContext = dbContext;
            UserManager = userManager;
        }

        [HttpGet]
        public async Task<IActionResult> AddVehicle()
        {
            await AuthenticateUserLogin(true);
            AddVehicleViewModel = new AddVehicleViewModel();

            List<VehicleType> VehicleTypeList = await GetVehicleTypes();
            List<Transmission> TransmissionList = await GetTransmissionTypes();
            List<Fuel> FuelList = await GetFuelTypes();

            ViewData["VehicleTypeList"] = new SelectList(VehicleTypeList, "Id", "Size");
            ViewData["TransmissionList"] = new SelectList(TransmissionList, "Id", "Type");
            ViewData["FuelList"] = new SelectList(FuelList, "Id", "Type");

            return View(AddVehicleViewModel);
        }

        [HttpPost]
        public async Task<IActionResult> AddVehicle(AddVehicleViewModel addVehicleViewModel)
        {
            await AuthenticateUserLogin(true);

            bool imageUploadedSuccessfully = false;
            string vehicleImageSource = "";
            if(ModelState.IsValid)
            {
                imageUploadedSuccessfully = UploadVehicleImage(addVehicleViewModel.vehicleImageFile).Result;

                if(imageUploadedSuccessfully)
                {
                    vehicleImageSource = Path.GetFileName(addVehicleViewModel.vehicleImageFile.FileName);
                    Vehicle newVehicle = CreateNewVehicle(addVehicleViewModel, vehicleImageSource);
                    int vehicleAdded = (int)await CommandFactory.CreateCommand(CommandFactory.ADD_VEHICLE, newVehicle, DbContext).Execute();

                    if(vehicleAdded == 1)
                    {
                        TempData["successmessage"] = "Vehicle Added Successfully!";
                        return RedirectToAction("Index", "Home");
                    }
                }
                else
                {
                    List<VehicleType> VehicleTypeList = await GetVehicleTypes();
                    List<Transmission> TransmissionList = await GetTransmissionTypes();
                    List<Fuel> FuelList = await GetFuelTypes();

                    ViewData["VehicleTypeList"] = new SelectList(VehicleTypeList, "Id", "Size");
                    ViewData["TransmissionList"] = new SelectList(TransmissionList, "Id", "Type");
                    ViewData["FuelList"] = new SelectList(FuelList, "Id", "Type");

                    TempData["errormessage"] = "Failed to add vehicle. Please try again!";
                    return View(addVehicleViewModel);
                }

                return View();
            }
            else
            {
                List<VehicleType> VehicleTypeList = await GetVehicleTypes();
                List<Transmission> TransmissionList = await GetTransmissionTypes();
                List<Fuel> FuelList = await GetFuelTypes();

                ViewData["VehicleTypeList"] = new SelectList(VehicleTypeList, "Id", "Size");
                ViewData["TransmissionList"] = new SelectList(TransmissionList, "Id", "Type");
                ViewData["FuelList"] = new SelectList(FuelList, "Id", "Type");

                TempData["errormessage"] = "Vehicle data is invalid. Please try again!";
                return View(addVehicleViewModel);
            }
        }

        public async Task<IActionResult> AuthenticateUserLogin(bool adminRequired)
        {
            ApplicationUser CurrentUser = await UserManager.GetUserAsync(HttpContext.User);
            bool IsAdmin = await UserManager.IsInRoleAsync(CurrentUser, "Admin");

            if (CurrentUser == null)
            {
                TempData["errormessage"] = "You need to be logged in to book a vehicle." + Environment.NewLine + " If you do not have an account, please navigate to the registration page by clicking on 'Register' at the top of the screen.";
                return RedirectToAction("Login", "Account");
            }
            if (adminRequired && IsAdmin == false)
            {
                TempData["errormessage"] = "You require admin privileges to view that page.";
                return RedirectToAction("Index", "Home");
            }
            else return null;
        }

        public async Task<bool> UploadVehicleImage(IFormFile vehicleImageFile)
        {
            string fileName = "";
            string filePath = "";

            fileName = Path.GetFileName(vehicleImageFile.FileName);
            filePath = Path.Combine(Directory.GetCurrentDirectory(), @"wwwroot\Images\Vehicles", fileName);
            try
            {
                using (FileStream fileStream = new FileStream(filePath, FileMode.Create))
                {
                    await vehicleImageFile.CopyToAsync(fileStream);
                }
                return true;
            }
            catch(Exception e)
            {
                TempData["errormessage"] = "Image failed to upload. Please try again!";
                return false;
            }
        }

        public Vehicle CreateNewVehicle(AddVehicleViewModel addVehicleViewModel, string VehicleImageSource)
        {
            Vehicle newVehicle = new Vehicle();

            newVehicle.Manufacturer = addVehicleViewModel.Manufacturer;
            newVehicle.Model = addVehicleViewModel.Model;
            newVehicle.Doors = addVehicleViewModel.Doors;
            newVehicle.Seats = addVehicleViewModel.Seats;
            newVehicle.Colour = addVehicleViewModel.Colour;
            newVehicle.CostPerDay = addVehicleViewModel.CostPerDay;
            newVehicle.VehicleType = new VehicleType() { Id = addVehicleViewModel.VehicleTypeId };
            newVehicle.Fuel = new Fuel() { Id = addVehicleViewModel.FuelId };
            newVehicle.Transmission = new Transmission() { Id = addVehicleViewModel.TransmissionId };
            newVehicle.VehicleImageSource = VehicleImageSource;

            return newVehicle;
        }

        public async Task<List<VehicleType>> GetVehicleTypes()
        {
            return (List<VehicleType>)await CommandFactory.CreateCommand(CommandFactory.GET_VEHICLE_TYPES, DbContext).Execute();
        }

        public async Task<List<Fuel>> GetFuelTypes()
        {
            return (List<Fuel>)await CommandFactory.CreateCommand(CommandFactory.GET_FUEL_TYPES, DbContext).Execute();
        }

        public async Task<List<Transmission>> GetTransmissionTypes()
        {
            return (List<Transmission>)await CommandFactory.CreateCommand(CommandFactory.GET_TRANSMISSION_TYPES, DbContext).Execute();
        }
    }
}