/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Admin;
import database.DatabaseConnectionPool;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Base64;

/**
 *
 * @author Greg
 */
public class AdminHandler
{

    public static String FIND_USER = "SELECT * FROM USERS WHERE (USERNAME = ? AND PASSWORD = ?)";

    public String encrypt(String Password)
    {
        try
        {
            byte[] hash = MessageDigest
                    .getInstance("SHA-256")
                    .digest(Password.getBytes(StandardCharsets.UTF_8));

            Password = Base64.getEncoder().encodeToString(hash);

        }
        catch (NoSuchAlgorithmException e)
        {
            Password = "";
        }

        return Password;
    }

    public Admin checkDetails(Admin a)
    {
        DatabaseConnectionPool pool = DatabaseConnectionPool.getInstance();
        Connection con = pool.getAvailableConnection();

        try
        {
            Admin fullAdmin = new Admin();
            PreparedStatement stmt = con.prepareStatement(FIND_USER);
            stmt.setString(1, a.getUsername());
            stmt.setString(2, encrypt(a.getPassword()));
            ResultSet rs = stmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next())
            {
                fullAdmin.setUserID(rs.getInt("USER_ID"));
                fullAdmin.setUsername(rs.getString("USERNAME"));
                fullAdmin.setPassword(rs.getString("PASSWORD"));
                fullAdmin.setAuthenticated(rs.getBoolean("AUTHENTICATED"));
            }
            rs.close();
            stmt.close();
            pool.returnConnection(con);
            return fullAdmin;
        }
        catch (SQLException sqle)
        {
            sqle.printStackTrace(System.err);
            return null;
        }

    }

    public boolean checkAuthenticated(Admin a)
    {
        return a.isAuthenticated();
    }
}
