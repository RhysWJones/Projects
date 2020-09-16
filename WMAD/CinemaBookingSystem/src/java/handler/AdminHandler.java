package handler;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rhysj
 */
public class AdminHandler
{

    private static AdminHandler instance = null;

    protected AdminHandler()
    {
        //stops instantiation
    }

    public static AdminHandler getInstance()
    {
        if (instance == null)
        {
            instance = new AdminHandler();
        }
        return instance;
    }

    public UserDTO checkAdminCredentials(String username, String password)
    {
        boolean correctCredentials = false;
        int userID = 0;
        DatabaseHandler db = DatabaseHandler.getInstance();
        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Users WHERE username = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            correctCredentials = rs.next() && rs.getString("password").equals(password);
            userID = rs.getInt("user_id");

            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.out.println("Error\n" + e);
        }

        if (correctCredentials)
        {
            UserDTO admin = getAdminDetails(userID);
            return admin;
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login credentials are not correct"));
            return null;
        }
    }

    public UserDTO getAdminDetails(int userID)
    {
        UserDTO adminDetails = null;
        DatabaseHandler db = DatabaseHandler.getInstance();
        try
        {
            Connection conn = db.getConnection();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE user_id = ?");
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                adminDetails = new UserDTO(rs.getInt("user_ID"), rs.getString("forename"), rs.getString("surname"), rs.getDate("DOB"), rs.getString("address_line_1"),
                        rs.getString("address_line_2"), rs.getString("postcode"), rs.getString("username"), rs.getString("password"), rs.getBoolean("admin"));
            }

            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println("Error\n" + sqle);
        }
        return adminDetails;
    }
}
