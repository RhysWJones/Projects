package model;

import database.DatabaseConnectionPool;
import Employee.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public class EmployeeHandler
{
    private static final String FIND_ALL = "Select * from Emp";
    
    public ArrayList<Employee> findAllEmployees()
    {
        ArrayList<Employee> list = new ArrayList<>();
        
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();
        
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(FIND_ALL);
            
            while (rs.next())
            {
                Employee emp = new Employee(
                        rs.getInt("empNo"),
                        rs.getString("eName"),
                        rs.getString("job"),
                        rs.getInt("mgr"),
                        rs.getDate("hireDate"),
                        rs.getInt("sal"),
                        rs.getInt("comm"),
                        rs.getInt("deptNo"));
                list.add(emp);
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
