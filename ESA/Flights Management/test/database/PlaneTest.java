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
public class PlaneTest {
    
    public PlaneTest() {
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
     * Test of getPlaneID method, of class Plane.
     */
    @Test
    public void testGetPlaneID() {
        System.out.println("getPlaneID");
        Plane instance = new Plane();
        int expResult = 1;
        instance.setPlaneID(expResult);
        int result = instance.getPlaneID();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setPlaneID method, of class Plane.
     */
    @Test
    public void testSetPlaneID() {
        System.out.println("setPlaneID");
        Plane instance = new Plane();
        int expResult = 1;
        instance.setPlaneID(expResult);
        int result = instance.getPlaneID();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getFlight method, of class Plane.
     */
    @Test
    public void testGetFlight() {
        System.out.println("getFlight");
        Plane instance = new Plane();
        Date date = Date.valueOf("2018-03-03");
        Time time = Time.valueOf("20:20:00");
        Flight expResult = new Flight(1,1,"test1","test2",date,time,date,time,instance);        
        instance.setFlight(expResult);
        Flight result = instance.getFlight();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setFlight method, of class Plane.
     */
    @Test
    public void testSetFlight() {
        System.out.println("setFlight");
        Plane instance = new Plane();
        Date date = Date.valueOf("2018-03-03");
        Time time = Time.valueOf("20:20:00");
        Flight expResult = new Flight(1,1,"test1","test2",date,time,date,time,instance);        
        instance.setFlight(expResult);
        Flight result = instance.getFlight();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getCapacity method, of class Plane.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        Plane instance = new Plane();
        int expResult = 100;
        instance.setCapacity(expResult);
        int result = instance.getCapacity();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setCapacity method, of class Plane.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("setCapacity");
        Plane instance = new Plane();
        int expResult = 100;
        instance.setCapacity(expResult);
        int result = instance.getCapacity();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getDesignation method, of class Plane.
     */
    @Test
    public void testGetDesignation() {
        System.out.println("getDesignation");
        Plane instance = new Plane();
        String expResult = "test1";
        instance.setDesignation(expResult);
        String result = instance.getDesignation();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setDesignation method, of class Plane.
     */
    @Test
    public void testSetDesignation() {
        System.out.println("setDesignation");
        Plane instance = new Plane();
        String expResult = "test1";
        instance.setDesignation(expResult);
        String result = instance.getDesignation();
        assertEquals(expResult, result);       
    }

    /**
     * Test of getAirline method, of class Plane.
     */
    @Test
    public void testGetAirline() {
        System.out.println("getAirline");
        Plane instance = new Plane();
        String expResult = "test1";
        instance.setAirline(expResult);
        String result = instance.getAirline();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setAirline method, of class Plane.
     */
    @Test
    public void testSetAirline() {
        System.out.println("setAirline");
        Plane instance = new Plane();
        String expResult = "test1";
        instance.setAirline(expResult);
        String result = instance.getAirline();
        assertEquals(expResult, result); 
        
    }

    /**
     * Test of getEquipment method, of class Plane.
     */
    @Test
    public void testGetEquipment() {
        System.out.println("getEquipment");
        Plane instance = new Plane();
        String expResult = "test1";
        instance.setEquipment(expResult);
        String result = instance.getEquipment();
        assertEquals(expResult, result);         
    }

    /**
     * Test of setEquipment method, of class Plane.
     */
    @Test
    public void testSetEquipment() {
        System.out.println("setEquipment");
        Plane instance = new Plane();
        String expResult = "test1";
        instance.setEquipment(expResult);
        String result = instance.getEquipment();
        assertEquals(expResult, result);         
    }
    
}
