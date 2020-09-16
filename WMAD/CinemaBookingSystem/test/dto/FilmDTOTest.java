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
public class FilmDTOTest
{
    private FilmDTO film1;
    public FilmDTOTest()
    {
        film1 = new FilmDTO(0, "title", 18, 120, "description");
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
     * Test of getFilmID method, of class FilmDTO.
     */
    @Test
    public void testGetFilmID()
    {
        System.out.println("getFilmID");
        FilmDTO instance = film1;
        int expResult = 0;
        int result = instance.getFilmID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTitle method, of class FilmDTO.
     */
    @Test
    public void testGetTitle()
    {
        System.out.println("getTitle");
        FilmDTO instance = film1;
        String expResult = "title";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAgeRating method, of class FilmDTO.
     */
    @Test
    public void testGetAgeRating()
    {
        System.out.println("getAgeRating");
        FilmDTO instance = film1;
        int expResult = 18;
        int result = instance.getAgeRating();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRuntime method, of class FilmDTO.
     */
    @Test
    public void testGetRuntime()
    {
        System.out.println("getRuntime");
        FilmDTO instance = film1;
        int expResult = 120;
        int result = instance.getRuntime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class FilmDTO.
     */
    @Test
    public void testGetDescription()
    {
        System.out.println("getDescription");
        FilmDTO instance = film1;
        String expResult = "description";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }
    
}
