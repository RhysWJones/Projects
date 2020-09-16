/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import view.ViewPassengersOnFlightView;
import model.FlightHandler;

/**
 *
 * @author danpa
 */
public class ViewPassengersOnFlightCommand implements Command
{

    FlightHandler flightHandler;
    int integer;

    public ViewPassengersOnFlightCommand(FlightHandler flightHandler, int integer)
    {
        this.flightHandler = flightHandler;
        this.integer = integer;
    }

    @Override
    public Object execute()
    {
        return new ViewPassengersOnFlightView(integer, flightHandler.viewPassengersOnFlight(integer)).toString();
    }

}
