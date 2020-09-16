package vehicleshowroomproj;

import java.io.*;
import java.util.*;

public class VehicleFileWriter
{

    FileOutputStream fOut;
    ObjectOutputStream out;

    public VehicleFileWriter()
    {

        try
        {
            fOut = new FileOutputStream("files/vehicles.ser");
            out = new ObjectOutputStream(fOut);
            System.out.println("File successfully created.");
        }
        catch (IOException ioe)
        {
            System.out.println("Error: File unsuccessfully created.\n" + ioe);
        }

    }

    public boolean writeToFile(ArrayList<Vehicle> vehicles)
    {
        try
        {
            out.writeObject(vehicles);
            out.close();
            fOut.close();
            System.out.println("Vehicles successfully written to file.");
            return true;
        }
        catch (IOException ioe)
        {
            System.out.println("Not Serializable\nVehicles not written to file.\n" + ioe);
            return false;
        }
    }
}
