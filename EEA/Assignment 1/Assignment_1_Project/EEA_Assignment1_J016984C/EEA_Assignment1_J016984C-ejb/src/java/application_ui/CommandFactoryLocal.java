/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_ui;

import dto.UserDTO;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface CommandFactoryLocal
{

    Command createCommand(int commandType, String email, String password);

    Command createCommand(int commandType, UserDTO userDTO);

    Command createCommand(int commandType, int entityId);

    Command createCommand(int commandType, int deliveryId, Date date);

    Command createCommand(int commandType, UserDTO user, String oldPassword, String oldEmail);

    Command createCommand(int commandType);

    Command createCommand(int commandType, UserDTO user, int entityId);

    Command createCommand(int commandType, int entityId, int secondEntityId);
    
}
