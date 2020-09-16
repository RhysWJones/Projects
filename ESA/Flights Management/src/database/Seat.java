package database;

public class Seat
{

    private int seatID;
    private int flightID;
    private int seatNumber;
    private boolean seatTaken;
    private Flight flight;

    public Seat()
    {
        this(-1, -1, -1, false);
    }

    public Seat(int seatID, int flightID, int seatNumber, boolean seatTaken)
    {
        this.seatID = seatID;
        this.flightID = flightID;
        this.seatNumber = seatNumber;
        this.seatTaken = seatTaken;
    }

    public void setFlight(Flight flight)
    {
        this.flight = flight;
    }

    public Flight getFlight()
    {
        return flight;
    }

    public int getSeatID()
    {
        return seatID;
    }

    public void setSeatID(int seatID)
    {
        this.seatID = seatID;
    }

    public int getFlightID()
    {
        return flightID;
    }

    public void setFlightID(int flightID)
    {
        this.flightID = flightID;
    }

    public int getSeatNumber()
    {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber)
    {
        this.seatNumber = seatNumber;
    }

    public boolean getSeatTaken()
    {
        return seatTaken;
    }

    public void setSeatTaken(boolean seatTaken)
    {
        this.seatTaken = seatTaken;
    }

}
