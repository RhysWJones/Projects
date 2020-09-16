package Source;

import DTO.DeptDTO;
import Manager.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbSource implements Source
{

    public DbSource(String username, String password)
    {
        DatabaseManager.getInstance().setUsername(username);
        DatabaseManager.getInstance().setPassword(password);
    }

    @Override
    public ArrayList<DeptDTO> getAllDepartments() throws SQLException
    {

        Connection connection = DatabaseManager.getInstance().getConnection();
        ArrayList<DeptDTO> departments = new ArrayList<>();

        PreparedStatement stmt = connection.prepareStatement("SELECT * from Dept");
        ResultSet rs = stmt.executeQuery();

        while (rs.next())
        {
            DeptDTO department = new DeptDTO(rs.getInt("DEPTNO"), rs.getString("DNAME"), rs.getString("LOC"));
            departments.add(department);
        }

        rs.close();
        stmt.close();
        connection.close();

        return departments;
    }

    @Override
    public boolean insertDepartment(DeptDTO dept) throws SQLException
    {
        boolean insertOK = false;

        Connection connection = DatabaseManager.getInstance().getConnection();

        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Dept VALUES (?, ?, ?)");
        stmt.setInt(1, dept.getDepartmentNumber());
        stmt.setString(2, dept.getDepartmentName());
        stmt.setString(3, dept.getDepartmentLocation());
        int rows = stmt.executeUpdate();

        insertOK = rows == 1;

        stmt.close();
        connection.close();

        return insertOK;
    }

    @Override
    public boolean deleteDepartment(DeptDTO dept) throws SQLException
    {
        try
        {
            Connection connection = DatabaseManager.getInstance().getConnection();
            try
            {
                PreparedStatement stmt = connection.prepareStatement("DELETE FROM Dept WHERE deptno = ?");
                stmt.setInt(1, dept.getDepartmentNumber());
                stmt.executeUpdate();

                stmt.close();
                connection.close();
            }
            catch (SQLException sqle)
            {
                throw (sqle);
            }
        }
        catch (SQLException sqle)
        {
            throw (sqle);
        }
        return true;
    }

}
