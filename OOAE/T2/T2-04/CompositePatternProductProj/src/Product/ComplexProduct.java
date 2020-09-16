package Product;

import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public class ComplexProduct implements Product
{

    private String description;
    private double price;
    protected ArrayList<Product> products = new ArrayList<>();

    public ComplexProduct(String description)
    {
        this.description = description;
    }

    @Override
    public String toString()
    {
        if (!products.isEmpty())
        {
            String tempDesc = description + ": ";
            for (Product p : products)
            {
                if (p == products.get(products.size() - 1))
                {
                    tempDesc += p.getDescription();
                }
                else
                {
                    tempDesc += p.getDescription() + ", ";
                }
            }
            return tempDesc + " £" + price;
        }

        else
        {
            return description + " £" + price;
        }
    }

    @Override
    public void addProduct(Product product)
    {
        products.add(product);

        price += product.getPrice();

    }

    @Override
    public void removeProduct(Product product)
    {
        products.remove(product);

        price -= product.getPrice();
    }

    @Override
    public ArrayList<Product> getChildren()
    {
        return products;
    }

    @Override
    public double getPrice()
    {
        for (Product p : products)
        {
            this.price += p.getPrice();
        }

        return price;
    }

    @Override
    public String getDescription()
    {
        return description;
    }
}
