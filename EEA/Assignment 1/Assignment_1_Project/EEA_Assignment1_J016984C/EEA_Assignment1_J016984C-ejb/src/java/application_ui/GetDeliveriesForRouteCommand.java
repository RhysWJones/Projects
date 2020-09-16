package application_ui;

import ejb.DeliveryHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class GetDeliveriesForRouteCommand implements GetDeliveriesForRouteCommandLocal
{
    @EJB
    private DeliveryHandlerLocal deliveryHandler;
    private int routeId;

    @Override
    public Object execute()
    {
        return deliveryHandler.getDeliveriesForRoute(routeId);
    }

    @Override
    public void setRouteId(int routeId)
    {
        this.routeId = routeId;
    }
}
