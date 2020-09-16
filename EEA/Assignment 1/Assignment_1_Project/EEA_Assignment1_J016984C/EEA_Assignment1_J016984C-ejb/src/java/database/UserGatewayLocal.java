/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import dto.UserDTO;
import entity.Users;
import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface UserGatewayLocal
{
    UserDTO login(String email, String password);

    boolean registerNewUser(UserDTO registeringUserDTO);

    UserDTO updateAccountDetails(UserDTO user, String oldPassword, String oldEmail);

    boolean deleteAccount(UserDTO user);

    UserDTO assignRouteToDriver(UserDTO user, int routeId);
    
}
