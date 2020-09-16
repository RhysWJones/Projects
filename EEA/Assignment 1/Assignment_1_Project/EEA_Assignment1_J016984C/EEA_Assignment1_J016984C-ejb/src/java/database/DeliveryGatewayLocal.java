/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import dto.DeliveryDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface DeliveryGatewayLocal
{

    DeliveryDTO searchForDelivery(int deliveryId);

    boolean cancelDelivery(int deliveryId);

    boolean bookCollection(int deliveryId, Date collectionDate);

    boolean rescheduleDelivery(int deliveryId, Date newDeliveryDate);

    ArrayList<DeliveryDTO> getRecipientDeliveries(int userId);

    ArrayList<DeliveryDTO> getDeliveriesForRoute(int routeId);

    boolean setRouteDeliveriesToOutForDelivery(int routeId);

    ArrayList<DeliveryDTO> getDriverDeliveries(int routeId);

    boolean deliverDelivery(int deliveryId);

    boolean failDelivery(int deliveryId);

    boolean changeDeliveryStatus(int deliveryId, int deliveryStatusId);
    
}
