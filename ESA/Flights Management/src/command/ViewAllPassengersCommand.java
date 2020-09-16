/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.PassengerHandler;
import view.AllPassengersView;

/**
 *
 * @author Greg
 */
public class ViewAllPassengersCommand implements Command
{

    private PassengerHandler reciever;

    public ViewAllPassengersCommand(PassengerHandler reciever)
    {
        this.reciever = reciever;
    }

    public Object execute()
    {
        return new AllPassengersView(reciever.findAllPassengers()).alphabetise();
    }
}
