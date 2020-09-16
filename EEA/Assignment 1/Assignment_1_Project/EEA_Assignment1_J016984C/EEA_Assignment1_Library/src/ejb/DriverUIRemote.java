package ejb;

import dto.DeliveryDTO;
import dto.DeliveryStatusDTO;
import dto.RouteDTO;
import dto.UserDTO;
import java.util.ArrayList;
import javax.ejb.Remote;

/**
 *
 * @author Rhys
 */
@Remote
public interface DriverUIRemote
{

    ArrayList<RouteDTO> getRoutes();

    ArrayList<DeliveryDTO> getDeliveriesForRoute(int routeId);

    UserDTO assignRouteToDriver(UserDTO user, int routeId);

    boolean setRouteDeliveriesToOutForDelivery(int routeId);

    ArrayList<DeliveryDTO> getDriverDeliveries(int routeId);

    boolean deliverDelivery(int deliveryId);

    boolean failDelivery(int deliveryId);

    ArrayList<DeliveryStatusDTO> getDeliveryStatuses();

    boolean setNewStatusOnDelivery(int deliveryId, int deliveryStatusId);
    
}
