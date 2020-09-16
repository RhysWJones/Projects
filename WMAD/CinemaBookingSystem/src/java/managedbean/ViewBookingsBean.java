package managedbean;

import adminUI.AdminCommandFactory;
import dto.BookingDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Rhys Jones
 */
@Named(value = "ViewBookingsBean")
@SessionScoped
public class ViewBookingsBean implements Serializable
{

    private ArrayList<BookingDTO> bookings;

    public String viewBookings()
    {
        bookings = new ArrayList();

        bookings = (ArrayList<BookingDTO>) AdminCommandFactory
                .createCommand(
                        AdminCommandFactory.GET_ALL_BOOKINGS)
                .execute();

        if (!bookings.isEmpty())
        {
            return "View Bookings";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: No Bookings."));
            return null;
        }
    }
    
    public String cancelBooking(BookingDTO booking)
    {
        boolean cancelOK = false;
        
        cancelOK = (boolean) AdminCommandFactory
                .createCommand(
                        AdminCommandFactory.CANCEL_BOOKING, booking)
                .execute();
        
        if(cancelOK)
        {
            bookings.remove(booking);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Booking Cancelled."));
            return "Cancelled";
        }
        else 
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: Could not cancel booking."));
            return null;
        }
    }

    public ArrayList<BookingDTO> getBookings()
    {
        return bookings;
    }

    public void setBookings(ArrayList<BookingDTO> bookings)
    {
        this.bookings = bookings;
    }
    
    
}
