package model;

import database.DatabaseConnectionPool;
import database.Risk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESA
 */
public class RiskHandler
{
//    public ArrayList<Passenger> checkAllRisksOnFlight(int FlightID)
//    {
//        ArrayList<Passenger> passengersOnFlight = new FlightHandler().viewPassengersOnFlight(FlightID);
//        
//        for(Passenger passenger : passengersOnFlight)
//        {
//            try
//            {
//                getRisksForPassenger(passenger);
//            } 
//            catch (SQLException ex)
//            {
//                Logger.getLogger(RiskHandler.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//        return passengersOnFlight;
//    }

    public boolean insertNewRiskValue(Risk newRisk)
    {
        boolean insertOK = false;
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO RISK(RISK_DESC, RISK_SCORE) VALUES(?, ?)");
            stmt.setString(1, newRisk.getRiskFactor());
            stmt.setInt(2, newRisk.getRiskScore());

            int rows = stmt.executeUpdate();

            insertOK = rows == 1;
            stmt.close();
            pool.returnConnection(con);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(RiskHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return insertOK;
    }
}
