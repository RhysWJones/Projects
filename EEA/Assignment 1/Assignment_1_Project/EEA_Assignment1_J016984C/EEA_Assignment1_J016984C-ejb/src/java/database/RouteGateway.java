package database;

import dto.RouteDTO;
import entity.Route;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rhys
 */
@Stateless
public class RouteGateway implements RouteGatewayLocal
{
    @PersistenceContext
    EntityManager em;
    
    @EJB
    DTOConversionGatewayLocal DTOConversionGateway;

    @Override
    public ArrayList<RouteDTO> getRoutes()
    {
        List<Route> routeList = (List<Route>) em.createNamedQuery("Route.findAll").getResultList();
        ArrayList<RouteDTO> routes = new ArrayList<RouteDTO>();
        for(Route route : routeList)
        {
            routes.add(DTOConversionGateway.createRouteDTO(route));
        }
        return routes;
    }
}
