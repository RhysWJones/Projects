/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rhys
 */
public class RouteDTOIT
{
    private RouteDTO routeDTOInstance = new RouteDTO();
    
    public RouteDTOIT()
    {
        DepotDTO depotDTOInstance = new DepotDTO();
        DeliveryDTO deliveryDTOInstance = new DeliveryDTO();
        UserDTO userDTOInstance = new UserDTO();
        
        //Initialise Lists
        ArrayList<DeliveryDTO> deliveryList = new ArrayList<DeliveryDTO>();
        deliveryList.add(deliveryDTOInstance);
        
        ArrayList<RouteDTO> routeList = new ArrayList<RouteDTO>();
        routeList.add(routeDTOInstance);
        
        ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
        userList.add(userDTOInstance);
        
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
     * Test of getRouteId method, of class RouteDTO.
     */
    @Test
    public void testGetRouteId()
    {
        System.out.println("getRouteId");
        int expResult = 1;
        int result = routeDTOInstance.getRouteId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRouteId method, of class RouteDTO.
     */
    @Test
    public void testSetRouteId()
    {
        System.out.println("setRouteId");
        int routeId = 2;
        RouteDTO instance = new RouteDTO();
        instance.setRouteId(routeId);
        assertEquals(instance.getRouteId(), routeId);
    }

    /**
     * Test of getName method, of class RouteDTO.
     */
    @Test
    public void testGetName()
    {
        System.out.println("getName");
        String expResult = "Test Route";
        String result = routeDTOInstance.getName();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setName method, of class RouteDTO.
     */
    @Test
    public void testSetName()
    {
        System.out.println("setName");
        String name = "Set Test";
        RouteDTO instance = new RouteDTO();
        instance.setName(name);
        assertTrue(instance.getName().equals(name));
    }

    /**
     * Test of getDepot method, of class RouteDTO.
     */
    @Test
    public void testGetDepot()
    {
        System.out.println("getDepot");
        DepotDTO result = routeDTOInstance.getDepot();
        int expResultId = result.getDepotId();
        assertEquals(expResultId, 1);
        String expResultName = result.getName();
        assertTrue(expResultName.equals("Test Depot"));
        ArrayList<DeliveryDTO> expResultDeliveries = result.getDepotDeliveries();
        assertTrue(expResultDeliveries != null);
        ArrayList<RouteDTO> expResultRoutes = result.getDepotRoutes();
        assertTrue(expResultRoutes != null);
    }

    /**
     * Test of setDepot method, of class RouteDTO.
     */
    @Test
    public void testSetDepot()
    {
        System.out.println("setDepot");
        DepotDTO depot = new DepotDTO();
        RouteDTO instance = new RouteDTO();
        instance.setDepot(depot);
        assertTrue(instance.getDepot() != null);
    }

    /**
     * Test of getUsers method, of class RouteDTO.
     */
    @Test
    public void testGetUsers()
    {
        System.out.println("getUsers");
        ArrayList<UserDTO> result = routeDTOInstance.getUsers();
        assertTrue(result != null);
    }

    /**
     * Test of setUsers method, of class RouteDTO.
     */
    @Test
    public void testSetUsers()
    {
        System.out.println("setUsers");
        ArrayList<UserDTO> users = new ArrayList<UserDTO>();
        RouteDTO instance = new RouteDTO();
        instance.setUsers(users);
        assertTrue(instance.getUsers() != null);
    }

    /**
     * Test of getDeliveries method, of class RouteDTO.
     */
    @Test
    public void testGetDeliveries()
    {
        System.out.println("getDeliveries");
        ArrayList<DeliveryDTO> result = routeDTOInstance.getDeliveries();
        assertTrue(result != null);
    }

    /**
     * Test of setDeliveries method, of class RouteDTO.
     */
    @Test
    public void testSetDeliveries()
    {
        System.out.println("setDeliveries");
        ArrayList<DeliveryDTO> deliveries = new ArrayList<DeliveryDTO>();
        RouteDTO instance = new RouteDTO();
        instance.setDeliveries(deliveries);
        assertTrue(instance.getDeliveries() != null);
    }
    
}
