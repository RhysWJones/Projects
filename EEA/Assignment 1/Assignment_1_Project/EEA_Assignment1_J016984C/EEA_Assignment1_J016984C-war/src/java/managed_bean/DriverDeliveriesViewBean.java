package managed_bean;

import dto.DeliveryDTO;
import dto.UserDTO;
import ejb.DriverUIRemote;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rhys
 */
@Named(value = "driverDeliveriesViewBean")
@SessionScoped
public class DriverDeliveriesViewBean implements Serializable
{
    @EJB
    private DriverUIRemote driverUI;
    private ArrayList<DeliveryDTO> driverDeliveries;

    public DriverDeliveriesViewBean()
    {
        
    }
    
    public String getDeliveriesForView()
    {
        HttpSession sessionScope = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        UserDTO driver = (UserDTO)sessionScope.getAttribute("loggedDriver");
        driverDeliveries = driverUI.getDriverDeliveries(driver.getRouteId().getRouteId());
        
        if(driverDeliveries != null)
        {
            return "Display Driver Deliveries";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You have no deliveries to deliver currently"));
            return "";
        }
    }
    
    public String deliverDelivery(int deliveredDelivery)
    {
        boolean deliveryDelivered = driverUI.deliverDelivery(deliveredDelivery);
        
        if(deliveryDelivered)
        {
            return getDeliveriesForView();
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Could not confirm delivery"));
            return "";
        }
    }
    
    public String failDelivery(int failedDelivery)
    {
        boolean deliveryFailed = driverUI.failDelivery(failedDelivery);
        
        if(deliveryFailed)
        {
            return getDeliveriesForView();
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Could not confirm delivery failure"));
            return "";
        }
    }

    public ArrayList<DeliveryDTO> getDriverDeliveries()
    {
        return driverDeliveries;
    }

    public void setDriverDeliveries(ArrayList<DeliveryDTO> driverDeliveries)
    {
        this.driverDeliveries = driverDeliveries;
    }
}
