package managedbean;

import adminUI.AdminCommandFactory;
import customerUI.CustomerCommandFactory;
import dto.UserDTO;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rhys Jones
 */
@Named(value = "LoginBean")
@RequestScoped
public class LoginBean implements Serializable
{

    private String username;
    private String password;
    private boolean isAdmin;

    public LoginBean()
    {
    }

    public String login(boolean isAdmin)
    {
        UserDTO loggedUser;
        if (isAdmin)
        {
            loggedUser = (UserDTO) AdminCommandFactory
                    .createCommand(
                            AdminCommandFactory.LOGIN_ADMIN, username, password)
                    .execute();
            if (loggedUser != null && loggedUser.isIsAdmin())
            {
                HttpSession sessionScope = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                sessionScope.setAttribute("loggedAdmin", loggedUser);
                return "loggedIn";
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Not an Admin: Log in as a Customer"));
                return null;
            }
        }
        if (!isAdmin)
        {
            loggedUser = (UserDTO) CustomerCommandFactory
                    .createCommand(
                            CustomerCommandFactory.LOGIN_CUSTOMER, username, password)
                    .execute();

            if (loggedUser != null && !loggedUser.isIsAdmin())
            {
                HttpSession sessionScope = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                sessionScope.setAttribute("loggedCustomer", loggedUser);
                
                return "loggedIn";
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Not a Customer: Log in as Admin"));
                return null;
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Incorrect login."));
            return null;
        }
    }

    public void clearCredentials()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public String logOff()
    {
        clearCredentials();
        return "loggedOff";
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        try
        {
            byte[] hash
                    = MessageDigest.getInstance("SHA-256")
                            .digest(password.getBytes(StandardCharsets.UTF_8));

            this.password
                    = Base64.getEncoder().encodeToString(hash);
        }
        catch (NoSuchAlgorithmException ex)
        {
            this.password = "";
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isIsAdmin()
    {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin)
    {
        this.isAdmin = isAdmin;
    }

}
