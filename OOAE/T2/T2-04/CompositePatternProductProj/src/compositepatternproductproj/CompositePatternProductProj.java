package compositepatternproductproj;

import Product.*;
import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public class CompositePatternProductProj
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList<Product> listOfProducts = new ArrayList<>();

        createSimpleProducts(listOfProducts);

        createComplexProducts(listOfProducts);

        for (Product p : listOfProducts)
        {
            System.out.println(p.toString());
        }

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

}
