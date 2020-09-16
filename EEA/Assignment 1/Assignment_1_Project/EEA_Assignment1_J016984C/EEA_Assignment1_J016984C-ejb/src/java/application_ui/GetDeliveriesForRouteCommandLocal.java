package application_ui;

import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface GetDeliveriesForRouteCommandLocal extends Command
{
    @Override
    Object execute();
    void setRouteId(int routeId);
}
