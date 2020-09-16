package dto;

import java.util.Date;
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
public class UserDTOTest
{

    private UserDTO user1;
    private UserDTO user2;

    public UserDTOTest()
    {
        Date DOB = new Date(1994 - 1900, 6, 24);
        user1 = new UserDTO(0, "John", "Smith", "24:07:1994", "20 Dewbury Lane", "Staffordshire", "ST17 2ES", "Johnno101", "Pass", true);
        user2 = new UserDTO(0, "John", "Smith", DOB, "20 Dewbury Lane", "Staffordshire", "ST17 2ES", "Johnno101", "Pass", true);
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
     * Test of getUserID method, of class UserDTO.
     */
    @Test
    public void testGetUserID()
    {
        System.out.println("getUserID");
        UserDTO instance = user1;
        UserDTO instance2 = user2;
        int expResult = 0;
        int result = instance.getUserID();
        assertEquals(expResult, result);
        result = instance2.getUserID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getForename method, of class UserDTO.
     */
    @Test
    public void testGetForename()
    {
        System.out.println("getForename");
        UserDTO instance = user1;
        UserDTO instance2 = user2;
        String expResult = "John";
        String result = instance.getForename();
        assertEquals(expResult, result);
        result = instance2.getForename();
        assertEquals(expResult, result);

    }

    /**
     * Test of getSurname method, of class UserDTO.
     */
    @Test
    public void testGetSurname()
    {
        System.out.println("getSurname");
        UserDTO instance = user1;
        UserDTO instance2 = user2;
        String expResult = "Smith";
        String result = instance.getSurname();
        assertEquals(expResult, result);
        result = instance2.getSurname();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDOB method, of class UserDTO.
     */
    @Test
    public void testGetDOB()
    {
        System.out.println("getDOB");
        UserDTO instance = user1;
        UserDTO instance2 = user2;
        Date d = new Date(1994 - 1900, 6, 24);
        Date expResult = d;
        Date result = instance.getDOB();
        assertEquals(expResult, result);
        result = instance2.getDOB();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAddressLine1 method, of class UserDTO.
     */
    @Test
    public void testGetAddressLine1()
    {
        System.out.println("getAddressLine1");
        UserDTO instance = user1;
        UserDTO instance2 = user2;
        String expResult = "20 Dewbury Lane";
        String result = instance.getAddressLine1();
        assertEquals(expResult, result);
        result = instance2.getAddressLine1();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAddressLine2 method, of class UserDTO.
     */
    @Test
    public void testGetAddressLine2()
    {
        System.out.println("getAddressLine2");
        UserDTO instance = user1;
        UserDTO instance2 = user2;
        String expResult = "Staffordshire";
        String result = instance.getAddressLine2();
        assertEquals(expResult, result);
        result = instance2.getAddressLine2();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostcode method, of class UserDTO.
     */
    @Test
    public void testGetPostcode()
    {
        System.out.println("getPostcode");
        UserDTO instance = user1;
        UserDTO instance2 = user2;
        String expResult = "ST17 2ES";
        String result = instance.getPostcode();
        assertEquals(expResult, result);
        result = instance2.getPostcode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class UserDTO.
     */
    @Test
    public void testGetUsername()
    {
        System.out.println("getUsername");
        UserDTO instance = user1;
        UserDTO instance2 = user2;
        String expResult = "Johnno101";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        result = instance2.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class UserDTO.
     */
    @Test
    public void testGetPassword()
    {
        System.out.println("getPassword");
        UserDTO instance = user1;
        UserDTO instance2 = user2;
        String expResult = "Pass";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        result = instance2.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of isIsAdmin method, of class UserDTO.
     */
    @Test
    public void testIsIsAdmin()
    {
        System.out.println("isIsAdmin");
        UserDTO instance = user1;
        UserDTO instance2 = user2;
        boolean expResult = true;
        boolean result = instance.isIsAdmin();
        assertEquals(expResult, result);
        result = instance2.isIsAdmin();
        assertEquals(expResult, result);
    }

}
