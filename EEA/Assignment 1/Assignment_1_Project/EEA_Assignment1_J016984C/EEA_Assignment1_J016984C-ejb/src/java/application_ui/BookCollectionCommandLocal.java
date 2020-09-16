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
public interface BookCollectionCommandLocal extends Command
{
    @Override
    public Object execute();

    void setDeliveryId(int deliveryId);

    void setCollectionDate(Date collectionDate);
}
