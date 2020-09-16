using AnimalCareSystem.Data;
using AnimalCareSystem.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ApplicationUI
{
    public class GetUsersByCityCommand : ICommand
    {
        private AccountHandler _accountHandler;
        private string _city;
        public GetUsersByCityCommand(string city, ApplicationDbContext dbContext)
        {
            _city = city;
            _accountHandler = new AccountHandler(dbContext);
        }
        public async Task<object> Execute()
        {
            return await _accountHandler.GetUsersByCity(_city);
        }
    }
}
