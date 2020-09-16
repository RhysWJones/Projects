package handler;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rhysj
 */
public class CustomerHandler
{

    private static CustomerHandler instance = null;

    protected CustomerHandler()
    {
    }

    public static CustomerHandler getInstance()
    {
        if (instance == null)
        {
            instance = new CustomerHandler();
        }
        return instance;
    }

    public boolean insertCustomer(UserDTO newCustomer)
    {
        boolean insertOK = false;
        DatabaseHandler db = DatabaseHandler.getInstance();

        try
        {
            Connection conn = db.getConnection();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Users (forename, surname, DOB, address_line_1, address_line_2, username, password, postcode, admin) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, newCustomer.getForename());
            stmt.setString(2, newCustomer.getSurname());
            java.sql.Date DOB = new java.sql.Date(newCustomer.getDOB().getTime());
            stmt.setDate(3, DOB);
            stmt.setString(4, newCustomer.getAddressLine1());
            stmt.setString(5, newCustomer.getAddressLine2());
            stmt.setString(6, newCustomer.getUsername());
            stmt.setString(7, newCustomer.getPassword());
            stmt.setString(8, newCustomer.getPostcode());
            stmt.setBoolean(9, false);

            int rows = stmt.executeUpdate();

            insertOK = rows == 1;

            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCOULD NOT INSERT CUSTOMER\n" + sqle);
        }
        return insertOK;
    }

    public UserDTO checkCustomerCredentials(String username, String password)
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
            System.out.println("Customer credentials incorrect.\n" + e);
        }

        if (correctCredentials)
        {
            UserDTO customer = getCustomerDetails(userID);
            return customer;
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login credentials are not correct"));
            return null;
        }
    }

    public UserDTO getCustomerDetails(int userID)
    {
        UserDTO customerDetails = null;
        DatabaseHandler db = DatabaseHandler.getInstance();

        try
        {
            Connection conn = db.getConnection();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE user_id = ?");
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                customerDetails = new UserDTO(rs.getInt("user_ID"), rs.getString("forename"), rs.getString("surname"), rs.getDate("DOB"), rs.getString("address_line_1"),
                        rs.getString("address_line_2"), rs.getString("postcode"), rs.getString("username"), rs.getString("password"), rs.getBoolean("admin"));
            }

            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println("Error" + sqle);
        }
        return customerDetails;
    }

    public boolean updateAccountDetails(UserDTO customer)
    {
        boolean updateOK = false;
        DatabaseHandler db = DatabaseHandler.getInstance();

        try
        {
            Connection conn = db.getConnection();

            PreparedStatement stmt = conn.prepareStatement("UPDATE Users SET FORENAME = '" + customer.getForename() + "', SURNAME = '" + customer.getSurname()
                    + "', ADDRESS_LINE_1 = '" + customer.getAddressLine1() + "', ADDRESS_LINE_2 = '" + customer.getAddressLine2() + "', POSTCODE = '" + customer.getPostcode()
                    + "', PASSWORD = '" + customer.getPassword() + "' WHERE User_ID = ?");
            stmt.setInt(1, customer.getUserID());

            int rows = stmt.executeUpdate();

            updateOK = rows == 1;

            stmt.close();
            conn.close();
        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCOULD NOT INSERT CUSTOMER\n" + sqle);
        }
        return updateOK;
    }

    public ArrayList<UserDTO> getAllCustomers()
    {
        ArrayList<UserDTO> customers = new ArrayList();
        DatabaseHandler db = DatabaseHandler.getInstance();

        try
        {
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM USERS WHERE ADMIN = FALSE");
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                UserDTO customer = new UserDTO(rs.getInt("USER_ID"), rs.getString("FORENAME"), rs.getString("SURNAME"),
                        rs.getDate("DOB"), rs.getString("ADDRESS_LINE_1"), rs.getString("ADDRESS_LINE_2"),
                        rs.getString("POSTCODE"), rs.getString("USERNAME"), rs.getString("PASSWORD"), false);
                customers.add(customer);
            }

            rs.close();
            stmt.close();
            conn.close();

        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\nCould not get Customers.\n" + sqle);
            return null;
        }
        return customers;
    }
}
