/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicleshowroomproj;

import java.util.ArrayList;
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
public class VehicleShowroomProjTest
{
    
    public VehicleShowroomProjTest()
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
     * Test of main method, of class VehicleShowroomProj.
     */
    @Test
    public void testMain()
    {
        System.out.println("main");
        String[] args = null;
        VehicleShowroomProj.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of populateVehicleArray method, of class VehicleShowroomProj.
     */
    @Test
    public void testPopulateVehicleArray()
    {
        System.out.println("populateVehicleArray");
        ArrayList<Vehicle> vehicles = null;
        VehicleShowroomProj.populateVehicleArray(vehicles);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printVehicles method, of class VehicleShowroomProj.
     */
    @Test
    public void testPrintVehicles()
    {
        System.out.println("printVehicles");
        ArrayList<Vehicle> vehicles = null;
        VehicleShowroomProj.printVehicles(vehicles);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addVehiclesToShowroom method, of class VehicleShowroomProj.
     */
    @Test
    public void testAddVehiclesToShowroom()
    {
        System.out.println("addVehiclesToShowroom");
        ArrayList<Vehicle> vehicles = null;
        Showroom showroom = null;
        VehicleShowroomProj.addVehiclesToShowroom(vehicles, showroom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
