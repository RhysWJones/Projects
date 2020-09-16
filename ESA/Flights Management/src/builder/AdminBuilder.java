/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import database.Admin;

/**
 *
 * @author Greg
 */
public class AdminBuilder
{

    private Admin a = new Admin();

    public void setID(int id)
    {
        a.setUserID(id);
    }

    public void setUName(String un)
    {
        a.setUsername(un);
    }

    public void setPword(String pw)
    {
        a.setPassword(pw);
    }

    public void setAuth(boolean auth)
    {
        a.setAuthenticated(auth);
    }

    public Admin build()
    {
        return a;
    }
}
