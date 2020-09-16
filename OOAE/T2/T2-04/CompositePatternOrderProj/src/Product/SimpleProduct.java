package Product;

import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public class SimpleProduct implements Product
{

    private String description;
    private double price;

    public SimpleProduct(String description, double price)
    {
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString()
    {
        return description + " £" + price;
    }

    @Override
    public void addProduct(Product product)
    {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeProduct(Product product)
    {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Product> getChildren()
    {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPrice()
    {
        return price;
    }
    
    @Override
    public String getDescription()
    {
        return description;
    }
}
