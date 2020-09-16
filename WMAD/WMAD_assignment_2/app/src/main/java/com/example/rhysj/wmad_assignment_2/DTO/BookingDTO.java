package com.example.rhysj.wmad_assignment_2.DTO;

/**
 * Created by Rhys Jones on 04/04/2018.
 */
        import java.io.Serializable;

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
