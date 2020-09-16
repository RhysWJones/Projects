package entity;

import entity.Delivery;
import entity.Route;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-04T18:59:51")
@StaticMetamodel(Depot.class)
public class Depot_ { 

    public static volatile CollectionAttribute<Depot, Delivery> deliveryCollection;
    public static volatile CollectionAttribute<Depot, Route> routeCollection;
    public static volatile SingularAttribute<Depot, Integer> depotId;
    public static volatile SingularAttribute<Depot, String> name;

}