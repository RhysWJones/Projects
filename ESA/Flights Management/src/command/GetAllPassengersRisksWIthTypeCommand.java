/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.PassengerRisk;
import view.AllPassengersRiskView;

/**
 *
 * @author danpa
 */
public class GetAllPassengersRisksWIthTypeCommand implements Command
{

    PassengerRisk receiver;
    int riskNum;

    public GetAllPassengersRisksWIthTypeCommand(PassengerRisk passengerRisk, int riskNum)
    {
        this.receiver = passengerRisk;
        this.riskNum = riskNum;
    }

    @Override
    public Object execute()
    {
        return new AllPassengersRiskView(receiver.findAllPassengersWithRiskType(riskNum)).print();
    }

}
