using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class GetVehicleCommand : ICommand
    {
        private VehicleHandler VehicleHandler;
        private long VehicleId;

        public GetVehicleCommand(long vehicleId, ApplicationDbContext dbContext)
        {
            VehicleHandler = new VehicleHandler(dbContext);
            VehicleId = vehicleId;
        }

        public async Task<object> Execute()
        {
            return await VehicleHandler.GetVehicle(VehicleId);
        }
    }
}
