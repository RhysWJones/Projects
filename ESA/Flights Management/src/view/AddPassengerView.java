/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import builder.PassengerBuilder;
import database.Passenger;
import java.sql.Date;
import java.text.*;
import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class AddPassengerView
{

    PassengerBuilder pb = new PassengerBuilder();
    Scanner kybd = new Scanner(System.in);

    public Passenger print() throws ParseException
    {

        System.out.println("Enter Forename: ");

        pb.setPForename(kybd.next());

        System.out.println("");

        System.out.println("Enter Surname: ");

        pb.setPSurname(kybd.next());

        System.out.println("");

        System.out.println("Enter DOB(yyyy-mm-dd): ");

        String setString = kybd.next();

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = Date.valueOf(setString);

        pb.setPDOB(date);

        System.out.println("");

        System.out.println("Enter Nationality: ");

        pb.setPNationality(kybd.next());

        System.out.println("");

        System.out.println("Enter Passport Number: ");

        pb.setPPassportNumber(kybd.nextInt());

        System.out.println("");

        Passenger p = pb.build();

        return p;

    }
}
