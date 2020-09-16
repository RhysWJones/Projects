package dto;

import java.util.Date;

/**
 *
 * @author Rhys
 */
public class DeliveryDTO
{
    private int deliveryId;
    private Date deliveryDate;
    private DeliveryStatusDTO deliveryStatus;
    private DepotDTO depot;
    private ParcelDTO parcel;
    private RouteDTO route;

    public DeliveryDTO()
    {
    }

    public DeliveryDTO(int deliveryId, Date deliveryDate, DeliveryStatusDTO deliveryStatus, DepotDTO depot, ParcelDTO parcel, RouteDTO route)
    {
        this.deliveryId = deliveryId;
        this.deliveryDate = deliveryDate;
        this.deliveryStatus = deliveryStatus;
        this.depot = depot;
        this.parcel = parcel;
        this.route = route;
    }

    public int getDeliveryId()
    {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId)
    {
        this.deliveryId = deliveryId;
    }

    public Date getDeliveryDate()
    {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate)
    {
        this.deliveryDate = deliveryDate;
    }

    public DeliveryStatusDTO getDeliveryStatus()
    {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatusDTO deliveryStatus)
    {
        this.deliveryStatus = deliveryStatus;
    }

    public DepotDTO getDepot()
    {
        return depot;
    }

    public void setDepot(DepotDTO depot)
    {
        this.depot = depot;
    }

    public ParcelDTO getParcel()
    {
        return parcel;
    }

    public void setParcel(ParcelDTO parcel)
    {
        this.parcel = parcel;
    }

    public RouteDTO getRoute()
    {
        return route;
    }

    public void setRoute(RouteDTO route)
    {
        this.route = route;
    }
}
