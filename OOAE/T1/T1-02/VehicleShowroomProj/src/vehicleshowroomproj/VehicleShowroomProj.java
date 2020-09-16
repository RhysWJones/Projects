package vehicleshowroomproj;

public class VehicleShowroomProj
{
    
    public static void main(String[] args)
    {
        // create objects
        Showroom showroom = new Showroom();
        
        Customer customer1 = new Customer("Barry King", "07585123456");
        Customer customer2 = new Customer("Joseph Bardle", "JosephBard@gmail.com");
        
        Vehicle vehicle1 = new Vehicle("Mercedes", "SLK", "12h123b", "12/9/2017", 'C', 43000);
        Vehicle vehicle2 = new Vehicle("peugeot", "208", "96a858h", "17/9/2014", 'B', 19595);
        Vehicle vehicle3 = new Vehicle("Fiat", "500", "57f158p", "27/9/2017", 'G', 18700);
        Vehicle vehicle4 = new Vehicle("Ford", "Kuga", "46n947l", "27/8/2013", 'D', 21000);
        
        //print all vehicle details
        System.out.println(" !!CALLING VEHICLE.TOSTRING!! \n");
        System.out.println(" vehicle 1: \n" + vehicle1.toString() + "\n\n vehicle 2: \n" 
                + vehicle2.toString() + "\n\n vehicle 3: \n" + vehicle3.toString() + "\n\n vehicle 4: \n" 
                + vehicle4.toString() + "\n\n");
        
        //buy vehicles
        vehicle1.buy("27/9/2017", customer1);
        vehicle3.buy("5/10/2017", customer2);
        
        //re-print all vehicle details
        System.out.println(" !!CALLING VEHICLE.TOSTRING AFTER BUYING VEHICLE 1 AND 3!! \n");
        System.out.println(" vehicle 1: \n" + vehicle1.toString() + "\n\n vehicle 2: \n" 
                + vehicle2.toString() + "\n\n vehicle 3: \n" + vehicle3.toString() + "\n\n vehicle 4: \n" 
                + vehicle4.toString() + "\n\n");
        
        //add vehicles to showroom
        showroom.addVehicle(vehicle1);
        showroom.addVehicle(vehicle2);
        showroom.addVehicle(vehicle3);
        //find vehicle by a vin number
        System.out.println(" !!CALLING SHOWROOM.FINDVEHICLEBYVIN!! \n");
        System.out.println(" Vehicle found by VIN 57F158P: \n" + showroom.findVehicleByVin("57f158p") 
                + "\n\n");
        
        //set showroom current vehicle and cycle next and previous checked boundaries
        
        System.out.println(" !!CALLING CURRENTVEHICLE/NEXTVEHICLE/PREVIOUSVEHICLE!! \n");
        
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
        System.out.println("\n Current Vehicle after next vehicle (Should be unchanged) \n" + showroom.getCurrentVehicle());
        
        System.out.println("\n And finally we will print all of the vehicles in the showroom: \n");
        
        //print all of the vehicles in the showroom
        showroom.printArray();
        
        System.out.println(" !!CALLING GETAGEOFVEHICLE FOR VEHICLE1!! \n");
        
        System.out.println(" Vehicle 1 is: " + vehicle1.getAgeOfVehicle() + " weeks old.");
        System.out.println("\n\n\n");
        
        System.out.println("Vehicles sold recently (in the last 2 weeks) are: \n" + showroom.getVehiclesSoldRecently());
    }
    
}
