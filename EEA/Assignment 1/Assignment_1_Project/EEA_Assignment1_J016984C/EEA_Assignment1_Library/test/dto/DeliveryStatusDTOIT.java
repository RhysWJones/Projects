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
 * @author Rhys
 */
public class DeliveryStatusDTOIT
{
    private DeliveryStatusDTO deliveryStatusDTOInstance = new DeliveryStatusDTO();
    
    public DeliveryStatusDTOIT()
    {
        deliveryStatusDTOInstance.setDeliveryStatusId(1);
        deliveryStatusDTOInstance.setName("Test Status");
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
     * Test of getDeliveryStatusId method, of class DeliveryStatusDTO.
     */
    @Test
    public void testGetDeliveryStatusId()
    {
        System.out.println("getDeliveryStatusId");
        int expResult = 1;
        int result = deliveryStatusDTOInstance.getDeliveryStatusId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDeliveryStatusId method, of class DeliveryStatusDTO.
     */
    @Test
    public void testSetDeliveryStatusId()
    {
        System.out.println("setDeliveryStatusId");
        int deliveryStatusId = 2;
        DeliveryStatusDTO instance = new DeliveryStatusDTO();
        instance.setDeliveryStatusId(deliveryStatusId);
        assertEquals(instance.getDeliveryStatusId(), 2);
    }

    /**
     * Test of getName method, of class DeliveryStatusDTO.
     */
    @Test
    public void testGetName()
    {
        System.out.println("getName");
        String expResult = "Test Status";
        String result = deliveryStatusDTOInstance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class DeliveryStatusDTO.
     */
    @Test
    public void testSetName()
    {
        System.out.println("setName");
        String name = "Test Set Status";
        deliveryStatusDTOInstance.setName(name);
        assertTrue(deliveryStatusDTOInstance.getName().equals(name));
    }
    
}
