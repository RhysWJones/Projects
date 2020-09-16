using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class CollectBookingCommand : ICommand
    {
        private BookingHandler BookingHandler;
        private long BookingId;

        public CollectBookingCommand(long bookingId, ApplicationDbContext dbContext)
        {
            BookingHandler = new BookingHandler(dbContext);
            BookingId = bookingId;
        }
        public async Task<object> Execute()
        {
            return await BookingHandler.CollectBooking(BookingId);
        }
    }
}
