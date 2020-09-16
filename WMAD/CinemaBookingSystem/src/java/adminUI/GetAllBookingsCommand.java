package adminUI;

import handler.BookingHandler;

/**
 *
 * @author Rhys Jones
 */
public class GetAllBookingsCommand implements AdminCommand
{
    BookingHandler bookHndlr = null;
    public GetAllBookingsCommand()
    {
        bookHndlr = BookingHandler.getInstance();
    }

    @Override
    public Object execute()
    {
        return bookHndlr.getAllBookings();
    }
    
}
