package builder;

import database.Flight;
import database.Passenger;
import database.PassengerRisk_ByFlight;
import database.Risk;

/**
 *
 * @author Krzychu-x
 */
public class PassengerRisk_ByFlightBuilder
{

    PassengerRisk_ByFlight passRisk = new PassengerRisk_ByFlight();

    public PassengerRisk_ByFlightBuilder withPassID(Passenger passenger)
    {
        this.passRisk.setPassenger(passenger);
        return this;
    }

    public PassengerRisk_ByFlightBuilder withFlightID(Flight flight)
    {
        this.passRisk.setFlight(flight);
        return this;
    }

    public PassengerRisk_ByFlightBuilder withRisks(Risk risk)
    {
        this.passRisk.addRisk(risk);
        return this;
    }

    public PassengerRisk_ByFlight build()
    {
        return passRisk;
    }
}
