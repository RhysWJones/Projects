using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class GetAllBookingsForVehicleCommand : ICommand
    {
        long VehiclId;
        private BookingHandler BookingHandler;
        public GetAllBookingsForVehicleCommand(long vehicleId, ApplicationDbContext dbContext)
        {
            VehiclId = vehicleId;
            BookingHandler = new BookingHandler(dbContext);
        }
        public async Task<object> Execute()
        {
            return await BookingHandler.GetAllBookingsForVehicle(VehiclId);
        }
    }
}
