using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class AddBookingCommand : ICommand
    {
        BookingHandler BookingHandler;
        Booking NewBooking;
        List<Equipment> ChosenEquipmentList;

        public AddBookingCommand(Booking newBooking, List<Equipment> chosenEquipmentList, ApplicationDbContext dbContext)
        {
            BookingHandler = new BookingHandler(dbContext);
            NewBooking = newBooking;
            ChosenEquipmentList = chosenEquipmentList;
        }

        public async Task<object> Execute()
        {
            return await BookingHandler.AddBooking(NewBooking, ChosenEquipmentList);
        }
    }
}
