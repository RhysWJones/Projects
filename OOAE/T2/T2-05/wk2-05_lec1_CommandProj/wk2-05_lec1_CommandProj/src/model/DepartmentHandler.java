package model;

import database.DatabaseConnectionPool;
import database.Department;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DepartmentHandler
{
    private static final String FIND_ALL = "Select * from Dept";
    
    public ArrayList<Department> findAllDepartments()
    {
        ArrayList<Department> list = new ArrayList<>();
        
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();
        
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(FIND_ALL);
            
            while (rs.next())
            {
                Department dept = new Department(
                        rs.getInt("deptNo"),
                        rs.getString("dName"),
                        rs.getString("loc"));
                list.add(dept);
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
