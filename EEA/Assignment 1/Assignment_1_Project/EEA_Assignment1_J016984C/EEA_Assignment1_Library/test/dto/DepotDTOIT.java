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
public class DepotDTOIT
{
    private DepotDTO depotDTOInstance = new DepotDTO();
    public DepotDTOIT()
    {
        ArrayList<DeliveryDTO> deliveryList = new ArrayList<DeliveryDTO>();
        deliveryList.add(new DeliveryDTO());
        ArrayList<RouteDTO> routeList = new ArrayList<RouteDTO>();
        routeList.add(new RouteDTO());
        depotDTOInstance.setDepotId(1);
        depotDTOInstance.setName("Test Depot");
        depotDTOInstance.setDepotDeliveries(deliveryList);
        depotDTOInstance.setDepotRoutes(routeList);
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
     * Test of getDepotId method, of class DepotDTO.
     */
    @Test
    public void testGetDepotId()
    {
        System.out.println("getDepotId");
        int expResult = 1;
        int result = depotDTOInstance.getDepotId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDepotId method, of class DepotDTO.
     */
    @Test
    public void testSetDepotId()
    {
        System.out.println("setDepotId");
        int depotId = 2;
        depotDTOInstance.setDepotId(depotId);
        assertEquals(depotDTOInstance.getDepotId(), 2);
    }

    /**
     * Test of getName method, of class DepotDTO.
     */
    @Test
    public void testGetName()
    {
        System.out.println("getName");
        String expResult = "Test Depot";
        String result = depotDTOInstance.getName();
        assertTrue(result.equals(expResult));
    }

    /**
     * Test of setName method, of class DepotDTO.
     */
    @Test
    public void testSetName()
    {
        System.out.println("setName");
        String name = "";
        DepotDTO instance = new DepotDTO();
        instance.setName(name);
        assertTrue(instance.getName() != null);
    }

    /**
     * Test of getDepotRoutes method, of class DepotDTO.
     */
    @Test
    public void testGetDepotRoutes()
    {
        System.out.println("getDepotRoutes");
        int expResultCount = 1;
        int resultCount = depotDTOInstance.getDepotRoutes().size();
        assertTrue(depotDTOInstance.getDepotRoutes() != null);
        assertEquals(resultCount, expResultCount);
    }

    /**
     * Test of setDepotRoutes method, of class DepotDTO.
     */
    @Test
    public void testSetDepotRoutes()
    {
        System.out.println("setDepotRoutes");
        ArrayList<RouteDTO> depotRoutes = new ArrayList<RouteDTO>();
        depotDTOInstance.setDepotRoutes(depotRoutes);
        assertTrue(depotDTOInstance.getDepotRoutes() != null);
    }

    /**
     * Test of getDepotDeliveries method, of class DepotDTO.
     */
    @Test
    public void testGetDepotDeliveries()
    {
        System.out.println("getDepotDeliveries");
        ArrayList<DeliveryDTO> result = depotDTOInstance.getDepotDeliveries();
        assertTrue(depotDTOInstance.getDepotDeliveries().size() > 0);
        assertTrue(depotDTOInstance.getDepotDeliveries() != null);
    }

    /**
     * Test of setDepotDeliveries method, of class DepotDTO.
     */
    @Test
    public void testSetDepotDeliveries()
    {
        System.out.println("setDepotDeliveries");
        ArrayList<DeliveryDTO> depotDeliveries = new ArrayList<DeliveryDTO>();
        depotDTOInstance.setDepotDeliveries(depotDeliveries);
        assertTrue(depotDTOInstance.getDepotDeliveries() != null);
        
    }
    
}
