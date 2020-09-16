package application_ui;

import ejb.RouteHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class GetRoutesCommand implements GetRoutesCommandLocal
{
    @EJB
    private RouteHandlerLocal routeHandler;

    @Override
    public Object execute()
    {
        return routeHandler.getRoutes();
    }
    
    
}
