package application_ui;

import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface ChangeDeliveryStatusCommandLocal extends Command
{
    @Override
    Object execute();
    
    void setDeliveryId(int deliveryId);
    
    void setDeliveryStatusId(int deliveryStatusId);
}
