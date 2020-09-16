using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class UpdateVehicleCostPerDayCommand : ICommand
    {
        private VehicleHandler VehicleHandler;
        private long VehicleId;
        private int NewCostPerDay;

        public UpdateVehicleCostPerDayCommand(ApplicationDbContext dbContext, long vehicleId, int newCostPerDay)
        {
            VehicleHandler = new VehicleHandler(dbContext);
            VehicleId = vehicleId;
            NewCostPerDay = newCostPerDay;
        }

        public async Task<object> Execute()
        {
            return await VehicleHandler.UpdateVehicleCostPerDay(VehicleId, NewCostPerDay);
        }
    }
}
