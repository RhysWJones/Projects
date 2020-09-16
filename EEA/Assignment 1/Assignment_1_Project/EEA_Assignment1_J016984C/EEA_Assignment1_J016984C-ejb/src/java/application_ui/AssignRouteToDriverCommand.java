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
public class AssignRouteToDriverCommand implements AssignRouteToDriverCommandLocal
{
    @EJB
    private UserHandlerLocal userHandler;
    private UserDTO user;
    private int routeId;

    @Override
    public Object execute()
    {
        return userHandler.assignRouteToDriver(user, routeId);
    }

    @Override
    public void setUser(UserDTO user)
    {
        this.user = user;
    }

    @Override
    public void setRouteId(int routeId)
    {
        this.routeId = routeId;
    }
}
