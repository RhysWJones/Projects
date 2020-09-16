package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DatabaseConnectionPool
{

    private static final DatabaseConnectionPool INSTANCE = new DatabaseConnectionPool();
    private static final String URL = "jdbc:derby://localhost:1527/ESA1";

    private ArrayList<Connection> availableConnections = new ArrayList<>(5);
    private ArrayList<Connection> busyConnections = new ArrayList<>(5);

    public static DatabaseConnectionPool getInstance()
    {
        return INSTANCE;
    }

    private DatabaseConnectionPool()
    {
        for (int i = 0; i < 5; i++)
        {
            try
            {
                availableConnections.add(establishConnection());
            }
            catch (Exception e)
            {
                e.printStackTrace(System.err);
            }
        }
    }

    private void closeConnection(Connection con)
    {
        try
        {
            con.close();
        }
        catch (Exception e)
        {
        }

    }

    public synchronized Connection getAvailableConnection()
    {
        Connection con = null;

        if (availableConnections.size() > 0)
        {
            con = availableConnections.remove(0);

            if (con != null)
            {
                busyConnections.add(con);
            }
        }

        return con;
    }

    private Connection establishConnection() throws Exception
    {
        Connection con = null;

        try
        {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());

            con = DriverManager.getConnection(URL);
            //con = DriverManager.getConnection(URL, "Greg", "Greg");
        }
        catch (Exception e)
        {
            throw new Exception("Problem connecting to the database", e);
        }

        return con;
    }

    public synchronized Connection returnConnection(Connection con)
    {
        if (busyConnections.remove(con))
        {
            availableConnections.add(con);
        }

        return con;
    }

    @Override
    protected void finalize() throws Throwable
    {
        for (Connection con : availableConnections)
        {
            closeConnection(con);
        }
        for (Connection con : busyConnections)
        {
            closeConnection(con);
        }
        super.finalize();
    }
}
