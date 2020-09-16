/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_ui;

import dto.UserDTO;
import ejb.UserHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class UpdateAccountDetailsCommand implements UpdateAccountDetailsCommandLocal
{
    @EJB
    private UserHandlerLocal userHandler;
    private UserDTO user;
    private String oldPassword;
    private String oldEmail;

    @Override
    public Object execute()
    {
        return userHandler.updateAccountDetails(user, oldPassword, oldEmail);
    }

    @Override
    public void setUser(UserDTO user)
    {
        this.user = user;
    }

    @Override
    public void setOldPassword(String oldPassword)
    {
        this.oldPassword = oldPassword;
    }

    @Override
    public void setOldEmail(String oldEmail)
    {
        this.oldEmail = oldEmail;
    }
    
}
