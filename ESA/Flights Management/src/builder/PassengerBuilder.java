/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import database.Passenger;
import java.sql.Date;

/**
 *
 * @author Greg
 */
public class PassengerBuilder
{

    private final Passenger p = new Passenger();

    public void setPID(int id)
    {
        p.setPassengerID(id);
    }

    public void setPForename(String fn)
    {
        p.setForename(fn);
    }

    public void setPSurname(String sn)
    {
        p.setSurname(sn);
    }

    public void setPDOB(Date DOB)
    {
        p.setDOB(DOB);
    }

    public void setPNationality(String n)
    {
        p.setNationality(n);
    }

    public void setPPassportNumber(int pn)
    {
        p.setPassportNumber(pn);
    }

    public void setIsRestricted(boolean r)
    {
        p.setIsRestricted(r);
    }

    public Passenger build()
    {
        return p;
    }

}
