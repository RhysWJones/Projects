package database;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Flight
{

    private int flightID;
    private int planeID;
    private String fOrigin;
    private String fDestination;
    private Date arrivalDate;
    private Time arrivalTime;
    private Date departureDate;
    private Time departureTime;
    private Plane plane;
    private ArrayList<Seat> seats = new ArrayList<>();
    private int maxRisk;

    public Flight()
    {
        this(-1, -1, "", "", null, null, null, null, null,-1);
    }

    public Flight(int flightID, int planeID, String fOrigin, String fDestination, Date arrivalDate, Time arrivalTime, Date departureDate, Time departureTime, Plane plane, int maxRisk) {
        this.flightID = flightID;
        this.planeID = planeID;
        this.fOrigin = fOrigin;
        this.fDestination = fDestination;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.plane = plane;
        this.maxRisk = maxRisk;
    }
    
    

    
    public Flight(int flightID, int planeID, String fDestination, String fOrigin, Date departureDate, Date arrivalDate, Plane plane)
    {
        this.flightID = flightID;
        this.planeID = planeID;
        this.fOrigin = fOrigin;
        this.fDestination = fDestination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.plane = plane;

    }

    public ArrayList<Seat> getSeat()
    {
        return seats;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public int getMaxRisk() {
        return maxRisk;
    }

    public void setMaxRisk(int maxRisk) {
        this.maxRisk = maxRisk;
    }
    
    

    public void addSeat(Seat seat)
    {
        this.seats.add(seat);
        seat.setFlight(this);
    }

    public Plane getPlane()
    {
        return plane;
    }

    public void setPlane(Plane plane)
    {
        this.plane = plane;
    }

    public int getFlightID()
    {
        return flightID;
    }

    public void setFlightID(int flightID)
    {
        this.flightID = flightID;
    }

    public int getPlaneID()
    {
        return planeID;
    }

    public void setPlaneID(int planeID)
    {
        this.planeID = planeID;
    }

    public String getfOrigin()
    {
        return fOrigin;
    }

    public void setfOrigin(String fOrigin)
    {
        this.fOrigin = fOrigin;
    }

    public String getfDestination()
    {
        return fDestination;
    }

    public void setfDestination(String fDestination)
    {
        this.fDestination = fDestination;
    }

    public Date getDepartureDate()
    {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate)
    {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime()
    {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime)
    {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime()
    {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalDate()
    {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate)
    {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        return ("FLIGHT" + "\n\tFlight number: " + getFlightID() + "\tPlane id: " + getPlaneID() + "\n\tFrom: " + getfOrigin()
                + "\tTo: " + getfDestination() + "\n\tDeparture date: " + getDepartureDate()
                + "\tArrival date: " + getArrivalDate() + "\n\tPlane designation: "
                + getPlane().getDesignation()
                + "\tPlane capacity: " + getPlane().getCapacity()
                + "\n\tPlane airline: " + getPlane().getAirline()
                + "\tEquipment: " + getPlane().getEquipment()
                + "\n");
    }

}
