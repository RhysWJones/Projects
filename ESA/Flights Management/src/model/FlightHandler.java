package model;

import builder.FlightBuilder;
import builder.PlaneBuilder;
import command.CommandFactory;
import database.DatabaseConnectionPool;
import database.Flight;
import database.FlightAndPassengers;
import database.Passenger;
import database.Plane;
import database.Seat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlightHandler
{

    private static final String FIND_ALL = "SELECT * FROM Flight LEFT JOIN Plane ON Flight.plane_ID = Plane.plane_ID  ORDER BY Flight.flight_ID, Plane.plane_ID";
    private static final String FIND_SINGLE = "SELECT * FROM Flight LEFT JOIN Plane ON Flight.plane_ID = Plane.plane_ID WHERE Flight.FLIGHT_ID = ? ORDER BY Flight.flight_ID, Plane.plane_ID";
//JOIN Seat ON Seat.flight_id = Flight.flight_ID

    public ArrayList<Flight> findAllFlights()
    {
        ArrayList<Flight> list = new ArrayList<>();

        int oldFlightNo = -1;
        FlightBuilder fBuilder = null;

        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();

        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(FIND_ALL);

            while (rs.next())
            {
                int flightID = rs.getInt("flight_id");
                if (flightID != oldFlightNo)
                {
                    if (fBuilder != null)
                    {
                        list.add(fBuilder.build());
                    }
                    fBuilder = new FlightBuilder()
                            .withID(flightID)
                            .withPlaneID(rs.getInt("plane_id"))
                            .toDestination(rs.getString("destination"))
                            .fromOrigin(rs.getString("origin"))
                            .atDepartureDate(rs.getDate("departure_date"))
                            .atArrivalDate(rs.getDate("arrival_date"))
                            //.atArrivalTime(rs.getDate("ARRIVAL_DATE"))
                            .atDepartureTime(rs.getTime("departure_time"));
                    oldFlightNo = flightID;
                }
//                int seatID = rs.getInt("seat_id");
//                if (seatID > 0)
//                {
//                    fBuilder.withSeats(new SeatBuilder()
//                            .withSeatID(seatID)
//                            .withFlightID(rs.getInt("flight_id"))
//                            .withSeatNumber(rs.getInt("seat_number"))
//                            .withSeatTaken(rs.getBoolean("seat_taken"))                                                        
//                            .build());
//                }
                int planeID = rs.getInt("plane_id");
                if (planeID > 0)
                {
                    fBuilder.withPlane(new PlaneBuilder()
                            .withPlaneID(planeID)
                            .withCapacity(rs.getInt("capacity"))
                            .withDesignation(rs.getString("designation"))
                            .withAirline(rs.getString("airline"))
                            .withEquipment(rs.getString("equipment"))
                            .build());
                }
            }
            if (fBuilder != null)
            {
                list.add(fBuilder.build());
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

    public ArrayList<Flight> findSingleFlight(int flightNumber)
    {
        ArrayList<Flight> list = new ArrayList<>();

        int oldFlightNo = -1;
        FlightBuilder fBuilder = null;

        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();

        try
        {
            PreparedStatement preparedStatement = con.prepareStatement(FIND_SINGLE);
            preparedStatement.setInt(1, flightNumber + 1);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next())
            {
                int flightID = rs.getInt("flight_id");
                if (flightID != oldFlightNo)
                {
                    if (fBuilder != null)
                    {
                        list.add(fBuilder.build());
                    }
                    fBuilder = new FlightBuilder()
                            .withID(flightID)
                            .withPlaneID(rs.getInt("plane_id"))
                            .toDestination(rs.getString("destination"))
                            .fromOrigin(rs.getString("origin"))
                            .atDepartureDate(rs.getDate("departure_date"))
                            .atArrivalDate(rs.getDate("ARRIVAL_DATE"))
                            .atArrivalTime(rs.getTime("ARRIVAL_TIME"))
                            .atDepartureTime(rs.getTime("departure_time"));
                    oldFlightNo = flightID;
                }
//                int seatID = rs.getInt("seat_id");
//                if (seatID > 0)
//                {
//                    fBuilder.withSeats(new SeatBuilder()
//                            .withSeatID(seatID)
//                            .withFlightID(rs.getInt("flight_id"))
//                            .withSeatNumber(rs.getInt("seat_number"))
//                            .withSeatTaken(rs.getBoolean("seat_taken"))                                                        
//                            .build());
//                }
                int planeID = rs.getInt("plane_id");
                if (planeID > 0)
                {
                    fBuilder.withPlane(new PlaneBuilder()
                            .withPlaneID(planeID)
                            .withCapacity(rs.getInt("capacity"))
                            .withDesignation(rs.getString("designation"))
                            .withAirline(rs.getString("airline"))
                            .withEquipment(rs.getString("equipment"))
                            .build());
                }
            }
            if (fBuilder != null)
            {
                list.add(fBuilder.build());
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

    public boolean addNewFlight(Flight newFlight)
    {
        boolean insertOK = false;
        try
        {
            DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
            Connection con = pool.getAvailableConnection();

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Flight (Plane_ID, Destination, Origin, Departure_time, Departure_date, ARRIVAL_TIME, ARRIVAL_DATE,MAX_RISK) VALUES (?,?,?,?,?,?,?,?)");

            stmt.setInt(1, newFlight.getPlaneID());
            stmt.setString(2, newFlight.getfDestination());
            stmt.setString(3, newFlight.getfOrigin());
            stmt.setTime(4, newFlight.getDepartureTime());
            stmt.setDate(5, newFlight.getDepartureDate());
            stmt.setTime(6, newFlight.getDepartureTime());
            stmt.setDate(7, newFlight.getArrivalDate());
            stmt.setInt(8, newFlight.getMaxRisk());

            int rows = stmt.executeUpdate();
            insertOK = rows == 1;

            stmt.close();
            pool.returnConnection(con);
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return insertOK;
    }

    public boolean addNewPlane(Plane newPlane)
    {
        boolean insertOK = false;
        try
        {
            DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
            Connection con = pool.getAvailableConnection();

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Plane (Designation, Capacity, Airline, Equipment) VALUES (?,?,?,?)");

            stmt.setString(1, newPlane.getDesignation());
            stmt.setInt(2, newPlane.getCapacity());
            stmt.setString(3, newPlane.getAirline());
            stmt.setString(4, newPlane.getEquipment());

            int rows = stmt.executeUpdate();
            insertOK = rows == 1;

            stmt.close();
            pool.returnConnection(con);
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return insertOK;
    }

    public ArrayList<Plane> getAllPlaneTypes()
    {
        ArrayList<Plane> planeTypes = new ArrayList<>();
        PlaneBuilder newPlane = null;
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();

        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PLANE");

            while (rs.next())
            {
                newPlane = new PlaneBuilder()
                        .withPlaneID(rs.getInt("PLANE_ID"))
                        .withDesignation(rs.getString("DESIGNATION"))
                        .withCapacity(rs.getInt("CAPACITY"))
                        .withAirline(rs.getString("AIRLINE"))
                        .withEquipment(rs.getString("EQUIPMENT"));
                planeTypes.add(newPlane.build());

            }

            rs.close();
            stmt.close();
            pool.returnConnection(con);
            return planeTypes;
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace(System.err);
            return planeTypes;
        }
    }

    public boolean addNewSeat(int flightID, int seatNumber, boolean seatTaken)
    {
        boolean insertOK = false;
        try
        {
            DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
            Connection con = pool.getAvailableConnection();

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Seat (Flight_ID, Seat_number, Seat_taken) VALUES (?,?,?)");

            stmt.setInt(1, flightID);
            stmt.setInt(2, seatNumber);
            stmt.setBoolean(3, seatTaken);

            int rows = stmt.executeUpdate();
            insertOK = rows == 1;

            stmt.close();
            pool.returnConnection(con);
        }
        catch (SQLException sqle)
        {
            System.out.println(sqle);
        }
        return insertOK;
    }

    public ArrayList<Passenger> viewPassengersOnFlight(int flightID)
    {
        ArrayList<Passenger> passengersOnFlight = new ArrayList();
        ArrayList<Seat> takenSeats = new ArrayList();
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();
        try
        {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM SEAT WHERE FLIGHT_ID = ? AND SEAT_TAKEN = TRUE");
            stmt.setInt(1, flightID + 1);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Seat seat = new Seat(rs.getInt("SEAT_ID"), rs.getInt("FLIGHT_ID"), rs.getInt("SEAT_NUMBER"), rs.getBoolean("SEAT_TAKEN"));
                takenSeats.add(seat);
            }

            for (Seat seat : takenSeats)
            {
                stmt = con.prepareStatement("SELECT * FROM BOOKING WHERE SEAT_ID = ?");
                stmt.setInt(1, seat.getSeatID());
                rs = stmt.executeQuery();

                while (rs.next())
                {

                    int passengerID = rs.getInt("PASSENGER_ID");

                    stmt = con.prepareStatement("SELECT * FROM PASSENGER WHERE PASSENGER_ID = ?");
                    stmt.setInt(1, passengerID);
                    rs = stmt.executeQuery();

                    while (rs.next())
                    {
                        Passenger passenger = new Passenger(rs.getInt("passenger_id"), rs.getString("forename"), rs.getString("surname"), rs.getDate("DOB"), rs.getString("nationality"), rs.getInt("passport_number"), rs.getBoolean("restricted"));
                        new PassengerHandler().addtRisksToPassenger(passenger);
                        // if (passenger.isIsRestricted()&& UserHandler.getInstance().getLoggedUser().isAuthenticated())
                        if (passenger.isIsRestricted())
                        {
                            passengersOnFlight.add(passenger);
                        }
                        // else if (passenger.isIsRestricted() && !(UserHandler.getInstance().getLoggedUser().isAuthenticated()))                        
                        else
                        {
                            passengersOnFlight.add(passenger);
                        }
                    }
                }
            }

            rs.close();
            stmt.close();
            pool.returnConnection(con);
        }
        catch (SQLException sqle)
        {
            System.out.println("Error\n" + sqle);
        }
        return passengersOnFlight;
    }

    public int getFlightsMaxRiskValue(int flightID)
    {
        int flightsMaxRiskValue = 0;
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        try
        {
            Connection con = pool.getAvailableConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM FLIGHT WHERE FLIGHT_ID = ?");

            stmt.setInt(1, flightID + 1);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                flightsMaxRiskValue = rs.getInt("MAX_RISK");
            }
            rs.close();
            stmt.close();
            pool.returnConnection(con);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(FlightHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return flightsMaxRiskValue;
    }

    public ArrayList<FlightAndPassengers> getFlightByMinRisk(int risk) {
        ArrayList<Flight> list = findAllFlights();     
  
        ArrayList<FlightAndPassengers> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            FlightAndPassengers newFlightAndPassengers = new FlightAndPassengers(list.get(i), viewPassengersOnFlight(i));
            if (newFlightAndPassengers.getTotalRiskScore() >= risk) {
                newList.add(newFlightAndPassengers);
            }
        }
        return newList;
    }
}
