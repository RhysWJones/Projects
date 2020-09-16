package vehicleshowroomproj;

import java.io.*;

public class VehicleFileWriter
{

    FileWriter fw;
    File file;

    public VehicleFileWriter()
    {
        file = new File("files/vehicleWrite.txt");
        try
        {
            fw = new FileWriter(file);
            if(file.exists())
            {
                System.out.println("File Exists");
            }
        }
        catch (IOException ioe)
        {
            System.out.println("File doesn't exist" + ioe);
        }
    }

    public void writeToFile(Showroom showroom)
    {
        Vehicle v = showroom.getCurrentVehicle();
        try
        {
            fw.write(v.getManufacturer() + "  " + v.getModel() + "  " +
                    v.getVehicleIdentificationNumber() + "  " + v.getManufactureDate() + "  " +
                    v.getTaxBand() + "  " + v.getCost());
            fw.flush();
            fw.close();
            
            System.out.println("Current vehicle successfully written to file.");
        }
        catch (IOException ioe)
        {
            System.out.println("Current vehicle unsuccessfully written to file." + ioe);
        }
    }
}
