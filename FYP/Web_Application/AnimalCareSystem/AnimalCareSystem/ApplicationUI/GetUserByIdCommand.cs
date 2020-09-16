using AnimalCareSystem.Data;
using AnimalCareSystem.Handlers;
using AnimalCareSystem.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ApplicationUI
{
    public class GetUserByIdCommand : ICommand
    {
        private string UserId;
        private AccountHandler AccountHandler;
        public GetUserByIdCommand(string userId, UserManager<ApplicationUser> userManager, ApplicationDbContext dbContext)
        {
            UserId = userId;
            AccountHandler = new AccountHandler(userManager, dbContext);
        }
        public async Task<object> Execute()
        {
            return await AccountHandler.GetUserById(UserId);
        }
    }
}
