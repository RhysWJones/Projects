package dto;

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
public class ScreenDTOTest
{
    private ScreenDTO screen;
    private CinemaDTO cinema;
    public ScreenDTOTest()
    {
        cinema = new CinemaDTO(0, "cineworld");
        screen = new ScreenDTO(0, cinema, "Screen 1");
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
     * Test of getScreenID method, of class ScreenDTO.
     */
    @Test
    public void testGetScreenID()
    {
        System.out.println("getScreenID");
        ScreenDTO instance = screen;
        int expResult = 0;
        int result = instance.getScreenID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCinema method, of class ScreenDTO.
     */
    @Test
    public void testGetCinema()
    {
        System.out.println("getCinema");
        ScreenDTO instance = screen;
        CinemaDTO expResult = cinema;
        CinemaDTO result = instance.getCinema();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScreenName method, of class ScreenDTO.
     */
    @Test
    public void testGetScreenName()
    {
        System.out.println("getScreenName");
        ScreenDTO instance = screen;
        String expResult = "Screen 1";
        String result = instance.getScreenName();
        assertEquals(expResult, result);
    }
    
}
