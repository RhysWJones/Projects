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
public class GetAllFlightsStrings implements Command
{

    FlightHandler receiver;
    int flightnumber;

    public GetAllFlightsStrings(FlightHandler receiver, int integer)
    {
        this.receiver = receiver;
        this.flightnumber = integer;
    }

    public Object execute()
    {
        return new AllFlightsView(receiver.findSingleFlight(flightnumber)).getString();
    }

}
