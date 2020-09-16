package Order;

import Product.Product;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rhys Jones
 */
public class Order
{

    private HashMap<String, ArrayList<Product>> productsMap;

    public Order()
    {
        productsMap = new HashMap<>();
    }

    public void addProduct(Product product)
    {
        if (productsMap.containsKey(product.getDescription()))
        {
            productsMap.get(product.getDescription()).add(product);
        }

        else
        {
            ArrayList<Product> tempProduct = new ArrayList<>();
            tempProduct.add(product);

            productsMap.put(product.getDescription(), tempProduct);
        }
    }

    public void removeProduct(Product product)
    {
        if (productsMap.containsKey(product.getDescription()))
        {
            int size = productsMap.get(product.getDescription()).size();

            if (size == 1)
            {
                productsMap.remove(product.getDescription());
                return;
            }

            productsMap.get(product.getDescription()).remove(0);
        }
    }
    
    public HashMap<String, ArrayList<Product>> getOrder()
    {
        return productsMap;
    }

}
