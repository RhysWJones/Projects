using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class GetCoincidingBookingsCommand : ICommand
    {
        private DateTime RequestedStartDate;
        private DateTime RequestedEndDate;
        private BookingHandler BookingHandler;

        public GetCoincidingBookingsCommand(DateTime requestedStartDate, DateTime requestedEndDate, ApplicationDbContext dbContext)
        {
            BookingHandler = new BookingHandler(dbContext);
            RequestedStartDate = requestedStartDate;
            RequestedEndDate = requestedEndDate;
        }

        public async Task<object> Execute()
        {
            return await BookingHandler.GetCoincidingBookings(RequestedStartDate, RequestedEndDate);
        }
    }
}
