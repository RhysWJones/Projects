package ejb;

import database.DeliveryGatewayLocal;
import dto.DeliveryDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class DeliveryHandler implements DeliveryHandlerLocal
{
    @EJB
    private DeliveryGatewayLocal deliveryTable;

    @Override
    public DeliveryDTO searchForDelivery(int deliveryId)
    {
        return deliveryTable.searchForDelivery(deliveryId);
    }

    @Override
    public boolean cancelDelivery(int deliveryId)
    {
        return deliveryTable.cancelDelivery(deliveryId);
    }

    @Override
    public boolean bookCollection(int deliveryId, Date collectionDate)
    {
        return deliveryTable.bookCollection(deliveryId, collectionDate);
    }

    @Override
    public boolean rescheduleDelivery(int deliveryId, Date newDeliveryDate)
    {
        return deliveryTable.rescheduleDelivery(deliveryId, newDeliveryDate);
    }

    @Override
    public ArrayList<DeliveryDTO> getRecipientDeliveries(int userId)
    {
        return deliveryTable.getRecipientDeliveries(userId);
    }

    @Override
    public ArrayList<DeliveryDTO> getDeliveriesForRoute(int routeId)
    {
        return deliveryTable.getDeliveriesForRoute(routeId);
    }

    @Override
    public boolean setRouteDeliveriesToOutForDelivery(int routeId)
    {
        return deliveryTable.setRouteDeliveriesToOutForDelivery(routeId);
    }

    @Override
    public ArrayList<DeliveryDTO> getDriverDeliveries(int routeId)
    {
        return deliveryTable.getDriverDeliveries(routeId);
    }

    @Override
    public boolean deliverDelivery(int deliveryId)
    {
        return deliveryTable.deliverDelivery(deliveryId);
    }

    @Override
    public boolean failDelivery(int deliveryId)
    {
        return deliveryTable.failDelivery(deliveryId);
    }

    @Override
    public boolean changeDeliveryStatus(int deliveryId, int deliveryStatusId)
    {
        return deliveryTable.changeDeliveryStatus(deliveryId, deliveryStatusId);
    }
}
