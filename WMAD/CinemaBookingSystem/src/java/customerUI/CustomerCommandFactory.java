package customerUI;

import dto.CinemaDTO;
import dto.ScreenDTO;
import dto.ShowingDTO;
import dto.UserDTO;
import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public class CustomerCommandFactory
{

    public static final int REGISTER_CUSTOMER = 1;
    public static final int LOGIN_CUSTOMER = 2;
    public static final int GET_ALL_CINEMAS = 3;
    public static final int GET_CINEMA_SCREENS = 4;
    public static final int GET_SCREEN_SHOWINGS = 5;
    public static final int UPDATE_ACCOUNT_DETAILS = 6;
    public static final int BOOK_TICKETS = 7;

    public static CustomerCommand createCommand(int commandType, UserDTO customer)
    {
        switch (commandType)
        {
            case REGISTER_CUSTOMER:
                return new RegisterCustomerCommand(customer);
            case UPDATE_ACCOUNT_DETAILS:
                return new UpdateAccountDetailsCommand(customer);
            default:
                return null;
        }
    }

    public static CustomerCommand createCommand(int commandType, String username, String password)
    {
        switch (commandType)
        {
            case LOGIN_CUSTOMER:
                return new LoginCustomerCommand(username, password);
            default:
                return null;
        }
    }

    public static CustomerCommand createCommand(int commandType)
    {
        switch (commandType)
        {
            case GET_ALL_CINEMAS:
                return new GetAllCinemasCommand();
            default:
                return null;
        }
    }
    
    public static CustomerCommand createCommand(int commandType, ArrayList<CinemaDTO> cinemas)
    {
        switch (commandType)
        {
            case GET_CINEMA_SCREENS:
                return new GetCinemaScreensCommand(cinemas);
            default:
                return null;
        }
    }
    
    public static CustomerCommand createCommand(int commandType, ScreenDTO screen)
    {
        switch (commandType)
        {
            case GET_SCREEN_SHOWINGS:
                return new GetScreenShowingsCommand(screen);
            default:
                return null;
        }
    }
    
    public static CustomerCommand createCommand(int commandType, ShowingDTO showing, UserDTO customer, int noOfSeats)
    {
        switch (commandType)
        {
            case BOOK_TICKETS:
                return new BookTicketsCommand(showing, customer, noOfSeats);
            default:
                return null;
        }
    }
}
