/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webServices;

import adminUI.AdminCommandFactory;
import dto.BookingDTO;
import dto.FilmDTO;
import dto.ScreenDTO;
import dto.ShowingDTO;
import dto.UserDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Rhys Jones
 */
@Path("AdminUI")
public class AdminUIResource
{

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AdminUIResource
     */
    public AdminUIResource()
    {
    }

    /**
     * Retrieves representation of an instance of webServices.AdminUIResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson()
    {
        return "This path is not supported.";
    }
    
    /**
     * Retrieves login details to authenticate the admin login
     * @param username
     * @param password
     * @return 
     */
    @GET
    @Path("/login/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO loginAdmin(
            @PathParam("username") String username,
            @PathParam("password") String password)
    {
        UserDTO loggedUser = (UserDTO) AdminCommandFactory
                    .createCommand(
                    AdminCommandFactory.LOGIN_ADMIN, username, password)
                    .execute();
        
        return loggedUser;
    }
    
    /**
     * Retrieves all of the films in the database
     * @return all FilmDTO's
     */
    @GET
    @Path("/film")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<FilmDTO> getAllFilms()
    {
        ArrayList<FilmDTO> films = (ArrayList<FilmDTO>) AdminCommandFactory
                .createCommand(
                        AdminCommandFactory.GET_ALL_FILMS)
                .execute();
        
        return films;
    }
    
    @GET
    @Path("/booking")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<BookingDTO> getAllBookings()
    {
        ArrayList<BookingDTO> bookings = (ArrayList<BookingDTO>) AdminCommandFactory
                .createCommand(
                        AdminCommandFactory.GET_ALL_BOOKINGS)
                .execute();
        
        return bookings;
    }
    
    @DELETE
    @Path("/film/{filmID}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteFilm(@PathParam("filmID") int filmID)
    {
        boolean deleteOk = (boolean) AdminCommandFactory
                .createCommand(
                        AdminCommandFactory.DELETE_FILM, filmID)
                .execute();
        
        return deleteOk;
    }
    
    @DELETE
    @Path("/booking/{bookingID}/{showingID}/{quantity}")
    //@Produces(MediaType.APPLICATION_JSON)
    public boolean cancelBooking(@PathParam("bookingID") int bookingID,
            @PathParam("showingID") int showingID,
            @PathParam("quantity") int quantity)
    {
        BookingDTO booking = new BookingDTO(bookingID, new UserDTO(), new ShowingDTO(showingID, null, null, new Date(), 0), quantity);
        
        boolean cancelOk = (boolean) AdminCommandFactory
                .createCommand(
                        AdminCommandFactory.CANCEL_BOOKING, booking)
                .execute();
        
        return cancelOk;
    }
    
    @POST
    @Path("/showing")
    //@Consumes(MediaType.APPLICATION_JSON)
    public boolean addShowing(@FormParam("filmID") int filmID,
            @FormParam("screenID") int screenID,
            @FormParam("time") String time)
    {
        FilmDTO film = new FilmDTO(filmID, "", 0, 0, "");
        ScreenDTO screen = new ScreenDTO(screenID, null, "");
        boolean insertOK = (boolean) AdminCommandFactory
                .createCommand(
                        AdminCommandFactory.ADD_SHOWING, film, screen, time)
                .execute();
        
        return insertOK;
    }
    
    @POST
    @Path("/film")
    //@Consumes(MediaType.APPLICATION_JSON)
    public boolean addFilm(@FormParam("title") String title,
            @FormParam("ageRating") int ageRating,
            @FormParam("runtime") int runtime,
            @FormParam("description") String description)
    {
        FilmDTO film = new FilmDTO(0, title, ageRating, runtime, description);
        boolean filmAdded = (boolean) AdminCommandFactory
                        .createCommand(
                                AdminCommandFactory.ADD_FILM, film)
                        .execute();
        
        return filmAdded;
    }
}
