package managed_bean;

import dto.DeliveryDTO;
import dto.RouteDTO;
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
@Named(value = "driverCollectLocationViewBean")
@SessionScoped
public class DriverCollectLocationViewBean implements Serializable
{

    @EJB
    private DriverUIRemote driverUI;
    private int chosenRoute;
    private ArrayList<RouteDTO> routes;
    private ArrayList<DeliveryDTO> deliveriesOnChosenRoute;

    public DriverCollectLocationViewBean()
    {

    }

    public String getRoutesAndDepots()
    {
        routes = driverUI.getRoutes();
        if (routes != null)
        {
            return "Display Route Selection";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Could not get delivery routes"));
            return "";
        }
    }

    public void getDeliveriesForRoute()
    {
        deliveriesOnChosenRoute = driverUI.getDeliveriesForRoute(chosenRoute);

        if (deliveriesOnChosenRoute == null)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Route has no deliveries available for collection"));
        }
    }

    public String collectDeliveries()
    {
        HttpSession sessionScope = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        UserDTO driver = (UserDTO)sessionScope.getAttribute("loggedDriver");
        UserDTO updatedDriver = driverUI.assignRouteToDriver(driver, chosenRoute);
        
        if(updatedDriver != null)
        {
            boolean deliveriesCollected = driverUI.setRouteDeliveriesToOutForDelivery(chosenRoute);
            
            if(deliveriesCollected)
            {
                return "";
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Could not collect deliveries."));
                return "";
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The route could not be assigned to you"));
            return "";
        }
    }

    public int getChosenRoute()
    {
        return chosenRoute;
    }

    public void setChosenRoute(int chosenRoute)
    {
        this.chosenRoute = chosenRoute;
    }

    public ArrayList<RouteDTO> getRoutes()
    {
        return routes;
    }

    public void setRoutes(ArrayList<RouteDTO> routes)
    {
        this.routes = routes;
    }

    public ArrayList<DeliveryDTO> getDeliveriesOnChosenRoute()
    {
        return deliveriesOnChosenRoute;
    }

    public void setDeliveriesOnChosenRoute(ArrayList<DeliveryDTO> deliveriesOnChosenRoute)
    {
        this.deliveriesOnChosenRoute = deliveriesOnChosenRoute;
    }

}
