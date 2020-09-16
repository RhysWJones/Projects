package dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rhys Jones
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BookingDTO implements Serializable
{
    private int bookingID;
    private UserDTO customer;
    private ShowingDTO showing;
    private int quantity;

    public BookingDTO()
    {
        this.bookingID = 0;
        this.customer = new UserDTO();
        this.showing = new ShowingDTO();
        this.quantity = 0;
    }

    public BookingDTO(int bookingID, UserDTO customer, ShowingDTO showing, int quantity)
    {
        this.bookingID = bookingID;
        this.customer = customer;
        this.showing = showing;
        this.quantity = quantity;
    }

    public int getBookingID()
    {
        return bookingID;
    }

    public UserDTO getCustomer()
    {
        return customer;
    }

    public ShowingDTO getShowing()
    {
        return showing;
    }

    public int getQuantity()
    {
        return quantity;
    }

}
