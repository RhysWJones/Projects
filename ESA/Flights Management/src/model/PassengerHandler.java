/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.*;
import java.sql.*;
import builder.*;
import java.util.ArrayList;

/**
 *
 * @author Greg
 */
public class PassengerHandler
{

    private String PassengerInfo;
    private final String add = "INSERT INTO PASSENGER (FORENAME, SURNAME, DOB, NATIONALITY, PASSPORT_NUMBER)VALUES (";
    private static final String FIND_ALL = "SELECT * FROM  PASSENGER ORDER BY PASSENGER.PASSENGER_ID";
    private static final String FIND_BY_SURNAME = "SELECT * FROM  PASSENGER WHERE SURNAME = ?";
    private static final String FIND_BY_PASSPORT_NUMBER = "SELECT * FROM  PASSENGER WHERE PASSPORT_NUMBER = ?";
    private static final String ORDER_BY = " ORDER BY PASSENGER.PASSENGER_ID";
    private static final String FIND_SPECIFIC = "SELECT * FROM PASSENGER WHERE (";

    public Boolean addPassenger(Passenger p)
    {
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();

        try
        {
            PassengerInfo = (p.toString());

            PreparedStatement stmt = con.prepareStatement(add + PassengerInfo + ")");
            stmt.execute();
            stmt.close();
            pool.returnConnection(con);
            return true;
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace(System.err);
            return false;
        }

    }

    public ArrayList<Passenger> findAllPassengers()
    {
        ArrayList<Passenger> list = new ArrayList<>();

        int oldPNum = -1;
        PassengerBuilder pb = null;

        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();

        try
        {
            PreparedStatement stmt = con.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int PassengerID = rs.getInt("PASSENGER_ID");
                if (PassengerID != oldPNum)
                {
                    if (pb != null)
                    {
                        list.add(pb.build());
                    }
                    pb = new PassengerBuilder();
                    pb.setPID(PassengerID);
                    pb.setPForename(rs.getString("FORENAME"));
                    pb.setPSurname(rs.getString("SURNAME"));
                    pb.setPDOB(rs.getDate("DOB"));
                    pb.setPNationality(rs.getString("NATIONALITY"));
                    pb.setPPassportNumber(rs.getInt("PASSPORT_NUMBER"));
                    oldPNum = PassengerID;
                }

            }
            if (pb != null)
            {
                Passenger p = pb.build();
                addtRisksToPassenger(p);
                list.add(p);
            }
            rs.close();
            stmt.close();
            pool.returnConnection(con);
            return list;
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace(System.err);
            return list;
        }
    }

    public void addtRisksToPassenger(Passenger passenger) throws SQLException
    {
        ArrayList<Risk> risks = new ArrayList();
        ArrayList<Integer> riskIDs = new ArrayList();
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM passenger_risk WHERE passenger_id = ?");
            stmt.setInt(1, passenger.getPassengerID());
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                riskIDs.add(rs.getInt("risk_id"));
            }

            for (int riskID : riskIDs)
            {
                stmt = con.prepareStatement("SELECT * FROM risk WHERE risk_id = ?");
                stmt.setInt(1, riskID);
                rs = stmt.executeQuery();

                while (rs.next())
                {
                    Risk risk = new Risk(rs.getInt("risk_id"), rs.getString("risk_desc"), rs.getInt("risk_score"));
                    risks.add(risk);
                    passenger.addRisk(risk);
                }
            }
            rs.close();
            stmt.close();
            pool.returnConnection(con);
        }
        catch (SQLException sqle)
        {
            System.out.println("ERROR\n" + sqle);
        }
    }

    public ArrayList<Passenger> GetAllPassengersBySurname(String surname)
    {
        ArrayList<Passenger> list = new ArrayList<>();

        int oldPNum = -1;
        PassengerBuilder pb = null;

        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();

        try
        {
            PreparedStatement preparedStatement = con.prepareStatement(FIND_BY_SURNAME);
            preparedStatement.setString(1, surname);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                int PassengerID = rs.getInt("PASSENGER_ID");
                if (PassengerID != oldPNum)
                {
                    if (pb != null)
                    {
                        list.add(pb.build());
                    }
                    pb = new PassengerBuilder();
                    pb.setPID(PassengerID);
                    pb.setPForename(rs.getString("FORENAME"));
                    pb.setPSurname(rs.getString("SURNAME"));
                    pb.setPDOB(rs.getDate("DOB"));
                    pb.setPNationality(rs.getString("NATIONALITY"));
                    pb.setPPassportNumber(rs.getInt("PASSPORT_NUMBER"));
                    oldPNum = PassengerID;
                }
            }
            if (pb != null)
            {
                list.add(pb.build());
            }
            rs.close();
            preparedStatement.close();
            pool.returnConnection(con);
            return list;
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace(System.err);
            return list;
        }
    }

    public ArrayList<Passenger> GetAllPassengersByPassport(int integer)
    {
        ArrayList<Passenger> list = new ArrayList<>();

        int oldPNum = -1;
        PassengerBuilder pb = null;

        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();

        try
        {
            PreparedStatement preparedStatement = con.prepareStatement(FIND_BY_PASSPORT_NUMBER);
            preparedStatement.setInt(1, integer);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                int PassengerID = rs.getInt("PASSENGER_ID");
                if (PassengerID != oldPNum)
                {
                    if (pb != null)
                    {
                        list.add(pb.build());
                    }
                    pb = new PassengerBuilder();
                    pb.setPID(PassengerID);
                    pb.setPForename(rs.getString("FORENAME"));
                    pb.setPSurname(rs.getString("SURNAME"));
                    pb.setPDOB(rs.getDate("DOB"));
                    pb.setPNationality(rs.getString("NATIONALITY"));
                    pb.setPPassportNumber(rs.getInt("PASSPORT_NUMBER"));
                    oldPNum = PassengerID;
                }
            }
            if (pb != null)
            {
                list.add(pb.build());
            }
            rs.close();
            preparedStatement.close();
            pool.returnConnection(con);
            return list;
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace(System.err);
            return list;
        }
    }

    public ArrayList<Passenger> findSpecificPassenger(Passenger p)
    {
        ArrayList<Passenger> list = new ArrayList<>();

        int oldPNum = -1;
        PassengerBuilder pb = null;

        String SearchCriteria = null;
        if (p.getPassengerID() == 0)
        {
            SearchCriteria = "PASSENGER_ID = " + p.getPassengerID() + " AND ";
        }
        else if (p.getForename() == null)
        {
            SearchCriteria = "FORENAME = '" + p.getForename() + "' AND ";
        }
        else if (p.getSurname() == null)
        {
            SearchCriteria = "SURNAME = '" + p.getSurname() + "' AND ";
        }
        else if (p.getDOB() == null)
        {
            SearchCriteria = "DOB = '" + p.getDOB() + "' AND ";
        }
        else if (p.getNationality() == null)
        {
            SearchCriteria = "NATIONALITY = " + p.getNationality() + "' AND ";
        }
        else if (p.getPassportNumber() == 0)
        {
            SearchCriteria = "PASSPORT_NUMBER = " + p.getPassportNumber();
        }
        if (SearchCriteria.endsWith(" AND "))
        {
            SearchCriteria = SearchCriteria.substring(5);
        }

        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();

        if (SearchCriteria == null)
        {
            return null;
        }
        else
        {
            SearchCriteria = SearchCriteria + ")" + ORDER_BY;
        }

        try
        {
            PreparedStatement stmt = con.prepareStatement(FIND_SPECIFIC + SearchCriteria);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                int PassengerID = rs.getInt("PASSENGER_ID");
                if (PassengerID != oldPNum)
                {
                    if (pb != null)
                    {
                        list.add(pb.build());
                    }
                    pb = new PassengerBuilder();
                    pb.setPID(PassengerID);
                    pb.setPForename(rs.getString("FORENAME"));
                    pb.setPSurname(rs.getString("SURNAME"));
                    pb.setPDOB(rs.getDate("DOB"));
                    pb.setPNationality(rs.getString("NATIONALITY"));
                    pb.setPPassportNumber(rs.getInt("PASSPORT_NUMBER"));
                    oldPNum = PassengerID;
                }

            }
            if (pb != null)
            {
                Passenger pas = pb.build();
                addtRisksToPassenger(pas);
                list.add(pas);
            }
            rs.close();
            stmt.close();
            pool.returnConnection(con);
            return list;
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace(System.err);
            return list;
        }
    }

    public String checkPassengerRiskLevel(Passenger passenger, int maxRiskValue)
    {
        String riskLevel = "Green";
        int totalRiskScore = 0;
        System.out.println(passenger.toString());
        for (Risk risk : passenger.getRisks())
        {
            totalRiskScore += risk.getRiskScore();
        }

        if (totalRiskScore < (maxRiskValue / 2))
        {
            riskLevel = "Green";
        }
        else if (totalRiskScore >= (maxRiskValue / 2) && totalRiskScore < maxRiskValue)
        {
            riskLevel = "Amber";
        }
        else if (totalRiskScore >= maxRiskValue)
        {
            riskLevel = "Red";
        }
        return riskLevel;
    }
}
