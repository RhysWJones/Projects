package customerUI;

import dto.ShowingDTO;
import dto.UserDTO;
import handler.BookingHandler;

/**
 *
 * @author Rhys Jones
 */
public class BookTicketsCommand implements CustomerCommand
{
    private ShowingDTO showing;
    private UserDTO customer;
    private int noOfSeats;
    BookingHandler bookHndlr = null;

    public BookTicketsCommand(ShowingDTO showing, UserDTO customer, int noOfSeats)
    {
        this.customer = customer;
        this.showing = showing;
        this.noOfSeats = noOfSeats;
        bookHndlr = BookingHandler.getInstance();
    }


    @Override
    public Object execute()
    {
        return bookHndlr.createBooking(showing, customer, noOfSeats);
    }
    
}
