/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
public class PassengerRisk_ByFlightTest {
    
    public PassengerRisk_ByFlightTest() {
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
     * Test of getRisk method, of class PassengerRisk_ByFlight.
     */
    @Test
    public void testGetRisk() {
        System.out.println("getRisk");
        PassengerRisk_ByFlight instance = new PassengerRisk_ByFlight();
        Risk expResult = new Risk(2,"test",2);
        instance.addRisk(expResult);
        ArrayList<Risk> risks = instance.getRisk();
        Risk result = risks.get(0);
        assertEquals(expResult, result);       
    }

    /**
     * Test of addRisk method, of class PassengerRisk_ByFlight.
     */
    @Test
    public void testAddRisk() {
        System.out.println("addRisk");
        PassengerRisk_ByFlight instance = new PassengerRisk_ByFlight();
        Risk expResult = new Risk(2,"test",2);
        instance.addRisk(expResult);
        ArrayList<Risk> risks = instance.getRisk();
        Risk result = risks.get(0);
        assertEquals(expResult, result);        
    }

    /**
     * Test of getPassengerID method, of class PassengerRisk_ByFlight.
     */
    @Test
    public void testGetPassengerID() {
        System.out.println("getPassengerID");
         PassengerRisk_ByFlight instance = new PassengerRisk_ByFlight(5, 5);
        int expResult = 5;
        int result = instance.getPassengerID();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setPassengerID method, of class PassengerRisk_ByFlight.
     */
    @Test
    public void testSetPassengerID() {
        System.out.println("setPassengerID");
        PassengerRisk_ByFlight instance = new PassengerRisk_ByFlight();
        int expResult = 5;
        instance.setPassengerID(expResult);
        int result = instance.getPassengerID();
        assertEquals(expResult, result); 
        
    }

    /**
     * Test of getFlightID method, of class PassengerRisk_ByFlight.
     */
    @Test
    public void testGetFlightID() {
        System.out.println("getFlightID");
         PassengerRisk_ByFlight instance = new PassengerRisk_ByFlight(5, 5);
        int expResult = 5;
        int result = instance.getFlightID();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setFlightID method, of class PassengerRisk_ByFlight.
     */
    @Test
    public void testSetFlightID() {
        System.out.println("setFlightID");
        PassengerRisk_ByFlight instance = new PassengerRisk_ByFlight();
        int expResult = 5;
        instance.setFlightID(expResult);
        int result = instance.getFlightID();
        assertEquals(expResult, result);        
    }
    
}
