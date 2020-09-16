package entity;

import entity.Delivery;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-04T18:59:51")
@StaticMetamodel(DeliveryStatus.class)
public class DeliveryStatus_ { 

    public static volatile CollectionAttribute<DeliveryStatus, Delivery> deliveryCollection;
    public static volatile SingularAttribute<DeliveryStatus, Integer> deliveryStatusId;
    public static volatile SingularAttribute<DeliveryStatus, String> name;

}