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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ROUTE")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r"),
    @NamedQuery(name = "Route.findByRouteId", query = "SELECT r FROM Route r WHERE r.routeId = :routeId"),
    @NamedQuery(name = "Route.findByName", query = "SELECT r FROM Route r WHERE r.name = :name")
})
public class Route implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ROUTE_ID")
    private Integer routeId;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "DEPOT_ID", referencedColumnName = "DEPOT_ID")
    @ManyToOne
    private Depot depotId;
    @OneToMany(mappedBy = "routeId")
    private Collection<Users> usersCollection;
    @OneToMany(mappedBy = "routeId")
    private Collection<Delivery> deliveryCollection;

    public Route()
    {
    }

    public Route(Integer routeId)
    {
        this.routeId = routeId;
    }

    public Integer getRouteId()
    {
        return routeId;
    }

    public void setRouteId(Integer routeId)
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

    public Depot getDepotId()
    {
        return depotId;
    }

    public void setDepotId(Depot depotId)
    {
        this.depotId = depotId;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection()
    {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection)
    {
        this.usersCollection = usersCollection;
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
        hash += (routeId != null ? routeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route))
        {
            return false;
        }
        Route other = (Route) object;
        if ((this.routeId == null && other.routeId != null) || (this.routeId != null && !this.routeId.equals(other.routeId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entity.Route[ routeId=" + routeId + " ]";
    }
    
}
