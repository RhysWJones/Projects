package application_ui;

import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface GetDeliveryStatusesCommandLocal extends Command
{
    @Override
    Object execute();
}
