package database;

import dto.DeliveryStatusDTO;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface DeliveryStatusGatewayLocal
{

    ArrayList<DeliveryStatusDTO> getDeliveryStatuses();
    
}
