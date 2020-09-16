package database;

import dto.UserDTO;
import entity.Route;
import entity.Users;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rhys
 */
@Stateless
public class UserGateway implements UserGatewayLocal
{

    @PersistenceContext
    EntityManager em;

    @EJB
    DTOConversionGatewayLocal DTOConversionGateway;

    @Override
    public UserDTO login(String email, String password)
    {
        boolean credentialsCorrect = false;
        try
        {
            Users user = (Users) em.createNamedQuery("Users.getUserByCredentials").setParameter("email", email).setParameter("password", password).getSingleResult();

            if (user.getPassword().equals(password))
            {
                credentialsCorrect = true;
            }

            if (credentialsCorrect == true)
            {
                UserDTO userDTO = DTOConversionGateway.createUserDTO(user);

                return userDTO;
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login credentials are not correct"));
                return null;
            }

        }
        catch (NoResultException e)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login credentials are not correct"));
            return null;
        }
    }

    @Override
    public boolean registerNewUser(UserDTO registeringUserDTO)
    {
        try
        {
            Users newUser = new Users();

            newUser.setForename(registeringUserDTO.getForename());
            newUser.setSurname(registeringUserDTO.getSurname());
            newUser.setDob(registeringUserDTO.getDateOfBirth());
            newUser.setAddressLine1(registeringUserDTO.getAddressLine1());
            newUser.setAddressLine2(registeringUserDTO.getAddressLine2());
            newUser.setPostcode(registeringUserDTO.getPostcode());
            newUser.setCity(registeringUserDTO.getCity());
            newUser.setTelephone(registeringUserDTO.getTelephone());
            newUser.setEmail(registeringUserDTO.getEmail());
            newUser.setPassword(registeringUserDTO.getPassword());
            newUser.setIsDriver(false);

            em.persist(newUser);
        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }

    @Override
    public UserDTO updateAccountDetails(UserDTO user, String oldPassword, String oldEmail)
    {
        try
        {
            Users originalUser = (Users) em.createNamedQuery("Users.getUserByCredentials").setParameter("email", oldEmail).setParameter("password", oldPassword).getSingleResult();

            if (!originalUser.getEmail().equals(user.getEmail()))
            {
                originalUser.setEmail(user.getEmail());
            }

            if (!originalUser.getPassword().equals(user.getPassword()))
            {
                originalUser.setPassword(user.getPassword());
            }

            if (!originalUser.getAddressLine1().equals(user.getAddressLine1()))
            {
                originalUser.setAddressLine1(user.getAddressLine1());
            }

            if (!originalUser.getAddressLine2().equals(user.getAddressLine2()))
            {
                originalUser.setAddressLine2(user.getAddressLine1());
            }

            if (!originalUser.getPostcode().equals(user.getPostcode()))
            {
                originalUser.setPostcode(user.getPostcode());
            }

            if (!originalUser.getCity().equals(user.getCity()))
            {
                originalUser.setCity(user.getCity());
            }

            if (!originalUser.getTelephone().equals(user.getTelephone()))
            {
                originalUser.setTelephone(user.getTelephone());
            }

            em.persist(originalUser);
            UserDTO updatedUser = DTOConversionGateway.createUserDTO(originalUser);
            return updatedUser;
        }
        catch (Exception e)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Failed to verify credentials"));
            return null;
        }
    }

    @Override
    public boolean deleteAccount(UserDTO user)
    {
        try
        {
            Users userAccount = (Users) em.createNamedQuery("Users.getUserByCredentials").setParameter("email", user.getEmail()).setParameter("password", user.getPassword()).getSingleResult();
            em.remove(userAccount);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    @Override
    public UserDTO assignRouteToDriver(UserDTO user, int routeId)
    {
        try
        {
            Users driver = (Users) em.createNamedQuery("Users.getUserByCredentials")
                    .setParameter("email", user.getEmail())
                    .setParameter("password", user.getPassword())
                    .getSingleResult();
            
            Route chosenRoute = (Route) em.createNamedQuery("Route.findByRouteId")
                    .setParameter("routeId", routeId)
                    .getSingleResult();
            
            driver.setRouteId(chosenRoute);
            em.persist(driver);
            
            UserDTO updatedDriverDTO = DTOConversionGateway.createUserDTO(driver);
            
            return updatedDriverDTO;
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
