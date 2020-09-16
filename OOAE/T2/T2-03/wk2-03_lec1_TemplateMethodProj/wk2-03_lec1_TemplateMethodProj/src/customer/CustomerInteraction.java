package customer;

import database.ConnectionPool;
import java.sql.Connection;

public abstract class CustomerInteraction
{
    private Connection con;
    protected int custId = -1;
    protected Customer customer = null;
    protected int rows = -1;
    
    private void closeConnection()
    {
        ConnectionPool.getInstance().returnConnection(con);
    }
    
    //this will be overridden in the sub-classes
    // and provides the variation of algorithm
    protected abstract void doInteraction(Connection c);
    
    private void establishConnection()
    {
        con = ConnectionPool.getInstance().getAvailableConnection();
    }
    
    //this is the template method
    public void execute()
    {
        establishConnection();
        doInteraction(con);
        closeConnection();
    }
    
    public int getCustId()
    {
        return custId;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public int getRows()
    {
        return rows;
    }
}
