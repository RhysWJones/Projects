package builder;

import database.Seat;

public class SeatBuilder
{

    Seat seat = new Seat();

    public SeatBuilder withSeatID(int seatID)
    {
        seat.setSeatID(seatID);
        return this;
    }

    public SeatBuilder withFlightID(int flightID)
    {
        seat.setFlightID(flightID);
        return this;
    }

    public SeatBuilder withSeatNumber(int seatNumber)
    {
        seat.setSeatNumber(seatNumber);
        return this;
    }

    public SeatBuilder withSeatTaken(boolean seatTaken)
    {
        seat.setSeatTaken(seatTaken);
        return this;
    }

    public Seat build()
    {
        return seat;
    }
}
