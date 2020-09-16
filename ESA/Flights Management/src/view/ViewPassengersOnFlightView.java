/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.Passenger;
import java.util.ArrayList;
import model.FlightHandler;
import model.PassengerHandler;

/**
 *
 * @author danpa
 */
public class ViewPassengersOnFlightView
{

    ArrayList<Passenger> viewPassengersOnFlight;
    int flightsMaxRiskValue;
    StringBuilder builder = new StringBuilder();

    public ViewPassengersOnFlightView(int flightID, ArrayList<Passenger> viewPassengersOnFlight)
    {
        this.viewPassengersOnFlight = viewPassengersOnFlight;
        flightsMaxRiskValue = new FlightHandler().getFlightsMaxRiskValue(flightID);

    }

    @Override
    public String toString()
    {
        for (Passenger passenger : viewPassengersOnFlight)
        {
            String passengerRiskLevel = new PassengerHandler().checkPassengerRiskLevel(passenger, flightsMaxRiskValue);

            builder.append(passenger.toString());
            System.out.println("RISK NUMBER " + passenger.getRisks().size());
            builder.append("\n" + passenger.getRisks().toString());
            builder.append("\nRISK LEVEL: " + passengerRiskLevel);

            if (passengerRiskLevel.equalsIgnoreCase("red"))
            {
                builder.append("\nWARNING: PASSENGER CANNOT FLY / ALERT AUTHORITIES");
            }
            builder.append("\n\n");
        }
        return builder.toString();
    }
}
