package application_ui;

import ejb.DeliveryHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class GetDriverDeliveriesCommand implements GetDriverDeliveriesCommandLocal
{
    @EJB
    private DeliveryHandlerLocal deliveryHandler;
    private int routeId;

    @Override
    public Object execute()
    {
        return deliveryHandler.getDriverDeliveries(routeId);
    }

    @Override
    public void setRouteId(int routeId)
    {
        this.routeId = routeId;
    }
    
}
