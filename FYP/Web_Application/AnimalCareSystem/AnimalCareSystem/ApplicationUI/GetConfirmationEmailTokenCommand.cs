using AnimalCareSystem.Handlers;
using AnimalCareSystem.Models;
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ApplicationUI
{
    public class GetConfirmationEmailTokenCommand : ICommand
    {
        private ApplicationUser User;
        private AccountHandler AccountHandler;
        public GetConfirmationEmailTokenCommand(ApplicationUser user, UserManager<ApplicationUser> userManager)
        {
            User = user;
            AccountHandler = new AccountHandler(userManager);
        }

        public async Task<object> Execute()
        {
            return await AccountHandler.GetEmailConfirmationToken(User);
        }
    }
}
