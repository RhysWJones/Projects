package entity;

import entity.Route;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-04T18:59:51")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> city;
    public static volatile SingularAttribute<Users, String> postcode;
    public static volatile SingularAttribute<Users, String> telephone;
    public static volatile SingularAttribute<Users, Integer> userId;
    public static volatile SingularAttribute<Users, String> forename;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Route> routeId;
    public static volatile SingularAttribute<Users, Integer> driverId;
    public static volatile SingularAttribute<Users, String> surname;
    public static volatile SingularAttribute<Users, Date> dob;
    public static volatile SingularAttribute<Users, String> addressLine1;
    public static volatile SingularAttribute<Users, String> addressLine2;
    public static volatile SingularAttribute<Users, Boolean> isDriver;
    public static volatile SingularAttribute<Users, String> email;

}