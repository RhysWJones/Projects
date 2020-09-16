
package vehicleshowroomproj;

public class Hybrid extends Vehicle
{
    private double consumption;
    private String drive;
    
    public Hybrid(String manufacturer, String model, String vehicleIdentificationNumber, String manufactureDate, char taxBand, double cost, double consumption, String drive)
    {
        super(manufacturer, model, vehicleIdentificationNumber, manufactureDate, taxBand, cost);
        this.consumption = consumption;
        this.drive = drive;
    }

    public double getConsumption()
    {
        return consumption;
    }

    public void setConsumption(double consumption)
    {
        this.consumption = consumption;
    }

    public String getDrive()
    {
        return drive;
    }

    public void setDrive(String drive)
    {
        this.drive = drive;
    }
    
    @Override
    public String toString()
    {
        return " Engine Type: Hybrid \n" + super.toString() + "\n Fuel Consumption (MPG): " + consumption + "\n Drive: " + drive;
    }
}
