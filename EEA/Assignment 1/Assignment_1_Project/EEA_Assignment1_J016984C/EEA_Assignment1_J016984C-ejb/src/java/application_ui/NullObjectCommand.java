/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_ui;

import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class NullObjectCommand implements NullObjectCommandLocal
{

    @Override
    public Object execute()
    {
        return new Object();
    }
}
