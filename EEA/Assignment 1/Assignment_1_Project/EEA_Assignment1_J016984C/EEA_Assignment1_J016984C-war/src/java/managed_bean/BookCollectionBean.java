package managed_bean;

import dto.DeliveryDTO;
import ejb.User_UIRemote;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rhys
 */
@Named(value = "bookCollectionBean")
@SessionScoped
public class BookCollectionBean implements Serializable
{
    private Date collectionDate;
    private DeliveryDTO delivery;
    @EJB
    private User_UIRemote userUI;

    public BookCollectionBean()
    {
    }
    
    public String bookCollection()
    {
        boolean awaitingCollection = userUI.bookCollection(delivery.getDeliveryId(), collectionDate);
        if(awaitingCollection)
        {
            collectionDate = null;
            delivery = null;
            return "Success";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Collection could not be booked."));
            return "";
        }
    }
    
    public Date getCollectionDate()
    {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate)
    {
        this.collectionDate = collectionDate;
    }

    public DeliveryDTO getDelivery()
    {
        return delivery;
    }

    public void setDelivery(DeliveryDTO delivery)
    {
        this.delivery = delivery;
    }
    
    public String setDeliveryForCollection(DeliveryDTO delivery)
    {
        setDelivery(delivery);
        return "Collect Delivery";
    }
}
