using AnimalCareSystem.Handlers;
using AnimalCareSystem.Models;
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ApplicationUI
{
    public class ConfirmEmailCommand : ICommand
    {
        private ApplicationUser User;
        private string ConfirmationCode;
        private AccountHandler AccountHandler;
        public ConfirmEmailCommand(ApplicationUser user, string confirmationCode, UserManager<ApplicationUser> userManager)
        {
            User = user;
            ConfirmationCode = confirmationCode;
            AccountHandler = new AccountHandler(userManager);
        }
        public async Task<object> Execute()
        {
            return await AccountHandler.ConfirmEmail(User, ConfirmationCode);
        }
    }
}
