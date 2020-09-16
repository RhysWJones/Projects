package adminUI;

import dto.BookingDTO;
import dto.FilmDTO;
import dto.ScreenDTO;

/**
 *
 * @author Rhys Jones
 */
public class AdminCommandFactory
{

    public static final int LOGIN_ADMIN = 1;
    public static final int GET_ALL_FILMS = 2;
    public static final int DELETE_FILM = 3;
    public static final int ADD_FILM = 4;
    public static final int GET_ALL_BOOKINGS = 5;
    public static final int CANCEL_BOOKING = 6;
    public static final int ADD_SHOWING = 7;

    public static AdminCommand createCommand(int commandType, String username, String password)
    {
        switch (commandType)
        {
            case LOGIN_ADMIN:
                return new LoginAdminCommand(username, password);
            default:
                return null;
        }
    }

    public static AdminCommand createCommand(int commandType)
    {
        switch (commandType)
        {
            case GET_ALL_FILMS:
                return new GetAllFilmsCommand();
            case GET_ALL_BOOKINGS:
                return new GetAllBookingsCommand();
            default:
                return null;
        }
    }

    public static AdminCommand createCommand(int commandType, int filmID)
    {
        switch (commandType)
        {
            case DELETE_FILM:
                return new DeleteFilmCommand(filmID);
            default:
                return null;
        }
    }
    
    public static AdminCommand createCommand(int commandType, FilmDTO film)
    {
        switch (commandType)
        {
            case ADD_FILM:
                return new AddFilmCommand(film);
            default:
                return null;
        }
    }
    
    public static AdminCommand createCommand(int commandType, BookingDTO booking)
    {
        switch (commandType)
        {
            case CANCEL_BOOKING:
                return new CancelBookingCommand(booking);
            default:
                return null;
        }
    }
    
    public static AdminCommand createCommand(int commandType, FilmDTO film, ScreenDTO screen, String time)
    {
        switch (commandType)
        {
            case ADD_SHOWING:
                return new AddShowingCommand(film, screen, time);
            default:
                return null;
        }
    }
}
