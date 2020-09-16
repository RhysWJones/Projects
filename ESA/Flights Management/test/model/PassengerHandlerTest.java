/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Passenger;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Greg
 */
public class PassengerHandlerTest {
    
    public PassengerHandlerTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of addPassenger method, of class PassengerHandler.
     */
    @Test
    public void testAddPassenger() {
        System.out.println("addPassenger");
        Passenger p = new Passenger();
        p.setForename("DAVID");
        p.setSurname("DAVIDSON");
        p.setDOB(new Date(2012-02-02));
        p.setNationality("ENGLISH");
        PassengerHandler instance = new PassengerHandler();
        assertTrue(instance.addPassenger(p));
    }

    /**
     * Test of findAllPassengers method, of class PassengerHandler.
     */
    @Test
    public void testFindAllPassengers() {
        System.out.println("findAllPassengers");
        PassengerHandler instance = new PassengerHandler();
        ArrayList<Passenger> expResult = new ArrayList();
        for(int i = 1; i < 24; i++){
            Passenger p = new Passenger();
            p.setPassengerID(i);
            p.setForename("Rob");
            p.setSurname("Smith");
            p.setDOB(new Date(2018-02-20));
            p.setNationality("USA");
            p.setPassportNumber(i);
            expResult.add(p);
        }
        
        ArrayList<Passenger> result = instance.findAllPassengers();
        assertEquals(expResult, result);
    }

    /**
     * Test of findSpecificPassenger method, of class PassengerHandler.
     */
    @Test
    public void testFindSpecificPassenger() {
        System.out.println("findSpecificPassenger");
        Passenger p = new Passenger();
        PassengerHandler instance = new PassengerHandler();
        ArrayList<Passenger> expResult = new ArrayList();
        p.setPassengerID(3);    
        expResult.add(p);
        ArrayList<Passenger> result = instance.findSpecificPassenger(p);
        assertEquals(expResult, result);
        
    }
    
}
