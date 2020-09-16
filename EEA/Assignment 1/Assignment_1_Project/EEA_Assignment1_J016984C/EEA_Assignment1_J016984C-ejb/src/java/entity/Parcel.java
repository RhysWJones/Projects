/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rhys
 */
@Entity
@Table(name = "PARCEL")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Parcel.findAll", query = "SELECT p FROM Parcel p"),
    @NamedQuery(name = "Parcel.findByParcelId", query = "SELECT p FROM Parcel p WHERE p.parcelId = :parcelId"),
    @NamedQuery(name = "Parcel.findByRecipientName", query = "SELECT p FROM Parcel p WHERE p.recipientName = :recipientName"),
    @NamedQuery(name = "Parcel.findByAddressLine1", query = "SELECT p FROM Parcel p WHERE p.addressLine1 = :addressLine1"),
    @NamedQuery(name = "Parcel.findByAddressLine2", query = "SELECT p FROM Parcel p WHERE p.addressLine2 = :addressLine2"),
    @NamedQuery(name = "Parcel.findByPostcode", query = "SELECT p FROM Parcel p WHERE p.postcode = :postcode"),
    @NamedQuery(name = "Parcel.findByCity", query = "SELECT p FROM Parcel p WHERE p.city = :city"),
    @NamedQuery(name = "Parcel.findByDelivered", query = "SELECT p FROM Parcel p WHERE p.delivered = :delivered"),
    @NamedQuery(name = "Parcel.getDeliveriesForUser", query = "SELECT p FROM Parcel p WHERE p.recipientName = :recipientName AND p.addressLine1 = :addressLine1 AND p.postcode = :postcode AND p.city = :city")
})
public class Parcel implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PARCEL_ID")
    private Integer parcelId;
    @Size(max = 255)
    @Column(name = "RECIPIENT_NAME")
    private String recipientName;
    @Size(max = 255)
    @Column(name = "ADDRESS_LINE_1")
    private String addressLine1;
    @Size(max = 255)
    @Column(name = "ADDRESS_LINE_2")
    private String addressLine2;
    @Size(max = 255)
    @Column(name = "POSTCODE")
    private String postcode;
    @Size(max = 255)
    @Column(name = "CITY")
    private String city;
    @Column(name = "DELIVERED")
    private Boolean delivered;
    @OneToOne(mappedBy = "parcelId")
    private Delivery delivery;

    public Parcel()
    {
    }

    public Parcel(Integer parcelId)
    {
        this.parcelId = parcelId;
    }

    public Integer getParcelId()
    {
        return parcelId;
    }

    public void setParcelId(Integer parcelId)
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

    public Boolean getDelivered()
    {
        return delivered;
    }

    public void setDelivered(Boolean delivered)
    {
        this.delivered = delivered;
    }

    @XmlTransient
    public Delivery getDelivery()
    {
        return delivery;
    }

    public void setDelivery(Delivery delivery)
    {
        this.delivery = delivery;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (parcelId != null ? parcelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parcel))
        {
            return false;
        }
        Parcel other = (Parcel) object;
        if ((this.parcelId == null && other.parcelId != null) || (this.parcelId != null && !this.parcelId.equals(other.parcelId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.Parcel[ parcelId=" + parcelId + " ]";
    }
    
}
