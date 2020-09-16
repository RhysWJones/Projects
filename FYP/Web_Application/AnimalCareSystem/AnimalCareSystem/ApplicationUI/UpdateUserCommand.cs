using AnimalCareSystem.Data;
using AnimalCareSystem.Handlers;
using AnimalCareSystem.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ApplicationUI
{
    public class UpdateUserCommand : ICommand
    {
        private AccountHandler AccountHandler;
        private ApplicationUser EditedUser;
        public UpdateUserCommand(ApplicationUser editedUser, ApplicationDbContext dbContext)
        {
            EditedUser = editedUser;
            AccountHandler = new AccountHandler(dbContext);
        }
        public async Task<object> Execute()
        {
            return await AccountHandler.UpdateUser(EditedUser);
        }
    }
}
