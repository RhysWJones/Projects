using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class UpdateVehicleComparisonSourceCommand : ICommand
    {
        private VehicleHandler VehicleHandler;
        private int VehicleId;
        private string ComparisonSourceURL;

        public UpdateVehicleComparisonSourceCommand(ApplicationDbContext dbContext, int vehicleId, string comparisonSourceURL)
        {
            VehicleHandler = new VehicleHandler(dbContext);
            VehicleId = vehicleId;
            ComparisonSourceURL = comparisonSourceURL;
        }

        public async Task<object> Execute()
        {
            return await VehicleHandler.UpdateVehicleComparisonSource(VehicleId, ComparisonSourceURL);
        }
    }
}
