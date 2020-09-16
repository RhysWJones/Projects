package command;

import model.PassengerRisk;
import view.AllPassengersRiskView;

/**
 *
 * @author Krzychu-x
 */
public class GetAllPassengersRisks_ByFlight implements Command
{

    PassengerRisk receiver;

    public GetAllPassengersRisks_ByFlight(PassengerRisk receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public Object execute()
    {
        return new AllPassengersRiskView(receiver.findAllPassengersRisks(-1)).print();
    }
}
