package handler;

import dto.CinemaDTO;
import dto.ScreenDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public class ScreenHandler
{

    private static ScreenHandler instance = null;

    protected ScreenHandler()
    {
    }

    public static ScreenHandler getInstance()
    {
        if (instance == null)
        {
            instance = new ScreenHandler();
        }
        return instance;
    }

    public ArrayList<ScreenDTO> getCinemaScreens(ArrayList<CinemaDTO> cinemas)
    {
        ArrayList<ScreenDTO> screens = new ArrayList();
        DatabaseHandler db = DatabaseHandler.getInstance();

        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Screen");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                for (int i = 0; i < cinemas.size(); i++)
                {
                    if (rs.getInt("Cinema_ID") == cinemas.get(i).getCinemaID())
                    {
                        ScreenDTO screen = new ScreenDTO(rs.getInt("Screen_ID"), cinemas.get(i), rs.getString("Name"));
                        screens.add(screen);
                    }
                }
            }

            rs.close();
            stmt.close();
            conn.close();

        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCould not get screens.\n" + sqle);
        }
        return screens;
    }

    public ArrayList<ScreenDTO> getAllScreens()
    {
        ArrayList<ScreenDTO> screens = new ArrayList();
        CinemaHandler cineHndlr = new CinemaHandler();
        ArrayList<CinemaDTO> cinemas = cineHndlr.getAllCinemas();
        DatabaseHandler db = DatabaseHandler.getInstance();

        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Screen");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                for (int i = 0; i < cinemas.size(); i++)
                {
                    if (rs.getInt("Cinema_ID") == cinemas.get(i).getCinemaID())
                    {
                        ScreenDTO screen = new ScreenDTO(rs.getInt("Screen_ID"), cinemas.get(i), rs.getString("Name"));
                        screens.add(screen);
                    }
                }
            }

            rs.close();
            stmt.close();
            conn.close();

        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCould not get screens.\n" + sqle);
        }
        return screens;
    }
}
