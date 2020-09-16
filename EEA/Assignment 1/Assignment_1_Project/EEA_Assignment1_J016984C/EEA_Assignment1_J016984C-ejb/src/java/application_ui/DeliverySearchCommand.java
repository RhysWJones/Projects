package application_ui;

import ejb.DeliveryHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class DeliverySearchCommand implements DeliverySearchCommandLocal
{
    private int deliveryId;
    @EJB
    private DeliveryHandlerLocal deliveryHandler;

    @Override
    public void setDeliveryId(int deliveryId)
    {
        this.deliveryId = deliveryId;
    }

    @Override
    public Object execute()
    {
        return deliveryHandler.searchForDelivery(deliveryId);
    }
    
}
