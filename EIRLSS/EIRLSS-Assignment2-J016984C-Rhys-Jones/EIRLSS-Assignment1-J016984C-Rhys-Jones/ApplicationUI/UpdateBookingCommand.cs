using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class UpdateBookingCommand : ICommand
    {
        private Booking Booking;
        private List<Equipment> ChosenEquipmentList;
        private BookingHandler BookingHandler;

        public UpdateBookingCommand(Booking booking, List<Equipment> chosenEquipmentList, ApplicationDbContext dbContext)
        {
            Booking = booking;
            ChosenEquipmentList = chosenEquipmentList;
            BookingHandler = new BookingHandler(dbContext);
    }
        public async Task<object> Execute()
        {
            return await BookingHandler.UpdateBooking(Booking, ChosenEquipmentList);
        }
    }
}
