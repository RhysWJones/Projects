package application_ui;

import dto.UserDTO;
import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface AssignRouteToDriverCommandLocal extends Command
{
    @Override
    Object execute();
    void setRouteId(int routeId);
    void setUser(UserDTO user);
}
