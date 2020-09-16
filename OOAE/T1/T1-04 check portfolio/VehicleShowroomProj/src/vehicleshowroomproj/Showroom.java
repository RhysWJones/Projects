package vehicleshowroomproj;

import java.util.*;

public class Showroom
{
   private ArrayList<Vehicle> vehicleArray = new ArrayList();
   private Vehicle currentVehicle;
   private ArrayList<Vehicle> vehiclesSoldRecentlyArray = new ArrayList();
   private double discountedCost;
   
   public Showroom()
   {
       
   }
   
   public Vehicle getVehicleInShowroom(int index)
   {
       return vehicleArray.get(index);
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
   
   public String getCurrentVehicleAsString()
   {
       return currentVehicle.toString();
   }
   
   public Vehicle getCurrentVehicle()
   {
       return currentVehicle;
   }
   
   public Boolean nextVehicle()
   {
       for (int i = 0; i < vehicleArray.size(); i++)
       {
           if (vehicleArray.get(i) == currentVehicle)
           {
               if (i+1 >= vehicleArray.size())
               {
                   System.out.println("\n ERROR: THERE IS NO NEXT VEHICLE!!");
                    return false;
               }
               
               else
               {
                    currentVehicle = vehicleArray.get(i+1);
                    return true;
               }
           }
       }
       return true;
   }
   
   public Boolean previousVehicle()
   {
       for (int i = 0; i < vehicleArray.size(); i++)
       {
           if (vehicleArray.get(i) == currentVehicle)
           {
               if (i-1 < 0)
               {
                   System.out.println("\n ERROR: THERE IS NO PREVIOUS VEHICLE!!");
                    return false;
               }
               
               else
               {
                    currentVehicle = vehicleArray.get(i-1);
                    return true;
               }
           }
       }
       return true;
   }
   
    public boolean addVehicle(Vehicle vehicle)
    {
        vehicleArray.add(vehicle);
        setDiscountedCost(vehicle);
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
    
    public ArrayList getVehiclesSoldRecently()
    {
        Date currentDate = new Date();
        long age;
        
        for (int i = 0; i < vehicleArray.size(); i++)
        {
            age = currentDate.getTime() - vehicleArray.get(i).getManufactureDate().getTime();
            age = (age / (1000 * 60 * 60 * 24));
            
            if (age <= 14)
            {
                vehiclesSoldRecentlyArray.add(vehicleArray.get(i));
            }
        }
        
        return vehiclesSoldRecentlyArray;
    }
    
    public boolean removeCurrentVehicle()
    {
        for(int i = 0; i < vehicleArray.size(); i++)
        {
            if(vehicleArray.get(i) == currentVehicle)
            {
                vehicleArray.remove(i);
            }
        }
        currentVehicle = vehicleArray.get(0);
        return true;
    }
    
    public void setDiscountedCost(Vehicle vehicle)
    {
        
        if (vehicle.getAgeOfVehicle() > 52)
        {
            double twentyPercent = 0.20 * (vehicle.getCost()) ;
            discountedCost = (vehicle.getCost()) - twentyPercent;
            vehicle.setCost(discountedCost);
        }
//        for(int i = 0; i < vehicleArray.size(); i++)
//        {
//            if (vehicleArray.get(i).getAgeOfVehicle() > 52)
//            {
//                double twentyPercent = 0.20 * (vehicleArray.get(i).getCost()) ;
//                discountedCost = (vehicleArray.get(i).getCost()) - twentyPercent;
//                vehicleArray.get(i).setCost(discountedCost);
//            }
//        }
    }
}
