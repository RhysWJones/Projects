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
public class VehicleFileReaderTest
{

    public VehicleFileReaderTest()
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
     * Test of createVehicleFromFile method, of class VehicleFileReader.
     */
    @Test
    public void testCreateVehicleFromFile()
    {
        System.out.println("createVehicleFromFile");
        ArrayList<Vehicle> vehicles = new ArrayList();
        ArrayList<Vehicle> testVehicles = new ArrayList();
        testVehicles.add(new Vehicle("BMW", "I3", "18g128a", "12/09/2016", 'N', 29570));
        testVehicles.add(new Vehicle("Toyota", "Prius", "74h427d", "05/11/2017", 'N', 24115));
        testVehicles.add(new Vehicle("Audi", "A4-Avant", "26i172j", "17/07/2016", 'E', 28700));
        VehicleFileReader instance = new VehicleFileReader();
        instance.createVehicleFromFile(vehicles);
        for (int i = 0; i < vehicles.size(); i++)
        {
            System.out.println("\nVEHICLE FROM FILE\n==================\n" + vehicles.get(i).toString()
                    + "\n\nTEST VEHICLE SHOULD BE THE SAME\n===============================\n" + testVehicles.get(i).toString());
            assertEquals(vehicles.get(i).toString(), testVehicles.get(i).toString());
        }
    }

}
