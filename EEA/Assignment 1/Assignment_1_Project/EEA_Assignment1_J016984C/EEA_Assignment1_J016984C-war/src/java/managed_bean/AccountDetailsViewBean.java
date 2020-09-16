package managed_bean;

import dto.UserDTO;
import ejb.User_UIRemote;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rhys
 */
@Named(value = "accountDetailsViewBean")
@SessionScoped
public class AccountDetailsViewBean implements Serializable
{
    @EJB
    private User_UIRemote userUI;
    private UserDTO user;
    private String oldPassword;
    private String confirmPassword;
    private String newPassword;
    private String oldEmail;

    public AccountDetailsViewBean()
    {
    }

    public String updateAccountDetails()
    {
        String hashedEmptyString = "";
        try
        {
            byte[] hash
                    = MessageDigest.getInstance("SHA-256")
                            .digest(hashedEmptyString.getBytes(StandardCharsets.UTF_8));

            hashedEmptyString = Base64.getEncoder().encodeToString(hash);

        }
        catch (NoSuchAlgorithmException ex)
        {
            hashedEmptyString = "";
            Logger.getLogger(AccountDetailsViewBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!user.getPassword().equals(oldPassword) && !oldPassword.equals(hashedEmptyString))
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Old password is incorrect"));
            return "";
        }

        if (!newPassword.equals(confirmPassword))
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("New password does not match password confirmation"));
            return "";
        }
        
        if(!newPassword.equals(hashedEmptyString))
        {
            user.setPassword(newPassword);
        }
        
        UserDTO updatedUser;
        
        if(oldPassword.equals(hashedEmptyString))
        {
            updatedUser = userUI.updateAccountDetails(user, user.getPassword(), oldEmail);
        }
        else
        {
            updatedUser = userUI.updateAccountDetails(user, oldPassword, oldEmail);
        }
        
        if (user != null)
        {
            HttpSession sessionScope = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            sessionScope.setAttribute("loggedUser", updatedUser);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Account Updated"));
            return "Account Updated";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Account could not be updated"));
            return "";
        }
    }

    public String displayAccountDetails()
    {
        HttpSession sessionScope = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        UserDTO loggedInUser = (UserDTO) sessionScope.getAttribute("loggedUser");
        UserDTO loggedInUserCopy = new UserDTO();
        
        loggedInUserCopy.setForename(loggedInUser.getForename());
        loggedInUserCopy.setSurname(loggedInUser.getSurname());
        loggedInUserCopy.setDateOfBirth(loggedInUser.getDateOfBirth());
        loggedInUserCopy.setEmail(loggedInUser.getEmail());
        loggedInUserCopy.setPassword(loggedInUser.getPassword());
        loggedInUserCopy.setAddressLine1(loggedInUser.getAddressLine1());
        loggedInUserCopy.setAddressLine2(loggedInUser.getAddressLine2());
        loggedInUserCopy.setPostcode(loggedInUser.getPostcode());
        loggedInUserCopy.setCity(loggedInUser.getCity());
        loggedInUserCopy.setTelephone(loggedInUser.getTelephone());
        
        setUser(loggedInUserCopy);
        setOldEmail(loggedInUser.getEmail());
        return "Display Account Details";
    }
    
    public String deleteAccount()
    {
        boolean accountDeleted = userUI.deleteAccount(user);
        
        if(accountDeleted)
        {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Account Deleted"));
            return "Account Deleted";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Account could not be deleted, please try again later"));
            return "";
        }
    }

    public String getOldEmail()
    {
        return oldEmail;
    }

    public void setOldEmail(String oldEmail)
    {
        this.oldEmail = oldEmail;
    }

    public String getNewPassword()
    {
        return newPassword;
    }

    public void setNewPassword(String newPassword)
    {
        try
        {
            byte[] hash
                    = MessageDigest.getInstance("SHA-256")
                            .digest(newPassword.getBytes(StandardCharsets.UTF_8));

            this.newPassword
                    = Base64.getEncoder().encodeToString(hash);

        }
        catch (NoSuchAlgorithmException ex)
        {
            this.newPassword = "";
            Logger.getLogger(AccountDetailsViewBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getConfirmPassword()
    {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword)
    {
        try
        {
            byte[] hash
                    = MessageDigest.getInstance("SHA-256")
                            .digest(confirmPassword.getBytes(StandardCharsets.UTF_8));

            this.confirmPassword
                    = Base64.getEncoder().encodeToString(hash);

        }
        catch (NoSuchAlgorithmException ex)
        {
            this.confirmPassword = "";
            Logger.getLogger(AccountDetailsViewBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserDTO getUser()
    {
        return user;
    }

    public void setUser(UserDTO user)
    {
        this.user = user;
    }

    public String getOldPassword()
    {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword)
    {
        try
        {
            byte[] hash
                    = MessageDigest.getInstance("SHA-256")
                            .digest(oldPassword.getBytes(StandardCharsets.UTF_8));

            this.oldPassword
                    = Base64.getEncoder().encodeToString(hash);

        }
        catch (NoSuchAlgorithmException ex)
        {
            this.oldPassword = "";
            Logger.getLogger(AccountDetailsViewBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
