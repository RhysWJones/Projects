package entity;

import entity.DeliveryStatus;
import entity.Depot;
import entity.Parcel;
import entity.Route;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-04T18:59:51")
@StaticMetamodel(Delivery.class)
public class Delivery_ { 

    public static volatile SingularAttribute<Delivery, Integer> deliveryId;
    public static volatile SingularAttribute<Delivery, Route> routeId;
    public static volatile SingularAttribute<Delivery, DeliveryStatus> deliveryStatusId;
    public static volatile SingularAttribute<Delivery, Depot> depotId;
    public static volatile SingularAttribute<Delivery, Date> deliveryDate;
    public static volatile SingularAttribute<Delivery, Parcel> parcelId;

}