package junitproj;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DVDTest
{

    DVD d1, d2, d3;
    Person p1, p2;

    public DVDTest()
    {
        p1 = new Person("Leonardo", "DiCaprio");
        d1 = new DVD("Inception", p1, 5);

        p2 = new Person("Leonardo", "DiCaprio");
        d2 = new DVD("Inception", p2, 5);
        d3 = new DVD("Gone with the Wind", p2, 4);

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
        DVD instance = d1;
        String expResult = "Inception";
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
        String title = "Inception";
        DVD instance = d1;
        instance.setTitle(title);
    }

    /**
     * Test of getLeadActor method, of class DVD.
     */
    @Test
    public void testGetLeadActor()
    {
        System.out.println("getLeadActor");
        DVD instance = d1;
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
        DVD instance = d1;
        instance.setLeadActor(leadActor);
    }

    /**
     * Test of getNoOfStars method, of class DVD.
     */
    @Test
    public void testGetNoOfStars()
    {
        System.out.println("getNoOfStars");
        DVD instance = d1;
        int expResult = 5;
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
        int noOfStars = 5;
        DVD instance = d1;
        instance.setNoOfStars(noOfStars);
    }

    /**
     * Test of toString method, of class DVD.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
        DVD instance = d1;
        String expResult = "Title: Inception"
                + "\nLead Actor: Leonardo DiCaprio"
                + "\nNumber of stars: 5";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals()
    {
        assertEquals(d2, d1);
        assertNotSame(d2, d1);
        assertEquals(d1, d1);
        assertSame(d1, d1);
        assertFalse(d3.equals(d1));
    }

    @Test
    public void testHashCode()
    {
        assertEquals(d2.hashCode(), d1.hashCode());
        assertEquals(p2.hashCode(), d1.getLeadActor().hashCode());
    }

    @Test
    public void testClone() throws CloneNotSupportedException
    {
        DVD d2 = (DVD)d1.deepClone();
        assertEquals(d2, d1);
        assertNotSame(d2, d1);
        // change the lead actor of the original DVD object
        Person p1 = d1.getLeadActor();
        p1.setFirstName("Clark");
        p1.setLastName("Gable");
        assertFalse(d2.equals(d1));
        assertEquals("Clark Gable", d1.getLeadActor().toString());
        assertEquals("Leonardo DiCaprio", d2.getLeadActor().toString());
    }
    
    @Test
    public void testCompareTo()
    {
        assertEquals(1, d1.compareTo(d3));
        assertEquals(-1, d3.compareTo(d1));
        assertEquals(0, d1.compareTo(d1));
    }

}
