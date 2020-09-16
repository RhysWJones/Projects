package customerUI;

import dto.ScreenDTO;
import handler.ShowingHandler;

/**
 *
 * @author Rhys Jones
 */
public class GetScreenShowingsCommand implements CustomerCommand
{

    private final ScreenDTO screen;
    private ShowingHandler showingHndlr = null;

    public GetScreenShowingsCommand(ScreenDTO screen)
    {
        this.screen = screen;
        showingHndlr = ShowingHandler.getInstance();
    }

    @Override
    public Object execute()
    {
        return showingHndlr.getScreenShowings(screen);
    }

}
