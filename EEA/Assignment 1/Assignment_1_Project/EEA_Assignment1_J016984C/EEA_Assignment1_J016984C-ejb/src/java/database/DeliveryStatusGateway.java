package database;

import dto.DeliveryStatusDTO;
import entity.DeliveryStatus;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rhys
 */
@Stateless
public class DeliveryStatusGateway implements DeliveryStatusGatewayLocal
{

    @PersistenceContext
    EntityManager em;

    @EJB
    DTOConversionGatewayLocal DTOConversionGateway;

    @Override
    public ArrayList<DeliveryStatusDTO> getDeliveryStatuses()
    {
        try
        {
            List<DeliveryStatus> deliveryStatusList = em.createNamedQuery("DeliveryStatus.findAll").getResultList();
            ArrayList<DeliveryStatusDTO> deliveryStatuses = new ArrayList<DeliveryStatusDTO>();

            for (DeliveryStatus deliveryStatus : deliveryStatusList)
            {
                deliveryStatuses.add(DTOConversionGateway.createDeliveryStatusDTO(deliveryStatus));
            }
            return deliveryStatuses;
        }
        catch (Exception e)
        {
            return null;
        }
    }
}
