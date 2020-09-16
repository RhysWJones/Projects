package customerUI;

import dto.CinemaDTO;
import handler.ScreenHandler;
import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public class GetCinemaScreensCommand implements CustomerCommand
{

    private ArrayList<CinemaDTO> cinemas;
    private ScreenHandler screenHndlr = null;

    public GetCinemaScreensCommand(ArrayList<CinemaDTO> cinemas)
    {
        this.cinemas = cinemas;
        screenHndlr = ScreenHandler.getInstance();
    }

    @Override
    public Object execute()
    {
        return screenHndlr.getCinemaScreens(cinemas);
    }

}
