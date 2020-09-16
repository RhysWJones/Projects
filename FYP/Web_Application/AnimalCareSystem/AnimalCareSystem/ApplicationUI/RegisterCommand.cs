using AnimalCareSystem.Handlers;
using AnimalCareSystem.Models;
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ApplicationUI
{
    public class RegisterCommand : ICommand
    {
        private AccountHandler AccountHandler;
        private ApplicationUser NewUser;
        public RegisterCommand(ApplicationUser newUser, UserManager<ApplicationUser> userManager, SignInManager<ApplicationUser> signInManager)
        {
            NewUser = newUser;
            AccountHandler = new AccountHandler(userManager, signInManager);
        }

        public async Task<object> Execute()
        {
            return await AccountHandler.RegisterUser(NewUser);
        }
    }
}
