/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicleshowroomproj;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhysj
 */
public class ShowroomTest
{
    
    public ShowroomTest()
    {
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
     * Test of setCurrentVehicle method, of class Showroom.
     */
    @Test
    public void testSetCurrentVehicle()
    {
        System.out.println("setCurrentVehicle");
        Vehicle vehicle = null;
        Showroom instance = new Showroom();
        instance.setCurrentVehicle(vehicle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentVehicle method, of class Showroom.
     */
    @Test
    public void testGetCurrentVehicle()
    {
        System.out.println("getCurrentVehicle");
        Showroom instance = new Showroom();
        Vehicle expResult = null;
        Vehicle result = instance.getCurrentVehicle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextVehicle method, of class Showroom.
     */
    @Test
    public void testNextVehicle()
    {
        System.out.println("nextVehicle");
        Showroom instance = new Showroom();
        Boolean expResult = null;
        Boolean result = instance.nextVehicle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of previousVehicle method, of class Showroom.
     */
    @Test
    public void testPreviousVehicle()
    {
        System.out.println("previousVehicle");
        Showroom instance = new Showroom();
        Boolean expResult = null;
        Boolean result = instance.previousVehicle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addVehicle method, of class Showroom.
     */
    @Test
    public void testAddVehicle()
    {
        System.out.println("addVehicle");
        Vehicle vehicle = null;
        Showroom instance = new Showroom();
        boolean expResult = false;
        boolean result = instance.addVehicle(vehicle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findVehicleByVin method, of class Showroom.
     */
    @Test
    public void testFindVehicleByVin()
    {
        System.out.println("findVehicleByVin");
        String vin = "";
        Showroom instance = new Showroom();
        String expResult = "";
        String result = instance.findVehicleByVin(vin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printArray method, of class Showroom.
     */
    @Test
    public void testPrintArray()
    {
        System.out.println("printArray");
        Showroom instance = new Showroom();
        instance.printArray();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
