package database;

import java.util.ArrayList;

/**
 *
 * @author Krzychu-x
 */
public class PassengerRisk_ByFlight
{

    private Passenger passenger;
    private Flight flight;
    private ArrayList<Risk> risks = new ArrayList<>();

    public PassengerRisk_ByFlight()
    {
        this(null, null);
    }

    public PassengerRisk_ByFlight(Passenger passenger, Flight flight)
    {
        this.passenger = passenger;
        this.flight = flight;
    }

    public ArrayList<Risk> getRisk()
    {
        return risks;
    }

    public void addRisk(Risk risk)
    {
        this.risks.add(risk);
        risk.setPassRisk(this);
    }

    public Passenger getPassenger()
    {
        return passenger;
    }

    public void setPassenger(Passenger passenger)
    {
        this.passenger = passenger;
    }

    public Flight getFlight()
    {
        return flight;
    }

    public void setFlight(Flight flight)
    {
        this.flight = flight;
    }

    public ArrayList<Risk> getRisks()
    {
        return risks;
    }

    public void setRisks(ArrayList<Risk> risks)
    {
        this.risks = risks;
    }

    public int getTotalRiskScore()
    {
        int risk = 0;
        for (Risk r : risks)
        {
            risk += r.getRiskScore();
        }
        return risk;
    }

}
