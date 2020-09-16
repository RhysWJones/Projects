package managed_bean;

import dto.DeliveryDTO;
import ejb.User_UIRemote;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rhys
 */
@Named(value = "deliverySearchBean")
@SessionScoped
public class DeliverySearchBean implements Serializable
{
    private int deliveryId;
    @EJB
    private User_UIRemote userUI;
    private DeliveryDTO deliverySearchResult;

    public DeliverySearchBean()
    {
    }
    
    public void search()
    {
        deliverySearchResult = userUI.search(deliveryId);
        
        if(deliverySearchResult != null && deliverySearchResult instanceof DeliveryDTO)
        {
            deliveryId = 0;
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Delivery " + deliveryId + " could not be found"));
        }
    }

    public int getDeliveryId()
    {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId)
    {
        this.deliveryId = deliveryId;
    }

    public DeliveryDTO getDeliverySearchResult()
    {
        return deliverySearchResult;
    }
}
