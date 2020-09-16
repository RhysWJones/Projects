using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.ViewModels;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.AspNetCore.Http;
using System.IO;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.Controllers
{
    public class BookingController : Controller
    {
        private ViewVehicleBookingsViewModel ViewVehicleBookingsViewModel;
        private List<VehicleBookingsViewModel> VehicleBookingModels;
        private List<UserBookingsViewModel> UserBookingModels;
        private List<EquipmentCheckboxSelectViewModel> EquipmentCheckboxSelect;
        private BookVehicleViewModel BookVehicleViewModel;
        private ApplicationDbContext DbContext;
        private readonly UserManager<ApplicationUser> _userManager;
        private long VehicleId;
        private string errorString = "";

        public BookingController(ApplicationDbContext dbContext, UserManager<ApplicationUser> userManager)
        {
            DbContext = dbContext;
            _userManager = userManager;
        }

        [HttpGet]
        public async Task<IActionResult> BookVehicle(int? id)
        {
            IActionResult authenticationResult = await AuthenticateUserLogin(false);
            if(authenticationResult != null)
            {
                return authenticationResult;
            }

            ApplicationUser CurrentUser = await _userManager.GetUserAsync(HttpContext.User);

            if (CurrentUser.Blacklisted == true)
            {
                TempData["errormessage"] = "You are unable to book a vehicle due to a prior failure to collect a booked vehicle. Please contact us directly if you wish you rectify this issue.";
                return RedirectToAction("Index", "Home");
            }

            BookVehicleViewModel = new BookVehicleViewModel();
            EquipmentCheckboxSelect = new List<EquipmentCheckboxSelectViewModel>();
            BookVehicleViewModel.UserId = CurrentUser.Id;

            if (id > 0)
            {
                VehicleId = (int)id;
                ViewData["ChosenVehicle"] = await GetChosenVehicle(VehicleId);

                List<Equipment> equipmentList = (List<Equipment>)await CommandFactory.CreateCommand(CommandFactory.GET_ALL_EQUIPMENT, DbContext).Execute();

                BookVehicleViewModel.ChosenEquipmentList = CreateEquipmentCheckboxSelectList(equipmentList);

                return View(BookVehicleViewModel);
            }
            else
            {
                TempData["errormessage"] = "Something went wrong! If this error persists, please contact us directly.";
                return View(BookVehicleViewModel);
            }
        }

        [HttpPost]
        public async Task<IActionResult> BookVehicle(BookVehicleViewModel bookVehicleViewModel)
        {
            IActionResult authenticationResult = await AuthenticateUserLogin(false);
            if (authenticationResult != null)
            {
                return authenticationResult;
            }

            bool bookingValid = ValidateBooking(bookVehicleViewModel);
            
            if(bookingValid)
            {
                List<Equipment> chosenEquipmentList = new List<Equipment>();

                List<Booking> coincidingBookings = (List<Booking>)await CommandFactory.CreateCommand(CommandFactory.CHECK_FOR_COINCIDING_BOOKINGS, bookVehicleViewModel.StartDate, bookVehicleViewModel.EndDate, DbContext).Execute();

                if (coincidingBookings.Count > 0)
                {
                    foreach (Booking coincidingBooking in coincidingBookings)
                    {
                        if (bookVehicleViewModel.ChosenVehicleId == coincidingBooking.Vehicle.Id)
                        {
                            ViewData["ChosenVehicle"] = await GetChosenVehicle(bookVehicleViewModel.ChosenVehicleId);
                            ModelState.AddModelError("", "The vehicle is not available for the period of your booking. It is booked between " + coincidingBooking.StartDate.AddDays(-1).ToString("dd/MM/yyyy") + " and " + coincidingBooking.EndDate.AddDays(-1).ToString("dd/MM/yyyy"));
                            return View(bookVehicleViewModel);
                        }
                    }

                    foreach (EquipmentCheckboxSelectViewModel equipmentCheckbox in bookVehicleViewModel.ChosenEquipmentList)
                    {
                        if (equipmentCheckbox.CheckboxAnswer == true)
                        {
                            Equipment tempEquipment = new Equipment();
                            tempEquipment.Id = equipmentCheckbox.Id;
                            tempEquipment.Name = equipmentCheckbox.Name;
                            bool equipmentAvailable = (bool)await CommandFactory.CreateCommand(CommandFactory.CHECK_EQUIPMENT_AVAILABILITY, coincidingBookings, tempEquipment, DbContext).Execute();
                            if (equipmentAvailable == true)
                            {
                                chosenEquipmentList.Add(tempEquipment);
                            }
                            else
                            {
                                ViewData["ChosenVehicle"] = await GetChosenVehicle(bookVehicleViewModel.ChosenVehicleId);
                                errorString = equipmentCheckbox.Name + " is not available for the period of your booking. Please select a different booking period, or continue without this equipment item.";
                                ModelState.AddModelError("", errorString);
                                return View(bookVehicleViewModel);
                            }
                        }
                    }
                }
                Booking newBooking = ConvertViewModelToBooking(bookVehicleViewModel);

                int bookingAdded = (int)await CommandFactory.CreateCommand(CommandFactory.ADD_BOOKING, newBooking, chosenEquipmentList, DbContext).Execute();
                if (bookingAdded >= 1)
                {
                    TempData["successmessage"] = "Booking successfully created!";
                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    ViewData["ChosenVehicle"] = await GetChosenVehicle(VehicleId);
                    errorString = "Something went wrong, please try again.";
                    ModelState.AddModelError("", errorString);
                    return View(bookVehicleViewModel);
                }
            }
            
            ViewData["ChosenVehicle"] = await GetChosenVehicle(VehicleId);
            return View(bookVehicleViewModel);
        }

        [HttpGet]
        public async Task<IActionResult> ViewVehicleBookings(long? id)
        {
            IActionResult authenticationResult = await AuthenticateUserLogin(true);
            if (authenticationResult != null)
            {
                return authenticationResult;
            }

            if (id > 0)
            {
                VehicleId = (long)id;
                VehicleBookingModels = new List<VehicleBookingsViewModel>();
                ViewVehicleBookingsViewModel = new ViewVehicleBookingsViewModel();

                ViewData["ChosenVehicle"] = await GetChosenVehicle(VehicleId);

                List<Booking> vehicleBookings = new List<Booking>();

                vehicleBookings = (List<Booking>) await CommandFactory.CreateCommand(CommandFactory.GET_ALL_BOOKINGS_FOR_VEHICLE, VehicleId, DbContext).Execute();

                ViewVehicleBookingsViewModel.VehicleBookingModels = CreateVehicleBookingModels(vehicleBookings);

                return View(ViewVehicleBookingsViewModel);
            }
            else
            {
                TempData["errormessage"] = "Something went wrong! If this error persists, please contact an administrator.";
                return RedirectToAction("Index", "Home");
            }
        }

        [HttpGet]
        public async Task<IActionResult> EditBooking(long? id)
        {
            IActionResult authenticationResult = await AuthenticateUserLogin(false);
            if (authenticationResult != null)
            {
                return authenticationResult;
            }

            EquipmentCheckboxSelect = new List<EquipmentCheckboxSelectViewModel>();
            long bookingId = (long)id;
            List<Equipment> equipmentList = (List<Equipment>)await CommandFactory.CreateCommand(CommandFactory.GET_ALL_EQUIPMENT, DbContext).Execute();
            Booking bookingToEdit = (Booking)await CommandFactory.CreateCommand(CommandFactory.GET_BOOKING, bookingId, DbContext).Execute();

            EditBookingViewModel editBookingViewModel = CreateEditBookingViewModel(bookingToEdit);

            editBookingViewModel.ChosenEquipmentList = CreateEquipmentCheckboxSelectList(equipmentList);

            foreach(EquipmentCheckboxSelectViewModel item in editBookingViewModel.ChosenEquipmentList)
            {
                foreach(EquipmentBooking equipmentBooking in bookingToEdit.EquipmentBookings)
                {
                    if(item.Id == equipmentBooking.Equipment.Id)
                    {
                        item.CheckboxAnswer = true;
                    }
                }
            }

            return View(editBookingViewModel);
        }

        [HttpPost]
        public async Task<IActionResult> EditBooking(EditBookingViewModel editBookingViewModel)
        {
            IActionResult authenticationResult = await AuthenticateUserLogin(false);
            if (authenticationResult != null)
            {
                return authenticationResult;
            }

            bool bookingValid = ValidateBooking(editBookingViewModel);
            if (bookingValid)
            {
                List<Equipment> chosenEquipmentList = new List<Equipment>();

                List<Booking> coincidingBookings = (List<Booking>)await CommandFactory.CreateCommand(CommandFactory.CHECK_FOR_COINCIDING_BOOKINGS, editBookingViewModel.StartDate, editBookingViewModel.EndDate, DbContext).Execute();

                for(int i = 0; i < coincidingBookings.Count; i++)
                {
                    if(coincidingBookings[i].Id == editBookingViewModel.BookingId)
                    {
                        coincidingBookings.RemoveAt(i);
                        break;
                    }
                }

                if (coincidingBookings.Count > 0)
                {
                    foreach (Booking coincidingBooking in coincidingBookings)
                    {
                        if (editBookingViewModel.VehicleId == coincidingBooking.Vehicle.Id)
                        {
                            ViewData["ChosenVehicle"] = await GetChosenVehicle(editBookingViewModel.VehicleId);
                            ModelState.AddModelError("", "The vehicle is not available for the period of your booking. The latest you can book this vehicle until is " + coincidingBooking.StartDate.AddDays(-1).ToString("dd/MM/yyyy"));
                            return View(editBookingViewModel);
                        }
                    }

                    foreach (EquipmentCheckboxSelectViewModel equipmentCheckbox in editBookingViewModel.ChosenEquipmentList)
                    {
                        if (equipmentCheckbox.CheckboxAnswer == true)
                        {
                            Equipment tempEquipment = new Equipment();
                            tempEquipment.Id = equipmentCheckbox.Id;
                            tempEquipment.Name = equipmentCheckbox.Name;
                            bool equipmentAvailable = (bool)await CommandFactory.CreateCommand(CommandFactory.CHECK_EQUIPMENT_AVAILABILITY, coincidingBookings, tempEquipment, DbContext).Execute();
                            if (equipmentAvailable == true)
                            {
                                chosenEquipmentList.Add(tempEquipment);
                            }
                            else
                            {
                                errorString = "A " + equipmentCheckbox.Name + " is not available for the period of your booking. Please select a different booking period, or continue without this equipment item.";
                                ModelState.AddModelError("", errorString);
                                return View(editBookingViewModel);
                            }
                        }
                    }
                }
                Booking booking = ConvertViewModelToBooking(editBookingViewModel);

                if(booking == null)
                {
                    errorString = "Something went wrong, please try again.";
                    ModelState.AddModelError("", errorString);
                    return View(editBookingViewModel);
                }
                int bookingUpdated = (int)await CommandFactory.CreateCommand(CommandFactory.UPDATE_BOOKING, booking, chosenEquipmentList, DbContext).Execute();

                if (bookingUpdated >= 1)
                {
                    TempData["successmessage"] = "Booking Updated Successfully.";
                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    errorString = "Something went wrong, please try again.";
                    ModelState.AddModelError("", errorString);
                    return View(editBookingViewModel);
                }
            }

            return View(editBookingViewModel);
        }

        public async Task<IActionResult> DeleteBooking(long? id)
        {
            IActionResult authenticationResult = await AuthenticateUserLogin(false);
            if (authenticationResult != null)
            {
                return authenticationResult;
            }

            long bookingId = (long)id;

            int bookingDeleted = (int)await CommandFactory.CreateCommand(CommandFactory.DELETE_BOOKING, bookingId, DbContext).Execute();
            if(bookingDeleted < 1)
            {
                errorString = "Something went wrong, please try again.";
                ModelState.AddModelError("", errorString);
                return View();
            }

            TempData["successmessage"] = "Booking Deleted Successfully!";
            return RedirectToAction("Index", "Home");
        }

        [HttpGet]
        public async Task<IActionResult> CollectBooking(long? id)
        {
            IActionResult authenticationResult = await AuthenticateUserLogin(true);
            if (authenticationResult != null)
            {
                return authenticationResult;
            }

            long bookingId = (long)id;
            Booking userBooking = (Booking)await CommandFactory.CreateCommand(CommandFactory.GET_BOOKING, bookingId, DbContext).Execute();
            CollectBookingViewModel collectBookingViewModel = new CollectBookingViewModel();
            collectBookingViewModel.BookingId = (int)bookingId;
            collectBookingViewModel.DrivingLicenseNumber = userBooking.User.LicenseNumber;
            

            return View(collectBookingViewModel);
        }

        [HttpPost]
        public async Task<IActionResult> CollectBooking(CollectBookingViewModel collectBookingViewModel)
        {
            //Check the user is an admin.
            IActionResult authenticationResult = await AuthenticateUserLogin(true);
            if (authenticationResult != null)
            {
                return authenticationResult;
            }
            
            //get the full booking record
            int bookingId = collectBookingViewModel.BookingId;
            Booking userBooking = (Booking)await CommandFactory.CreateCommand(CommandFactory.GET_BOOKING, bookingId, DbContext).Execute();

            //Create a unique folder path based on the booking users name and license number, then upload the file to that folder.
            string folderPath = GenerateUserBasedFolderPath(userBooking.User);
            string uploadedFilePath = await UploadIdentificationFile(collectBookingViewModel.AdditionalIdentificationImage, folderPath);


            if(uploadedFilePath.Equals("uploadFailed"))
            {
                errorString = "Something went wrong, please try again.";
                ModelState.AddModelError("", errorString);
                return View();
            }
            else
            {
                //Update the bookee's user data with the file path for the identification image.
                userBooking.User.IdentificationFolderSource = uploadedFilePath;
                int userUpdated = (int) await CommandFactory.CreateCommand(CommandFactory.UPDATE_USER, userBooking.User, DbContext, _userManager).Execute();

                if(userUpdated < 1)
                {
                    errorString = "Something went wrong, please try again.";
                    ModelState.AddModelError("", errorString);
                    return View();
                }
            }

            //Check if the user's license is still valid, or whether it has been reported as lost, stolen or suspended
            bool userLicenseInvalid;
            try
            {
                userLicenseInvalid = await CheckIfUserLicenseValid(userBooking.User);
            }
            catch (Exception e)
            {
                TempData["errormessage"] = e.Message;
                return View();
            }

            //If the user's license is valid, then we check whether they have previously committed insurance fraud.
            if (!userLicenseInvalid)
            {
                bool userCommittedInsuranceFraud;
                try
                {
                    userCommittedInsuranceFraud = await CheckIfUserCommittedInsuranceFraud(userBooking.User);
                }
                catch (Exception e)
                {
                    TempData["errormessage"] = e.Message;
                    return View();
                }

                //If the user committed insurance fraud, then alert the admin and delete the booking.
                if(userCommittedInsuranceFraud)
                {
                    int bookingDeleted = (int)await CommandFactory.CreateCommand(CommandFactory.DELETE_BOOKING, bookingId, DbContext).Execute();

                    errorString = "This booking can not be collected: The person who made this booking has previously made a fraudulent insurance claim. This booking has been deleted.";
                    TempData["errormessage"] = errorString;
                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    int bookingCollected = (int)await CommandFactory.CreateCommand(CommandFactory.COLLECT_BOOKING, bookingId, DbContext).Execute();
                    if (bookingCollected < 1)
                    {
                        errorString = "Something went wrong, please try again.";
                        ModelState.AddModelError("", errorString);
                        return View();
                    }

                    TempData["successmessage"] = "Booking Marked As Collected!";
                    return RedirectToAction("Index", "Home");
                }
            }
            else
            {
                //Put the files into collection ready to email to the DVLA
                FormFileCollection fileCollection = new FormFileCollection();
                fileCollection.Add(collectBookingViewModel.DrivingLicenseImageBack);
                fileCollection.Add(collectBookingViewModel.DrivingLicenseImageFront);
                fileCollection.Add(collectBookingViewModel.PersonCollectingImage);
                fileCollection.Add(collectBookingViewModel.AdditionalIdentificationImage);

                //Send the email to the DVLA and then delete the booking and inform the admin.
                await CommandFactory.CreateCommand(CommandFactory.SEND_EMAIL, fileCollection, userBooking.User).Execute();
                int bookingDeleted = (int)await CommandFactory.CreateCommand(CommandFactory.DELETE_BOOKING, bookingId, DbContext).Execute();

                errorString = "This booking can not be collected: The license associated with this booking is currently invalidated by the DVLA. The DVLA have been informed and this booking has been deleted.";
                TempData["errormessage"] = errorString;
                return RedirectToAction("Index", "Home");
            }
        }

        public async Task<IActionResult> ViewUserBookings()
        {
            IActionResult authenticationResult = await AuthenticateUserLogin(false);
            if (authenticationResult != null)
            {
                return authenticationResult;
            }

            ApplicationUser CurrentUser = await _userManager.GetUserAsync(HttpContext.User);

            string UserId = CurrentUser.Id;
            UserBookingModels = new List<UserBookingsViewModel>();
            ViewUserBookingsViewModel ViewUserBookingsViewModel = new ViewUserBookingsViewModel();

            List<Booking> userBookings = new List<Booking>();

            userBookings = (List<Booking>)await CommandFactory.CreateCommand(CommandFactory.GET_ALL_BOOKINGS_FOR_USER, UserId, DbContext).Execute();

            ViewUserBookingsViewModel.UserBookingModels = CreateUserBookingModels(userBookings);

            return View(ViewUserBookingsViewModel);
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

        public bool ValidateBooking(Object bookingViewModel)
        {
            bool valid = true;

            if (bookingViewModel is BookVehicleViewModel)
            {
                BookVehicleViewModel bookVehicleViewModel = (BookVehicleViewModel)bookingViewModel;

                double dateRangeInDays = (bookVehicleViewModel.StartDate.Date - bookVehicleViewModel.EndDate.Date).TotalDays;

                if (bookVehicleViewModel.StartDate.Date < DateTime.Today.Date)
                {
                    ModelState.AddModelError("", "Booking cannot begin in the past.");
                    valid = false;
                }

                if (dateRangeInDays > 14)
                {
                    ModelState.AddModelError("", "Booking cannot be for longer than 2 weeks.");
                    valid = false;
                }

                if (dateRangeInDays == 0 && bookVehicleViewModel.EndHalfDay != true)
                {
                    ModelState.AddModelError("", "Minimum booking length is half a day.");
                    valid = false;
                }
            }
            else if(bookingViewModel is EditBookingViewModel)
            {
                EditBookingViewModel editBookingViewModel = (EditBookingViewModel)bookingViewModel;

                double dateRangeInDays = (editBookingViewModel.StartDate.Date - editBookingViewModel.EndDate.Date).TotalDays;

                if (dateRangeInDays > 14)
                {
                    ModelState.AddModelError("", "Booking cannot be for longer than 2 weeks.");
                    valid = false;
                }

                if (dateRangeInDays == 0 && editBookingViewModel.EndHalfDay != true)
                {
                    ModelState.AddModelError("", "Minimum booking length is half a day.");
                    valid = false;
                }

                return valid;
            }
            
            return valid;
        }

        public async Task<Vehicle> GetChosenVehicle(long vehicleId)
        {
            return (Vehicle)await CommandFactory.CreateCommand(CommandFactory.GET_VEHICLE, vehicleId, DbContext).Execute();
        }

        public List<VehicleBookingsViewModel> CreateVehicleBookingModels(List<Booking> vehicleBookings)
        {
            for (int i = 0; i < vehicleBookings.Count; i++)
            {
                VehicleBookingModels.Add(new VehicleBookingsViewModel());
                VehicleBookingModels[i].BookingId = vehicleBookings[i].Id;
                VehicleBookingModels[i].StartDate = vehicleBookings[i].StartDate;
                VehicleBookingModels[i].EndDate = vehicleBookings[i].EndDate;
                VehicleBookingModels[i].BookedBy = vehicleBookings[i].User.Forename + " " + vehicleBookings[i].User.Surname;

                if (vehicleBookings[i].StartDate < DateTime.Today && vehicleBookings[i].EndDate > DateTime.Today && vehicleBookings[i].Collected == true)
                {
                    VehicleBookingModels[i].IsCurrentlyOnRental = true;
                }
                if (vehicleBookings[i].StartDate < DateTime.Today && vehicleBookings[i].Collected == false)
                {
                    VehicleBookingModels[i].NotCollected = true;
                }
            }

            return VehicleBookingModels;
        }

        public List<UserBookingsViewModel> CreateUserBookingModels(List<Booking> userBookings)
        {
            for (int i = 0; i < userBookings.Count; i++)
            {
                UserBookingModels.Add(new UserBookingsViewModel());
                UserBookingModels[i].BookingId = userBookings[i].Id;
                UserBookingModels[i].StartDate = userBookings[i].StartDate;
                UserBookingModels[i].EndDate = userBookings[i].EndDate;
                UserBookingModels[i].VehicleBooked = userBookings[i].Vehicle.Manufacturer + " " + userBookings[i].Vehicle.Model;
                UserBookingModels[i].Price = userBookings[i].Price;

                if (userBookings[i].StartDate < DateTime.Today && userBookings[i].EndDate > DateTime.Today && userBookings[i].Collected == true)
                {
                    UserBookingModels[i].IsCurrentlyOnRental = true;
                }
                if (userBookings[i].StartDate < DateTime.Today && userBookings[i].Collected == false)
                {
                    UserBookingModels[i].NotCollected = true;
                }
            }

            return UserBookingModels;
        }

        public List<EquipmentCheckboxSelectViewModel> CreateEquipmentCheckboxSelectList(List<Equipment> equipmentList)
        {
            for (int i = 0; i < equipmentList.Count; i++)
            {
                EquipmentCheckboxSelect.Add(new EquipmentCheckboxSelectViewModel());
                EquipmentCheckboxSelect[i].Id = equipmentList[i].Id;
                EquipmentCheckboxSelect[i].Name = equipmentList[i].Name;
            }

            return EquipmentCheckboxSelect;
        }

        public Booking ConvertViewModelToBooking(Object bookingViewModel)
        {
            if(bookingViewModel is BookVehicleViewModel)
            {
                BookVehicleViewModel bookVehicleViewModel = (BookVehicleViewModel)bookingViewModel;

                Booking booking = new Booking();
                ApplicationUser userBooking = new ApplicationUser();
                Vehicle chosenVehicle = new Vehicle();

                userBooking.Id = bookVehicleViewModel.UserId;
                chosenVehicle.Id = bookVehicleViewModel.ChosenVehicleId;

                booking.StartDate = bookVehicleViewModel.StartDate;
                booking.EndDate = bookVehicleViewModel.EndDate;
                booking.StartHalfDay = bookVehicleViewModel.StartHalfDay;
                booking.EndHalfDay = bookVehicleViewModel.EndHalfDay;
                booking.Price = bookVehicleViewModel.TotalCost;
                booking.Vehicle = chosenVehicle;
                booking.User = userBooking;

                return booking;
            }
            else if(bookingViewModel is EditBookingViewModel)
            {
                EditBookingViewModel editBookingViewModel = (EditBookingViewModel)bookingViewModel;

                Booking booking = new Booking();

                booking.Id = editBookingViewModel.BookingId;
                booking.StartDate = editBookingViewModel.StartDate;
                booking.EndDate = editBookingViewModel.EndDate;
                booking.StartHalfDay = editBookingViewModel.StartHalfDay;
                booking.EndHalfDay = editBookingViewModel.EndHalfDay;
                booking.Price = editBookingViewModel.Price;
                booking.Collected = editBookingViewModel.Collected;

                return booking;
            }
            return null;
        }

        public EditBookingViewModel CreateEditBookingViewModel(Booking bookingToEdit)
        {
            EditBookingViewModel editBookingViewModel = new EditBookingViewModel();

            editBookingViewModel.BookingId = bookingToEdit.Id;
            editBookingViewModel.StartDate = bookingToEdit.StartDate;
            editBookingViewModel.EndDate = bookingToEdit.EndDate;
            editBookingViewModel.LateReturn = bookingToEdit.LateReturn;
            editBookingViewModel.StartHalfDay = bookingToEdit.EndHalfDay;
            editBookingViewModel.Collected = bookingToEdit.Collected;
            editBookingViewModel.Price = bookingToEdit.Price;
            editBookingViewModel.VehicleId = bookingToEdit.Vehicle.Id;
            editBookingViewModel.VehicleName = bookingToEdit.Vehicle.Manufacturer + " " + bookingToEdit.Vehicle.Model;
            editBookingViewModel.VehicleCostPerDay = bookingToEdit.Vehicle.CostPerDay;
            editBookingViewModel.UserForename = bookingToEdit.User.Forename;
            editBookingViewModel.UserSurname = bookingToEdit.User.Surname;

            return editBookingViewModel;
        }

        public async Task<bool> CheckIfUserLicenseValid(ApplicationUser user)
        {
            bool userLicenseInvalid = false;
            List<String> listOfInvalidLicenses = (List<String>) await CommandFactory.CreateCommand(CommandFactory.GET_INVALID_LICENSES).Execute();
            if(listOfInvalidLicenses != null)
            {
                foreach (String invalidLicense in listOfInvalidLicenses)
                {
                    String[] licenseDataSplit = invalidLicense.Split(',');
                    if (user.LicenseNumber.Equals(licenseDataSplit[0]))
                    {
                        userLicenseInvalid = true;
                    }
                }
            }
            else
            {
                Exception DVLAFileUnavailableException = new Exception();
                DVLAFileUnavailableException.Message.Insert(0, "Unable To Check User Against DVLA File. Please Ensure a DVLA File Is Uploaded.");
                throw new Exception();
            }
            return userLicenseInvalid;
        }

        public async Task<bool> CheckIfUserCommittedInsuranceFraud(ApplicationUser user)
        {
            List<FraudulentClaim> fraudulentClaims = (List<FraudulentClaim>)await CommandFactory.CreateCommand(CommandFactory.GET_INSURANCE_FRAUD_DATA).Execute();

            foreach(FraudulentClaim claim in fraudulentClaims)
            {
                if(claim.Forenames.Equals(user.Forename, StringComparison.OrdinalIgnoreCase) && claim.FamilyName.Equals(user.Surname, StringComparison.OrdinalIgnoreCase) && claim.DateOfBirth.Date == user.DateOfBirth.Date)
                {
                    return true;
                }
            }

            return false;
        }

        public async Task<string> UploadIdentificationFile(IFormFile file, string folderPath)
        {
            string fileName = "";
            string filePath = "";

            fileName = Path.GetFileName(file.FileName);
            Directory.CreateDirectory(folderPath);
            filePath = Path.Combine(folderPath, fileName);
            try
            {
                using (FileStream fileStream = new FileStream(filePath, FileMode.Create))
                {
                    await file.CopyToAsync(fileStream);
                }
                return filePath;
            }
            catch (Exception e)
            {
                TempData["errormessage"] = "Image failed to upload. Please try again!";
                return "uploadFailed";
            }
        }

        public string GenerateUserBasedFolderPath(ApplicationUser user)
        {
            string userPath = @"Files\" + user.Forename + "_" + user.Surname + "_" + user.LicenseNumber;
            string folderPath = Path.Combine(Directory.GetCurrentDirectory(), userPath);

            return folderPath;
        }

    }
}