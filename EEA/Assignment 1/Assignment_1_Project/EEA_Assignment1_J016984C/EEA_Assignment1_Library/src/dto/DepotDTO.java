package dto;

import java.util.ArrayList;

/**
 *
 * @author Rhys
 */
public class DepotDTO
{
    private int depotId;
    private String name;
    private ArrayList<RouteDTO> depotRoutes;
    private ArrayList<DeliveryDTO> depotDeliveries;

    public DepotDTO()
    {
    }

    public DepotDTO(int depotId, String name)
    {
        this.depotId = depotId;
        this.name = name;
    }

    public int getDepotId()
    {
        return depotId;
    }

    public void setDepotId(int depotId)
    {
        this.depotId = depotId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<RouteDTO> getDepotRoutes()
    {
        return depotRoutes;
    }

    public void setDepotRoutes(ArrayList<RouteDTO> depotRoutes)
    {
        this.depotRoutes = depotRoutes;
    }

    public ArrayList<DeliveryDTO> getDepotDeliveries()
    {
        return depotDeliveries;
    }

    public void setDepotDeliveries(ArrayList<DeliveryDTO> depotDeliveries)
    {
        this.depotDeliveries = depotDeliveries;
    }
}
