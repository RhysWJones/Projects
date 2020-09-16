package vehicleshowroomproj;

import java.io.*;
import java.util.*;

public class VehicleFileReader
{

    FileInputStream fIn;
    ObjectInputStream in;

    public VehicleFileReader()
    {
        try
        {
            fIn = new FileInputStream("files/vehicles.ser");
            in = new ObjectInputStream(fIn);
            System.out.println("File for reading found.");
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("FILE NOT FOUND"
                    + "\n==============\n" + fnfe);
        }
        catch (IOException ioe)
        {
            System.out.println("SOMETHING HAS GONE WRONG"
                    + "\n========================\n" + ioe);
        }
    }

    public ArrayList<Vehicle> populateArrayFromFile(ArrayList<Vehicle> vehicles)
    {
        vehicles.removeAll(vehicles);
        try
        {
            vehicles = (ArrayList<Vehicle>) in.readObject();
            in.close();
            System.out.println("Successfully populated array with vehicles from file.");
        }
        catch (Exception e)
        {
            System.out.println("ERROR\n=====\n"
                    + "Unsuccessfully populated array with vehicles from file.\n" + e);
        }
        return vehicles;
    }
}
