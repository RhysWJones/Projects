package Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Deals with database interactions.
 * @author Rhys Jones
 */
public class DatabaseManager
{
    private String username;
    private String password;
    private final String url;
    
    private static DatabaseManager instance = new DatabaseManager();
    
    protected DatabaseManager()
    {
        url = "jdbc:oracle:thin:@crusstuora1.staffs.ac.uk:1521:stora";
    }
    
    public static DatabaseManager getInstance()
    {
        return instance;
    }
    
    public Connection getConnection() throws SQLException
    {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        return DriverManager.getConnection(url, username, password);
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
