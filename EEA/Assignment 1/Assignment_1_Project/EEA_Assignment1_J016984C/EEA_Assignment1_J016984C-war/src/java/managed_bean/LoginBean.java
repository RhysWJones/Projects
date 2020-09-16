package managed_bean;

import dto.UserDTO;
import ejb.User_UIRemote;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rhys
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean implements Serializable
{

    @EJB
    private User_UIRemote userUI;
    private String email = "";
    private String password = "";
    private UserDTO loggedInUser;

    public LoginBean()
    {
    }

    public String login()
    {
        loggedInUser = userUI.login(email, password);
        if (loggedInUser != null)
        {
            if (loggedInUser.isIsDriver())
            {
                HttpSession sessionScope = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                sessionScope.setAttribute("loggedDriver", loggedInUser);
            }
            else
            {
                HttpSession sessionScope = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                sessionScope.setAttribute("loggedUser", loggedInUser);
            }
            return "loggedIn";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login credentials are not correct"));
            return null;
        }
    }
    
    public void clearCredentials()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public String logout()
    {
        clearCredentials();
        return "loggedOut";
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
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
}
