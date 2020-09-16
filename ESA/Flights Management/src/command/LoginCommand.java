/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import database.Admin;
import model.AdminHandler;

/**
 *
 * @author Greg
 */
public class LoginCommand implements Command
{

    private AdminHandler adminHandler;
    private Admin admin;

    public LoginCommand(Admin a)
    {
        this.adminHandler = new AdminHandler();
        this.admin = a;
    }

    @Override
    public Object execute()
    {
        return adminHandler.checkDetails(admin);
    }

}
