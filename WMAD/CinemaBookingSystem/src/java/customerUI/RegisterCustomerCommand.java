package customerUI;

import dto.UserDTO;
import handler.CustomerHandler;

/**
 *
 * @author Rhys Jones
 */
public class RegisterCustomerCommand implements CustomerCommand
{
    private CustomerHandler custHndlr = null;
    private final UserDTO newCustomer;

    public RegisterCustomerCommand(UserDTO newCustomer)
    {
        this.newCustomer = newCustomer;
        custHndlr = CustomerHandler.getInstance();
    }
    
    @Override
    public Object execute()
    {
        return custHndlr.insertCustomer(newCustomer);
    }
    
    
}
