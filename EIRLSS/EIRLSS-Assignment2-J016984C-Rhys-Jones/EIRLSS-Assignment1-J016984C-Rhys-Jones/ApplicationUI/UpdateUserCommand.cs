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
    public class UpdateUserCommand : ICommand
    {
        private UserHandler UserHandler;
        private ApplicationUser UpdatedUser;

        public UpdateUserCommand(ApplicationUser updatedUser, UserManager<ApplicationUser> userManager, ApplicationDbContext dbContext)
        {
            UserHandler = new UserHandler(userManager, dbContext);
            UpdatedUser = updatedUser;
        }

        public async Task<object> Execute()
        {
            return await UserHandler.UpdateUser(UpdatedUser);
        }
    }
}
