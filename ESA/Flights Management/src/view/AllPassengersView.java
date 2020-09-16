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
 * @author Greg
 */
public class AllPassengersView
{

    private ArrayList<Passenger> AllPassengers;

    public AllPassengersView(ArrayList<Passenger> AllPassengers)
    {
        this.AllPassengers = AllPassengers;
    }

    public String print()
    {
        System.out.println("All Flights\n");
        for (Passenger p : AllPassengers)
        {

            System.out.println("Passenger ID: " + p.getPassengerID()
                    + "\tForename: " + p.getForename()
                    + "\tSurname: " + p.getSurname()
                    + "\tDate of Birth: " + p.getDOB()
                    + "\tNationality: " + p.getNationality()
                    + "\tPassport Number: " + p.getPassportNumber() + "\n");
        }
        return "Test";
    }

    public ArrayList<JLabel> alphabetise()
    {
        ArrayList<JLabel> labels = new ArrayList<>();
        Collections.sort(AllPassengers);
        char alphabet = 'A';
        String buff = "";
        for (int i = 0; i < AllPassengers.size(); i++)
        {
            if (alphabet == Character.toUpperCase(AllPassengers.get(i).getSurname().charAt(0)))
            {
                buff += (AllPassengers.get(i).getLabel());
                System.out.println(buff.toString());
            }
            else
            {
                labels.add(new JLabel("<html><table>" + buff.toString() + "</table></html>"));
                buff = "";
                //buff +=( AllPassengers.get(i).getLabel());
                // System.out.println(buff.toString()); 
                alphabet++;
            }
        }

        return labels;
    }

}
