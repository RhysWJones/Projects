package managedbean;

import customerUI.CustomerCommandFactory;
import dto.UserDTO;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rhys Jones
 */
@Named(value = "UpdateAccountBean")
@SessionScoped
public class UpdateAccountBean implements Serializable
{

    private HttpSession sessionScope = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private UserDTO user = (UserDTO) sessionScope.getAttribute("loggedCustomer");

    public UpdateAccountBean()
    {
    }

    public String updateAccount()
    {
        boolean updateSuccessful = false;
        serializeUserPassword(user.getPassword());

            try
            {
                updateSuccessful = (boolean) CustomerCommandFactory
                        .createCommand(
                                CustomerCommandFactory.UPDATE_ACCOUNT_DETAILS, user)
                        .execute();
            }
            catch (Exception e)
            {
                System.out.println("ERROR\n=====\n" + e);
            }
        
        if (updateSuccessful)
        {
            sessionScope.setAttribute("loggedCustomer", user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Updated."));
            return "Updated";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: Customer could not be updated."));
            return null;
        }
    }

    public UserDTO getUser()
    {
        return user;
    }

    public void serializeUserPassword(String pass)
    {
        pass = user.getPassword();
        try
        {
            byte[] hash = MessageDigest.getInstance("SHA-256")
                    .digest(pass.getBytes(StandardCharsets.UTF_8));

            pass = Base64.getEncoder().encodeToString(hash);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        user.setPassword(pass);
    }
}
