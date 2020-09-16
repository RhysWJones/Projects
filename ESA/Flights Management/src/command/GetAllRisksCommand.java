/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.PassengerRisk;
import view.GetRisksView;

/**
 *
 * @author danpa
 */
public class GetAllRisksCommand implements Command
{

    PassengerRisk receiver;

    public GetAllRisksCommand(PassengerRisk passengerRisk_ByFlightHandler)
    {
        this.receiver = passengerRisk_ByFlightHandler;
    }

    @Override
    public Object execute()
    {
        return new GetRisksView(receiver.getRisks()).getRiskNames();
    }

}
