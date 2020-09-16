/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminUI;

import dto.FilmDTO;
import dto.ScreenDTO;
import handler.ShowingHandler;

/**
 *
 * @author Rhys Jones
 */
public class AddShowingCommand implements AdminCommand
{
    private FilmDTO film;
    private ScreenDTO screen;
    private ShowingHandler showHndlr = null;
    private String time;
    public AddShowingCommand(FilmDTO film, ScreenDTO screen, String time)
    {
        this.film = film;
        this.screen = screen;
        this.time = time;
        showHndlr = ShowingHandler.getInstance();
    }

    @Override
    public Object execute()
    {
        return showHndlr.addShowing(film, screen, time);
    }
    
}
