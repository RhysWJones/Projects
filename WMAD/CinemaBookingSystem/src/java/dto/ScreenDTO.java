package dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rhys Jones
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ScreenDTO implements Serializable
{

    private int screenID;
    private CinemaDTO cinema;
    private String screenName;
    
    ScreenDTO()
    {
        this.screenID = 0;
        this.cinema = new CinemaDTO();
        this.screenName = "";
    }

    /**
     *
     * @param screenID
     * @param cinema
     * @param screenName
     */
    public ScreenDTO(int screenID, CinemaDTO cinema, String screenName)
    {
        this.screenID = screenID;
        this.cinema = cinema;
        this.screenName = screenName;
    }

    public int getScreenID()
    {
        return screenID;
    }

    public CinemaDTO getCinema()
    {
        return cinema;
    }

    public String getScreenName()
    {
        return screenName;
    }

}
