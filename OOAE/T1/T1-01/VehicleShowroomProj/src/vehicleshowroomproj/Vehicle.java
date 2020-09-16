package vehicleshowroomproj;

public class Vehicle
{
    private String manufacturer;
    private String model;
    private String custName;
    private String vehicleIdentificationNumber;
    private String manufactureDate;
    private String dateSold;
    private boolean isSold = false;
    private char taxBand;
    private int cost;

    public Vehicle(String manufacturer, String model, String vehicleIdentificationNumber, String manufactureDate, char taxBand, int cost)
    {
        this.manufacturer = manufacturer;
        this.model = model;
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        this.manufactureDate = manufactureDate;
        this.taxBand = taxBand;
        this.cost = cost;
    }
    
    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }
    
    public String getManufacturer()
    {
        return manufacturer;
    }
    
    public void setModel(String model)
    {
        this.model = model;
    }
    
    public String getModel()
    {
        return model;
    }
    
    public void setCustName(String name)
    {
        this.custName = name;
    }
    
    public String getCustName()
    {
        return custName;
    }
    
    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber)
    {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }
    
    public String getVehicleIdentificationNumber()
    {
        return vehicleIdentificationNumber;
    }
    
    public void setManufactureDate(String manufactureDate)
    {
        this.manufactureDate = manufactureDate;
    }
    
    public String getManufactureDate()
    {
        return manufactureDate;
    }
    
    public void setDateSold(String dateSold)
    {
        this.dateSold = dateSold;
    }
    
    public String getDateSold()
    {
        return dateSold;
    }

    public boolean isSold()
    {
        return isSold;
    }

    public void setIsSold(boolean isSold)
    {
        this.isSold = isSold;
    }

    public char getTaxBand()
    {
        return taxBand;
    }

    public void setTaxBand(char taxBand)
    {
        this.taxBand = taxBand;
    }

    public int getCost()
    {
        return cost;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
    }
    
    public void buy(String dateSold, String custName)
    {
        this.dateSold = dateSold;
        this.custName = custName;
        this.isSold = true;
    }
    
    @Override
    public String toString()
    {
        String emissions = co2Emissions(this.taxBand);
        if (isSold)
        {
        return " Manufacturer: " + manufacturer + "\n Model: " + model + "\n Vehicle Identification Number: " + vehicleIdentificationNumber 
                + "\n Date of Manufacture: " + manufactureDate + "\n taxBand: " + taxBand + "\n CO2 Emitted: " + emissions + "\n Cost: " + cost + "\n Sold: " + isSold + "\n Customer name: " + custName;
        }
            return " Manufacturer: " + manufacturer + "\n Model: " + model + "\n Vehicle Identification Number: " + vehicleIdentificationNumber 
                + "\n Date of Manufacture: " + manufactureDate + "\n taxBand: " + taxBand + "\n CO2 Emitted: " + emissions + "\n Cost: " + cost + "\n Sold: " + isSold;
    }
    
    public String co2Emissions(char taxBand)
    {
        String emissions = null;
        if (Character.toString(taxBand).matches("A"))
        {
            emissions = "0-100";
        }
        
        else if (Character.toString(taxBand).matches("B"))
        {
            emissions = "101-110";
        }
        
        else if (Character.toString(taxBand).matches("C"))
        {
            emissions = "111-120";
        }
        
        else if (Character.toString(taxBand).matches("D"))
        {
            emissions = "121-130";
        }
        
        else if (Character.toString(taxBand).matches("E"))
        {
            emissions = "131-140";
        }
        
        else if (Character.toString(taxBand).matches("F"))
        {
            emissions = "141-150";
        }
        
        else if (Character.toString(taxBand).matches("G"))
        {
            emissions = "151-160";
        }
        
        else 
        {
            emissions = "Error - tax band is invalid";
        }
        
        return emissions;
    }
    
       
}
