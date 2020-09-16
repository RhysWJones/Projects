/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

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
public class CinemaDTOTest
{
    private CinemaDTO cinema1;
    public CinemaDTOTest()
    {
        cinema1 = new CinemaDTO(0, "Cineworld");
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
     * Test of getCinemaID method, of class CinemaDTO.
     */
    @Test
    public void testGetCinemaID()
    {
        System.out.println("getCinemaID");
        CinemaDTO instance = cinema1;
        int expResult = 0;
        int result = instance.getCinemaID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class CinemaDTO.
     */
    @Test
    public void testGetName()
    {
        System.out.println("getName");
        CinemaDTO instance = cinema1;
        String expResult = "Cineworld";
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
}
