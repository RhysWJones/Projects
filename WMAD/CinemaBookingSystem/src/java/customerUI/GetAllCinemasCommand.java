package customerUI;

import handler.CinemaHandler;

/**
 *
 * @author Rhys Jones
 */
public class GetAllCinemasCommand implements CustomerCommand
{

    CinemaHandler cineHndlr = null;

    public GetAllCinemasCommand()
    {
        cineHndlr = CinemaHandler.getInstance();
    }

    @Override
    public Object execute()
    {
        return cineHndlr.getAllCinemas();
    }
}
