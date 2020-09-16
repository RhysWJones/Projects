package handler;

import dto.BookingDTO;
import dto.ShowingDTO;
import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public class BookingHandler
{

    private static BookingHandler instance = null;

    protected BookingHandler()
    {
    }

    public static BookingHandler getInstance()
    {
        if (instance == null)
        {
            instance = new BookingHandler();
        }
        return instance;
    }

    public boolean createBooking(ShowingDTO showing, UserDTO customer, int noOfSeats)
    {
        boolean insertOK = false;
        int availableSeats = 0;
        DatabaseHandler db = DatabaseHandler.getInstance();

        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SHOWING WHERE SHOWING_ID = ?");
            stmt.setInt(1, showing.getShowingID());
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                availableSeats = rs.getInt("Available_Seats");
            }

            if (availableSeats - noOfSeats >= 0)
            {
                stmt = conn.prepareStatement("INSERT INTO BOOKING (USER_ID, SHOWING_ID, QUANTITY) values (?, ?, ?)");

                stmt.setInt(1, customer.getUserID());
                stmt.setInt(2, showing.getShowingID());
                stmt.setInt(3, noOfSeats);

                int rows = stmt.executeUpdate();

                insertOK = rows == 1;

                if (insertOK)
                {
                    stmt = conn.prepareStatement("UPDATE SHOWING SET AVAILABLE_SEATS = AVAILABLE_SEATS - (?) WHERE SHOWING_ID = ?");
                    stmt.setInt(1, noOfSeats);
                    stmt.setInt(2, showing.getShowingID());
                    stmt.executeUpdate();
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCOULD NOT CREATE BOOKING\n" + sqle);
        }
        return insertOK;
    }

    public ArrayList<BookingDTO> getAllBookings()
    {
        ShowingHandler showingHndlr = new ShowingHandler();
        ArrayList<ShowingDTO> showings = showingHndlr.getAllShowings();
        CustomerHandler custHndlr = new CustomerHandler();
        ArrayList<UserDTO> users = custHndlr.getAllCustomers();
        ArrayList<BookingDTO> bookings = new ArrayList();
        DatabaseHandler db = DatabaseHandler.getInstance();

        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM BOOKING");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                for (int i = 0; i < users.size(); i++)
                {
                    for (int j = 0; j < showings.size(); j++)
                    {
                        if (rs.getInt("USER_ID") == users.get(i).getUserID() && rs.getInt("SHOWING_ID") == showings.get(j).getShowingID())
                        {
                            BookingDTO booking = new BookingDTO(rs.getInt("BOOKING_ID"), users.get(i), showings.get(j), rs.getInt("QUANTITY"));
                            bookings.add(booking);
                        }
                    }
                }
            }

            rs.close();
            stmt.close();
            conn.close();

        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCould not get bookings.\n" + sqle);
            return null;
        }
        return bookings;
    }

    public boolean cancelBooking(BookingDTO booking)
    {
        DatabaseHandler db = DatabaseHandler.getInstance();

        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM BOOKING WHERE BOOKING_ID = ?");
            stmt.setInt(1, booking.getBookingID());
            stmt.executeUpdate();

            stmt = conn.prepareStatement("UPDATE SHOWING SET AVAILABLE_SEATS = AVAILABLE_SEATS + (?) WHERE SHOWING_ID = ?");
            stmt.setInt(1, booking.getQuantity());
            stmt.setInt(2, booking.getShowing().getShowingID());
            stmt.executeUpdate();
        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCould not delete booking.\n" + sqle);
            return false;
        }
        return true;
    }
}
