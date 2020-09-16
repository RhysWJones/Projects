package webServices;

import customerUI.CustomerCommandFactory;
import dto.CinemaDTO;
import dto.ScreenDTO;
import dto.ShowingDTO;
import dto.UserDTO;
import java.util.ArrayList;
import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Rhys Jones
 */
@Path("CustomerUI")
public class CustomerUIResource
{

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CustomerUIResource
     */
    public CustomerUIResource()
    {
    }
    
    //NEEDED FOR TESTING FOR SOME REASON.
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson()
    {
        return "This path is not supported.";
    }
    
    /**
     * Retrieves login details to authenticate the customer login
     * @param username
     * @param password
     * @return the logged in user
     */
    @GET
    @Path("/login/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO loginCustomer(
            @PathParam("username") String username,
            @PathParam("password") String password)
    {
        UserDTO loggedUser = (UserDTO) CustomerCommandFactory
                    .createCommand(
                    CustomerCommandFactory.LOGIN_CUSTOMER, username, password)
                    .execute();
        
        return loggedUser;
    }

    /**
     * PUT method for updating account details
     * @param userID
     * @param forename
     * @param surname
     * @param DOB
     * @param addressLine1
     * @param addressLine2
     * @param postcode
     * @param username
     * @param password
     * @return whether the update was successful or not
     */
    @PUT
    @Path("/account")
    //@Consumes(MediaType.APPLICATION_JSON)
    public boolean updateAccountDetails(@FormParam("userID") String userID,
            @FormParam("forename") String forename,
            @FormParam("surname") String surname,
            @FormParam("DOB") String DOB,
            @FormParam("addressLine1") String addressLine1,
            @FormParam("addressLine2") String addressLine2,
            @FormParam("postcode") String postcode,
            @FormParam("username") String username,
            @FormParam("password") String password)
    {
        boolean updateSuccessful = false;
        UserDTO user = new UserDTO(Integer.parseInt(userID), forename, surname, DOB, addressLine1, addressLine2, postcode, username, password, false);
        
        updateSuccessful = (boolean) CustomerCommandFactory
                        .createCommand(
                                CustomerCommandFactory.UPDATE_ACCOUNT_DETAILS, user)
                        .execute();
        
        return updateSuccessful;
    }
    
    /**
     * 
     * @param forename
     * @param surname
     * @param DOB
     * @param addressLine1
     * @param addressLine2
     * @param postcode
     * @param username
     * @param password
     * @return whether registration was a success or not
     */
    @POST
    @Path("/register")
    //@Consumes(MediaType.APPLICATION_JSON)
    public boolean registerCustomer(@FormParam("forename") String forename,
            @FormParam("surname") String surname,
            @FormParam("DOB") String DOB,
            @FormParam("addressLine1") String addressLine1,
            @FormParam("addressLine2") String addressLine2,
            @FormParam("postcode") String postcode,
            @FormParam("username") String username,
            @FormParam("password") String password)
    {
        boolean insertSuccessful = false;
        UserDTO user = new UserDTO(0, forename, surname, DOB, addressLine1, addressLine2, postcode, username, password, false);
        
                insertSuccessful = (boolean) CustomerCommandFactory
                        .createCommand(
                                CustomerCommandFactory.REGISTER_CUSTOMER, user)
                        .execute();
        
        return insertSuccessful;
    }
    
    /**
     * Returns a list of showings for a screen
     * @param screenID
     * @param screenName
     * @param cinemaID
     * @param cinemaName
     * @return list of showings for a screen
     */
    @GET
    @Path("/showing/{screenID}/{screenName}/{cinemaID}/{cinemaName}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ShowingDTO> getScreenShowings(@PathParam("screenID") int screenID,
            @PathParam("screenName") String screenName,
            @PathParam("cinemaID") int cinemaID,
            @PathParam("cinemaName") String cinemaName)
    {
        CinemaDTO cinema = new CinemaDTO(cinemaID, cinemaName);
        ScreenDTO screen = new ScreenDTO(screenID, cinema, screenName);
        ArrayList<ShowingDTO> showings = (ArrayList<ShowingDTO>) CustomerCommandFactory
                .createCommand(
                        CustomerCommandFactory.GET_SCREEN_SHOWINGS, screen)
                .execute();
        
        return showings;
    }
    
    /**
     * Returns a list of screens for a cinema
     * @return list of screens for a cinema
     */
    @GET
    @Path("/screen")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ScreenDTO> getCinemaScreens()
    {
        ArrayList<CinemaDTO> cinemas = (ArrayList<CinemaDTO>) CustomerCommandFactory
                .createCommand(
                        CustomerCommandFactory.GET_ALL_CINEMAS)
                .execute();
        
        ArrayList<ScreenDTO> screens = (ArrayList<ScreenDTO>) CustomerCommandFactory
                .createCommand(
                        CustomerCommandFactory.GET_CINEMA_SCREENS, cinemas)
                .execute();
        
        return screens;
    }
    
    /**
     * Insert a booking into the database
     * @param showingID
     * @param userID
     * @param noOfSeats
     * @return whether booking was successful or not
     */
    @POST
    @Path("/booking")
    //@Consumes(MediaType.APPLICATION_JSON)
    public boolean bookTickets(@FormParam("showingID") int showingID, 
            @FormParam("userID") int userID, 
            @FormParam("seats") int noOfSeats)
    {
        ShowingDTO showing = new ShowingDTO(showingID, null, null, new Date(), 0);
        UserDTO loggedUser = new UserDTO(userID, "", "", "", "", "", "", "", "", false);
        
        boolean bookingOK = (boolean) CustomerCommandFactory
                .createCommand(
                        CustomerCommandFactory.BOOK_TICKETS, showing, loggedUser, noOfSeats)
                .execute();
        
        return bookingOK;
    }
}
