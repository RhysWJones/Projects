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
public class RegisterCommand implements RegisterCommandLocal
{
    private UserDTO registeringUserDTO;
    
    @EJB
    private UserHandlerLocal userHandler;

    @Override
    public void setRegisteringUserDTO(UserDTO registeringUserDTO)
    {
        this.registeringUserDTO = registeringUserDTO;
    }

    @Override
    public Object execute()
    {
        return userHandler.register(registeringUserDTO);
    }
}
