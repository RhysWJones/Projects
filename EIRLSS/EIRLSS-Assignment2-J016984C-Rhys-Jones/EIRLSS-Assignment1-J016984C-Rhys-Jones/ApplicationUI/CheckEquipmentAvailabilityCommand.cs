using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class CheckEquipmentAvailabilityCommand : ICommand
    {
        private EquipmentHandler EquipmentHandler;
        private Equipment Equipment;
        private List<Booking> Bookings;

        public CheckEquipmentAvailabilityCommand(Equipment equipment, List<Booking> bookings, ApplicationDbContext dbContext)
        {
            Equipment = equipment;
            Bookings = bookings;
            EquipmentHandler = new EquipmentHandler(dbContext);
        }

        public async Task<object> Execute()
        {
            return await EquipmentHandler.CheckEquipmentAvailability(Equipment, Bookings);
        }
    }
}
