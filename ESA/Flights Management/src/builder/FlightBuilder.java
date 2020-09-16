package builder;

import database.Flight;
import database.Plane;
import database.Seat;
import java.sql.Time;
import java.sql.Date;

public class FlightBuilder
{

    private final Flight flight = new Flight();

    public FlightBuilder withID(int flightID)
    {
        this.flight.setFlightID(flightID);
        return this;
    }

    public FlightBuilder withPlaneID(int planeID)
    {
        this.flight.setPlaneID(planeID);
        return this;
    }

    public FlightBuilder toDestination(String fDestination)
    {
        this.flight.setfDestination(fDestination);
        return this;
    }

    public FlightBuilder fromOrigin(String fOrigin)
    {
        this.flight.setfOrigin(fOrigin);
        return this;
    }

    public FlightBuilder atDepartureDate(Date departureDate)
    {
        this.flight.setDepartureDate(departureDate);
        return this;
    }

    public FlightBuilder atDepartureTime(Time departureTime)
    {
        this.flight.setDepartureTime(departureTime);
        return this;
    }

    public FlightBuilder atArrivalDate(Date arrivalDate)
    {
        this.flight.setArrivalDate(arrivalDate);
        return this;
    }

    public FlightBuilder atArrivalTime(Time arrivalTime)
    {
        this.flight.setArrivalTime(arrivalTime);
        return this;
    }

    public FlightBuilder withPlane(Plane plane)
    {
        this.flight.setPlane(plane);
        return this;
    }

    public FlightBuilder withSeats(Seat seat)
    {
        this.flight.addSeat(seat);
        return this;
    }
    
    public FlightBuilder withMaxRisk(int risk){
        this.flight.setMaxRisk(risk);
        return this;
    }

    public Flight build()
    {
        return flight;
    }
}
