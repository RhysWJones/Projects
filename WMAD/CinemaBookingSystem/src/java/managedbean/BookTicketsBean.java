package managedbean;

import customerUI.CustomerCommandFactory;
import dto.ShowingDTO;
import dto.UserDTO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rhys Jones
 */
@Named(value = "BookTicketsBean")
@SessionScoped
public class BookTicketsBean implements Serializable
{
    private int noOfSeats;
    private ShowingDTO showing;
    private final HttpSession sessionScope = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

    public BookTicketsBean()
    {
    }
    
    public String bookTickets()
    {
        boolean bookingOK;
        UserDTO customer = (UserDTO)sessionScope.getAttribute("loggedCustomer");
        
        bookingOK = (boolean) CustomerCommandFactory
                .createCommand(
                        CustomerCommandFactory.BOOK_TICKETS, showing, customer, noOfSeats)
                .execute();
        
        if(bookingOK)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Booking successful."));
            return "Tickets Booked";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: Booking unsuccessful."));
            return null;
        }
    }

    public int getNoOfSeats()
    {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats)
    {
        this.noOfSeats = noOfSeats;
    }

    public ShowingDTO getShowing()
    {
        return showing;
    }

    public void setShowing(ShowingDTO showing)
    {
        this.showing = showing;
    }
    
    public String setShowingForBooking(ShowingDTO showing)
    {
        setShowing(showing);
        return "Book Tickets";
    }
    
}
