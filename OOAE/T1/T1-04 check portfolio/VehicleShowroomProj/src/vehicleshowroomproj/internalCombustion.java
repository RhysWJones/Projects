
package vehicleshowroomproj;


public class internalCombustion extends Vehicle
{
    private double consumption;
    
    public internalCombustion(String manufacturer, String model, String vehicleIdentificationNumber, String manufactureDate, char taxBand, double cost, double consumption)
    {
        super(manufacturer, model, vehicleIdentificationNumber, manufactureDate, taxBand, cost);
        this.consumption = consumption;
    }

    public double getConsumption()
    {
        return consumption;
    }

    public void setConsumption(double consumption)
    {
        this.consumption = consumption;
    }
    
    @Override
    public String toString()
    {
        return " Engine Type: Combustion \n" + super.toString() + "\n Fuel Consumption (MPG): " + consumption;
    }
}
