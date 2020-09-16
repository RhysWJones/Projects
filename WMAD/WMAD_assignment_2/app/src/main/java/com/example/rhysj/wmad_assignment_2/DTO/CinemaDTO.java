package com.example.rhysj.wmad_assignment_2.DTO;

/**
 * Created by Rhys Jones on 04/04/2018.
 */

import java.io.Serializable;

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
