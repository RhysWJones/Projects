package application_ui;

import ejb.DeliveryHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class SetRouteDeliveriesToOutForDeliveryCommand implements SetRouteDeliveriesToOutForDeliveryCommandLocal
{
    @EJB
    private DeliveryHandlerLocal deliveryHandler;
    private int routeId;

    @Override
    public Object execute()
    {
        return deliveryHandler.setRouteDeliveriesToOutForDelivery(routeId);
    }

    @Override
    public void setRouteId(int routeId)
    {
        this.routeId = routeId;
    }
    
}
