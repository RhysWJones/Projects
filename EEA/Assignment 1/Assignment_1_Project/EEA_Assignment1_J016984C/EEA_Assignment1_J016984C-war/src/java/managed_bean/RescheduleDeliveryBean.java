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
@Named(value = "rescheduleDeliveryBean")
@SessionScoped
public class RescheduleDeliveryBean implements Serializable
{

    private Date newDeliveryDate;
    private DeliveryDTO delivery;
    @EJB
    private User_UIRemote userUI;
    
    public RescheduleDeliveryBean()
    {
    }
    
    public String rescheduleDelivery()
    {
        boolean deliveryRescheduled = userUI.rescheduleDelivery(delivery.getDeliveryId(), newDeliveryDate);
        if(deliveryRescheduled)
        {
            delivery = null;
            newDeliveryDate = null;
            return "Success";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Delivery could not be re-scheduled."));
            return "";
        }
    }

    public Date getNewDeliveryDate()
    {
        return newDeliveryDate;
    }

    public void setNewDeliveryDate(Date newDeliveryDate)
    {
        this.newDeliveryDate = newDeliveryDate;
    }

    public DeliveryDTO getDelivery()
    {
        return delivery;
    }

    public void setDelivery(DeliveryDTO delivery)
    {
        this.delivery = delivery;
    }
    
    public String setDeliveryForRescheduling(DeliveryDTO delivery)
    {
        setDelivery(delivery);
        return "Reschedule Delivery";
    }
    
}
