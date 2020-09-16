package managedbean;

import customerUI.CustomerCommandFactory;
import dto.CinemaDTO;
import dto.ScreenDTO;
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
@Named(value = "ViewCinemasBean")
@SessionScoped
public class ViewCinemasBean implements Serializable
{
    private ArrayList<CinemaDTO> cinemas;
    private ArrayList<ScreenDTO> screens;
    
    public ArrayList<CinemaDTO> getAllCinemas()
    {
        cinemas = new ArrayList();

        cinemas = (ArrayList<CinemaDTO>) CustomerCommandFactory
                .createCommand(
                        CustomerCommandFactory.GET_ALL_CINEMAS)
                .execute();
        
        if(!cinemas.isEmpty())
        {
            return cinemas;
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: No Cinemas."));
            return null;
        }
    }
    
    public ArrayList<ScreenDTO> getCinemaScreens()
    {
        screens = new ArrayList();

        screens = (ArrayList<ScreenDTO>) CustomerCommandFactory
                .createCommand(
                        CustomerCommandFactory.GET_CINEMA_SCREENS, cinemas)
                .execute();
        
        if(!screens.isEmpty())
        {
            return screens;
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: No Cinema Screens."));
            return null;
        }
    }

    public ArrayList<CinemaDTO> getCinemas()
    {
        return cinemas;
    }

    public ArrayList<ScreenDTO> getScreens()
    {
        return screens;
    }
    
    
   
}
