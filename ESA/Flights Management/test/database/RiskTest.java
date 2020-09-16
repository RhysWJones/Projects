/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Krzychu
 */
public class RiskTest {
    
    public RiskTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPassRisk method, of class Risk.
     */
    @Test
    public void testGetPassRisk() {
        System.out.println("getPassRisk");
        Risk instance = new Risk();
        PassengerRisk_ByFlight expResult = new PassengerRisk_ByFlight(5, 5);
        instance.setPassRisk(expResult);
        PassengerRisk_ByFlight result = instance.getPassRisk();
        assertEquals(expResult, result);       
    }

    /**
     * Test of setPassRisk method, of class Risk.
     */
    @Test
    public void testSetPassRisk() {
        System.out.println("setPassRisk");
        Risk instance = new Risk();
        PassengerRisk_ByFlight expResult = new PassengerRisk_ByFlight(5, 5);
        instance.setPassRisk(expResult);
        PassengerRisk_ByFlight result = instance.getPassRisk();
        assertEquals(expResult, result);      
       
    }

    /**
     * Test of getRiskID method, of class Risk.
     */
    @Test
    public void testGetRiskID() {
        System.out.println("getRiskID");
        Risk instance = new Risk(2,"test",0);
        int expResult = 2;
        int result = instance.getRiskID();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setRiskID method, of class Risk.
     */
    @Test
    public void testSetRiskID() {
        System.out.println("setRiskID");
        int expResult = 2;        
        Risk instance = new Risk();        
        instance.setRiskID(expResult);
        int result = instance.getRiskID();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getRiskFactor method, of class Risk.
     */
    @Test
    public void testGetRiskFactor() {
        System.out.println("getRiskFactor");
        Risk instance = new Risk(2,"test",0);
        String expResult = "test";
        String result = instance.getRiskFactor();
        assertEquals(expResult, result);        
    }

    /**
     * Test of setRiskFactor method, of class Risk.
     */
    @Test
    public void testSetRiskFactor() {
        System.out.println("setRiskFactor");
        String expResult = "test";       
        Risk instance = new Risk();        
        instance.setRiskFactor(expResult);
        String result = instance.getRiskFactor();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getRiskScore method, of class Risk.
     */
    @Test
    public void testGetRiskScore() {
        System.out.println("getRiskScore");
         Risk instance = new Risk(2,"test",10);
        int expResult = 10;
        int result = instance.getRiskScore();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setRiskScore method, of class Risk.
     */
    @Test
    public void testSetRiskScore() {
        System.out.println("setRiskScore");
        int expResult = 10;        
        Risk instance = new Risk();        
        instance.setRiskScore(expResult);
        int result = instance.getRiskScore();
        assertEquals(expResult, result);
       
    }
    
}
