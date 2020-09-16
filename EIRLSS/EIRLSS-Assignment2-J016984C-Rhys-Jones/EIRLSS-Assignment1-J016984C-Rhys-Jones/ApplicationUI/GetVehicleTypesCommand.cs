using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class GetVehicleTypesCommand : ICommand
    {
        private VehicleHandler VehicleHandler;

        public GetVehicleTypesCommand(ApplicationDbContext dbContext)
        {
            VehicleHandler = new VehicleHandler(dbContext);
        }

        public async Task<object> Execute()
        {
            return await VehicleHandler.GetVehicleTypes();
        }
    }
}
