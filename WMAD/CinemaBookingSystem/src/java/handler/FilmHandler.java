package handler;

import dto.FilmDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public class FilmHandler
{

    private static FilmHandler instance = null;

    protected FilmHandler()
    {
    }

    public static FilmHandler getInstance()
    {
        if (instance == null)
        {
            instance = new FilmHandler();
        }
        return instance;
    }

    public ArrayList<FilmDTO> getAllFilms()
    {
        ArrayList<FilmDTO> films = new ArrayList();
        DatabaseHandler db = DatabaseHandler.getInstance();

        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM FILM");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                FilmDTO film = new FilmDTO(rs.getInt("Film_ID"), rs.getString("Title"), rs.getInt("Age_Rating"), rs.getInt("Runtime"), rs.getString("Description"));
                films.add(film);
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCould not get Films.\n" + sqle);
        }
        return films;
    }

    public boolean deleteFilm(int filmID)
    {
        DatabaseHandler db = DatabaseHandler.getInstance();

        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM FILM WHERE FILM_ID = ?");
            stmt.setInt(1, filmID);
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
            return false;
        }
        return true;
    }

    public boolean addFilm(FilmDTO film)
    {
        boolean insertOK = false;
        DatabaseHandler db = DatabaseHandler.getInstance();
        
        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO FILM (title, age_rating, runtime, description) values (?, ?, ?, ?)");

            stmt.setString(1, film.getTitle());
            stmt.setInt(2, film.getAgeRating());
            stmt.setInt(3, film.getRuntime());
            stmt.setString(4, film.getDescription());
            int rows = stmt.executeUpdate();

            insertOK = rows == 1;

            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCOULD NOT INSERT FILM\n" + sqle);
        }
        return insertOK;
    }
}
