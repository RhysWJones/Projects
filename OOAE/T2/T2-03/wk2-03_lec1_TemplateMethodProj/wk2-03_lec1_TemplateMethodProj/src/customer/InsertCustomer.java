package customer;

import java.sql.Connection;

public class InsertCustomer extends CustomerInteraction
{
    private final String name;
    
    public InsertCustomer(String name)
    {
        this.name = name;
    }
    
    @Override
    protected void doInteraction(Connection c)
    {
        //use connection to insert customer details (name) into database
        //set custId to id of new row
        rows = 1;
    }
}
