package customer;

import java.sql.Connection;

public class DeleteCustomer extends CustomerInteraction
{
    
    public DeleteCustomer(int custId)
    {
        this.custId = custId;
    }
    
    @Override
    protected void doInteraction(Connection c)
    {
        //use connection to delete customer details from database
        //set rows to indicate the number of rows deleted
    }
}
