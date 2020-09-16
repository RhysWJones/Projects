package managed_bean;

import dto.DeliveryStatusDTO;
import ejb.DriverUIRemote;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rhys
 */
@Named(value = "updateDeliveryStatusBean")
@SessionScoped
public class UpdateDeliveryStatusBean implements Serializable
{
    @EJB
    private DriverUIRemote driverUI;
    private int chosenStatus;
    private ArrayList<DeliveryStatusDTO> deliveryStatuses;
    private int deliveryId;
    
    public UpdateDeliveryStatusBean()
    {
    }
    
    public String changeDeliveryStatus(int deliveryId)
    {
        deliveryStatuses = driverUI.getDeliveryStatuses();
        
        if(deliveryStatuses != null)
        {
            this.deliveryId = deliveryId;
            return "Change Delivery Status";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Delivery statuses could not be found"));
            return "";
        }
    }
    
    public String setNewStatusOnDelivery()
    {
        boolean deliveryStatusUpdated = driverUI.setNewStatusOnDelivery(deliveryId, chosenStatus);
        
        if(deliveryStatusUpdated)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Status updated"));
            return "Status Updated";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The delivery status could not be updated"));
            return "";
        }
    }

    public int getChosenStatus()
    {
        return chosenStatus;
    }

    public void setChosenStatus(int chosenStatus)
    {
        this.chosenStatus = chosenStatus;
    }

    public ArrayList<DeliveryStatusDTO> getDeliveryStatuses()
    {
        return deliveryStatuses;
    }

    public void setDeliveryStatuses(ArrayList<DeliveryStatusDTO> deliveryStatuses)
    {
        this.deliveryStatuses = deliveryStatuses;
    }

    public int getDeliveryId()
    {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId)
    {
        this.deliveryId = deliveryId;
    }
    
}
