package managed_bean;

import dto.DeliveryDTO;
import dto.UserDTO;
import ejb.User_UIRemote;
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
@Named(value = "recipientDeliveriesViewBean")
@SessionScoped
public class RecipientDeliveriesViewBean implements Serializable
{

    @EJB
    private User_UIRemote userUI;
    private ArrayList<DeliveryDTO> recipientDeliveries;

    public RecipientDeliveriesViewBean()
    {
    }
    
    public String getAllDeliveriesForUser()
    {
        HttpSession sessionScope = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        UserDTO user = (UserDTO) sessionScope.getAttribute("loggedUser");
        recipientDeliveries = userUI.getRecipientDeliveries(user.getId());
        if(!recipientDeliveries.isEmpty())
        {
            return "Display Recipient Deliveries";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No deliveries were found for you."));
            return "";
        }
    }

    public ArrayList<DeliveryDTO> getRecipientDeliveries()
    {
        return recipientDeliveries;
    }

    public void setRecipientDeliveries(ArrayList<DeliveryDTO> recipientDeliveries)
    {
        this.recipientDeliveries = recipientDeliveries;
    }

}
