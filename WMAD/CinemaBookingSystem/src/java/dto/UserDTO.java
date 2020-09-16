package dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rhys Jones
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDTO implements Serializable
{

    private int userID;
    private String forename;
    private String surname;
    private Date DOB;
    private String addressLine1;
    private String addressLine2;
    private String postcode;
    private String username;
    private String password;
    private boolean isAdmin;

    public UserDTO()
    {
        this.userID = 0;
        this.forename = "";
        this.surname = "";
        this.DOB = Calendar.getInstance().getTime();
        this.addressLine1 = "";
        this.addressLine2 = "";
        this.postcode = "";
        this.username = "";
        this.password = "";
        this.isAdmin = false;
    }
    
    /**
     * Constructs the UserDTO using a String DOB and then converting it to a date.
     * @param userID
     * @param forename
     * @param surname
     * @param DOB
     * @param addressLine1
     * @param addressLine2
     * @param postcode
     * @param username
     * @param password
     * @param isAdmin 
     */
    public UserDTO(int userID, String forename, String surname, String DOB,
            String addressLine1, String addressLine2, String postcode, String username,
            String password, boolean isAdmin)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.userID = userID;
        this.forename = forename;
        this.surname = surname;
        
        try
        {
            this.DOB = sdf.parse(DOB);
        }
        catch(ParseException pe)
        {
            System.out.println("Parse failed" + pe);
        }
        
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postcode = postcode;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    
    /**
     * Constructs the UserDTO using a Date DOB
     * @param userID
     * @param forename
     * @param surname
     * @param DOB
     * @param addressLine1
     * @param addressLine2
     * @param postcode
     * @param username
     * @param password
     * @param isAdmin 
     */
    public UserDTO(int userID, String forename, String surname, Date DOB,
            String addressLine1, String addressLine2, String postcode, String username,
            String password, boolean isAdmin)
    {
        this.userID = userID;
        this.forename = forename;
        this.surname = surname;
        this.DOB = DOB;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postcode = postcode;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    
    /**
     * Returns the userID
     * @return userID
     */
    public int getUserID()
    {
        return userID;
    }

    public String getForename()
    {
        return forename;
    }

    public String getSurname()
    {
        return surname;
    }

    public Date getDOB()
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

    public String getPassword()
    {
        return password;
    }

    public boolean isIsAdmin()
    {
        return isAdmin;
    }

    public void setForename(String forename)
    {
        this.forename = forename;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
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

    public void setPassword(String password)
    {
        this.password = password;
    }

}
