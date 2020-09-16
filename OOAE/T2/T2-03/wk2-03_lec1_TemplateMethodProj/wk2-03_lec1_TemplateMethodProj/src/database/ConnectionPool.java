package database;

import java.sql.Connection;
import java.util.ArrayList;

public class ConnectionPool
{
    private final static ConnectionPool INSTANCE = new ConnectionPool();
    
    private ArrayList<Connection> pool;
    
    public static ConnectionPool getInstance()
    {
        return INSTANCE;
    }
    
    private ConnectionPool()
    {
        pool = new ArrayList<>();
        //set up connections
    }
    
    public Connection getAvailableConnection()
    {
        Connection con = null;
        //get connection from pool, make unavailable
        return con;
    }
    
    public void returnConnection(Connection c)
    {
        //make connection available again
    }
}
