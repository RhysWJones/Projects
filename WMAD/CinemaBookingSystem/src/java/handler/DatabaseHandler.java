package handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler
{
    private static DatabaseHandler instance = null;

    protected DatabaseHandler()
    {
    }

    public static DatabaseHandler getInstance()
    {
        if (instance == null)
        {
            instance = new DatabaseHandler();
        }
        return instance;
    }

    public static Connection getConnection() throws SQLException
    {
        DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
        return DriverManager.getConnection("jdbc:derby://localhost:1527/Cinema System", "j016984c", "J016984C");
    }

}
