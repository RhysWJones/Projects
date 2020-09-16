/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import database.Passenger;
import model.PassengerHandler;

/**
 *
 * @author Greg
 */
public class AddPassengerCommand implements Command
{

    public PassengerHandler Receiver;
    public Passenger p;

    AddPassengerCommand(PassengerHandler Receiver, Passenger p)
    {
        this.Receiver = Receiver;
        this.p = p;
    }

    @Override
    public Object execute()
    {
        return Receiver.addPassenger(p);

    }

}
