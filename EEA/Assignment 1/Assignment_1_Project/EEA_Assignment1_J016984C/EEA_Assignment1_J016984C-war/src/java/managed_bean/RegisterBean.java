package managed_bean;

import dto.UserDTO;
import ejb.User_UIRemote;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rhys
 */
@Named(value = "registerBean")
@RequestScoped
public class RegisterBean
{
    
    @EJB
    private User_UIRemote userUI;
    private String forename;
    private String surname;
    private Date dateOfBirth;
    private String email;
    private String password;
    private String confirmPassword;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postcode;
    private String telephone;
    private boolean registeredSuccessfully;
    private UserDTO registeringUser;
    
    public RegisterBean()
    {
        
    }
    
    public String register()
    {
        if(!this.password.equals(this.confirmPassword))
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Passwords don't match"));
            return null;
        }
        
        registeringUser = createNewUserDTO();
        
        registeredSuccessfully = userUI.register(registeringUser);
        if (registeredSuccessfully)
        {
            return "registered";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login credentials are not correct"));
            return null;
        }
    }

    public String getForename()
    {
        return forename;
    }

    public void setForename(String forename)
    {
        this.forename = forename;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
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
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getAddressLine1()
    {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2()
    {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }
    
    public UserDTO createNewUserDTO()
    {
        UserDTO newUser = new UserDTO();
        
        newUser.setForename(this.forename);
        newUser.setSurname(this.surname);
        newUser.setDateOfBirth(this.dateOfBirth);
        newUser.setEmail(this.email);
        newUser.setPassword(this.password);
        newUser.setAddressLine1(this.addressLine1);
        newUser.setAddressLine2(this.addressLine2);
        newUser.setCity(this.city);
        newUser.setPostcode(this.postcode);
        newUser.setTelephone(this.telephone);
        
        return newUser;
    }
}
