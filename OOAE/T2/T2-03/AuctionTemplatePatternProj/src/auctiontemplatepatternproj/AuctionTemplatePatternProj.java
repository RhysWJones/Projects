package auctiontemplatepatternproj;

import AuctionItem.AuctionItem;
import AuctionItem.FineChina;
import AuctionItem.Jewellery;
import AuctionItem.Painting;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Rhys Jones
 */
public class AuctionTemplatePatternProj
{

    private static Scanner kybd = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int choice = 0;

        while (choice != 9)
        {
            outputMenu();

            try
            {
                System.out.println("Enter the number that corresponds to the choice you wish to choose:");
                choice = kybd.nextInt();
            }
            catch (InputMismatchException ime)
            {
                System.out.println("Input must be a number!");
            }
            kybd.nextLine(); // Flush buffer

            if (choice == 1)
            {
                System.out.println("You have chosen 'Fine China' please enter some information.");
                System.out.print("Description:");
                String description = kybd.nextLine();

                AuctionItem china = new FineChina(description);

                sell(china);

                outputAuctionDetails(china);
            }
            
            else if (choice == 2)
            {
                System.out.println("You have chosen 'Painting' please enter some information.");
                System.out.print("Description:");
                String description = kybd.nextLine();

                AuctionItem painting = new Painting(description);

                sell(painting);

                outputAuctionDetails(painting);
            }
            
            else if (choice == 3)
            {
                System.out.println("You have chosen 'Jewellery' please enter some information.");
                System.out.print("Description:");
                String description = kybd.nextLine();

                AuctionItem jewellery = new Jewellery(description);

                sell(jewellery);

                outputAuctionDetails(jewellery);
            }
        }
    }

    public static void outputMenu()
    {
        System.out.println("1. Fine China");
        System.out.println("2. Painting");
        System.out.println("3. Jewellery");
        System.out.println("9. Exit");
    }

    public static void sell(AuctionItem item)
    {
        System.out.print("Hammer price of the item (the stated price during sale, before VAT):");
        double hammerPrice = kybd.nextDouble();
        kybd.nextLine(); //flush buffer

        item.auction(hammerPrice);
    }

    public static void outputAuctionDetails(AuctionItem item)
    {
        System.out.println(item.toString());
    }
}
