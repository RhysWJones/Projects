/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Rhys
 */
public class DeliveryDTOIT
{
    private DeliveryDTO deliveryDTOInstance = new DeliveryDTO();
    public DeliveryDTOIT()
    {
        //Initialise DTO's
        DeliveryStatusDTO deliveryStatusDTOInstance = new DeliveryStatusDTO();
        DepotDTO depotDTOInstance = new DepotDTO();
        RouteDTO routeDTOInstance = new RouteDTO();
        UserDTO userDTOInstance = new UserDTO();
        ParcelDTO parcelDTOInstance = new ParcelDTO();
        
        //Initialise Lists
        ArrayList<DeliveryDTO> deliveryList = new ArrayList<DeliveryDTO>();
        deliveryList.add(deliveryDTOInstance);
        
        ArrayList<RouteDTO> routeList = new ArrayList<RouteDTO>();
        routeList.add(routeDTOInstance);
        
        ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
        userList.add(userDTOInstance);
        
        //Create ParcelDTO
        parcelDTOInstance.setParcelId(1);
        parcelDTOInstance.setRecipientName("Test Recipient");
        parcelDTOInstance.setAddressLine1("Test Address 1");
        parcelDTOInstance.setAddressLine2("Test Address 2");
        parcelDTOInstance.setCity("Test City");
        parcelDTOInstance.setPostcode("Test Postcode");
        parcelDTOInstance.setDelivered(false);
        parcelDTOInstance.setDelivery(deliveryDTOInstance);
        
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
        
        //Create DeliveryStatusDTO
        deliveryStatusDTOInstance.setDeliveryStatusId(1);
        deliveryStatusDTOInstance.setName("Test Status");
        
        //Create DepotDTO
        depotDTOInstance.setDepotId(1);
        depotDTOInstance.setName("Test Depot");
        depotDTOInstance.setDepotDeliveries(deliveryList);
        depotDTOInstance.setDepotRoutes(routeList);
        
        //Create RouteDTO
        routeDTOInstance.setRouteId(1);
        routeDTOInstance.setName("Test Route");
        routeDTOInstance.setDeliveries(deliveryList);
        routeDTOInstance.setDepot(depotDTOInstance);
        routeDTOInstance.setUsers(userList);
        
        //Create DeliveryDTO
        deliveryDTOInstance.setDeliveryId(1);
        deliveryDTOInstance.setDeliveryDate(new Date());
        deliveryDTOInstance.setDeliveryStatus(deliveryStatusDTOInstance);
        deliveryDTOInstance.setDepot(depotDTOInstance);
        deliveryDTOInstance.setParcel(parcelDTOInstance);
        deliveryDTOInstance.setRoute(routeDTOInstance);
    }
    
    @BeforeAll
    public static void setUpClass()
    {
    }
    
    @AfterAll
    public static void tearDownClass()
    {
    }
    
    @BeforeEach
    public void setUp()
    {
    }
    
    @AfterEach
    public void tearDown()
    {
    }

    /**
     * Test of getDeliveryId method, of class DeliveryDTO.
     */
    @Test
    public void testGetDeliveryId()
    {
        System.out.println("Test getDeliveryId");
        int expResult = 1;
        int result = deliveryDTOInstance.getDeliveryId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDeliveryId method, of class DeliveryDTO.
     */
    @Test
    public void testSetDeliveryId()
    {
        System.out.println("setDeliveryId");
        int deliveryId = 2;
        deliveryDTOInstance.setDeliveryId(deliveryId);
    }

    /**
     * Test of getDeliveryDate method, of class DeliveryDTO.
     */
    @Test
    public void testGetDeliveryDate()
    {
        System.out.println("getDeliveryDate");
        Date expResult = new Date();
        Date result = deliveryDTOInstance.getDeliveryDate();
        assertTrue(expResult.getDate() == result.getDate());
        assertTrue(expResult.getMonth()== result.getMonth());
        assertTrue(expResult.getYear() == result.getYear());
    }

    /**
     * Test of setDeliveryDate method, of class DeliveryDTO.
     */
    @Test
    public void testSetDeliveryDate()
    {
        System.out.println("setDeliveryDate");
        Date deliveryDate = new Date();
        deliveryDTOInstance.setDeliveryDate(deliveryDate);
        assertSame(deliveryDate, deliveryDTOInstance.getDeliveryDate());
    }

    /**
     * Test of getDeliveryStatus method, of class DeliveryDTO.
     */
    @Test
    public void testGetDeliveryStatus()
    {
        System.out.println("getDeliveryStatus");
        int expResultId = 1;
        int resultId = deliveryDTOInstance.getDeliveryStatus().getDeliveryStatusId();
        assertEquals(expResultId, resultId);
        String expResultName = "Test Status";
        String resultName = deliveryDTOInstance.getDeliveryStatus().getName();
        assertTrue(expResultName.equals(resultName));
    }

    /**
     * Test of setDeliveryStatus method, of class DeliveryDTO.
     */
    @Test
    public void testSetDeliveryStatus()
    {
        System.out.println("setDeliveryStatus");
        DeliveryStatusDTO deliveryStatus = new DeliveryStatusDTO();
        deliveryDTOInstance.setDeliveryStatus(deliveryStatus);
        assertSame(deliveryDTOInstance.getDeliveryStatus(), deliveryStatus);
    }

    /**
     * Test of getDepot method, of class DeliveryDTO.
     */
    @Test
    public void testGetDepot()
    {
        System.out.println("getDepot");
        int expResultId = 1;
        int resultId = deliveryDTOInstance.getDepot().getDepotId();
        assertEquals(expResultId, resultId);
        String expResultName = "Test Depot";
        String resultName = deliveryDTOInstance.getDepot().getName();
        assertTrue(resultName.equals(expResultName));
        assertTrue(deliveryDTOInstance.getDepot().getDepotDeliveries() != null);
        assertTrue(deliveryDTOInstance.getDepot().getDepotRoutes() != null);
    }

    /**
     * Test of setDepot method, of class DeliveryDTO.
     */
    @Test
    public void testSetDepot()
    {
        System.out.println("setDepot");
        DepotDTO depot = new DepotDTO();
        deliveryDTOInstance.setDepot(depot);
        assertTrue(deliveryDTOInstance.getDepot() != null);
    }

    /**
     * Test of getParcel method, of class DeliveryDTO.
     */
    @Test
    public void testGetParcel()
    {
        System.out.println("getParcel");
        int expResultId = 1;
        int resultId = deliveryDTOInstance.getParcel().getParcelId();
        assertEquals(expResultId, resultId);
        String expResultName = "Test Recipient";
        String resultName = deliveryDTOInstance.getParcel().getRecipientName();
        assertTrue(resultName.equals(expResultName));
        String expResultAddress1 = "Test Address 1";
        String resultAddress1 = deliveryDTOInstance.getParcel().getAddressLine1();
        assertTrue(resultAddress1.equals(expResultAddress1));
        String expResultAddress2 = "Test Address 2";
        String resultAddress2 = deliveryDTOInstance.getParcel().getAddressLine2();
        assertTrue(resultAddress2.equals(expResultAddress2));
        String expResultCity = "Test City";
        String resultCity = deliveryDTOInstance.getParcel().getCity();
        assertTrue(resultCity.equals(expResultCity));
        String expResultPostcode = "Test Postcode";
        String resultPostcode = deliveryDTOInstance.getParcel().getPostcode();
        assertTrue(resultPostcode.equals(expResultPostcode));
        assertTrue(deliveryDTOInstance.getParcel().getDelivery() != null);
    }

    /**
     * Test of setParcel method, of class DeliveryDTO.
     */
    @Test
    public void testSetParcel()
    {
        System.out.println("setParcel");
        ParcelDTO parcel = new ParcelDTO();
        deliveryDTOInstance.setParcel(parcel);
        assertTrue(deliveryDTOInstance.getParcel() != null);
    }

    /**
     * Test of getRoute method, of class DeliveryDTO.
     */
    @Test
    public void testGetRoute()
    {
        System.out.println("getRoute");
        int expResultId = 1;
        int resultId = deliveryDTOInstance.getRoute().getRouteId();
        assertEquals(resultId, expResultId);
        String expResultName = "Test Route";
        String resultName = deliveryDTOInstance.getRoute().getName();
        assertTrue(resultName.equals(expResultName));
        assertTrue(deliveryDTOInstance.getRoute().getDeliveries() != null);
        assertTrue(deliveryDTOInstance.getRoute().getDepot()!= null);
        assertTrue(deliveryDTOInstance.getRoute().getUsers()!= null);
    }

    /**
     * Test of setRoute method, of class DeliveryDTO.
     */
    @Test
    public void testSetRoute()
    {
        System.out.println("setRoute");
        RouteDTO route = new RouteDTO();
        deliveryDTOInstance.setRoute(route);
        assertTrue(deliveryDTOInstance.getRoute() != null);
    }
    
}
