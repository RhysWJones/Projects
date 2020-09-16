package ejb;

import dto.DeliveryDTO;
import dto.UserDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author Rhys
 */
@Remote
public interface User_UIRemote
{

    UserDTO login(String email, String password);

    boolean register(UserDTO userDTO);

    DeliveryDTO search(int deliveryId);

    boolean cancelDelivery(int deliveryId);

    boolean bookCollection(int deliveryId, Date collectionDate);

    boolean rescheduleDelivery(int deliveryId, Date newDeliveryDate);

    ArrayList<DeliveryDTO> getRecipientDeliveries(int userId);

    public UserDTO updateAccountDetails(UserDTO user, String oldPassword, String oldEmail);

    boolean deleteAccount(UserDTO user);
    
}
