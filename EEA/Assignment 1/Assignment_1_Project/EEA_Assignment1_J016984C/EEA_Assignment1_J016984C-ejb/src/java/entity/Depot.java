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
@Table(name = "DEPOT")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Depot.findAll", query = "SELECT d FROM Depot d"),
    @NamedQuery(name = "Depot.findByDepotId", query = "SELECT d FROM Depot d WHERE d.depotId = :depotId"),
    @NamedQuery(name = "Depot.findByName", query = "SELECT d FROM Depot d WHERE d.name = :name")
})
public class Depot implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DEPOT_ID")
    private Integer depotId;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @OneToMany(mappedBy = "depotId")
    private Collection<Route> routeCollection;
    @OneToMany(mappedBy = "depotId")
    private Collection<Delivery> deliveryCollection;

    public Depot()
    {
    }

    public Depot(Integer depotId)
    {
        this.depotId = depotId;
    }

    public Integer getDepotId()
    {
        return depotId;
    }

    public void setDepotId(Integer depotId)
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

    @XmlTransient
    public Collection<Route> getRouteCollection()
    {
        return routeCollection;
    }

    public void setRouteCollection(Collection<Route> routeCollection)
    {
        this.routeCollection = routeCollection;
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
        hash += (depotId != null ? depotId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Depot))
        {
            return false;
        }
        Depot other = (Depot) object;
        if ((this.depotId == null && other.depotId != null) || (this.depotId != null && !this.depotId.equals(other.depotId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.Depot[ depotId=" + depotId + " ]";
    }
    
}
