package compositepatternorderproj;

import Order.Order;
import Product.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rhys Jones
 */
public class CompositePatternOrderProj
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        Order order = createOrder();
        
        
        HashMap<String, ArrayList<Product>> productsInOrder = order.getOrder();
        
        System.out.println(outputOrder(productsInOrder));
        
//        ArrayList<Product> listOfProducts = new ArrayList<>();

//        createSimpleProducts(listOfProducts);

//        createComplexProducts(listOfProducts);

//        for (Product p : listOfProducts)
//        {
//            System.out.println(p.toString());
//        }

    }

    public static void createSimpleProducts(ArrayList<Product> listOfProducts)
    {
        //Create hammer product.
        Product hammer = new SimpleProduct("Hammer", 19.95);
        //Add hammer to the list of products.
        listOfProducts.add(hammer);

        //Create assorted nails product
        Product nails = new SimpleProduct("Assorted nails", 9.95);
        //Add assorted nails to the list of products.
        listOfProducts.add(nails);

        //Create glass front product
        Product glass = new SimpleProduct("Glass front", 0.80);
        //Add glass front to the list of products.
        listOfProducts.add(glass);

        //Create frame product
        Product frame = new SimpleProduct("Frame", 1.20);
        //Add frame to the list of products.
        listOfProducts.add(frame);

        //Create backing board product
        Product board = new SimpleProduct("Backing board", 0.30);
        //Add backing board to the list of products.
        listOfProducts.add(board);
    }

    public static void createComplexProducts(ArrayList<Product> listOfProducts)
    {
        //Create complex (picture) product.
        Product picture = new ComplexProduct("Picture");

        //Add products to picture
        picture.addProduct(new SimpleProduct("Glass front", 0.80));
        picture.addProduct(new SimpleProduct("Frame", 1.20));
        picture.addProduct(new SimpleProduct("Backing board", 0.30));
        //Add complex (picture) product to the list of products.
        listOfProducts.add(picture);
    }
    
    public static Order createOrder()
    {
        //Create complex (picture) product.
        Order order = new Order();

        //Add products to order
        //2 Hammers
        order.addProduct(new SimpleProduct("Hammer", 19.95));
        order.addProduct(new SimpleProduct("Hammer", 19.95));
        
        //2 Assorted Nails
        order.addProduct(new SimpleProduct("Assorted nails", 9.95));
        order.addProduct(new SimpleProduct("Assorted nails", 9.95));
        
        //3 glass fronts
        order.addProduct(new SimpleProduct("Glass Front", 0.80));
        order.addProduct(new SimpleProduct("Glass Front", 0.80));
        order.addProduct(new SimpleProduct("Glass Front", 0.80));
        
        //3 Frames
        order.addProduct(new SimpleProduct("Frame", 1.20));
        order.addProduct(new SimpleProduct("Frame", 1.20));
        order.addProduct(new SimpleProduct("Frame", 1.20));
        
        //3 Backing Boards
        order.addProduct(new SimpleProduct("Backing board", 0.30));
        order.addProduct(new SimpleProduct("Backing board", 0.30));
        order.addProduct(new SimpleProduct("Backing board", 0.30));
        
        //Return order
        return order;
    }
    
    public static String outputOrder(HashMap<String, ArrayList<Product>> productsInOrder)
    {
        String s = "============================================================\n";
        s += String.format("%-16s %-16s %-16s %-7s \n", "Description", "Price(£)", "Quantity", "Cost(£)");
        s += "============================================================\n";

        double total = 0;

        for (Map.Entry<String, ArrayList<Product>> entry : productsInOrder.entrySet())
        {
            ArrayList<Product> value = entry.getValue();

            int quantity = value.size();

            s += String.format("%-16s %-16.2f %-16s %-7.2f \n",
                    value.get(0).getDescription(),
                    value.get(0).getPrice(),
                    quantity,
                    (value.get(0).getPrice() * quantity));

            total += (value.get(0).getPrice() * quantity);
        }

        s += String.format("%60s \n", "----------");
        s += String.format("%-50s %-7.2f", "Total", total);
        return s;
    }

}
