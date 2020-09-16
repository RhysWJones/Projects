package managedbean;

import dto.UserDTO;
import customerUI.CustomerCommandFactory;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Rhys
 */
@Named(value = "RegisterBean")
@RequestScoped
public class RegisterBean implements Serializable
{

    private String forename;
    private String surname;
    private String DOB;
    private String addressLine1;
    private String addressLine2;
    private String postcode;
    private String username;
    private String password1;
    private String password2;

    public RegisterBean()
    {
    }

    public String register()
    {
        boolean insertSuccessful = false;

        if (password1.equals(password2))
        {
            try
            {
                byte[] hash = MessageDigest.getInstance("SHA-256")
                        .digest(password1.getBytes(StandardCharsets.UTF_8));

                password1 = Base64.getEncoder().encodeToString(hash);

                UserDTO newCustomer = new UserDTO(0, forename, surname, DOB, addressLine1, addressLine2, postcode, username, password1, false);

                insertSuccessful = (boolean) CustomerCommandFactory
                        .createCommand(
                                CustomerCommandFactory.REGISTER_CUSTOMER, newCustomer)
                        .execute();

            }
            catch (Exception e)
            {
                System.out.println("ERROR\n=====\n" + e);
            }
        }
        if (insertSuccessful)
        {
            return "registered";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: Customer could not be created."));
            return null;
        }
    }

    public void setForename(String forename)
    {
        this.forename = forename;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public void setDOB(String DOB)
    {
        this.DOB = DOB;
    }

    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword1(String password1)
    {
        this.password1 = password1;
    }

    public void setPassword2(String password2)
    {
        this.password2 = password2;
    }

    public String getForename()
    {
        return forename;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getDOB()
    {
        return DOB;
    }

    public String getAddressLine1()
    {
        return addressLine1;
    }

    public String getAddressLine2()
    {
        return addressLine2;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword1()
    {
        return password1;
    }

    public String getPassword2()
    {
        return password2;
    }

}
