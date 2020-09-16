package application_ui;

import ejb.DeliveryHandlerLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class RescheduleDeliveryCommand implements RescheduleDeliveryCommandLocal
{
    private int deliveryId;
    private Date newDeliveryDate;
    @EJB
    private DeliveryHandlerLocal deliveryHandler;

    @Override
    public Object execute()
    {
        return deliveryHandler.rescheduleDelivery(deliveryId, newDeliveryDate);
    }

    @Override
    public void setDeliveryId(int deliveryId)
    {
        this.deliveryId = deliveryId;
    }

    @Override
    public void setNewDeliveryDate(Date newDeliveryDate)
    {
        this.newDeliveryDate = newDeliveryDate;
    }
}
