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
public class GetAllPassengersByPassportNumCommand implements Command
{

    PassengerHandler receiver;
    int integer;

    public GetAllPassengersByPassportNumCommand(PassengerHandler passengerHandler, int integer)
    {
        this.receiver = passengerHandler;
        this.integer = integer;
    }

    @Override
    public Object execute()
    {
        return new GetAllPassengersByCriteriaView(receiver.GetAllPassengersByPassport(integer)).print();
    }
}
