package application_ui;

import ejb.DeliveryStatusHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class GetDeliveryStatusesCommand implements GetDeliveryStatusesCommandLocal
{
    @EJB
    private DeliveryStatusHandlerLocal deliveryStatusHandler;

    @Override
    public Object execute()
    {
        return deliveryStatusHandler.getDeliveryStatuses();
    }
    
}
