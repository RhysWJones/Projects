package application_ui;

import dto.UserDTO;
import ejb.UserHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class DeleteAccountCommand implements DeleteAccountCommandLocal
{
    @EJB
    private UserHandlerLocal userHandler;
    private UserDTO user;

    @Override
    public Object execute()
    {
        return userHandler.deleteAccount(user);
    }

    @Override
    public void setUser(UserDTO user)
    {
        this.user = user;
    }
    
}
