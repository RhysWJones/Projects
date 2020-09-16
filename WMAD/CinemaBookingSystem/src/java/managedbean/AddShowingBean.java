package managedbean;

import adminUI.AdminCommandFactory;
import dto.FilmDTO;
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
@Named(value = "AddShowingBean")
@SessionScoped
public class AddShowingBean implements Serializable
{

    private ScreenDTO screen;
    private FilmDTO film;
    private ArrayList<FilmDTO> films;
    private String time;

    public String addShowing()
    {
        boolean insertOK;

        insertOK = (boolean) AdminCommandFactory
                .createCommand(
                        AdminCommandFactory.ADD_SHOWING, film, screen, time)
                .execute();

        if (insertOK)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Showing Created."));
            return "Showing Created";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error: Showing could not be created."));
            return null;
        }
    }

    public String displayFilms(ScreenDTO screen)
    {
        this.screen = screen;
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

    public ScreenDTO getScreen()
    {
        return screen;
    }

    public FilmDTO getFilm()
    {
        return film;
    }

    public ArrayList<FilmDTO> getFilms()
    {
        return films;
    }

    public String setSelectedFilm(FilmDTO film)
    {
        this.film = film;
        return "Film Selected";
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getTime()
    {
        return time;
    }
    
    

}
