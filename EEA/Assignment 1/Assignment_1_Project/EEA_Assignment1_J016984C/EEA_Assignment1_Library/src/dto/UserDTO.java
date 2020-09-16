package dto;

import java.util.Date;

/**
 *
 * @author Rhys
 */
public class UserDTO
{
    private int id;
    private String forename;
    private String surname;
    private Date dateOfBirth;
    private String addressLine1;
    private String addressLine2;
    private String postcode;
    private String city;
    private String telephone;
    private String email;
    private String password;
    private boolean isDriver;
    private int driverId;
    private RouteDTO route;

    public UserDTO()
    {
        
    }

    public UserDTO(int id, String forename, String surname, Date dateOfBirth, String addressLine1, String addressLine2, String postcode, String city, String telephone, String email, String password, boolean isDriver, int driverId, RouteDTO route)
    {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postcode = postcode;
        this.city = city;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
        this.isDriver = isDriver;
        this.driverId = driverId;
        this.route = route;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
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
        this.password = password;
    }

    public boolean isIsDriver()
    {
        return isDriver;
    }

    public void setIsDriver(boolean isDriver)
    {
        this.isDriver = isDriver;
    }

    public int getDriverId()
    {
        return driverId;
    }

    public void setDriverId(int driverId)
    {
        this.driverId = driverId;
    }

    public RouteDTO getRouteId()
    {
        return route;
    }

    public void setRouteId(RouteDTO routeId)
    {
        this.route = routeId;
    }
    
    
}
