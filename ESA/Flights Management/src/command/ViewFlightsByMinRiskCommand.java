/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.FlightHandler;
import view.AllFlightsView;

/**
 *
 * @author danpa
 */
public class ViewFlightsByMinRiskCommand implements Command {
int risk;
FlightHandler reciever;

    public ViewFlightsByMinRiskCommand( FlightHandler reciever,int risk) {
        this.risk = risk;
        this.reciever = reciever;
    }    

    @Override
    public Object execute() {
        return reciever.getFlightByMinRisk(risk);
    }    
}
