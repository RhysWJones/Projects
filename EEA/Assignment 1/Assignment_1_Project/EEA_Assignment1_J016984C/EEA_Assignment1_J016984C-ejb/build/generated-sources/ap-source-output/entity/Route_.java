package entity;

import entity.Delivery;
import entity.Depot;
import entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-04T18:59:51")
@StaticMetamodel(Route.class)
public class Route_ { 

    public static volatile SingularAttribute<Route, Integer> routeId;
    public static volatile CollectionAttribute<Route, Delivery> deliveryCollection;
    public static volatile SingularAttribute<Route, String> name;
    public static volatile SingularAttribute<Route, Depot> depotId;
    public static volatile CollectionAttribute<Route, Users> usersCollection;

}