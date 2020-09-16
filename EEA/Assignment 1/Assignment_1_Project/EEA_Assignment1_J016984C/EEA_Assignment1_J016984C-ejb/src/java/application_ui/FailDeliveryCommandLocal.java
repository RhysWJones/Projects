package application_ui;

import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface FailDeliveryCommandLocal extends Command
{
    @Override
    Object execute();
    void setDeliveryId(int deliveryId);
}
