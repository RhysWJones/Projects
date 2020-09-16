package builder;

import database.Plane;

public class PlaneBuilder
{

    Plane plane = new Plane();

    public PlaneBuilder withPlaneID(int planeID)
    {
        this.plane.setPlaneID(planeID);
        return this;
    }

    public PlaneBuilder withCapacity(int capacity)
    {
        this.plane.setCapacity(capacity);
        return this;
    }

    public PlaneBuilder withDesignation(String designation)
    {
        this.plane.setDesignation(designation);
        return this;
    }

    public PlaneBuilder withAirline(String airline)
    {
        this.plane.setAirline(airline);
        return this;
    }

    public PlaneBuilder withEquipment(String equipment)
    {
        this.plane.setEquipment(equipment);
        return this;
    }

    public Plane build()
    {
        return plane;
    }
}
