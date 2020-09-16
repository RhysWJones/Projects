/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

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
public class BookingDTOTest
{

    private UserDTO customer;
    private ShowingDTO showing;
    private BookingDTO booking;
    private FilmDTO film;
    private ScreenDTO screen;
    private CinemaDTO cinema;
    private Date time;

    public BookingDTOTest()
    {
        Date DOB = new Date(1994 - 1900, 6, 24);
        time = new Date(2017 - 1900, 6, 24, 15, 30);
        customer = new UserDTO(0, "John", "Smith", DOB, "20 Dewbury Lane", "Staffordshire", "ST17 2ES", "Johnno101", "Pass", true);
        cinema = new CinemaDTO(0, "cineworld");
        film = new FilmDTO(0, "title", 18, 120, "description");
        screen = new ScreenDTO(0, cinema, "screenName");
        showing = new ShowingDTO(0, film, screen, time, 20);
        booking = new BookingDTO(0, customer, showing, 3);

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
     * Test of getBookingID method, of class BookingDTO.
     */
    @Test
    public void testGetBookingID()
    {
        System.out.println("getBookingID");
        BookingDTO instance = booking;
        int expResult = 0;
        int result = instance.getBookingID();
        assertEquals(expResult, result);

    }

    /**
     * Test of getCustomer method, of class BookingDTO.
     */
    @Test
    public void testGetCustomer()
    {
        System.out.println("getCustomer");
        BookingDTO instance = booking;
        UserDTO expResult = customer;
        UserDTO result = instance.getCustomer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShowing method, of class BookingDTO.
     */
    @Test
    public void testGetShowing()
    {
        System.out.println("getShowing");
        BookingDTO instance = booking;
        ShowingDTO expResult = showing;
        ShowingDTO result = instance.getShowing();
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantity method, of class BookingDTO.
     */
    @Test
    public void testGetQuantity()
    {
        System.out.println("getQuantity");
        BookingDTO instance = booking;
        int expResult = 3;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
    }

}
