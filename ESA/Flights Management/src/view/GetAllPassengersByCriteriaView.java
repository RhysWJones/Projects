/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.Passenger;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JLabel;

/**
 *
 * @author danpa
 */
public class GetAllPassengersByCriteriaView
{

    ArrayList<Passenger> passengers;

    public GetAllPassengersByCriteriaView(ArrayList<Passenger> passengers)
    {
        this.passengers = passengers;
    }

    public ArrayList<JLabel> getLabels()
    {
        ArrayList<JLabel> labels = new ArrayList<>();
        Collections.sort(passengers);

        passengers.forEach((passenger) ->
        {
            labels.add(new JLabel(passenger.getLabel()));
        });
        return labels;
    }

    public ArrayList<String> print()
    {
        ArrayList<String> labels = new ArrayList<>();
        passengers.forEach((passenger) ->
        {
            labels.add(passenger.toString());
        });
        return labels;
    }
}
