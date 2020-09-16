package vehicleshowroomproj;

import java.util.*;

public class VehicleShowroomProj
{

    public static void main(String[] args)
    {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Showroom showroom = new Showroom();

        populateVehicleArray(vehicles);

        addVehiclesToShowroom(vehicles, showroom);

        showroom.setCurrentVehicle(vehicles.get(0));
        
        VehicleFileWriter vfw = new VehicleFileWriter();
        vfw.writeToFile(showroom);
        
        VehicleFileReader vfr = new VehicleFileReader();
        vfr.createVehicleFromFile(vehicles);
    }

    public static void populateVehicleArray(ArrayList<Vehicle> vehicles)
    {
        Vehicle vehicle1 = new Vehicle("Mercedes", "SLK", "12h123b", "12/9/14", 'C', 43000);
        Vehicle vehicle2 = new Vehicle("Fiat", "500", "96a858h", "17/9/14", 'B', 18700);
        Vehicle vehicle3 = new Vehicle("Fiat", "500", "57f158p", "15/9/14", 'G', 18700);
        Vehicle vehicle4 = new Vehicle("Ford", "Kuga", "46n947l", "27/8/13", 'D', 21000);
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        vehicles.add(vehicle4);
    }

    public static void printVehicles(ArrayList<Vehicle> vehicles)
    {
        System.out.println(" vehicle 1: \n" + vehicles.get(0).toString() + "\n\n vehicle 2: \n"
                + vehicles.get(1).toString() + "\n\n vehicle 3: \n" + vehicles.get(2).toString() + "\n\n vehicle 4: \n"
                + vehicles.get(3).toString() + "\n\n");
    }

    public static void addVehiclesToShowroom(ArrayList<Vehicle> vehicles, Showroom showroom)
    {
        showroom.addVehicle(vehicles.get(0));
        showroom.addVehicle(vehicles.get(1));
        showroom.addVehicle(vehicles.get(2));
    }

}
