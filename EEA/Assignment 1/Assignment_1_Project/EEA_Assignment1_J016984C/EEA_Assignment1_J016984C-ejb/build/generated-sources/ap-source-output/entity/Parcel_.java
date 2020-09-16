package entity;

import entity.Delivery;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-04T18:59:51")
@StaticMetamodel(Parcel.class)
public class Parcel_ { 

    public static volatile SingularAttribute<Parcel, Delivery> delivery;
    public static volatile SingularAttribute<Parcel, String> city;
    public static volatile SingularAttribute<Parcel, String> postcode;
    public static volatile SingularAttribute<Parcel, String> recipientName;
    public static volatile SingularAttribute<Parcel, String> addressLine1;
    public static volatile SingularAttribute<Parcel, String> addressLine2;
    public static volatile SingularAttribute<Parcel, Boolean> delivered;
    public static volatile SingularAttribute<Parcel, Integer> parcelId;

}