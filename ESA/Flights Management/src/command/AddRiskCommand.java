/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import database.Risk;
import model.RiskHandler;

/**
 *
 * @author danpa
 */
public class AddRiskCommand implements Command
{

    RiskHandler reciever;
    Risk risk;

    public AddRiskCommand(RiskHandler riskHandler, Risk risk)
    {
        this.reciever = riskHandler;
        this.risk = risk;
    }

    @Override
    public Object execute()
    {
        return reciever.insertNewRiskValue(risk);
    }

}
