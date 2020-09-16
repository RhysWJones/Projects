package ejb;

import dto.DeliveryStatusDTO;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface DeliveryStatusHandlerLocal
{

    ArrayList<DeliveryStatusDTO> getDeliveryStatuses();
    
}
