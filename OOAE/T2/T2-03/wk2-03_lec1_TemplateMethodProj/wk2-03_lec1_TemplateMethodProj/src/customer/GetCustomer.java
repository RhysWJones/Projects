package customer;

import java.sql.Connection;

public class GetCustomer extends CustomerInteraction
{
    
    public GetCustomer(int custId)
    {
        this.custId = custId;
    }
    
    @Override
    protected void doInteraction(Connection c)
    {
        //use connection to get customer details from database
        //create Customer object using ResultSet data and store in customer
        rows = 1;
    }
}
