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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Rhysj
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
    vehicleshowroomproj.VehicleTest.class, vehicleshowroomproj.VehicleFileReaderTest.class, vehicleshowroomproj.VehicleShowroomProjTest.class, vehicleshowroomproj.VehicleFileWriterTest.class, vehicleshowroomproj.ShowroomTest.class
})
public class VehicleshowroomprojSuite
{

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }
    
}
