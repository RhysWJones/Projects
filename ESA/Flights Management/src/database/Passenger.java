/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Greg
 */
public class Passenger implements Comparable
{

    private int PassengerID;
    private String Forename;
    private String Surname;
    private Date DOB;
    private String Nationality;
    private int PassportNumber;
    private boolean isRestricted;
    private ArrayList<Risk> risks = new ArrayList<Risk>();

    public Passenger()
    {
    }

    public Passenger(int PassengerID, String Forename, String Surname, Date DOB, String Nationality, int PassportNumber, boolean isRestricted)
    {
        this.PassengerID = PassengerID;
        this.Forename = Forename;
        this.Surname = Surname;
        this.DOB = DOB;
        this.Nationality = Nationality;
        this.PassportNumber = PassportNumber;
        this.isRestricted = isRestricted;
    }

    public Passenger(int PassengerID, String Forename, String Surname, Date DOB, String Nationality, int PassportNumber, boolean isRestricted, ArrayList<Risk> risks)
    {
        this.PassengerID = PassengerID;
        this.Forename = Forename;
        this.Surname = Surname;
        this.DOB = DOB;
        this.Nationality = Nationality;
        this.PassportNumber = PassportNumber;
        this.isRestricted = isRestricted;
        this.risks = risks;
    }

    public boolean isIsRestricted()
    {
        return isRestricted;
    }

    public void setIsRestricted(boolean isRestricted)
    {
        this.isRestricted = isRestricted;
    }

    public int getPassengerID()
    {
        return PassengerID;
    }

    public void setPassengerID(int PassengerID)
    {
        this.PassengerID = PassengerID;
    }

    public String getForename()
    {
        return Forename;
    }

    public void setForename(String Forename)
    {
        this.Forename = Forename;
    }

    public String getSurname()
    {
        return Surname;
    }

    public void setSurname(String Surname)
    {
        this.Surname = Surname;
    }

    public Date getDOB()
    {
        return DOB;
    }

    public void setDOB(Date DOB)
    {
        this.DOB = DOB;
    }

    public String getNationality()
    {
        return Nationality;
    }

    public void setNationality(String Nationality)
    {
        this.Nationality = Nationality;
    }

    public int getPassportNumber()
    {
        return PassportNumber;
    }

    public void setPassportNumber(int PassportNumber)
    {
        this.PassportNumber = PassportNumber;
    }

    public void addRisk(Risk risk)
    {
        this.risks.add(risk);
    }

    public ArrayList<Risk> getRisks()
    {
        return risks;
    }

    public int getRiskScore() {
        int total = 0;
        for (Risk risk : risks) {
            total += risk.getRiskScore();
        }
        return total;
    }

    public String getRiskString() {
        StringBuilder buff = new StringBuilder();
        int totalRiskScore = 0;
        for (Risk r : risks) {
            buff.append("\tRisk factor:  " + r.getRiskFactor() + "\tRisk score:  " + r.getRiskScore());
            totalRiskScore += r.getRiskScore();
        }
        buff.append("\n\tTotal risk scores: " + totalRiskScore);
        return buff.toString();
    }

    @Override
    public String toString() {

        return "PASSENGER" + "\n\tForename: \t" + Forename + "\n\tSurname: \t" + Surname + "\n\tDOB: \t" + DOB + "\n\tNationality: \t" + Nationality + "\n\tPassport num:  \t" + PassportNumber +"\n\tRisks: " + getRiskString() ;
    }

    public String getLabel()
    {
        StringBuilder buff = new StringBuilder();
        buff.append("<html><table>");
        buff.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "\tSurname: " + Surname, "\tForename: " + Forename));
        buff.append(String.format("<tr><td align='left'>%s</td><td>:</td><td>%s</td></tr>", "\tD-O-B: " + DOB, "\tNationality: " + Nationality));
        buff.append(String.format("<tr><td align='left'>%s</td><td></td></tr>", "\tPassPort number: " + PassportNumber));
        buff.append(String.format("<tr><td align='left'>%s</td><td></td><td>%s</td></tr>", "------------------------", "---------------------"));
        buff.append(String.format("<tr><td align='left'>%s</td><td></td></tr>", "\tRisks: " + getRiskString()));
        buff.append("</table></html>");
        return buff.toString();
    }

    @Override
    public int compareTo(Object t)
    {
        return this.Surname.compareTo(((Passenger) t).getSurname());
    }

}
