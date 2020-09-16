package model;

import builder.FlightBuilder;
import builder.PassengerBuilder;
import builder.PassengerRisk_ByFlightBuilder;
import builder.RiskBuilder;
import database.DatabaseConnectionPool;
import database.PassengerRisk_ByFlight;
import database.Risk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Krzychu-x
 */
public class PassengerRisk
{

    private static final String FIND_ALL = "SELECT * FROM Passenger_Risk LEFT JOIN Risk ON Passenger_Risk.Risk_ID = Risk.Risk_ID JOIN Passenger ON Passenger.Passenger_ID = Passenger_Risk.Passenger_ID JOIN Booking ON Booking.Passenger_ID = Passenger.Passenger_ID JOIN Seat ON Seat.Seat_ID = Booking.Seat_ID ORDER BY Passenger.Passenger_ID, Risk.Risk_ID";
    //private static final String FIND_ALL_WITH_MIN = "SELECT * FROM Passenger_Risk LEFT JOIN Risk ON Passenger_Risk.Risk_ID = Risk.Risk_ID JOIN Passenger ON Passenger.Passenger_ID = Passenger_Risk.Passenger_ID JOIN Booking ON Booking.Passenger_ID = Passenger.Passenger_ID JOIN Seat ON Seat.Seat_ID = Booking.Seat_ID where RISK_SCORE > ? ORDER BY Passenger.Passenger_ID, Risk.Risk_ID";
    private static final String FIND_ALL_RISKS = "SELECT * FROM RISK";
    private static final String FIND_RISKS_WITH_TYPE = "SELECT * FROM Passenger_Risk LEFT JOIN Risk ON Passenger_Risk.Risk_ID = Risk.Risk_ID JOIN Passenger ON Passenger.Passenger_ID = Passenger_Risk.Passenger_ID JOIN Booking ON Booking.Passenger_ID = Passenger.Passenger_ID JOIN Seat ON Seat.Seat_ID = Booking.Seat_ID WHERE passenger_Risk.RISK_ID =? ORDER BY Passenger.Passenger_ID, Risk.Risk_ID";

    public ArrayList<Risk> getRisks()
    {
        ArrayList<Risk> list = new ArrayList();

        RiskBuilder riskBuilder = null;

        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();

        PreparedStatement preparedStatement = null;

        ResultSet rs = null;
        try
        {
            preparedStatement = con.prepareStatement(FIND_ALL_RISKS);
            rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                riskBuilder = new RiskBuilder()
                        .withRiskID(rs.getInt("RISK_ID"))
                        .withRiskFactor(rs.getString("RISK_DESC"))
                        .withRiskScore(rs.getInt("RISK_SCORE"));
                list.add(riskBuilder.build());
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

    public ArrayList<PassengerRisk_ByFlight> findAllPassengersWithRiskType(int type)
    {
        ArrayList<PassengerRisk_ByFlight> list = new ArrayList<>();

        int oldPassengerID_No = -1;
        PassengerRisk_ByFlightBuilder riskBuilder = null;
        PassengerBuilder passengerBuilder = null;
        FlightBuilder flightBuilder = null;

        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();

        try
        {

            PreparedStatement preparedStatement = null;

            ResultSet rs = null;

            preparedStatement = con.prepareStatement(FIND_RISKS_WITH_TYPE);
            preparedStatement.setInt(1, type + 1);
            rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                int passengerID = rs.getInt("Passenger_ID");
                String passengerForname = rs.getString("FORENAME");
                String passengerSurname = rs.getString("Surname");
                int flightID = rs.getInt("Flight_ID");
                if (passengerID != oldPassengerID_No)
                {
                    if (riskBuilder != null)
                    {
                        list.add(riskBuilder.build());
                    }
                    passengerBuilder = new PassengerBuilder();
                    passengerBuilder.setPID(passengerID);
                    passengerBuilder.setPForename(passengerForname);
                    passengerBuilder.setPSurname(passengerSurname);

                    flightBuilder = new FlightBuilder();
                    flightBuilder.withID(flightID);

                    riskBuilder = new PassengerRisk_ByFlightBuilder()
                            .withPassID(passengerBuilder.build())
                            .withFlightID(flightBuilder.build());

                    oldPassengerID_No = passengerID;
                }
                int riskID = rs.getInt("risk_ID");
                if (riskID > 0)
                {
                    riskBuilder.withRisks(new RiskBuilder()
                            .withRiskID(riskID)
                            .withRiskFactor(rs.getString("RISK_DESC"))
                            .withRiskScore(rs.getInt("Risk_Score"))
                            .build());
                }

            }
            if (riskBuilder != null)
            {
                list.add(riskBuilder.build());
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

    public ArrayList<PassengerRisk_ByFlight> findAllPassengersRisks(int min)
    {
        ArrayList<PassengerRisk_ByFlight> list = new ArrayList<>();

        int oldPassengerID_No = -1;
        PassengerRisk_ByFlightBuilder riskBuilder = null;
        PassengerBuilder passengerBuilder = null;
        FlightBuilder flightBuilder = null;

        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();

        try
        {

            PreparedStatement preparedStatement = null;

            ResultSet rs = null;

            preparedStatement = con.prepareStatement(FIND_ALL);
            rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                int passengerID = rs.getInt("Passenger_ID");
                String passengerForname = rs.getString("FORENAME");
                String passengerSurname = rs.getString("Surname");
                int flightID = rs.getInt("Flight_ID");
                if (passengerID != oldPassengerID_No)
                {
                    if (riskBuilder != null)
                    {
                        if (riskBuilder.build().getTotalRiskScore() >= min)
                        {
                            list.add(riskBuilder.build());

                        }
                    }
                    passengerBuilder = new PassengerBuilder();
                    passengerBuilder.setPID(passengerID);
                    passengerBuilder.setPForename(passengerForname);
                    passengerBuilder.setPSurname(passengerSurname);

                    flightBuilder = new FlightBuilder();
                    flightBuilder.withID(flightID);

                    riskBuilder = new PassengerRisk_ByFlightBuilder()
                            .withPassID(passengerBuilder.build())
                            .withFlightID(flightBuilder.build());

                    oldPassengerID_No = passengerID;
                }
                int riskID = rs.getInt("risk_ID");
                if (riskID > 0)
                {
                    riskBuilder.withRisks(new RiskBuilder()
                            .withRiskID(riskID)
                            .withRiskFactor(rs.getString("RISK_DESC"))
                            .withRiskScore(rs.getInt("Risk_Score"))
                            .build());
                }

            }
            if (riskBuilder != null)
            {

                if (riskBuilder.build().getTotalRiskScore() >= min)
                {
                    list.add(riskBuilder.build());

                }
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

}
