
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
public class CinemaDTO implements Serializable
{
    private int cinemaID;
    private String name;
    
    CinemaDTO()
    {
        this.cinemaID = 0;
        this.name = "";
    }
    
    /**
     * Constructs a CinemaDTO Object
     * @param cinemaID 
     * @param name 
     */
    public CinemaDTO(int cinemaID, String name)
    {
        this.cinemaID = cinemaID;
        this.name = name;
    }

    public int getCinemaID()
    {
        return cinemaID;
    }

    public String getName()
    {
        return name;
    }
    
    
}
