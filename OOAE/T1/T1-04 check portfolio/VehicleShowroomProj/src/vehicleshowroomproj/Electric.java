
package vehicleshowroomproj;

public class Electric extends Vehicle
{
    private int range;
    private String batteryType;
    
    public Electric(String manufacturer, String model, String vehicleIdentificationNumber, String manufactureDate, char taxBand, double cost, int range, String batteryType)
    {
        super(manufacturer, model, vehicleIdentificationNumber, manufactureDate, taxBand, cost);
        this.batteryType = batteryType;
        this.range = range;
    }

    public int getRange()
    {
        return range;
    }

    public void setRange(int range)
    {
        this.range = range;
    }

    public String getBatteryType()
    {
        return batteryType;
    }

    public void setBatteryType(String batteryType)
    {
        this.batteryType = batteryType;
    }
    
    @Override
    public String toString()
    {
        return " Engine Type: Electric \n" + " Battery Type: " + batteryType + "\n" + super.toString() + "\n Range in miles: " + range;
    }
}
