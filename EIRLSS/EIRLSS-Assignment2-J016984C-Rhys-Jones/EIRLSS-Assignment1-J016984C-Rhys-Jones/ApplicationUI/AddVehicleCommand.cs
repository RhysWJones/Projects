using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class AddVehicleCommand : ICommand
    {
        private VehicleHandler VehicleHandler;
        private Vehicle NewVehicle;

        public AddVehicleCommand(Vehicle vehicle, ApplicationDbContext dbContext)
        {
            VehicleHandler = new VehicleHandler(dbContext);
            NewVehicle = vehicle;
        }

        public async Task<object> Execute()
        {
            return await VehicleHandler.AddVehicle(NewVehicle);
        }
    }
}
