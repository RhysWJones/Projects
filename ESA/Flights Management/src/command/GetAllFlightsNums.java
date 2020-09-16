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
public class GetAllFlightsNums implements Command
{

    FlightHandler receiver;

    public GetAllFlightsNums(FlightHandler flightHandler)
    {
        this.receiver = flightHandler;
    }

    @Override
    public Object execute()
    {
        return new AllFlightsView(receiver.findAllFlights()).getFlightNames();
    }

}
