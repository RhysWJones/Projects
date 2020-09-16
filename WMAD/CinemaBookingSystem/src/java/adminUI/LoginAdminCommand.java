package adminUI;

import handler.AdminHandler;

/**
 *
 * @author Rhysj
 */
public class LoginAdminCommand implements AdminCommand
{
    private final String username;
    private final String password;
    private AdminHandler adminHndlr = null;

    public LoginAdminCommand(String username, String password)
    {
        this.username = username;
        this.password = password;
        adminHndlr = AdminHandler.getInstance();
    }
    
    @Override
    public Object execute()
    {
        return adminHndlr.checkAdminCredentials(username, password);
    }
    
    
}
