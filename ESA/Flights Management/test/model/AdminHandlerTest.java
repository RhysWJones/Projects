/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Admin;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Greg
 */
public class AdminHandlerTest {
    
    public AdminHandlerTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of encrypt method, of class AdminHandler.
     */
    @org.junit.Test
    public void testEncrypt() {
        System.out.println("encrypt");
        String Password = "dave";
        AdminHandler instance = new AdminHandler();
        String expResult = "YeoIA/iFNSO3d9QUrOMTDNTT+S3izX/4aVwzfXnC7u4=";
        String result = instance.encrypt(Password);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkDetails method, of class AdminHandler.
     */
    @org.junit.Test
    public void testCheckDetails() {
        System.out.println("checkDetails");
        Admin a = new Admin();
        a.setUsername("greg");
        a.setPassword("DSxpDn3V+UeAOD6d+h9N7wRDGRBK0WqxXkXusqjfyBs=");
        a.setAuthenticated(true);
        AdminHandler instance = new AdminHandler();
        boolean expResult = true;
        boolean result = instance.checkDetails(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkAuthenticated method, of class AdminHandler.
     */
    @org.junit.Test
    public void testCheckAuthenticated() {
        System.out.println("checkAuthenticated");
        Admin a = new Admin();
        a.setUsername("greg");
        a.setPassword("DSxpDn3V+UeAOD6d+h9N7wRDGRBK0WqxXkXusqjfyBs=");
        AdminHandler instance = new AdminHandler();
        boolean expResult = false;
        boolean result = instance.checkAuthenticated(a);
        assertEquals(expResult, result);
    }
    
}
