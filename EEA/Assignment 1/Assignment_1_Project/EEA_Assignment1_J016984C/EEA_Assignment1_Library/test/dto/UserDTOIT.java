/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Rhys
 */
public class UserDTOIT
{
    private UserDTO userDTOInstance = new UserDTO();
    public UserDTOIT()
    {
        RouteDTO routeDTOInstance = new RouteDTO();
        DepotDTO depotDTOInstance = new DepotDTO();
        DeliveryDTO deliveryDTOInstance = new DeliveryDTO();
        
        //Initialise Lists
        ArrayList<DeliveryDTO> deliveryList = new ArrayList<DeliveryDTO>();
        deliveryList.add(deliveryDTOInstance);
        
        ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
        userList.add(userDTOInstance);
        
        //Create RouteDTO
        routeDTOInstance.setRouteId(1);
        routeDTOInstance.setName("Test Route");
        routeDTOInstance.setDeliveries(deliveryList);
        routeDTOInstance.setDepot(depotDTOInstance);
        routeDTOInstance.setUsers(userList);
        
        //Create UserDTO
        userDTOInstance.setId(1);
        userDTOInstance.setForename("Test");
        userDTOInstance.setSurname("User");
        userDTOInstance.setEmail("Test Email");
        userDTOInstance.setPassword("Test Password");
        userDTOInstance.setAddressLine1("Test Address 1");
        userDTOInstance.setAddressLine2("Test Address 2");
        userDTOInstance.setCity("Test City");
        userDTOInstance.setPostcode("Test Postcode");
        userDTOInstance.setTelephone("Test Telephone");
        userDTOInstance.setDateOfBirth(new Date());
        userDTOInstance.setIsDriver(true);
        userDTOInstance.setDriverId(1);
        userDTOInstance.setRouteId(routeDTOInstance);
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
     * Test of getId method, of class UserDTO.
     */
    @Test
    public void testGetId()
    {
        System.out.println("getId");
        int expResult = 1;
        int result = userDTOInstance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class UserDTO.
     */
    @Test
    public void testSetId()
    {
        System.out.println("setId");
        int id = 2;
        UserDTO instance = new UserDTO();
        instance.setId(id);
        assertEquals(instance.getId(), id);
    }

    /**
     * Test of getForename method, of class UserDTO.
     */
    @Test
    public void testGetForename()
    {
        System.out.println("getForename");
        String expResult = "Test";
        String result = userDTOInstance.getForename();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setForename method, of class UserDTO.
     */
    @Test
    public void testSetForename()
    {
        System.out.println("setForename");
        String forename = "John";
        UserDTO instance = new UserDTO();
        instance.setForename(forename);
        assertTrue(instance.getForename().equals(forename));
    }

    /**
     * Test of getSurname method, of class UserDTO.
     */
    @Test
    public void testGetSurname()
    {
        System.out.println("getSurname");
        String expResult = "User";
        String result = userDTOInstance.getSurname();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setSurname method, of class UserDTO.
     */
    @Test
    public void testSetSurname()
    {
        System.out.println("setSurname");
        String surname = "Doe";
        UserDTO instance = new UserDTO();
        instance.setSurname(surname);
        assertTrue(instance.getSurname().equals(surname));
    }

    /**
     * Test of getDateOfBirth method, of class UserDTO.
     */
    @Test
    public void testGetDateOfBirth()
    {
        System.out.println("getDateOfBirth");
        Date expResult = new Date();
        Date result = userDTOInstance.getDateOfBirth();
        int compare = result.compareTo(expResult);
        assertTrue(expResult.getDate() == result.getDate());
        assertTrue(expResult.getMonth()== result.getMonth());
        assertTrue(expResult.getYear() == result.getYear());
    }

    /**
     * Test of setDateOfBirth method, of class UserDTO.
     */
    @Test
    public void testSetDateOfBirth()
    {
        System.out.println("setDateOfBirth");
        Date dateOfBirth = new Date();
        UserDTO instance = new UserDTO();
        instance.setDateOfBirth(dateOfBirth);
        assertTrue(instance.getDateOfBirth().compareTo(dateOfBirth) == 0);
    }

    /**
     * Test of getAddressLine1 method, of class UserDTO.
     */
    @Test
    public void testGetAddressLine1()
    {
        System.out.println("getAddressLine1");
        String expResult = "Test Address 1";
        String result = userDTOInstance.getAddressLine1();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setAddressLine1 method, of class UserDTO.
     */
    @Test
    public void testSetAddressLine1()
    {
        System.out.println("setAddressLine1");
        String addressLine1 = "Set Test";
        UserDTO instance = new UserDTO();
        instance.setAddressLine1(addressLine1);
        assertTrue(instance.getAddressLine1().equals(addressLine1));
    }

    /**
     * Test of getAddressLine2 method, of class UserDTO.
     */
    @Test
    public void testGetAddressLine2()
    {
        System.out.println("getAddressLine2");
        String expResult = "Test Address 2";
        String result = userDTOInstance.getAddressLine2();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setAddressLine2 method, of class UserDTO.
     */
    @Test
    public void testSetAddressLine2()
    {
        System.out.println("setAddressLine2");
        String addressLine2 = "Set Test";
        UserDTO instance = new UserDTO();
        instance.setAddressLine2(addressLine2);
        assertTrue(instance.getAddressLine2().equals(addressLine2));
    }

    /**
     * Test of getPostcode method, of class UserDTO.
     */
    @Test
    public void testGetPostcode()
    {
        System.out.println("getPostcode");
        String expResult = "Test Postcode";
        String result = userDTOInstance.getPostcode();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setPostcode method, of class UserDTO.
     */
    @Test
    public void testSetPostcode()
    {
        System.out.println("setPostcode");
        String postcode = "Set Test";
        UserDTO instance = new UserDTO();
        instance.setPostcode(postcode);
        assertTrue(instance.getPostcode().equals(postcode));
    }

    /**
     * Test of getCity method, of class UserDTO.
     */
    @Test
    public void testGetCity()
    {
        System.out.println("getCity");
        String expResult = "Test City";
        String result = userDTOInstance.getCity();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setCity method, of class UserDTO.
     */
    @Test
    public void testSetCity()
    {
        System.out.println("setCity");
        String city = "Set Test";
        UserDTO instance = new UserDTO();
        instance.setCity(city);
        assertTrue(instance.getCity().equals(city));
    }

    /**
     * Test of getTelephone method, of class UserDTO.
     */
    @Test
    public void testGetTelephone()
    {
        System.out.println("getTelephone");
        String expResult = "Test Telephone";
        String result = userDTOInstance.getTelephone();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setTelephone method, of class UserDTO.
     */
    @Test
    public void testSetTelephone()
    {
        System.out.println("setTelephone");
        String telephone = "Set Test";
        UserDTO instance = new UserDTO();
        instance.setTelephone(telephone);
        assertTrue(instance.getTelephone().equals(telephone));
    }

    /**
     * Test of getEmail method, of class UserDTO.
     */
    @Test
    public void testGetEmail()
    {
        System.out.println("getEmail");
        String expResult = "Test Email";
        String result = userDTOInstance.getEmail();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setEmail method, of class UserDTO.
     */
    @Test
    public void testSetEmail()
    {
        System.out.println("setEmail");
        String email = "Set Test";
        UserDTO instance = new UserDTO();
        instance.setEmail(email);
        assertTrue(instance.getEmail().equals(email));
    }

    /**
     * Test of getPassword method, of class UserDTO.
     */
    @Test
    public void testGetPassword()
    {
        System.out.println("getPassword");
        String expResult = "Test Password";
        String result = userDTOInstance.getPassword();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setPassword method, of class UserDTO.
     */
    @Test
    public void testSetPassword()
    {
        System.out.println("setPassword");
        String password = "Set Test";
        UserDTO instance = new UserDTO();
        instance.setPassword(password);
        assertTrue(instance.getPassword().equals(password));
    }

    /**
     * Test of isIsDriver method, of class UserDTO.
     */
    @Test
    public void testIsIsDriver()
    {
        System.out.println("isIsDriver");
        boolean expResult = true;
        boolean result = userDTOInstance.isIsDriver();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsDriver method, of class UserDTO.
     */
    @Test
    public void testSetIsDriver()
    {
        System.out.println("setIsDriver");
        boolean isDriver = false;
        UserDTO instance = new UserDTO();
        instance.setIsDriver(isDriver);
        assertEquals(instance.isIsDriver(), false);
    }

    /**
     * Test of getDriverId method, of class UserDTO.
     */
    @Test
    public void testGetDriverId()
    {
        System.out.println("getDriverId");
        int expResult = 1;
        int result = userDTOInstance.getDriverId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDriverId method, of class UserDTO.
     */
    @Test
    public void testSetDriverId()
    {
        System.out.println("setDriverId");
        int driverId = 2;
        UserDTO instance = new UserDTO();
        instance.setDriverId(driverId);
        assertEquals(instance.getDriverId(), driverId);
    }

    /**
     * Test of getRouteId method, of class UserDTO.
     */
    @Test
    public void testGetRouteId()
    {
        System.out.println("getRouteId");
        int expResultId = 1;
        int resultId = userDTOInstance.getRouteId().getRouteId();
        assertEquals(expResultId, resultId);
        String expResultName = "Test Route";
        String resultName = userDTOInstance.getRouteId().getName();
        assertTrue(resultName.equals(expResultName));
        assertTrue(userDTOInstance.getRouteId().getDeliveries() != null);
        assertTrue(userDTOInstance.getRouteId().getDepot()!= null);
        assertTrue(userDTOInstance.getRouteId().getUsers()!= null);
    }

    /**
     * Test of setRouteId method, of class UserDTO.
     */
    @Test
    public void testSetRouteId()
    {
        System.out.println("setRouteId");
        RouteDTO routeId = new RouteDTO();
        UserDTO instance = new UserDTO();
        instance.setRouteId(routeId);
        assertTrue(instance.getRouteId() != null);
    }
    
}
