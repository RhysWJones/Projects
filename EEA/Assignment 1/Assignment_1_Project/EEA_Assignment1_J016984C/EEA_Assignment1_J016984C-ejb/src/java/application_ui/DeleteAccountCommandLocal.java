package application_ui;

import dto.UserDTO;
import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface DeleteAccountCommandLocal extends Command
{
    @Override
    public Object execute();
    void setUser(UserDTO user);
}
