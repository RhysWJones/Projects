package database;

public class Plane
{

    private int planeID;
    private int capacity;
    private String designation;
    private String airline;
    private String equipment;
    private Flight flight;

    public Plane()
    {
        this(-1, "", -1, "", "");
    }

    public Plane(int planeID, String designation, int capacity, String airline, String equipment)
    {
        this.planeID = planeID;
        this.designation = designation;
        this.capacity = capacity;
        this.airline = airline;
        this.equipment = equipment;
    }

    public int getPlaneID()
    {
        return planeID;
    }

    public void setPlaneID(int planeID)
    {
        this.planeID = planeID;
    }

    public Flight getFlight()
    {
        return flight;
    }

    public void setFlight(Flight dept)
    {
        this.flight = dept;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public String getDesignation()
    {
        return designation;
    }

    public void setDesignation(String designation)
    {
        this.designation = designation;
    }

    public String getAirline()
    {
        return airline;
    }

    public void setAirline(String airline)
    {
        this.airline = airline;
    }

    public String getEquipment()
    {
        return equipment;
    }

    public void setEquipment(String equipment)
    {
        this.equipment = equipment;
    }

}
