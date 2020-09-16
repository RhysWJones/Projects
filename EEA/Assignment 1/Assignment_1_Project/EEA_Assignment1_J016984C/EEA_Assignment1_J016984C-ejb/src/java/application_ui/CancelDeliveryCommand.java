package application_ui;

import ejb.DeliveryHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class CancelDeliveryCommand implements CancelDeliveryCommandLocal
{
    private int deliveryId;
    @EJB
    private DeliveryHandlerLocal deliveryHandler;

    @Override
    public Object execute()
    {
        return deliveryHandler.cancelDelivery(deliveryId);
    }

    @Override
    public void setDeliveryId(int deliveryId)
    {
        this.deliveryId = deliveryId;
    }
    
    
}
