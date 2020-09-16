package managedbean;

import customerUI.CustomerCommandFactory;
import dto.ScreenDTO;
import dto.ShowingDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Rhys Jones
 */
@Named(value = "ViewShowingsBean")
@SessionScoped
public class ViewShowingsBean implements Serializable
{

    private ArrayList<ShowingDTO> showings;

    public String getScreenShowings(ScreenDTO screen)
    {
        showings = new ArrayList();

        showings = (ArrayList<ShowingDTO>) CustomerCommandFactory
                .createCommand(
                        CustomerCommandFactory.GET_SCREEN_SHOWINGS, screen)
                .execute();

        if (!showings.isEmpty())
        {
            return "View Showings";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: No Cinemas."));
            return null;
        }
    }

    public ArrayList<ShowingDTO> getShowings()
    {
        return showings;
    }
    
    
}
