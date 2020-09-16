/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import dto.DeliveryDTO;
import dto.DeliveryStatusDTO;
import dto.DepotDTO;
import dto.ParcelDTO;
import dto.RouteDTO;
import dto.UserDTO;
import entity.Delivery;
import entity.DeliveryStatus;
import entity.Depot;
import entity.Parcel;
import entity.Route;
import entity.Users;
import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface DTOConversionGatewayLocal
{
    public RouteDTO createRouteDTO(Route route);
    
    public DepotDTO createDepotDTO(Depot depot);

    public ParcelDTO createParcelDTO(Parcel parcel);

    public DeliveryStatusDTO createDeliveryStatusDTO(DeliveryStatus deliveryStatus);
    
    public DeliveryDTO createDeliveryDTO(Delivery delivery);
    
    public UserDTO createUserDTO(Users user);
}
