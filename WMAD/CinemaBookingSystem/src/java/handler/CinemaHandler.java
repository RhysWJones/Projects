package handler;

import dto.CinemaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public class CinemaHandler
{

    private static CinemaHandler instance = null;

    protected CinemaHandler()
    {
    }

    public static CinemaHandler getInstance()
    {
        if (instance == null)
        {
            instance = new CinemaHandler();
        }
        return instance;
    }

    public ArrayList<CinemaDTO> getAllCinemas()
    {
        ArrayList<CinemaDTO> cinemas = new ArrayList();
        DatabaseHandler db = DatabaseHandler.getInstance();
        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Cinema");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                CinemaDTO cinema = new CinemaDTO(rs.getInt("Cinema_ID"), rs.getString("Name"));
                cinemas.add(cinema);
            }
            rs.close();
            stmt.close();
            conn.close();

        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCould not get cinemas/screens.\n" + sqle);
        }
        return cinemas;
    }
}
