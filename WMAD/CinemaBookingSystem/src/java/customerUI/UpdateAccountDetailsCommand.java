package customerUI;

import dto.UserDTO;
import handler.CustomerHandler;

/**
 *
 * @author Rhys Jones
 */
public class UpdateAccountDetailsCommand implements CustomerCommand
{
    private CustomerHandler custHndlr = null;
    private final UserDTO customer;
    public UpdateAccountDetailsCommand(UserDTO customer)
    {
        this.customer = customer;
        custHndlr = CustomerHandler.getInstance();
    }

    @Override
    public Object execute()
    {
        return custHndlr.updateAccountDetails(customer);
    }
    
}
