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
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class DTOConversionGateway implements DTOConversionGatewayLocal
{
    @Override
    public RouteDTO createRouteDTO(Route route)
    {
        RouteDTO routeDTO = new RouteDTO();
        
        routeDTO.setRouteId(route.getRouteId());
        routeDTO.setName(route.getName());
        routeDTO.setDepot(createDepotDTO(route.getDepotId()));
        
        return routeDTO;
    }
    
    @Override
    public DepotDTO createDepotDTO(Depot depot)
    {
        DepotDTO depotDTO = new DepotDTO();
        
        depotDTO.setDepotId(depot.getDepotId());
        depotDTO.setName(depot.getName());
        
        return depotDTO;
    }

    @Override
    public ParcelDTO createParcelDTO(Parcel parcel)
    {
        ParcelDTO parcelDTO = new ParcelDTO();

        parcelDTO.setParcelId(parcel.getParcelId());
        parcelDTO.setRecipientName(parcel.getRecipientName());
        parcelDTO.setAddressLine1(parcel.getAddressLine1());
        if (parcel.getAddressLine2() != null)
        {
            parcelDTO.setAddressLine2(parcel.getAddressLine2());
        }
        parcelDTO.setPostcode(parcel.getPostcode());
        parcelDTO.setCity(parcel.getCity());

        return parcelDTO;
    }

    @Override
    public DeliveryStatusDTO createDeliveryStatusDTO(DeliveryStatus deliveryStatus)
    {
        DeliveryStatusDTO deliveryStatusDTO = new DeliveryStatusDTO();

        deliveryStatusDTO.setDeliveryStatusId(deliveryStatus.getDeliveryStatusId());
        deliveryStatusDTO.setName(deliveryStatus.getName());

        return deliveryStatusDTO;
    }
    
    @Override
    public DeliveryDTO createDeliveryDTO(Delivery delivery)
    {
        DeliveryDTO deliveryDTO = new DeliveryDTO();

        deliveryDTO.setDeliveryId(delivery.getDeliveryId());
        deliveryDTO.setDeliveryDate(delivery.getDeliveryDate());
        deliveryDTO.setDeliveryStatus(createDeliveryStatusDTO(delivery.getDeliveryStatusId()));
        deliveryDTO.setParcel(createParcelDTO(delivery.getParcelId()));
        if (delivery.getDepotId() != null)
        {
            deliveryDTO.setDepot(createDepotDTO(delivery.getDepotId()));
        }
        if (delivery.getRouteId() != null)
        {
            deliveryDTO.setRoute(createRouteDTO(delivery.getRouteId()));
        }
        return deliveryDTO;
    }
    
    @Override
    public UserDTO createUserDTO(Users user)
    {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getUserId());
        userDTO.setForename(user.getForename());
        userDTO.setSurname(user.getSurname());
        userDTO.setDateOfBirth(user.getDob());
        userDTO.setAddressLine1(user.getAddressLine1());
        userDTO.setAddressLine2(user.getAddressLine2());
        userDTO.setPostcode(user.getPostcode());
        userDTO.setCity(user.getCity());
        userDTO.setTelephone(user.getTelephone());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setIsDriver(user.getIsDriver());

        if (userDTO.isIsDriver())
        {
            userDTO.setDriverId(user.getDriverId());
            if(user.getRouteId() != null)
            {
                userDTO.setRouteId(createRouteDTO(user.getRouteId()));
            }
        }

        return userDTO;
    }
}
