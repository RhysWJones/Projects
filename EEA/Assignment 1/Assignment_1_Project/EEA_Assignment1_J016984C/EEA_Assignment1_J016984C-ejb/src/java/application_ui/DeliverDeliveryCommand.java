/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application_ui;

import ejb.DeliveryHandlerLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Rhys
 */
@Stateless
public class DeliverDeliveryCommand implements DeliverDeliveryCommandLocal
{
    @EJB
    private DeliveryHandlerLocal deliveryHandler;
    private int deliveryId;

    @Override
    public Object execute()
    {
        return deliveryHandler.deliverDelivery(deliveryId);
    }

    @Override
    public void setDeliveryId(int deliveryId)
    {
        this.deliveryId = deliveryId;
    }
    
}
