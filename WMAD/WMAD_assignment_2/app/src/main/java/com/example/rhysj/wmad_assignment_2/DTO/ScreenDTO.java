package com.example.rhysj.wmad_assignment_2.DTO;

/**
 * Created by J016984c on 04/04/2018.
 */
import java.io.Serializable;

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