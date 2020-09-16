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
public class PersonTest
{
    Person p1;
    Person p2;
    public PersonTest()
    {
        p1 = new Person("John", "Mayer");
        p2 = new Person("Adam", "Ant");
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
     * Test of getFirstName method, of class Person.
     */
    @Test
    public void testGetFirstName()
    {
        System.out.println("getFirstName");
        Person instance = p1;
        String expResult = "John";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class Person.
     */
    @Test
    public void testSetFirstName()
    {
        System.out.println("setFirstName");
        String firstName = "John";
        Person instance = p1;
        instance.setFirstName(firstName);
    }

    /**
     * Test of getLastName method, of class Person.
     */
    @Test
    public void testGetLastName()
    {
        System.out.println("getLastName");
        Person instance = p1;
        String expResult = "Mayer";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLastName method, of class Person.
     */
    @Test
    public void testSetLastName()
    {
        System.out.println("setLastName");
        String lastName = "Mayer";
        Person instance = p1;
        instance.setLastName(lastName);
    }

    /**
     * Test of toString method, of class Person.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        Person instance = p1;
        String expResult = "John Mayer";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCompareTo()
    {
        assertEquals(1, p1.compareTo(p2));
        assertEquals(-1, p2.compareTo(p1));
        assertEquals(0, p1.compareTo(p1));
    }
    
}
