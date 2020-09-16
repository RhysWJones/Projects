package vehicleshowroomproj;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class VehicleShowroomProj
{
    
    public static void main(String[] args)
    {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Hybrid hybrid = new Hybrid("Toyota", "Prius", "74h427d", "05/11/2017", 'N', 24115, 94, "Drive1");
        Showroom showroom = new Showroom();
        
        populateArray(vehicles);
        
        addVehiclesToShowroom(vehicles, showroom);
        
//        printVehicleDetails(vehicles);
//        showroom.printArray();

        showroom.setCurrentVehicle(vehicles.get(1));
        
        System.out.println(showroom.getCurrentVehicleAsString());
        System.out.println("");
        
        showroom.removeCurrentVehicle();
        
        showroom.printArray();
        
        System.out.println("Testing Hybrid Class\n====================\n");
        System.out.println("GETCONSUMPTION\n==============\n"+ hybrid.getConsumption() + "\nGETDRIVE\n========\n" + hybrid.getDrive());
        
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
        Vehicle electric = new Electric("BMW", "I3", "18g128a", "12/9/2016", 'N', 29570, 186, "lithium-ion");
        Vehicle hybrid = new Hybrid("Toyota", "Prius", "74h427d", "05/11/2017", 'N', 24115, 94, "Drive1");
        Vehicle combustion = new internalCombustion("Audi", "A4 Avant", "26i172j", "17/07/2016", 'E', 28700, 51);
        
        vehicles.add(electric);
        vehicles.add(hybrid);
        vehicles.add(combustion);
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
    
    public static void addVehiclesToShowroom(ArrayList<Vehicle> vehicles, Showroom showroom)
    {
        showroom.addVehicle(vehicles.get(0));
        showroom.addVehicle(vehicles.get(1));
        showroom.addVehicle(vehicles.get(2));
    }
}
