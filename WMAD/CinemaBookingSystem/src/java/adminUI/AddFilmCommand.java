package adminUI;

import dto.FilmDTO;
import handler.FilmHandler;

/**
 *
 * @author Rhys Jones
 */
public class AddFilmCommand implements AdminCommand
{

    private FilmDTO film;
    private FilmHandler filmHndlr = null;

    public AddFilmCommand(FilmDTO film)
    {
        this.film = film;
        filmHndlr = FilmHandler.getInstance();
    }

    @Override
    public Object execute()
    {
        return filmHndlr.addFilm(film);
    }

}
