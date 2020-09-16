package ejb;

import dto.DeliveryDTO;
import dto.UserDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import application_ui.CommandFactory;
import application_ui.CommandFactoryLocal;

/**
 *
 * @author Rhys
 */
@Stateless
public class User_UI implements User_UIRemote
{
    
    @EJB
    private CommandFactoryLocal commandFactory;

    @Override
    public UserDTO login(String email, String password)
    {
        return (UserDTO)commandFactory.createCommand(CommandFactory.LOGIN, email, password).execute();
    }

    @Override
    public boolean register(UserDTO userDTO)
    {
        return (boolean)commandFactory.createCommand(CommandFactory.REGISTER, userDTO).execute();
    }

    @Override
    public DeliveryDTO search(int deliveryId)
    {
        return (DeliveryDTO)commandFactory.createCommand(CommandFactory.SEARCH_FOR_DELIVERY, deliveryId).execute();
    }

    @Override
    public boolean cancelDelivery(int deliveryId)
    {
        return (boolean)commandFactory.createCommand(CommandFactory.CANCEL_DELIVERY, deliveryId).execute();
    }

    @Override
    public boolean bookCollection(int deliveryId, Date collectionDate)
    {
        return (boolean)commandFactory.createCommand(CommandFactory.BOOK_COLLECTION, deliveryId, collectionDate).execute();
    }

    @Override
    public boolean rescheduleDelivery(int deliveryId, Date newDeliveryDate)
    {
        return (boolean)commandFactory.createCommand(CommandFactory.RESCHEDULE_DELIVERY, deliveryId, newDeliveryDate).execute();
    }

    @Override
    public ArrayList<DeliveryDTO> getRecipientDeliveries(int userId)
    {
        return (ArrayList<DeliveryDTO>)commandFactory.createCommand(CommandFactory.GET_RECIPIENT_DELIVERIES, userId).execute();
    }

    @Override
    public UserDTO updateAccountDetails(UserDTO user, String oldPassword, String oldEmail)
    {
        return (UserDTO)commandFactory.createCommand(CommandFactory.UPDATE_ACCOUNT_DETAILS, user, oldPassword, oldEmail).execute();
    }

    @Override
    public boolean deleteAccount(UserDTO user)
    {
        return (boolean)commandFactory.createCommand(CommandFactory.DELETE_ACCOUNT, user).execute();
    }
}
