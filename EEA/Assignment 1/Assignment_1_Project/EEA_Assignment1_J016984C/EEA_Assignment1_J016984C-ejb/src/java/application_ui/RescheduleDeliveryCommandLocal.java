/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_ui;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Rhys
 */
@Local
public interface RescheduleDeliveryCommandLocal extends Command
{
    @Override
    public Object execute();
    
    public void setDeliveryId(int deliveryId);
    
    public void setNewDeliveryDate(Date newDeliveryDate);
}
