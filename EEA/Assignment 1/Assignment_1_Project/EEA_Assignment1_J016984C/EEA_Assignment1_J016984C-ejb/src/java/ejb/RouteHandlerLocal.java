/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dto.RouteDTO;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface RouteHandlerLocal
{

    ArrayList<RouteDTO> getRoutes();
    
}
