/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junitproj;

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
public class DVDTest
{
    DVD film;
    Person p1;
    
    public DVDTest()
    {
        p1 = new Person("Christian", "Bale");
        film = new DVD("The Dark Knight", p1, 228);
    }

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

    /**
     * Test of getTitle method, of class DVD.
     */
    @Test
    public void testGetTitle()
    {
        System.out.println("getTitle");
        DVD instance = film;
        String expResult = "The Dark Knight";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class DVD.
     */
    @Test
    public void testSetTitle()
    {
        System.out.println("setTitle");
        String title = "The Dark Knight";
        DVD instance = film;
        instance.setTitle(title);
    }

    /**
     * Test of getLeadActor method, of class DVD.
     */
    @Test
    public void testGetLeadActor()
    {
        System.out.println("getLeadActor");
        DVD instance = film;
        Person expResult = p1;
        Person result = instance.getLeadActor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLeadActor method, of class DVD.
     */
    @Test
    public void testSetLeadActor()
    {
        System.out.println("setLeadActor");
        Person leadActor = p1;
        DVD instance = film;
        instance.setLeadActor(leadActor);
    }

    /**
     * Test of getNoOfStars method, of class DVD.
     */
    @Test
    public void testGetNoOfStars()
    {
        System.out.println("getNoOfStars");
        DVD instance = film;
        int expResult = 228;
        int result = instance.getNoOfStars();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNoOfStars method, of class DVD.
     */
    @Test
    public void testSetNoOfStars()
    {
        System.out.println("setNoOfStars");
        int noOfStars = 228;
        DVD instance = film;
        instance.setNoOfStars(noOfStars);
    }

    /**
     * Test of toString method, of class DVD.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        DVD instance = film;
        String expResult = "Title: The Dark Knight"
                + "\nLead Actor: Christian Bale"
                + "\nNumber of stars: 228";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
