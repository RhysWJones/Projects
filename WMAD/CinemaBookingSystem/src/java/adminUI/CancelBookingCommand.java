package adminUI;

import dto.BookingDTO;
import handler.BookingHandler;

/**
 *
 * @author Rhys Jones
 */
public class CancelBookingCommand implements AdminCommand
{
    private BookingDTO booking;
    private BookingHandler bookHndlr = null;
    public CancelBookingCommand(BookingDTO booking)
    {
        this.booking = booking;
        bookHndlr = BookingHandler.getInstance();
    }

    @Override
    public Object execute()
    {
        return bookHndlr.cancelBooking(booking);
    }
    
}
