package application_ui;

import ejb.DeliveryHandlerLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class BookCollectionCommand implements BookCollectionCommandLocal
{
    @EJB
    private DeliveryHandlerLocal deliveryHandler;
    private int deliveryId;
    private Date collectionDate;

    @Override
    public Object execute()
    {
        return deliveryHandler.bookCollection(deliveryId, collectionDate);
    }

    @Override
    public void setDeliveryId(int deliveryId)
    {
        this.deliveryId = deliveryId;
    }

    @Override
    public void setCollectionDate(Date collectionDate)
    {
        this.collectionDate = collectionDate;
    }
}
