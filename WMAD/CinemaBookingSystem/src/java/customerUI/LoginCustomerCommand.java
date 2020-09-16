package customerUI;

import handler.CustomerHandler;

/**
 *
 * @author Rhys Jones
 */
public class LoginCustomerCommand implements CustomerCommand
{
    private final String username;
    private final String password;
    private CustomerHandler custHndlr = null;

    public LoginCustomerCommand(String username, String password)
    {
        this.username = username;
        this.password = password;
        custHndlr = CustomerHandler.getInstance();
    }
    
    @Override
    public Object execute()
    {
        return custHndlr.checkCustomerCredentials(username, password);
    }
    
    
}
