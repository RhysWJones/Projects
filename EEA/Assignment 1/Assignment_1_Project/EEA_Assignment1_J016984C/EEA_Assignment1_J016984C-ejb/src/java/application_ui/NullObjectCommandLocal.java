/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_ui;

import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface NullObjectCommandLocal extends Command
{
    Object execute();
}
