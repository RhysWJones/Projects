/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rhys
 */
@Entity
@Table(name = "DELIVERY_STATUS")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "DeliveryStatus.findAll", query = "SELECT d FROM DeliveryStatus d"),
    @NamedQuery(name = "DeliveryStatus.findByDeliveryStatusId", query = "SELECT d FROM DeliveryStatus d WHERE d.deliveryStatusId = :deliveryStatusId"),
    @NamedQuery(name = "DeliveryStatus.findByName", query = "SELECT d FROM DeliveryStatus d WHERE d.name = :name")
})
public class DeliveryStatus implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DELIVERY_STATUS_ID")
    private Integer deliveryStatusId;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "deliveryStatusId")
    private Collection<Delivery> deliveryCollection;

    public DeliveryStatus()
    {
    }

    public DeliveryStatus(Integer deliveryStatusId)
    {
        this.deliveryStatusId = deliveryStatusId;
    }

    public Integer getDeliveryStatusId()
    {
        return deliveryStatusId;
    }

    public void setDeliveryStatusId(Integer deliveryStatusId)
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

    @XmlTransient
    public Collection<Delivery> getDeliveryCollection()
    {
        return deliveryCollection;
    }

    public void setDeliveryCollection(Collection<Delivery> deliveryCollection)
    {
        this.deliveryCollection = deliveryCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (deliveryStatusId != null ? deliveryStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliveryStatus))
        {
            return false;
        }
        DeliveryStatus other = (DeliveryStatus) object;
        if ((this.deliveryStatusId == null && other.deliveryStatusId != null) || (this.deliveryStatusId != null && !this.deliveryStatusId.equals(other.deliveryStatusId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.DeliveryStatus[ deliveryStatusId=" + deliveryStatusId + " ]";
    }
    
}
