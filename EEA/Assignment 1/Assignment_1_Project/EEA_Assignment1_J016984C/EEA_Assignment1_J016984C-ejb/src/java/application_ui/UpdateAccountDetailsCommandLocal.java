/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_ui;

import dto.UserDTO;
import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface UpdateAccountDetailsCommandLocal extends Command
{
    @Override
    public Object execute();
    void setUser(UserDTO user);
    void setOldPassword(String oldPassword);
    void setOldEmail(String oldEmail);
}
