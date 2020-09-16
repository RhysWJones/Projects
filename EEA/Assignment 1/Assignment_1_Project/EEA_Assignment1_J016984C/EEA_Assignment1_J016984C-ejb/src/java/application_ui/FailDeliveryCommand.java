package application_ui;

import ejb.DeliveryHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class FailDeliveryCommand implements FailDeliveryCommandLocal
{
    @EJB
    private DeliveryHandlerLocal deliveryHandler;
    private int deliveryId;

    @Override
    public Object execute()
    {
        return deliveryHandler.failDelivery(deliveryId);
    }

    @Override
    public void setDeliveryId(int deliveryId)
    {
        this.deliveryId = deliveryId;
    }
    
}
