/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rhys
 */
@Entity
@Table(name = "DELIVERY")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d"),
    @NamedQuery(name = "Delivery.findByDeliveryId", query = "SELECT d FROM Delivery d WHERE d.deliveryId = :deliveryId"),
    @NamedQuery(name = "Delivery.findByDeliveryDate", query = "SELECT d FROM Delivery d WHERE d.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "Delivery.getDeliveriesForRoute", query = "SELECT d FROM Delivery d WHERE d.routeId.routeId = :routeId AND d.deliveryStatusId.name = :deliveryStatus"),
    @NamedQuery(name = "Delivery.getDriverDeliveries", query = "SELECT d FROM Delivery d WHERE d.routeId.routeId = :routeId")
})
public class Delivery implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DELIVERY_ID")
    private Integer deliveryId;
    @Column(name = "DELIVERY_DATE")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @JoinColumn(name = "DELIVERY_STATUS_ID", referencedColumnName = "DELIVERY_STATUS_ID")
    @ManyToOne
    private DeliveryStatus deliveryStatusId;
    @JoinColumn(name = "DEPOT_ID", referencedColumnName = "DEPOT_ID")
    @ManyToOne
    private Depot depotId;
    @JoinColumn(name = "PARCEL_ID", referencedColumnName = "PARCEL_ID")
    @ManyToOne
    private Parcel parcelId;
    @JoinColumn(name = "ROUTE_ID", referencedColumnName = "ROUTE_ID")
    @ManyToOne
    private Route routeId;

    public Delivery()
    {
    }

    public Delivery(Integer deliveryId)
    {
        this.deliveryId = deliveryId;
    }

    public Integer getDeliveryId()
    {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId)
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

    public DeliveryStatus getDeliveryStatusId()
    {
        return deliveryStatusId;
    }

    public void setDeliveryStatusId(DeliveryStatus deliveryStatusId)
    {
        this.deliveryStatusId = deliveryStatusId;
    }

    public Depot getDepotId()
    {
        return depotId;
    }

    public void setDepotId(Depot depotId)
    {
        this.depotId = depotId;
    }

    public Parcel getParcelId()
    {
        return parcelId;
    }

    public void setParcelId(Parcel parcelId)
    {
        this.parcelId = parcelId;
    }

    public Route getRouteId()
    {
        return routeId;
    }

    public void setRouteId(Route routeId)
    {
        this.routeId = routeId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (deliveryId != null ? deliveryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delivery))
        {
            return false;
        }
        Delivery other = (Delivery) object;
        if ((this.deliveryId == null && other.deliveryId != null) || (this.deliveryId != null && !this.deliveryId.equals(other.deliveryId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.Delivery[ deliveryId=" + deliveryId + " ]";
    }
    
}
