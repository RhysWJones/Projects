package handler;

import dto.FilmDTO;
import dto.ScreenDTO;
import dto.ShowingDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rhys Jones
 */
public class ShowingHandler
{

    private static ShowingHandler instance = null;

    protected ShowingHandler()
    {
    }

    public static ShowingHandler getInstance()
    {
        if (instance == null)
        {
            instance = new ShowingHandler();
        }
        return instance;
    }

    public ArrayList<ShowingDTO> getScreenShowings(ScreenDTO screen)
    {
        FilmHandler filmHndlr = new FilmHandler();
        ArrayList<ShowingDTO> showings = new ArrayList();
        ArrayList<FilmDTO> films = new ArrayList();
        films = filmHndlr.getAllFilms();
        Date time;
        DatabaseHandler db = DatabaseHandler.getInstance();

        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM showing WHERE (SCREEN_ID) = ?");
            stmt.setInt(1, screen.getScreenID());
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                for (int i = 0; i < films.size(); i++)
                {
                    if (rs.getInt("film_id") == films.get(i).getFilmID())
                    {
                        time = new Date(rs.getTime("time").getTime());
                        ShowingDTO showing = new ShowingDTO(rs.getInt("Showing_ID"), films.get(i), screen, time, rs.getInt("Available_Seats"));
                        showings.add(showing);
                    }
                }
            }

            rs.close();
            stmt.close();
            conn.close();

        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCould not get Showings or Films.\n" + sqle);
        }
        return showings;
    }

    public ArrayList<ShowingDTO> getAllShowings()
    {
        FilmHandler filmHndlr = new FilmHandler();
        ScreenHandler screenHndlr = new ScreenHandler();
        ArrayList<ShowingDTO> showings = new ArrayList();
        ArrayList<FilmDTO> films = filmHndlr.getAllFilms();
        ArrayList<ScreenDTO> screens = screenHndlr.getAllScreens();
        Date time;
        DatabaseHandler db = DatabaseHandler.getInstance();
        
        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM showing");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                for (int i = 0; i < films.size(); i++)
                {
                    if (rs.getInt("film_id") == films.get(i).getFilmID())
                    {
                        time = new Date(rs.getTime("time").getTime());
                        ShowingDTO showing = new ShowingDTO(rs.getInt("Showing_ID"), films.get(i), screens.get(i), time, rs.getInt("Available_Seats"));
                        showings.add(showing);
                    }
                }
            }

            rs.close();
            stmt.close();
            conn.close();

        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCould not get Showings.\n" + sqle);
        }
        return showings;
    }

    public boolean addShowing(FilmDTO film, ScreenDTO screen, String time)
    {
        boolean insertOK = false;
        DatabaseHandler db = DatabaseHandler.getInstance();
        
        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO SHOWING (FILM_ID, SCREEN_ID, TIME, AVAILABLE_SEATS) values (?, ?, ?, ?)");

            stmt.setInt(1, film.getFilmID());
            stmt.setInt(2, screen.getScreenID());
            stmt.setTime(3, java.sql.Time.valueOf(time));
            stmt.setInt(4, 20);
            int rows = stmt.executeUpdate();

            insertOK = rows == 1;

            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCOULD NOT INSERT SHOWING\n" + sqle);
        }
        return insertOK;
    }
}
