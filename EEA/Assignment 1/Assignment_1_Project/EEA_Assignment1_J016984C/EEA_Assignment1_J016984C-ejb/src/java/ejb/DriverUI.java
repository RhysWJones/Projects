package ejb;

import application_ui.CommandFactory;
import dto.RouteDTO;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import application_ui.CommandFactoryLocal;
import dto.DeliveryDTO;
import dto.DeliveryStatusDTO;
import dto.UserDTO;

/**
 *
 * @author Rhys
 */
@Stateless
public class DriverUI implements DriverUIRemote
{
    @EJB
    private CommandFactoryLocal commandFactory;
    
    @Override
    public ArrayList<RouteDTO> getRoutes()
    {
        return (ArrayList<RouteDTO>)commandFactory.createCommand(CommandFactory.GET_ROUTES).execute();
    }

    @Override
    public ArrayList<DeliveryDTO> getDeliveriesForRoute(int routeId)
    {
        return (ArrayList<DeliveryDTO>)commandFactory.createCommand(CommandFactory.GET_DELIVERIES_FOR_ROUTE, routeId).execute();
    }

    @Override
    public UserDTO assignRouteToDriver(UserDTO user, int routeId)
    {
        return (UserDTO)commandFactory.createCommand(CommandFactory.ASSIGN_ROUTE_TO_DRIVER, user, routeId).execute();
    }

    @Override
    public boolean setRouteDeliveriesToOutForDelivery(int routeId)
    {
        return (boolean)commandFactory.createCommand(CommandFactory.SET_ROUTE_DELIVERIES_TO_OUT_FOR_DELIVERY, routeId).execute();
    }

    @Override
    public ArrayList<DeliveryDTO> getDriverDeliveries(int routeId)
    {
        return (ArrayList<DeliveryDTO>)commandFactory.createCommand(CommandFactory.GET_DRIVER_DELIVERIES, routeId).execute();
    }

    @Override
    public boolean deliverDelivery(int deliveryId)
    {
        return (boolean)commandFactory.createCommand(CommandFactory.DELIVER_DELIVERY, deliveryId).execute();
    }

    @Override
    public boolean failDelivery(int deliveryId)
    {
        return (boolean)commandFactory.createCommand(CommandFactory.FAIL_DELIVERY, deliveryId).execute();
    }

    @Override
    public ArrayList<DeliveryStatusDTO> getDeliveryStatuses()
    {
        return (ArrayList<DeliveryStatusDTO>)commandFactory.createCommand(CommandFactory.GET_DELIVERY_STATUSES).execute();
    }

    @Override
    public boolean setNewStatusOnDelivery(int deliveryId, int deliveryStatusId)
    {
        return (boolean)commandFactory.createCommand(CommandFactory.CHANGE_DELIVERY_STATUS, deliveryId, deliveryStatusId).execute();
    }
    
}
