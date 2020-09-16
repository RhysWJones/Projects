/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Flight;
import database.Plane;
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
public class FlightHandlerTest {
    
    public FlightHandlerTest() {
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
     * Test of findAllFlights method, of class FlightHandler.
     */
//    @Test
//    public void testFindAllFlights() {
//        System.out.println("findAllFlights");
//        FlightHandler instance1 = new FlightHandler();
//        FlightHandler instance2 = new FlightHandler();
//        ArrayList<Flight> expResult = instance2.findAllFlights();
//        ArrayList<Flight> result = instance1.findAllFlights();
//        assertEquals(expResult, result);
//        
//    }

    /**
     * Test of addNewFlight method, of class FlightHandler.
     */
    @Test
    public void testAddNewFlight() {
        System.out.println("addNewFlight");
        int planeID = 11;
        String Destination = "test1";
        String Origin = "test2";
        Date departureDate = null;
        Time departureTime = null;
        Date arrivalDate = null;
        Time arrivalTime = null;
        Plane plane = new Plane();
        Flight flight = new Flight(1, 2, Destination, Origin, departureDate, departureTime, arrivalDate, arrivalTime, plane);
        FlightHandler instance = new FlightHandler();        
        boolean result = instance.addNewFlight(flight);
        assertTrue(result);         
    }

    /**
     * Test of addNewPlane method, of class FlightHandler.
     */
    @Test
    public void testAddNewPlane() {
        System.out.println("addNewPlane");
        String designation = "test1";
        int capacity = 0;
        int planeID = 2;
        String airline = "test2";
        String equipment = "test3";
        Plane plane = new Plane(planeID, designation, capacity, airline, equipment);
        FlightHandler instance = new FlightHandler();        
        boolean result = instance.addNewPlane(plane);
        assertTrue(result);         
    }

    /**
     * Test of addNewSeat method, of class FlightHandler.
     */
    @Test
    public void testAddNewSeat() {
        System.out.println("addNewSeat");
        int flightID = 1;
        int seatNumber = 4;
        boolean seatTaken = true;
        FlightHandler instance = new FlightHandler();        
        boolean result = instance.addNewSeat(flightID, seatNumber, seatTaken);
        assertTrue(result);        
    }
    
}