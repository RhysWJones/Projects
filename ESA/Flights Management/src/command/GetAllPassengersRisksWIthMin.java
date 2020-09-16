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
public class GetAllPassengersRisksWIthMin implements Command
{

    PassengerRisk receiver;
    int riskScore;

    public GetAllPassengersRisksWIthMin(PassengerRisk receiver, int riskScore)
    {
        this.receiver = receiver;
        this.riskScore = riskScore;
    }

    @Override
    public Object execute()
    {
        return new AllPassengersRiskView(receiver.findAllPassengersRisks(riskScore)).print();
    }

}
