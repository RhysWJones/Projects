using AnimalCareSystem.Data;
using AnimalCareSystem.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ApplicationUI
{
    public class CommandFactory
    {
        public const int REGISTER = 1;
        public const int LOGIN = 2;
        public const int GET_CONFIRMATION_EMAIL_TOKEN = 3;
        public const int GET_USER_BY_ID = 4;
        public const int CONFIRM_EMAIL = 5;
        public const int GET_SERVICE_TYPES = 6;
        public const int UPDATE_USER = 7;
        public const int GET_USERS_BY_CITY = 8;

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

        public static ICommand CreateCommand(int commandType, ApplicationUser user, UserManager<ApplicationUser> userManager)
        {
            switch (commandType)
            {
                case GET_CONFIRMATION_EMAIL_TOKEN:
                    return new GetConfirmationEmailTokenCommand(user, userManager);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, string id, UserManager<ApplicationUser> userManager, ApplicationDbContext dbContext)
        {
            switch(commandType)
            {
                case GET_USER_BY_ID:
                    return new GetUserByIdCommand(id, userManager, dbContext);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, ApplicationUser user, string id, UserManager<ApplicationUser> userManager)
        {
            switch (commandType)
            {
                case CONFIRM_EMAIL:
                    return new ConfirmEmailCommand(user, id, userManager);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, ApplicationDbContext dbContext)
        {
            switch(commandType)
            {
                case GET_SERVICE_TYPES:
                    return new GetServiceTypesCommand(dbContext);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, ApplicationUser user, ApplicationDbContext dbContext)
        {
            switch (commandType)
            {
                case UPDATE_USER:
                    return new UpdateUserCommand(user, dbContext);
                default:
                    return new NullObjectCommand();
            }
        }

        public static ICommand CreateCommand(int commandType, string str, ApplicationDbContext dbContext)
        {
            switch (commandType)
            {
                case GET_USERS_BY_CITY:
                    return new GetUsersByCityCommand(str, dbContext);
                default:
                    return new NullObjectCommand();
            }
        }
    }
}
