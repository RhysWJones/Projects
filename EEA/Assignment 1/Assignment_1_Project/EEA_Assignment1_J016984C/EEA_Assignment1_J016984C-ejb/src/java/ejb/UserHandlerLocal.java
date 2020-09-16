/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.UserDTO;
import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface UserHandlerLocal
{

    UserDTO login(String email, String password);

    boolean register(UserDTO registeringUserDTO);

    UserDTO updateAccountDetails(UserDTO user, String oldPassword, String oldEmail);

    boolean deleteAccount(UserDTO user);

    UserDTO assignRouteToDriver(UserDTO user, int routeId);
    
}
