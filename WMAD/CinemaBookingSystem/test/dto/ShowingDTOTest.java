package dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhys Jones
 */
public class ShowingDTOTest
{

    private ShowingDTO showing;
    private FilmDTO film;
    private ScreenDTO screen;
    private CinemaDTO cinema;
    private Date time;

    public ShowingDTOTest()
    {
        time = new Date(2017 - 1900, 6, 24, 15, 30);
        cinema = new CinemaDTO(0, "cineworld");
        film = new FilmDTO(0, "title", 18, 120, "description");
        screen = new ScreenDTO(0, cinema, "screenName");
        showing = new ShowingDTO(0, film, screen, time, 20);
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of getShowingID method, of class ShowingDTO.
     */
    @Test
    public void testGetShowingID()
    {
        System.out.println("getShowingID");
        ShowingDTO instance = showing;
        int expResult = 0;
        int result = instance.getShowingID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFilm method, of class ShowingDTO.
     */
    @Test
    public void testGetFilm()
    {
        System.out.println("getFilm");
        ShowingDTO instance = showing;
        FilmDTO expResult = film;
        FilmDTO result = instance.getFilm();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScreen method, of class ShowingDTO.
     */
    @Test
    public void testGetScreen()
    {
        System.out.println("getScreen");
        ShowingDTO instance = showing;
        ScreenDTO expResult = screen;
        ScreenDTO result = instance.getScreen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTime method, of class ShowingDTO.
     */
    @Test
    public void testGetTimeString()
    {
        System.out.println("getTime");
        ShowingDTO instance = showing;
        String expResult = "15:30";
        String result = instance.getTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAvailableSeats method, of class ShowingDTO.
     */
    @Test
    public void testGetAvailableSeats()
    {
        System.out.println("getAvailableSeats");
        ShowingDTO instance = showing;
        int expResult = 20;
        int result = instance.getAvailableSeats();
        assertEquals(expResult, result);
    }

}
