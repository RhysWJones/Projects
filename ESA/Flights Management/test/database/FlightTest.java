/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
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
public class FlightTest {
    
    public FlightTest() {
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
     * Test of getSeat method, of class Flight.
     */
    @Test
    public void testGetSeat() {
        System.out.println("getSeat");
        Flight instance = new Flight();
        Seat expResult = new Seat(1,1,1,true);
        instance.addSeat(expResult);
        ArrayList<Seat> seats = instance.getSeat();
        Seat result = seats.get(0);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addSeat method, of class Flight.
     */
    @Test
    public void testAddSeat() {
        System.out.println("addSeat");
        Seat expResult = new Seat(1,1,1,true);
        Flight instance = new Flight();
        instance.addSeat(expResult);
        ArrayList<Seat> seats = instance.getSeat();
        Seat result = seats.get(0);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPlane method, of class Flight.
     */
    @Test
    public void testGetPlane() {
        System.out.println("getPlane");
        Flight instance = new Flight();
        Plane expResult = new Plane(1,"test1",1,"test2","test3");
        instance.setPlane(expResult);
        Plane result = instance.getPlane();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setPlane method, of class Flight.
     */
    @Test
    public void testSetPlane() {
        System.out.println("setPlane");
        Flight instance = new Flight();
        Plane expResult = new Plane(1,"test1",1,"test2","test3");
        instance.setPlane(expResult);
        Plane result = instance.getPlane();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFlightID method, of class Flight.
     */
    @Test
    public void testGetFlightID() {
        System.out.println("getFlightID");
        Flight instance = new Flight();
        int expResult = 1;
        instance.setFlightID(expResult);
        int result = instance.getFlightID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFlightID method, of class Flight.
     */
    @Test
    public void testSetFlightID() {
        System.out.println("setFlightID");
        Flight instance = new Flight();
        int expResult = 1;
        instance.setFlightID(expResult);
        int result = instance.getFlightID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPlaneID method, of class Flight.
     */
    @Test
    public void testGetPlaneID() {
        System.out.println("getPlaneID");
        Flight instance = new Flight();
        int expResult = 1;
        instance.setPlaneID(expResult);
        int result = instance.getPlaneID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setPlaneID method, of class Flight.
     */
    @Test
    public void testSetPlaneID() {
        System.out.println("setPlaneID");
        Flight instance = new Flight();
        int expResult = 1;
        instance.setPlaneID(expResult);
        int result = instance.getPlaneID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getfOrigin method, of class Flight.
     */
    @Test
    public void testGetfOrigin() {
        System.out.println("getfOrigin");
        Flight instance = new Flight();
        String expResult = "test origin";
        instance.setfOrigin(expResult);
        String result = instance.getfOrigin();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setfOrigin method, of class Flight.
     */
    @Test
    public void testSetfOrigin() {
        System.out.println("setfOrigin");
        Flight instance = new Flight();
        String expResult = "test origin";
        instance.setfOrigin(expResult);
        String result = instance.getfOrigin();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getfDestination method, of class Flight.
     */
    @Test
    public void testGetfDestination() {
        System.out.println("getfDestination");
        Flight instance = new Flight();
        String expResult = "test destination";
        instance.setfDestination(expResult);
        String result = instance.getfDestination();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setfDestination method, of class Flight.
     */
    @Test
    public void testSetfDestination() {
        System.out.println("setfDestination");
        Flight instance = new Flight();
        String expResult = "test destination";
        instance.setfDestination(expResult);
        String result = instance.getfDestination();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDepartureDate method, of class Flight.
     */
    @Test
    public void testGetDepartureDate() {
        System.out.println("getDepartureDate");
        
        Flight instance = new Flight();
        Date expResult = Date.valueOf("2018-03-03");
        instance.setDepartureDate(expResult);
        Date result = instance.getDepartureDate();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDepartureDate method, of class Flight.
     */
    @Test
    public void testSetDepartureDate() {
        System.out.println("setDepartureDate");
        Flight instance = new Flight();
        Date expResult = Date.valueOf("2018-03-03");
        instance.setDepartureDate(expResult);
        Date result = instance.getDepartureDate();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        System.out.println("getDepartureTime");
        Flight instance = new Flight();
        Time expResult = Time.valueOf("20:20:00");
        instance.setDepartureTime(expResult);
        Time result = instance.getDepartureTime();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        System.out.println("setDepartureTime");
        Flight instance = new Flight();
        Time expResult = Time.valueOf("20:20:00");
        instance.setDepartureTime(expResult);
        Time result = instance.getDepartureTime();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getArrivalTime method, of class Flight.
     */
    @Test
    public void testGetArrivalTime() {
        System.out.println("getArrivalTime");
        Flight instance = new Flight();
        Time expResult = Time.valueOf("20:20:00");
        instance.setArrivalTime(expResult);
        Time result = instance.getArrivalTime();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setArrivalTime method, of class Flight.
     */
    @Test
    public void testSetArrivalTime() {
        System.out.println("setArrivalTime");
        Flight instance = new Flight();
        Time expResult = Time.valueOf("20:20:00");
        instance.setArrivalTime(expResult);
        Time result = instance.getArrivalTime();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getArrivalDate method, of class Flight.
     */
    @Test
    public void testGetArrivalDate() {
        System.out.println("getArrivalDate");
        Flight instance = new Flight();
        Date expResult = Date.valueOf("2018-03-03");
        instance.setArrivalDate(expResult);
        Date result = instance.getArrivalDate();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setArrivalDate method, of class Flight.
     */
    @Test
    public void testSetArrivalDate() {
        System.out.println("setArrivalDate");
        Flight instance = new Flight();
        Date expResult = Date.valueOf("2018-03-03");
        instance.setArrivalDate(expResult);
        Date result = instance.getArrivalDate();
        assertEquals(expResult, result);
        
    }
    
}