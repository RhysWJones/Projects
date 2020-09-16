package database;

import dto.DeliveryDTO;
import entity.Delivery;
import entity.DeliveryStatus;
import entity.Parcel;
import entity.Users;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rhys
 */
@Stateless
public class DeliveryGateway implements DeliveryGatewayLocal
{

    @PersistenceContext
    EntityManager em;

    @EJB
    DTOConversionGatewayLocal DTOConversionGateway;

    @Override
    public DeliveryDTO searchForDelivery(int deliveryId)
    {
        try
        {
            Delivery delivery = (Delivery) em.createNamedQuery("Delivery.findByDeliveryId").setParameter("deliveryId", deliveryId).getSingleResult();
            DeliveryDTO deliveryDTO = DTOConversionGateway.createDeliveryDTO(delivery);
            return deliveryDTO;
        }
        catch (NoResultException e)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Delivery not found"));
            return null;
        }
    }

    @Override
    public boolean cancelDelivery(int deliveryId)
    {
        try
        {
            Delivery delivery = (Delivery) em.createNamedQuery("Delivery.findByDeliveryId").setParameter("deliveryId", deliveryId).getSingleResult();
            DeliveryStatus cancellationRequestedStatus = (DeliveryStatus) em.createNamedQuery("DeliveryStatus.findByName").setParameter("name", "Scheduled For Cancellation").getSingleResult();

            delivery.setDeliveryStatusId(cancellationRequestedStatus);
            em.persist(delivery);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean bookCollection(int deliveryId, Date collectionDate)
    {
        try
        {
            Delivery delivery = (Delivery) em.createNamedQuery("Delivery.findByDeliveryId").setParameter("deliveryId", deliveryId).getSingleResult();
            DeliveryStatus awaitingCollectionStatus = (DeliveryStatus) em.createNamedQuery("DeliveryStatus.findByName").setParameter("name", "Awaiting Collection").getSingleResult();

            delivery.setDeliveryStatusId(awaitingCollectionStatus);
            delivery.setDeliveryDate(collectionDate);
            em.persist(delivery);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean rescheduleDelivery(int deliveryId, Date newDeliveryDate)
    {
        try
        {
            Delivery delivery = (Delivery) em.createNamedQuery("Delivery.findByDeliveryId").setParameter("deliveryId", deliveryId).getSingleResult();
            DeliveryStatus rescheduledForDelivery = (DeliveryStatus) em.createNamedQuery("DeliveryStatus.findByName").setParameter("name", "Re-Scheduled For Delivery").getSingleResult();

            delivery.setDeliveryDate(newDeliveryDate);
            delivery.setDeliveryStatusId(rescheduledForDelivery);
            em.persist(delivery);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public ArrayList<DeliveryDTO> getRecipientDeliveries(int userId)
    {
        try
        {
            Users recipient = (Users) em.createNamedQuery("Users.findByUserId").setParameter("userId", userId).getSingleResult();
            String recipientName = recipient.getForename() + " " + recipient.getSurname();

            List<Parcel> parcels = (List<Parcel>) em.createNamedQuery("Parcel.getDeliveriesForUser")
                    .setParameter("recipientName", recipientName)
                    .setParameter("addressLine1", recipient.getAddressLine1())
                    .setParameter("postcode", recipient.getPostcode())
                    .setParameter("city", recipient.getCity())
                    .getResultList();
            ArrayList<DeliveryDTO> deliveryDTOCollection = new ArrayList<DeliveryDTO>();

            for (int i = 0; i < parcels.size(); i++)
            {
                Delivery delivery = (Delivery) em.createNamedQuery("Delivery.findByDeliveryId").setParameter("deliveryId", parcels.get(i).getDelivery().getDeliveryId()).getSingleResult();
                deliveryDTOCollection.add(DTOConversionGateway.createDeliveryDTO(delivery));
            }
            return deliveryDTOCollection;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public ArrayList<DeliveryDTO> getDeliveriesForRoute(int routeId)
    {
        try
        {
            List<Delivery> deliveryList = (List<Delivery>) em.createNamedQuery("Delivery.getDeliveriesForRoute")
                    .setParameter("routeId", routeId)
                    .setParameter("deliveryStatus", "At Depot")
                    .getResultList();

            ArrayList<DeliveryDTO> deliveries = new ArrayList<DeliveryDTO>();

            for (Delivery delivery : deliveryList)
            {
                deliveries.add(DTOConversionGateway.createDeliveryDTO(delivery));
            }

            return deliveries;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean setRouteDeliveriesToOutForDelivery(int routeId)
    {
        try
        {
            List<Delivery> routeDeliveries = (List<Delivery>) em.createNamedQuery("Delivery.getDeliveriesForRoute")
                    .setParameter("routeId", routeId)
                    .setParameter("deliveryStatus", "At Depot")
                    .getResultList();

            DeliveryStatus outForDeliveryStatus = (DeliveryStatus) em.createNamedQuery("DeliveryStatus.findByName")
                    .setParameter("name", "Out For Delivery")
                    .getSingleResult();

            for (Delivery routeDelivery : routeDeliveries)
            {
                routeDelivery.setDeliveryStatusId(outForDeliveryStatus);
                em.persist(routeDelivery);
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public ArrayList<DeliveryDTO> getDriverDeliveries(int routeId)
    {
        try
        {
            List<Delivery> deliveryList = (List<Delivery>) em.createNamedQuery("Delivery.getDriverDeliveries")
                    .setParameter("routeId", routeId)
                    .getResultList();

            ArrayList<DeliveryDTO> deliveries = new ArrayList<DeliveryDTO>();

            deliveryList.forEach((delivery) ->
            {
                if(!delivery.getDeliveryStatusId().getName().equals("Dispatched")
                        || !delivery.getDeliveryStatusId().getName().equals("At Depot")
                        || !delivery.getDeliveryStatusId().getName().equals("Awaiting Collection"))
                {
                    deliveries.add(DTOConversionGateway.createDeliveryDTO(delivery));
                }
            });

            return deliveries;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean deliverDelivery(int deliveryId)
    {
        try
        {
            Delivery delivery = (Delivery) em.createNamedQuery("Delivery.findByDeliveryId").setParameter("deliveryId", deliveryId).getSingleResult();
            DeliveryStatus deliveredStatus = (DeliveryStatus) em.createNamedQuery("DeliveryStatus.findByName").setParameter("name", "Delivered").getSingleResult();
            
            delivery.setDeliveryStatusId(deliveredStatus);
            em.persist(delivery);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean failDelivery(int deliveryId)
    {
        try
        {
            Delivery delivery = (Delivery) em.createNamedQuery("Delivery.findByDeliveryId").setParameter("deliveryId", deliveryId).getSingleResult();
            DeliveryStatus deliveryFailedStatus = (DeliveryStatus) em.createNamedQuery("DeliveryStatus.findByName").setParameter("name", "Delivery Failed").getSingleResult();
            
            delivery.setDeliveryStatusId(deliveryFailedStatus);
            em.persist(delivery);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean changeDeliveryStatus(int deliveryId, int deliveryStatusId)
    {
        try
        {
            Delivery delivery = (Delivery) em.createNamedQuery("Delivery.findByDeliveryId").setParameter("deliveryId", deliveryId).getSingleResult();
            DeliveryStatus newStatus = (DeliveryStatus) em.createNamedQuery("DeliveryStatus.findByDeliveryStatusId").setParameter("deliveryStatusId", deliveryStatusId).getSingleResult();
            
            delivery.setDeliveryStatusId(newStatus);
            em.persist(delivery);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
