/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Rhys
 */
public class ParcelDTOIT
{
    private ParcelDTO parcelDTOInstance = new ParcelDTO();
    public ParcelDTOIT()
    {
        DeliveryDTO deliveryDTOInstance = new DeliveryDTO();
        DeliveryStatusDTO deliveryStatusDTOInstance = new DeliveryStatusDTO();
        DepotDTO depotDTOInstance = new DepotDTO();
        RouteDTO routeDTOInstance = new RouteDTO();
        
        
        //Create DeliveryDTO
        deliveryDTOInstance.setDeliveryId(1);
        deliveryDTOInstance.setDeliveryDate(new Date());
        deliveryDTOInstance.setDeliveryStatus(deliveryStatusDTOInstance);
        deliveryDTOInstance.setDepot(depotDTOInstance);
        deliveryDTOInstance.setParcel(parcelDTOInstance);
        deliveryDTOInstance.setRoute(routeDTOInstance);
        
        //Create ParcelDTO
        parcelDTOInstance.setParcelId(1);
        parcelDTOInstance.setRecipientName("Test Recipient");
        parcelDTOInstance.setAddressLine1("Test Address 1");
        parcelDTOInstance.setAddressLine2("Test Address 2");
        parcelDTOInstance.setCity("Test City");
        parcelDTOInstance.setPostcode("Test Postcode");
        parcelDTOInstance.setDelivered(false);
        parcelDTOInstance.setDelivery(deliveryDTOInstance);
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
     * Test of getParcelId method, of class ParcelDTO.
     */
    @Test
    public void testGetParcelId()
    {
        System.out.println("getParcelId");
        int expResult = 1;
        int result = parcelDTOInstance.getParcelId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setParcelId method, of class ParcelDTO.
     */
    @Test
    public void testSetParcelId()
    {
        System.out.println("setParcelId");
        int parcelId = 0;
        ParcelDTO instance = new ParcelDTO();
        instance.setParcelId(parcelId);
        assertEquals(instance.getParcelId(), parcelId);
    }

    /**
     * Test of getRecipientName method, of class ParcelDTO.
     */
    @Test
    public void testGetRecipientName()
    {
        System.out.println("getRecipientName");
        String expResult = "Test Recipient";
        String result = parcelDTOInstance.getRecipientName();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setRecipientName method, of class ParcelDTO.
     */
    @Test
    public void testSetRecipientName()
    {
        System.out.println("setRecipientName");
        String recipientName = "Set Test";
        ParcelDTO instance = new ParcelDTO();
        instance.setRecipientName(recipientName);
        assertTrue(instance.getRecipientName().equals(recipientName));
    }

    /**
     * Test of getAddressLine1 method, of class ParcelDTO.
     */
    @Test
    public void testGetAddressLine1()
    {
        System.out.println("getAddressLine1");
        String expResult = "Test Address 1";
        String result = parcelDTOInstance.getAddressLine1();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setAddressLine1 method, of class ParcelDTO.
     */
    @Test
    public void testSetAddressLine1()
    {
        System.out.println("setAddressLine1");
        String addressLine1 = "Set Test";
        ParcelDTO instance = new ParcelDTO();
        instance.setAddressLine1(addressLine1);
        assertTrue(instance.getAddressLine1().equals(addressLine1));
    }

    /**
     * Test of getAddressLine2 method, of class ParcelDTO.
     */
    @Test
    public void testGetAddressLine2()
    {
        System.out.println("getAddressLine2");
        String expResult = "Test Address 2";
        String result = parcelDTOInstance.getAddressLine2();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setAddressLine2 method, of class ParcelDTO.
     */
    @Test
    public void testSetAddressLine2()
    {
        System.out.println("setAddressLine2");
        String addressLine2 = "Set Test";
        ParcelDTO instance = new ParcelDTO();
        instance.setAddressLine2(addressLine2);
        assertTrue(instance.getAddressLine2().equals(addressLine2));
    }

    /**
     * Test of getPostcode method, of class ParcelDTO.
     */
    @Test
    public void testGetPostcode()
    {
        System.out.println("getPostcode");
        String expResult = "Test Postcode";
        String result = parcelDTOInstance.getPostcode();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setPostcode method, of class ParcelDTO.
     */
    @Test
    public void testSetPostcode()
    {
        System.out.println("setPostcode");
        String postcode = "Test Set";
        ParcelDTO instance = new ParcelDTO();
        instance.setPostcode(postcode);
        assertTrue(instance.getPostcode().equals(postcode));
    }

    /**
     * Test of getCity method, of class ParcelDTO.
     */
    @Test
    public void testGetCity()
    {
        System.out.println("getCity");
        String expResult = "Test City";
        String result = parcelDTOInstance.getCity();
        assertTrue(expResult.equals(result));
    }

    /**
     * Test of setCity method, of class ParcelDTO.
     */
    @Test
    public void testSetCity()
    {
        System.out.println("setCity");
        String city = "Test Set";
        ParcelDTO instance = new ParcelDTO();
        instance.setCity(city);
        assertTrue(instance.getCity().equals(city));
    }

    /**
     * Test of isDelivered method, of class ParcelDTO.
     */
    @Test
    public void testIsDelivered()
    {
        System.out.println("isDelivered");
        boolean expResult = false;
        boolean result = parcelDTOInstance.isDelivered();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDelivered method, of class ParcelDTO.
     */
    @Test
    public void testSetDelivered()
    {
        System.out.println("setDelivered");
        boolean delivered = true;
        ParcelDTO instance = new ParcelDTO();
        instance.setDelivered(delivered);
        assertEquals(instance.isDelivered(), delivered);
    }

    /**
     * Test of getDelivery method, of class ParcelDTO.
     */
    @Test
    public void testGetDelivery()
    {
        System.out.println("getDelivery");
        DeliveryDTO result = parcelDTOInstance.getDelivery();
        assertTrue(result != null);
    }

    /**
     * Test of setDelivery method, of class ParcelDTO.
     */
    @Test
    public void testSetDelivery()
    {
        System.out.println("setDelivery");
        DeliveryDTO delivery = new DeliveryDTO();
        delivery.setDeliveryId(1);
        ParcelDTO instance = new ParcelDTO();
        instance.setDelivery(delivery);
        assertTrue(instance.getDelivery() != null);
        assertEquals(instance.getDelivery().getDeliveryId(), 1);
    }
    
}
