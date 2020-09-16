package ejb;

import database.RouteGatewayLocal;
import dto.RouteDTO;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class RouteHandler implements RouteHandlerLocal
{
    @EJB
    private RouteGatewayLocal routeTable;

    @Override
    public ArrayList<RouteDTO> getRoutes()
    {
        return routeTable.getRoutes();
    }
    
}
