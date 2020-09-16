using AnimalCareSystem.Data;
using AnimalCareSystem.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace AnimalCareSystem.ApplicationUI
{
    public class GetServiceTypesCommand : ICommand
    {
        private ServiceHandler ServiceHandler;
        public GetServiceTypesCommand(ApplicationDbContext dbContext)
        {
            ServiceHandler = new ServiceHandler(dbContext);
        }
        public async Task<object> Execute()
        {
            return await ServiceHandler.GetServiceTypes();
        }
    }
}
