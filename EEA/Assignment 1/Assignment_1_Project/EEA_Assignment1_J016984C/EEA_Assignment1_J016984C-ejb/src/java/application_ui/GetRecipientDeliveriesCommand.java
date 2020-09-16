package application_ui;

import ejb.DeliveryHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class GetRecipientDeliveriesCommand implements GetRecipientDeliveriesCommandLocal
{

    @EJB
    private DeliveryHandlerLocal deliveryHandler;
    private int userId;

    @Override
    public Object execute()
    {
        return deliveryHandler.getRecipientDeliveries(userId);
    }

    @Override
    public void setUserId(int userId)
    {
        this.userId = userId;
    }

}
