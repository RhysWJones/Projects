package vehicleshowroomproj;

import java.util.*;

public class Showroom
{
   private ArrayList<Vehicle> vehicleArray = new ArrayList<>();
   private Vehicle currentVehicle;
   
   public Showroom()
   {
       
   }
   
   public void setCurrentVehicle(Vehicle vehicle)
   {
       for (int i = 0; i < vehicleArray.size(); i++)
       {
           if(vehicleArray.get(i) == vehicle)
           {
               this.currentVehicle = vehicle;
           }
       }
   }
   
   public Vehicle getCurrentVehicle()
   {
       return currentVehicle;
   }
   
   public Boolean nextVehicle()
   {
       for (int i = 0; i < vehicleArray.size(); i++)
       {
           if(vehicleArray.get(i) == currentVehicle)
           {
               if (i+1 >= vehicleArray.size())
               {
                   System.out.println("\n ERROR: THERE IS NO NEXT VEHICLE!!");
                    return false;
               }
               
               else
               {
                    currentVehicle = vehicleArray.get(i+1);
               }
           }
       }
       return true;
   }
   
   public Boolean previousVehicle()
   {
       for (int i = 0; i < vehicleArray.size(); i++)
       {
           if(vehicleArray.get(i) == currentVehicle)
           {
               if (i-1 < 0)
               {
                   System.out.println("\n ERROR: THERE IS NO PREVIOUS VEHICLE!!");
                    return false;
               }
               
               else
               {
                    currentVehicle = vehicleArray.get(i-1);
               }
           }
       }
       return true;
   }
   
    public boolean addVehicle(Vehicle vehicle)
    {
        vehicleArray.add(vehicle);
        return true;
    }
    
    public String findVehicleByVin(String vin)
    {
        String vehicleFound = null;
        for (int i = 0; i < vehicleArray.size(); i++)
        {
            if (vehicleArray.get(i).getVehicleIdentificationNumber().equalsIgnoreCase(vin))
            {
                vehicleFound = vehicleArray.get(i).toString();
            }
        }
        return vehicleFound;
    }
    
    public void printArray()
    {
        for (int i = 0; i < vehicleArray.size(); i++)
        {
            System.out.println(vehicleArray.get(i));
            System.out.println("");
        }
    }
    
}
