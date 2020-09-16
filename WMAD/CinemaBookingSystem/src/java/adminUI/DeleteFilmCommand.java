package adminUI;

import handler.FilmHandler;

/**
 *
 * @author Rhys Jones
 */
public class DeleteFilmCommand implements AdminCommand
{
    private FilmHandler filmHndlr = null;
    private int filmID;

    public DeleteFilmCommand(int filmID)
    {
        filmHndlr = FilmHandler.getInstance();
        this.filmID = filmID;
    }

    @Override
    public Object execute()
    {
        return filmHndlr.deleteFilm(filmID);
    }
    
}
