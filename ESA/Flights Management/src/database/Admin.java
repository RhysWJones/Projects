/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Greg
 */
public class Admin
{

    private int UserID;
    private String Username;
    private String Password;
    private boolean Authenticated;

    public Admin()
    {
        this.UserID = 0;
        this.Username = null;
        this.Password = null;
        this.Authenticated = false;
    }

    public Admin(String Username, String Password)
    {
        this.Username = Username;
        this.Password = Password;
    }

    public int getUserID()
    {
        return UserID;
    }

    public void setUserID(int UserID)
    {
        this.UserID = UserID;
    }

    public String getUsername()
    {
        return Username;
    }

    public void setUsername(String Username)
    {
        this.Username = Username;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String Password)
    {
        this.Password = Password;
    }

    public boolean isAuthenticated()
    {
        return Authenticated;
    }

    public void setAuthenticated(boolean Authenticated)
    {
        this.Authenticated = Authenticated;
    }

    @Override
    public String toString()
    {
        return "Admin{" + "UserID=" + UserID + ", Username=" + Username + ", Password=" + Password + ", Authenticated=" + Authenticated + '}';
    }

}
