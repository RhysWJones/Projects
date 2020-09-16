package managedbean;

import adminUI.AdminCommandFactory;
import dto.FilmDTO;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Rhys Jones
 */
@Named(value = "AddFilmBean")
@RequestScoped
public class AddFilmBean
{
    private String title;
    private int ageRating;
    private int runtime;
    private String description;
    
    public String addFilm()
    {
        boolean filmAdded = false;
        FilmDTO film = new FilmDTO(0, title, ageRating, runtime, description);
        
        filmAdded = (boolean) AdminCommandFactory
                        .createCommand(
                                AdminCommandFactory.ADD_FILM, film)
                        .execute();
        
        if(filmAdded)
        {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Film Added."));
             return "Film Added";
        }
        else
        {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: Film could not be Added."));
             return null;
        }
    }

    public String getTitle()
    {
        return title;
    }

    public int getAgeRating()
    {
        return ageRating;
    }

    public int getRuntime()
    {
        return runtime;
    }

    public String getDescription()
    {
        return description;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAgeRating(int ageRating)
    {
        this.ageRating = ageRating;
    }

    public void setRuntime(int runtime)
    {
        this.runtime = runtime;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    
    
}
