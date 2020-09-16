package dto;

/**
 *
 * @author Rhys
 */
public class DeliveryStatusDTO
{
    private int deliveryStatusId;
    private String name;

    public DeliveryStatusDTO()
    {
    }

    public DeliveryStatusDTO(int deliveryStatusId, String name)
    {
        this.deliveryStatusId = deliveryStatusId;
        this.name = name;
    }

    public int getDeliveryStatusId()
    {
        return deliveryStatusId;
    }

    public void setDeliveryStatusId(int deliveryStatusId)
    {
        this.deliveryStatusId = deliveryStatusId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
