using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class CommandFactory
    {
        public const int REGISTER = 1;
        public const int LOGIN = 2;
        public const int GET_VEHICLE_TYPES = 3;
        public const int GET_TRANSMISSION_TYPES = 4;
        public const int GET_FUEL_TYPES = 5;
        public const int ADD_VEHICLE = 6;
        public const int GET_VEHICLES = 7;
        public const int GET_ALL_BOOKINGS_FOR_VEHICLE = 8;
        public const int GET_VEHICLE = 9;
        public const int GET_ALL_EQUIPMENT = 10;
        public const int CHECK_FOR_COINCIDING_BOOKINGS = 11;
        public const int CHECK_EQUIPMENT_AVAILABILITY = 12;
        public const int ADD_BOOKING = 13;
        public const int CREATE_EQUIPMENT_BOOKING = 14;
        public const int GET_BOOKING = 15;
        public const int UPDATE_BOOKING = 16;
        public const int DELETE_BOOKING = 17;
        public const int BLACKLIST_USER = 18;
        public const int COLLECT_BOOKING = 19;
        public const int GET_ALL_BOOKINGS_FOR_USER = 20;
        public const int GET_INVALID_LICENSES = 21;
        public const int SEND_EMAIL = 22;
        public const int UPDATE_USER = 23;
        public const int GET_INSURANCE_FRAUD_DATA = 24;
        public const int UPDATE_VEHICLE_COMPARISON_SOURCE = 25;
        public const int UPDATE_VEHICLE_COST_PER_DAY = 26;

        public static ICommand CreateCommand(int commandType)
        {
            switch(commandType)
            {
                case GET_INVALID_LICENSES:
                    return new GetInvalidLicensesCommand();
                case GET_INSURANCE_FRAUD_DATA:
                    return new GetInsuranceFraudDataCommand();
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, ApplicationDbContext dbContext, int entityId, string text)
        {
            switch(commandType)
            {
                case UPDATE_VEHICLE_COMPARISON_SOURCE:
                    return new UpdateVehicleComparisonSourceCommand(dbContext, entityId, text);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, ApplicationDbContext dbContext, long entityId, int number)
        {
            switch(commandType)
            {
                case UPDATE_VEHICLE_COST_PER_DAY:
                    return new UpdateVehicleCostPerDayCommand(dbContext, entityId, number);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, IFormFileCollection formFileCollection, ApplicationUser user)
        {
            switch(commandType)
            {
                case SEND_EMAIL:
                    return new SendEmailCommand(formFileCollection, user);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, ApplicationDbContext dbContext)
        {
            switch (commandType)
            {
                case GET_VEHICLE_TYPES:
                    return new GetVehicleTypesCommand(dbContext);
                case GET_TRANSMISSION_TYPES:
                    return new GetTransmissionTypesCommand(dbContext);
                case GET_FUEL_TYPES:
                    return new GetFuelTypesCommand(dbContext);
                case GET_VEHICLES:
                    return new GetVehiclesCommand(dbContext);
                case GET_ALL_EQUIPMENT:
                    return new GetAllEquipmentCommand(dbContext);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, ApplicationUser newUser, UserManager<ApplicationUser> userManager, SignInManager<ApplicationUser> signInManager)
        {
            switch (commandType)
            {
                case REGISTER:
                    return new RegisterCommand(newUser, userManager, signInManager);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, string email, string password, bool rememberMe, SignInManager<ApplicationUser> signInManager)
        {
            switch (commandType)
            {
                case LOGIN:
                    return new LoginCommand(email, password, rememberMe, signInManager);
                default:
                    return new NullObjectCommand();
            }

        }
        public static ICommand CreateCommand(int commandType, long entityId, ApplicationDbContext dbContext)
        {
            switch (commandType)
            {
                case GET_ALL_BOOKINGS_FOR_VEHICLE:
                    return new GetAllBookingsForVehicleCommand(entityId, dbContext);
                case GET_VEHICLE:
                    return new GetVehicleCommand(entityId, dbContext);
                case GET_BOOKING:
                    return new GetBookingCommand(entityId, dbContext);
                case DELETE_BOOKING:
                    return new DeleteBookingCommand(entityId, dbContext);
                case COLLECT_BOOKING:
                    return new CollectBookingCommand(entityId, dbContext);
                default:
                    return new NullObjectCommand();
            }
        }
        public static ICommand CreateCommand(int commandType, string userId, ApplicationDbContext dbContext, UserManager<ApplicationUser> userManager)
        {
            switch (commandType)
            {
                case BLACKLIST_USER:
                    return new BlacklistUserCommand(userId, dbContext, userManager);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, ApplicationUser user, ApplicationDbContext dbContext, UserManager<ApplicationUser> userManager)
        {
            switch (commandType)
            {
                case UPDATE_USER:
                    return new UpdateUserCommand(user, userManager, dbContext);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, string userId, ApplicationDbContext dbContext)
        {
            switch (commandType)
            {
                case GET_ALL_BOOKINGS_FOR_USER:
                    return new GetAllBookingsForUserCommand(userId, dbContext);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, Vehicle newVehicle, ApplicationDbContext dbContext)
        {
            switch (commandType)
            {
                case ADD_VEHICLE:
                    return new AddVehicleCommand(newVehicle, dbContext);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, DateTime requestedStartDate, DateTime requestedEndDate, ApplicationDbContext dbContext)
        {
            switch (commandType)
            {
                case CHECK_FOR_COINCIDING_BOOKINGS:
                    return new GetCoincidingBookingsCommand(requestedStartDate, requestedEndDate, dbContext);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, List<Booking> bookings, Equipment equipment, ApplicationDbContext dbContext)
        {
            switch (commandType)
            {
                case CHECK_EQUIPMENT_AVAILABILITY:
                    return new CheckEquipmentAvailabilityCommand(equipment, bookings, dbContext);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, Booking booking, List<Equipment> chosenEquipmentList, ApplicationDbContext dbContext)
        {
            switch (commandType)
            {
                case ADD_BOOKING:
                    return new AddBookingCommand(booking, chosenEquipmentList, dbContext);
                case UPDATE_BOOKING:
                    return new UpdateBookingCommand(booking, chosenEquipmentList, dbContext);
                default:
                    return new NullObjectCommand();
            }
        }
    }
}
