using EIRLSS_Assignment1_J016984C_Rhys_Jones.Data;
using EIRLSS_Assignment1_J016984C_Rhys_Jones.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EIRLSS_Assignment1_J016984C_Rhys_Jones.ApplicationUI
{
    public class GetAllBookingsForUserCommand : ICommand
    {
        private BookingHandler BookingHandler;
        private string UserId;

        public GetAllBookingsForUserCommand(string userId, ApplicationDbContext dbContext)
        {
            BookingHandler = new BookingHandler(dbContext);
            UserId = userId;
        }
        public async Task<object> Execute()
        {
            return await BookingHandler.GetAllBookingsForUser(UserId);
        }
    }
}
