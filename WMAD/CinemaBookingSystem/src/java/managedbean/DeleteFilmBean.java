package managedbean;

import adminUI.AdminCommandFactory;
import dto.FilmDTO;
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
@Named(value = "DeleteFilmBean")
@SessionScoped
public class DeleteFilmBean implements Serializable
{
    private ArrayList<FilmDTO> films;

    /**
     *
     * @return
     */
    public String displayAllFilms()
    {
        films = new ArrayList();

        films = (ArrayList<FilmDTO>) AdminCommandFactory
                .createCommand(
                        AdminCommandFactory.GET_ALL_FILMS)
                .execute();

        if (!films.isEmpty())
        {
            return "Display Films";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: No Films."));
            return null;
        }
    }
    
    public String deleteFilm(int filmID)
    {
        boolean deleteOk = false;
        
        deleteOk = (boolean) AdminCommandFactory
                .createCommand(
                        AdminCommandFactory.DELETE_FILM, filmID)
                .execute();
        
        if (deleteOk)
        {
            for(int i = 0; i < films.size(); i++)
            {
                if(films.get(i).getFilmID() == filmID)
                {
                    films.remove(i);
                }
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deleted."));
            return "Deleted";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: Could not delete film."));
            return null;
        }
    }

    public ArrayList<FilmDTO> getFilms()
    {
        return films;
    }
    
}
