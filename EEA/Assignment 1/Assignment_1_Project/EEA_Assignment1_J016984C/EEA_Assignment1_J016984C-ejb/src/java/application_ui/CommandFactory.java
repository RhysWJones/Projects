package application_ui;

import dto.UserDTO;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class CommandFactory implements CommandFactoryLocal
{

    public static final int LOGIN = 1;
    public static final int REGISTER = 2;
    public static final int SEARCH_FOR_DELIVERY = 3;
    public static final int CANCEL_DELIVERY = 4;
    public static final int BOOK_COLLECTION = 5;
    public static final int RESCHEDULE_DELIVERY = 6;
    public static final int GET_RECIPIENT_DELIVERIES = 7;
    public static final int UPDATE_ACCOUNT_DETAILS = 8;
    public static final int DELETE_ACCOUNT = 9;
    public static final int GET_ROUTES = 10;
    public static final int GET_DELIVERIES_FOR_ROUTE = 11;
    public static final int ASSIGN_ROUTE_TO_DRIVER = 12;
    public static final int SET_ROUTE_DELIVERIES_TO_OUT_FOR_DELIVERY = 13;
    public static final int GET_DRIVER_DELIVERIES = 14;
    public static final int DELIVER_DELIVERY = 15;
    public static final int FAIL_DELIVERY = 16;
    public static final int GET_DELIVERY_STATUSES = 17;
    public static final int CHANGE_DELIVERY_STATUS = 18;

    @EJB
    private LoginCommandLocal loginCommand;
    @EJB
    private RegisterCommandLocal registerCommand;
    @EJB
    private DeliverySearchCommandLocal deliverySearchCommand;
    @EJB
    private CancelDeliveryCommandLocal cancelDeliveryCommand;
    @EJB
    private BookCollectionCommandLocal bookCollectionCommand;
    @EJB
    private RescheduleDeliveryCommandLocal rescheduleDeliveryCommand;
    @EJB
    private GetRecipientDeliveriesCommandLocal getRecipientDeliveriesCommand;
    @EJB
    private UpdateAccountDetailsCommandLocal updateAccountDetailsCommand;
    @EJB
    private DeleteAccountCommandLocal deleteAccountCommand;
    @EJB
    private GetRoutesCommandLocal getRoutesCommand;
    @EJB
    private GetDeliveriesForRouteCommandLocal getDeliveriesForRouteCommand;
    @EJB
    private AssignRouteToDriverCommandLocal assignRouteToDriverCommand;
    @EJB
    private SetRouteDeliveriesToOutForDeliveryCommandLocal setRouteDeliveriesToOutForDeliveryCommand;
    @EJB
    private GetDriverDeliveriesCommandLocal getDriverDeliveriesCommand;
    @EJB
    private DeliverDeliveryCommandLocal deliverDeliveryCommand;
    @EJB
    private FailDeliveryCommandLocal failDeliveryCommand;
    @EJB
    private GetDeliveryStatusesCommandLocal getDeliveryStatusesCommand;
    @EJB
    private ChangeDeliveryStatusCommandLocal changeDeliveryStatusCommand;
    @EJB
    private NullObjectCommandLocal nullObjectCommand;

    @Override
    public Command createCommand(int commandType, String email, String password)
    {
        switch (commandType)
        {
            case LOGIN:
                loginCommand.setEmail(email);
                loginCommand.setPassword(password);
                return loginCommand;
            default:
                return nullObjectCommand;
        }
    }

    @Override
    public Command createCommand(int commandType, UserDTO userDTO)
    {
        switch (commandType)
        {
            case REGISTER:
                registerCommand.setRegisteringUserDTO(userDTO);
                return registerCommand;
            case DELETE_ACCOUNT:
                deleteAccountCommand.setUser(userDTO);
                return deleteAccountCommand;
            default:
                return nullObjectCommand;
        }
    }

    @Override
    public Command createCommand(int commandType, int entityId)
    {
        switch (commandType)
        {
            case SEARCH_FOR_DELIVERY:
                deliverySearchCommand.setDeliveryId(entityId);
                return deliverySearchCommand;
            case CANCEL_DELIVERY:
                cancelDeliveryCommand.setDeliveryId(entityId);
                return cancelDeliveryCommand;
            case GET_RECIPIENT_DELIVERIES:
                getRecipientDeliveriesCommand.setUserId(entityId);
                return getRecipientDeliveriesCommand;
            case GET_DELIVERIES_FOR_ROUTE:
                getDeliveriesForRouteCommand.setRouteId(entityId);
                return getDeliveriesForRouteCommand;
            case SET_ROUTE_DELIVERIES_TO_OUT_FOR_DELIVERY:
                setRouteDeliveriesToOutForDeliveryCommand.setRouteId(entityId);
                return setRouteDeliveriesToOutForDeliveryCommand;
            case GET_DRIVER_DELIVERIES:
                getDriverDeliveriesCommand.setRouteId(entityId);
                return getDriverDeliveriesCommand;
            case DELIVER_DELIVERY:
                deliverDeliveryCommand.setDeliveryId(entityId);
                return deliverDeliveryCommand;
            case FAIL_DELIVERY:
                failDeliveryCommand.setDeliveryId(entityId);
                return failDeliveryCommand;
            default:
                return nullObjectCommand;
        }
    }

    @Override
    public Command createCommand(int commandType, int deliveryId, Date date)
    {
        switch (commandType)
        {
            case BOOK_COLLECTION:
                bookCollectionCommand.setDeliveryId(deliveryId);
                bookCollectionCommand.setCollectionDate(date);
                return bookCollectionCommand;
            case RESCHEDULE_DELIVERY:
                rescheduleDeliveryCommand.setDeliveryId(deliveryId);
                rescheduleDeliveryCommand.setNewDeliveryDate(date);
                return rescheduleDeliveryCommand;
            default:
                return nullObjectCommand;
        }
    }

    @Override
    public Command createCommand(int commandType, UserDTO user, String oldPassword, String oldEmail)
    {
        switch (commandType)
        {
            case UPDATE_ACCOUNT_DETAILS:
                updateAccountDetailsCommand.setUser(user);
                updateAccountDetailsCommand.setOldPassword(oldPassword);
                updateAccountDetailsCommand.setOldEmail(oldEmail);
                return updateAccountDetailsCommand;
            default:
                return nullObjectCommand;
        }
    }

    @Override
    public Command createCommand(int commandType)
    {
        switch (commandType)
        {
            case GET_ROUTES:
                return getRoutesCommand;
            case GET_DELIVERY_STATUSES:
                return getDeliveryStatusesCommand;
            default:
                return nullObjectCommand;
        }
    }

    @Override
    public Command createCommand(int commandType, UserDTO user, int entityId)
    {
        switch (commandType)
        {
            case ASSIGN_ROUTE_TO_DRIVER:
                assignRouteToDriverCommand.setUser(user);
                assignRouteToDriverCommand.setRouteId(entityId);
                return assignRouteToDriverCommand;
            default:
                return nullObjectCommand;
        }
    }

    @Override
    public Command createCommand(int commandType, int entityId, int secondEntityId)
    {
        switch(commandType)
        {
            case CHANGE_DELIVERY_STATUS:
                changeDeliveryStatusCommand.setDeliveryId(entityId);
                changeDeliveryStatusCommand.setDeliveryStatusId(secondEntityId);
                return changeDeliveryStatusCommand;
            default:
                return nullObjectCommand;
        }
    }

}
