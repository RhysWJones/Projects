package com.example.rhysj.wmad_assignment_2.DTO;

/**
 * Created by Rhys Jones on 04/04/2018.
 */
import java.io.Serializable;

public class FilmDTO implements Serializable
{
    private int filmID;
    private String title;
    private int ageRating;
    private int runtime;
    private String description;

    FilmDTO()
    {
        this.filmID = 0;
        this.title = "";
        this.ageRating = 0;
        this.runtime = 0;
        this.description = "";
    }

    /**
     *
     * @param filmID
     * @param title
     * @param ageRating
     * @param runtime
     * @param description
     */
    public FilmDTO(int filmID, String title, int ageRating, int runtime, String description)
    {
        this.filmID = filmID;
        this.title = title;
        this.ageRating = ageRating;
        this.runtime = runtime;
        this.description = description;
    }

    public int getFilmID()
    {
        return filmID;
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
}