package managed_bean;

import dto.DeliveryDTO;
import ejb.User_UIRemote;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rhys
 */
@Named(value = "expandedDeliveryViewBean")
@SessionScoped
public class ExpandedDeliveryViewBean implements Serializable
{
    private DeliveryDTO delivery;
    @EJB
    private User_UIRemote userUI;
    public ExpandedDeliveryViewBean()
    {
    }
    
    public String cancelDelivery()
    {
        boolean cancellationRequested = userUI.cancelDelivery(delivery.getDeliveryId());
        if(cancellationRequested)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cancellation requested for Delivery " + delivery.getDeliveryId()));
            delivery = null;
            return "Cancellation Requested";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cancellation request could not be processed"));
            return "Cancellation Failed";
        }
    }

    public DeliveryDTO getDelivery()
    {
        return delivery;
    }

    public void setDelivery(DeliveryDTO delivery)
    {
        this.delivery = delivery;
    }
    
    public String setDeliveryForExpansion(DeliveryDTO delivery)
    {
        setDelivery(delivery);
        return "Expand Delivery";
    }
    
}
