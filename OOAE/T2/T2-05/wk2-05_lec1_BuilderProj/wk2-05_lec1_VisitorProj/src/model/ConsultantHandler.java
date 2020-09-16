package model;

import builder.ConsultantBuilder;
import database.Consultant;
import database.DatabaseConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public class ConsultantHandler 
{
    private static final String FIND_ALL = "Select * from Consultant";
    
    public ArrayList<Consultant> findAllConsultants()
    {
        ArrayList<Consultant> list = new ArrayList<>();
        
        int oldConNo = -1;
        ConsultantBuilder cBuilder = null;
        
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();
        
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(FIND_ALL);
            
            while (rs.next())
            {
                int conNo = rs.getInt("CON_ID");
                if (conNo != oldConNo)
                {
                    if (cBuilder != null)
                    {
                        list.add(cBuilder.build());
                    }
                    cBuilder = new ConsultantBuilder()
                            .withId(conNo)
                            .withName(rs.getString("NAME"))
                            .withPrice(rs.getInt("PRICE"));
                    oldConNo = conNo;
                }
            }
            if (cBuilder != null)
            {
                list.add(cBuilder.build());
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
}
