package adminUI;

import handler.FilmHandler;

/**
 *
 * @author Rhys Jones
 */
public class GetAllFilmsCommand implements AdminCommand
{
    private FilmHandler filmHndlr = null;

    public GetAllFilmsCommand()
    {
        filmHndlr = FilmHandler.getInstance();
    }
    
    @Override
    public Object execute()
    {
        return filmHndlr.getAllFilms();
    }
    
}
