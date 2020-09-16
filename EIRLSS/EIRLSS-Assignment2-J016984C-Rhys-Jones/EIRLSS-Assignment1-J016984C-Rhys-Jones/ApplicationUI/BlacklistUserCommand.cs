using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using Microsoft.AspNetCore.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class BlacklistUserCommand : ICommand
    {
        private UserHandler UserHandler;
        private string UserId;

        public BlacklistUserCommand(string userId, ApplicationDbContext dbContext, UserManager<ApplicationUser> userManager)
        {
            UserId = userId;
            UserHandler = new UserHandler(userManager, dbContext);
        }

        public async Task<object> Execute()
        {
            return await UserHandler.BlacklistUser(UserId);
        }
    }
}
