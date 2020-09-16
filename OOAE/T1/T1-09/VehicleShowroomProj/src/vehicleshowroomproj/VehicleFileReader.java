package vehicleshowroomproj;

import java.io.*;
import java.util.*;

public class VehicleFileReader
{

    private Scanner input;

    private String manufacturer;
    private String model;
    private String custName;
    private String vehicleIdentificationNumber;
    private String manufactureDate;
    private char taxBand;
    private int cost;

    public VehicleFileReader()
    {
        try
        {
            input = new Scanner(new File("files/vehicleInput.txt"));
            System.out.println("File found for reader");
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("FILE NOT FOUND"
                    + "\n==============\n" + fnfe);
        }
    }

    public void createVehicleFromFile(ArrayList<Vehicle> vehicles)
    {
        Vehicle vehicle;
        while (input.hasNext())
        {
            try
            {
                manufacturer = input.next();
                model = input.next();
                vehicleIdentificationNumber = input.next();
                manufactureDate = input.next();
                taxBand = input.next().charAt(0);
                cost = Integer.parseInt(input.next());
                
                System.out.println("Data read successfully");
            }
            catch (Exception e)
            {
                System.out.println("Error reading data" + e);
            }
            vehicle = new Vehicle(manufacturer, model,
                    vehicleIdentificationNumber, manufactureDate,
                    taxBand, cost);
            vehicles.add(vehicle);
        }
        if (input != null)
        {
            input.close();
        }
    }
}
