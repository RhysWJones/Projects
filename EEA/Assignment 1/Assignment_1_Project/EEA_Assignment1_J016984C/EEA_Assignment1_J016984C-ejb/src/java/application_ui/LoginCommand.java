/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_ui;

import ejb.UserHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class LoginCommand implements LoginCommandLocal
{
    private String email;
    private String password;
    
    @EJB
    private UserHandlerLocal userHandler;

    @Override
    public Object execute()
    {
        return userHandler.login(email, password);
    }

    @Override
    public void setEmail(String email)
    {
        this.email = email;
    }

    @Override
    public void setPassword(String password)
    {
        this.password = password;
    }
}
