package application_ui;

import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface SetRouteDeliveriesToOutForDeliveryCommandLocal extends Command
{
    @Override
    Object execute();
    void setRouteId(int routeId);
}
