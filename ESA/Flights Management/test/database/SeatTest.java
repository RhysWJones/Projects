/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Date;
import java.sql.Time;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krzychu
 */
public class SeatTest {
    
    public SeatTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setFlight method, of class Seat.
     */
    @Test
    public void testSetFlight() {
        System.out.println("setFlight");
        Date date = Date.valueOf("2018-03-03");
        Time time = Time.valueOf("20:20:00");
        Plane plane = new Plane();
        Flight expResult = new Flight(1,1,"test1","test2",date,time,date,time,plane); 
        Seat instance = new Seat();
        instance.setFlight(expResult);
        Flight result = instance.getFlight();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getFlight method, of class Seat.
     */
    @Test
    public void testGetFlight() {
        System.out.println("getFlight");
        Date date = Date.valueOf("2018-03-03");
        Time time = Time.valueOf("20:20:00");
        Plane plane = new Plane();
        Flight expResult = new Flight(1,1,"test1","test2",date,time,date,time,plane); 
        Seat instance = new Seat();
        instance.setFlight(expResult);
        Flight result = instance.getFlight();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getSeatID method, of class Seat.
     */
    @Test
    public void testGetSeatID() {
        System.out.println("getSeatID");
        Seat instance = new Seat();
        int expResult = 1;
        instance.setSeatID(expResult);
        int result = instance.getSeatID();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setSeatID method, of class Seat.
     */
    @Test
    public void testSetSeatID() {
        System.out.println("setSeatID");
        Seat instance = new Seat();
        int expResult = 1;
        instance.setSeatID(expResult);
        int result = instance.getSeatID();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getFlightID method, of class Seat.
     */
    @Test
    public void testGetFlightID() {
        System.out.println("getFlightID");
        Seat instance = new Seat();
        int expResult = 1;
        instance.setFlightID(expResult);
        int result = instance.getFlightID();        
        assertEquals(expResult, result);       
    }

    /**
     * Test of setFlightID method, of class Seat.
     */
    @Test
    public void testSetFlightID() {
        System.out.println("setFlightID");
        Seat instance = new Seat();
        int expResult = 1;
        instance.setFlightID(expResult);
        int result = instance.getFlightID();        
        assertEquals(expResult, result);        
    }

    /**
     * Test of getSeatNumber method, of class Seat.
     */
    @Test
    public void testGetSeatNumber() {
        System.out.println("getSeatNumber");
        Seat instance = new Seat();
        int expResult = 1;
        instance.setSeatNumber(expResult);
        int result = instance.getSeatNumber();        
        assertEquals(expResult, result);        
    }

    /**
     * Test of setSeatNumber method, of class Seat.
     */
    @Test
    public void testSetSeatNumber() {
        System.out.println("setSeatNumber");
        Seat instance = new Seat();
        int expResult = 1;
        instance.setSeatNumber(expResult);
        int result = instance.getSeatNumber();        
        assertEquals(expResult, result);        
    }

    /**
     * Test of getSeatTaken method, of class Seat.
     */
    @Test
    public void testGetSeatTaken() {
        System.out.println("getSeatTaken");
        Seat instance = new Seat();
        boolean expResult = false;
        boolean result = instance.getSeatTaken();
        instance.setSeatTaken(result);
        assertEquals(expResult, result);       
    }

    /**
     * Test of setSeatTaken method, of class Seat.
     */
    @Test
    public void testSetSeatTaken() {
        System.out.println("setSeatTaken");
        Seat instance = new Seat();
        boolean expResult = false;
        boolean result = instance.getSeatTaken();
        instance.setSeatTaken(result);
        assertEquals(expResult, result);       
    }
    
}
