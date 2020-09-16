package command;

import model.FlightHandler;
import view.AllFlightsView;

public class GetAllFlightLabels implements Command
{

    FlightHandler receiver;

    public GetAllFlightLabels(FlightHandler receiver)
    {
        this.receiver = receiver;
    }

    public Object execute()
    {
        return new AllFlightsView(receiver.findAllFlights()).makeCards();
    }

}
