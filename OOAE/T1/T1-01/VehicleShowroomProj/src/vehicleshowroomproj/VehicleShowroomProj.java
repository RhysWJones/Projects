
package vehicleshowroomproj;

import java.util.HashSet;
import java.util.Set;

public class VehicleShowroomProj
{
    
    public static void main(String[] args)
    {
        Showroom showroom = new Showroom();
        
        Vehicle vehicle1 = new Vehicle("Mercedes", "SLK", "12h123b", "12/9/14", 'C', 43000);
        Vehicle vehicle2 = new Vehicle("Fiat", "500", "96a858h", "17/9/14", 'B', 18700);
        Vehicle vehicle3 = new Vehicle("Fiat", "500", "57f158p", "15/9/14", 'G', 18700);
        Vehicle vehicle4 = new Vehicle("Ford", "Kuga", "46n947l", "27/8/13", 'D', 21000);
        
        System.out.println(" vehicle 1: \n" + vehicle1.toString() + "\n\n vehicle 2: \n" 
                + vehicle2.toString() + "\n\n vehicle 3: \n" + vehicle3.toString() + "\n\n vehicle 4: \n" 
                + vehicle4.toString() + "\n\n");
        
        vehicle1.buy("27/11/14", "James King");
        vehicle3.buy("16/12/14", "David Copperfeel");
        
        System.out.println(" vehicle 1: \n" + vehicle1.toString() + "\n\n vehicle 2: \n" 
                + vehicle2.toString() + "\n\n vehicle 3: \n" + vehicle3.toString() + "\n\n vehicle 4: \n" 
                + vehicle4.toString() + "\n\n");
        
        showroom.addVehicle(vehicle1);
        showroom.addVehicle(vehicle2);
        showroom.addVehicle(vehicle3);
        System.out.println(" Vehicle found by VIN 57F158P: \n" + showroom.findVehicleByVin("57f158p") 
                + "\n\n");
        
        showroom.setCurrentVehicle(vehicle1);
        System.out.println(" Current Vehicle: \n" + showroom.getCurrentVehicle());
        showroom.nextVehicle();
        System.out.println("\n Current Vehicle after next vehicle \n" + showroom.getCurrentVehicle());
        showroom.previousVehicle();
        System.out.println("\n Current Vehicle after previous vehicle \n" + showroom.getCurrentVehicle());
        showroom.previousVehicle();
        System.out.println("\n Current Vehicle after previous vehicle (Should be unchanged) \n" + showroom.getCurrentVehicle());
        showroom.setCurrentVehicle(vehicle3);
        System.out.println("\n Current Vehicle after setting current vehicle to the "
                + "end of the list \n" + showroom.getCurrentVehicle());
        
        System.out.println("\n Now to try and get the details of the next vehicle: ");
        
        showroom.nextVehicle();
        
        System.out.println("\n Now we have tested these, we will search for a vehicle by it's VIN, we will use the VIN '57f158p'.\n");
        System.out.println(showroom.findVehicleByVin("57f158p"));
        
        System.out.println("\n And finally we will print all of the vehicles in the showroom: \n");
        
        showroom.printArray();
    }
    
}
