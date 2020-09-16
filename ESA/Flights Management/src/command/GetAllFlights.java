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
public class GetAllFlights implements Command {
FlightHandler receiver;

    public GetAllFlights(FlightHandler flightHandler) {
        this.receiver = receiver;
    }

    public Object execute()
    {
        return receiver.findAllFlights();
    }
    
}
