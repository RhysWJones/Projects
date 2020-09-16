package dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rhys Jones
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShowingDTO implements Serializable
{

    private int showingID;
    private FilmDTO film;
    private ScreenDTO screen;
    private String time;
    private int availableSeats;

    public ShowingDTO()
    {
        this.showingID = 0;
        this.film = new FilmDTO();
        this.screen = new ScreenDTO();
        this.time = "";
        this.availableSeats = 0;
    }
    
    public ShowingDTO(int showingID, FilmDTO film, ScreenDTO screen, String time, int availableSeats)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        this.showingID = showingID;
        this.film = film;
        this.screen = screen;
        this.time = sdf.format(time);
        this.availableSeats = availableSeats;
    }
    
    public ShowingDTO(int showingID, FilmDTO film, ScreenDTO screen, Date time, int availableSeats)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        this.showingID = showingID;
        this.film = film;
        this.screen = screen;
        this.time = sdf.format(time);
        this.availableSeats = availableSeats;
    }

    public int getShowingID()
    {
        return showingID;
    }

    public FilmDTO getFilm()
    {
        return film;
    }

    public ScreenDTO getScreen()
    {
        return screen;
    }

    public String getTime()
    {
        return time;
    }

    public int getAvailableSeats()
    {
        return availableSeats;
    }

}
