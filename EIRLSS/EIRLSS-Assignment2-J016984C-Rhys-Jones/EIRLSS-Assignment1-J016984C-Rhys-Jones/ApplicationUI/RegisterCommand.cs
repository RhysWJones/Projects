using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class RegisterCommand : ICommand
    {
        private UserHandler UserHandler;
        private ApplicationUser NewUser;

        public RegisterCommand(ApplicationUser newUser, UserManager<ApplicationUser> userManager, SignInManager<ApplicationUser> signInManager)
        {
            NewUser = newUser;
            UserHandler = new UserHandler(userManager, signInManager);
        }

        public async Task<object> Execute()
        {
            return await UserHandler.RegisterUser(NewUser);
        }
    }
}
