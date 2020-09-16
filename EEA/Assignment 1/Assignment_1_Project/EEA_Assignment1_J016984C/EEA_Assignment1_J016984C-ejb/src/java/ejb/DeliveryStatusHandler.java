package ejb;

import database.DeliveryStatusGatewayLocal;
import dto.DeliveryStatusDTO;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class DeliveryStatusHandler implements DeliveryStatusHandlerLocal
{
    @EJB
    private DeliveryStatusGatewayLocal deliveryStatusTable;

    @Override
    public ArrayList<DeliveryStatusDTO> getDeliveryStatuses()
    {
        return deliveryStatusTable.getDeliveryStatuses();
    }
    
}
