/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;

/**
 *
 * @author danpa
 */
public class FlightAndPassengers {
    Flight flight;
    ArrayList<Passenger> passengers;
    int totalRisk;

    public FlightAndPassengers(Flight flight, ArrayList<Passenger> passengers) {
        this.flight = flight; 
        this.passengers = passengers;
        totalRisk = getTotalRiskScore();
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getTotalRisk() {
        return totalRisk;
    }

    public void setTotalRisk(int totalRisk) {
        this.totalRisk = totalRisk;
    }

    public int getTotalRiskScore() {
        int risk = 0;
        for (Passenger passenger : passengers) {
            risk += passenger.getRiskScore();
        }
        return risk;
    }

    @Override
    public String toString() {
        String string = flight.toString();
        for (Passenger passenger : passengers) {
            string += "\n" + passenger.toString();
        }
        return string;
    }

    public String toStringRiskyPassengers() {
        String string = flight.toString();
        for (Passenger passenger : passengers) {
            if (passenger.getRiskScore() > 0) {
                string += "Total Flight Risk: " + totalRisk + "\n\n" + passenger.toString();

            }
        }
        return string;
    }

}
