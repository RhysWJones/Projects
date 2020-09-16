/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.PassengerHandler;
import view.GetAllPassengersByCriteriaView;

/**
 *
 * @author danpa
 */
public class GetAllPassengersBySurnameCommand implements Command
{

    PassengerHandler receiver;
    String string;

    public GetAllPassengersBySurnameCommand(PassengerHandler receiver, String string)
    {
        this.receiver = receiver;
        this.string = string;
    }

    @Override
    public Object execute()
    {
        return new GetAllPassengersByCriteriaView(receiver.GetAllPassengersBySurname(string)).print();
    }
}
