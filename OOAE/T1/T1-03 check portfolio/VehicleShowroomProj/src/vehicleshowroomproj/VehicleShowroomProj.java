package vehicleshowroomproj;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class VehicleShowroomProj
{
    
    public static void main(String[] args)
    {
        new ShowroomGui();
        
//        // create objects
//        Showroom showroom = new Showroom();
//        
//        ArrayList<Customer> customers = new ArrayList<>();
//        
//        customers.add(new Customer("Barry King", "07585123456"));
//        customers.add(new Customer("Joseph Bardle", "JosephBard@gmail.com"));
//        
//        ArrayList<Vehicle> vehicles = new ArrayList<>();
//        
//        populateArray(vehicles);
//        
//        //print all vehicle details
//        printVehicleDetails(vehicles);
//        
//        //buy vehicles
//        buyVehicle(vehicles, customers);
//        
//        //re-print all vehicle details
//        printVehicleDetails(vehicles);
//        
//        //add vehicles to showroom
//        addVehicleToShowroom(vehicles, showroom);
        
        
    }
    
    public static void printVehicleDetails(ArrayList<Vehicle> vehicles)
    {
        System.out.println(" !!CALLING VEHICLE.TOSTRING!! \n");
        int index = 1;
        for(Vehicle vehicle : vehicles)
        {
            System.out.println(" vehicle " + index + ": \n" + vehicle);
            System.out.println("");
            index++;
        }
    }
    
    public static void populateArray(ArrayList<Vehicle> vehicles)
    {
        vehicles.add(new Vehicle("Mercedes", "SLK", "12h123b", "12/9/2017", 'C', 43000));
        vehicles.add(new Vehicle("peugeot", "208", "96a858h", "17/9/2014", 'B', 19595));
        vehicles.add(new Vehicle("Fiat", "500", "57f158p", "10/10/2017", 'G', 18700));
        vehicles.add(new Vehicle("Ford", "Kuga", "46n947l", "27/8/2013", 'D', 21000));
    }
    
    public static void createCustomers(ArrayList<Customer> customers)
    {
        customers.add(new Customer("Barry King", "07585123456"));
        customers.add(new Customer("Joseph Bardle", "JosephBard@gmail.com"));
    }
    
    public static void buyVehicle(ArrayList<Vehicle> vehicles, ArrayList<Customer> customers)
    {
        vehicles.get(0).buy("27/9/2017", customers.get(0));
        vehicles.get(2).buy("5/10/2017", customers.get(1));
    }
    
    public static void addVehicleToShowroom(ArrayList<Vehicle> vehicles, Showroom showroom)
    {
        showroom.addVehicle(vehicles.get(0));
        showroom.addVehicle(vehicles.get(1));
        showroom.addVehicle(vehicles.get(2));
    }
}
