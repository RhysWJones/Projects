package application_ui;

import ejb.DeliveryHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class ChangeDeliveryStatusCommand implements ChangeDeliveryStatusCommandLocal
{
    @EJB
    private DeliveryHandlerLocal deliveryHandler;
    private int deliveryId;
    private int deliveryStatusId;

    @Override
    public Object execute()
    {
        return deliveryHandler.changeDeliveryStatus(deliveryId, deliveryStatusId);
    }

    @Override
    public void setDeliveryId(int deliveryId)
    {
        this.deliveryId = deliveryId;
    }

    @Override
    public void setDeliveryStatusId(int deliveryStatusId)
    {
        this.deliveryStatusId = deliveryStatusId;
    }
    
}
