/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import database.UserGatewayLocal;
import dto.UserDTO;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class UserHandler implements UserHandlerLocal
{
    @EJB
    UserGatewayLocal userTable;

    @Override
    public UserDTO login(String email, String password)
    {
        return userTable.login(email, password);
    }

    @Override
    public boolean register(UserDTO registeringUserDTO)
    {
        return userTable.registerNewUser(registeringUserDTO);
    }

    @Override
    public UserDTO updateAccountDetails(UserDTO user, String oldPassword, String oldEmail)
    {
        return userTable.updateAccountDetails(user, oldPassword, oldEmail);
    }

    @Override
    public boolean deleteAccount(UserDTO user)
    {
        return userTable.deleteAccount(user);
    }

    @Override
    public UserDTO assignRouteToDriver(UserDTO user, int routeId)
    {
        return userTable.assignRouteToDriver(user, routeId);
    }
}
