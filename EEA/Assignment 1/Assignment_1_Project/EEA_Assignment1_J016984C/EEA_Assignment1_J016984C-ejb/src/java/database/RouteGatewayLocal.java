/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import dto.RouteDTO;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface RouteGatewayLocal
{

    ArrayList<RouteDTO> getRoutes();
    
}
