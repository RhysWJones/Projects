package dto;

import java.util.ArrayList;

/**
 *
 * @author Rhys
 */
public class RouteDTO
{
    private int routeId;
    private String name;
    private DepotDTO depot;
    private ArrayList<UserDTO> usersOnRoute;
    private ArrayList<DeliveryDTO> routeDeliveries;

    public RouteDTO()
    {
    }

    public RouteDTO(int routeId, String name, DepotDTO depot, ArrayList<UserDTO> users, ArrayList<DeliveryDTO> deliveries)
    {
        this.routeId = routeId;
        this.name = name;
        this.depot = depot;
        this.usersOnRoute = users;
        this.routeDeliveries = deliveries;
    }

    public int getRouteId()
    {
        return routeId;
    }

    public void setRouteId(int routeId)
    {
        this.routeId = routeId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public DepotDTO getDepot()
    {
        return depot;
    }

    public void setDepot(DepotDTO depot)
    {
        this.depot = depot;
    }

    public ArrayList<UserDTO> getUsers()
    {
        return usersOnRoute;
    }

    public void setUsers(ArrayList<UserDTO> users)
    {
        this.usersOnRoute = users;
    }

    public ArrayList<DeliveryDTO> getDeliveries()
    {
        return routeDeliveries;
    }

    public void setDeliveries(ArrayList<DeliveryDTO> deliveries)
    {
        this.routeDeliveries = deliveries;
    }
}
