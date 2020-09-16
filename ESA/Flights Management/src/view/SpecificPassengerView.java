/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import builder.PassengerBuilder;
import database.Passenger;
import static java.lang.Integer.parseInt;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class SpecificPassengerView
{

    Scanner kybd = new Scanner(System.in);
    PassengerBuilder pb = new PassengerBuilder();

    public Passenger input()
    {
        System.out.println("Enter Passport Number: ");

        int i = 0;

        try
        {
            i = parseInt(kybd.nextLine());
        }
        catch (Exception e)
        {
        }
        finally
        {
            pb.setPID(i);
        }

        System.out.println("Enter Forename: ");

        pb.setPForename(kybd.nextLine());

        System.out.println("");

        System.out.println("Enter Surname: ");

        pb.setPSurname(kybd.nextLine());

        System.out.println("");

        System.out.println("Enter DOB(yyyy-mm-dd): ");

        String setString = kybd.nextLine();

        Date date = null;

        try
        {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = Date.valueOf(setString);
        }
        catch (Exception e)
        {
        }
        finally
        {

            pb.setPDOB(date);
        }
        System.out.println("");

        System.out.println("Enter Nationality: ");

        pb.setPNationality(kybd.nextLine());

        System.out.println("");

        System.out.println("Enter Passport Number: ");

        try
        {
            i = parseInt(kybd.nextLine());
        }
        catch (Exception e)
        {
            i = -1;
        }
        finally
        {
            pb.setPPassportNumber(i);
        }

        System.out.println("");

        Passenger p = pb.build();

        return p;
    }

    public String print(ArrayList<Passenger> AllPassengers)
    {

        System.out.println("Passengers\n");
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
}
