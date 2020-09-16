/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import database.Plane;

/**
 *
 * @author danpa
 */
public class ComboItem
{

    private String key;
    private Plane value;

    public ComboItem(Plane value)
    {
        this.key = value.getDesignation();
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public Plane getValue()
    {
        return value;
    }
}
