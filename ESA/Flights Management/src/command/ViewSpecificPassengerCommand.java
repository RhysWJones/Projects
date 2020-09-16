/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.PassengerHandler;
import view.SpecificPassengerView;

/**
 *
 * @author Greg
 */
public class ViewSpecificPassengerCommand implements Command
{

    private PassengerHandler Receiver;

    public ViewSpecificPassengerCommand(PassengerHandler Receiver)
    {
        this.Receiver = Receiver;
    }

    @Override
    public Object execute()
    {
        SpecificPassengerView s = new SpecificPassengerView();
        return s.print(Receiver.findSpecificPassenger(s.input()));
    }

}
