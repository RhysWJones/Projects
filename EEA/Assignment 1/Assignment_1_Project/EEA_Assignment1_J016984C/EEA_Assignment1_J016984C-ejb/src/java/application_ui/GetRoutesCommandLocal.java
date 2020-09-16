package application_ui;

import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface GetRoutesCommandLocal extends Command
{
    @Override
    public Object execute();
}
