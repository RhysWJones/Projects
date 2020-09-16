package dto;

/**
 *
 * @author Rhys
 */
public class ParcelDTO
{
    private int parcelId;
    private String recipientName;
    private String addressLine1;
    private String addressLine2;
    private String postcode;
    private String city;
    private boolean delivered;
    private DeliveryDTO delivery;

    public ParcelDTO()
    {
    }

    public ParcelDTO(int parcelId, String recipientName, String addressLine1, String addressLine2, String postcode, String city, boolean delivered, DeliveryDTO delivery)
    {
        this.parcelId = parcelId;
        this.recipientName = recipientName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postcode = postcode;
        this.city = city;
        this.delivered = delivered;
        this.delivery = delivery;
    }

    public int getParcelId()
    {
        return parcelId;
    }

    public void setParcelId(int parcelId)
    {
        this.parcelId = parcelId;
    }

    public String getRecipientName()
    {
        return recipientName;
    }

    public void setRecipientName(String recipientName)
    {
        this.recipientName = recipientName;
    }

    public String getAddressLine1()
    {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1)
    {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2()
    {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2)
    {
        this.addressLine2 = addressLine2;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public boolean isDelivered()
    {
        return delivered;
    }

    public void setDelivered(boolean delivered)
    {
        this.delivered = delivered;
    }

    public DeliveryDTO getDelivery()
    {
        return delivery;
    }

    public void setDelivery(DeliveryDTO delivery)
    {
        this.delivery = delivery;
    }
}
