package Product;

import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public interface Product
{

    @Override
    public String toString();

    public void addProduct(Product product);

    public void removeProduct(Product product);

    public ArrayList<Product> getChildren();
    
    public double getPrice();
    
    public String getDescription();
}
