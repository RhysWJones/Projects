package factorymethodpatternguiproj;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author Rhys Jones
 */
public class FactoryMethodPatternGUIProj extends JFrame
{

    private static ArrayList<String> choices = new ArrayList<>();

    public FactoryMethodPatternGUIProj()
    {
        super("OOAE WEEK 4 TUTORIAL TASK 3");

        String[] choicesArray = new String[choices.size()];
        choices.toArray(choicesArray);
        
        ConcreteFactory factory = new ConcreteFactory();

        add(factory.createUIProduct(choicesArray));
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int menuChoice = 0;
        Scanner kybd = new Scanner(System.in);

        while (menuChoice != 9 && menuChoice != 2)
        {
            displayMenu();
            System.out.print("Please enter a number from the index: ");
            menuChoice = kybd.nextInt();
            kybd.nextLine(); //flush buffer
            switch (menuChoice)
            {
                case 9:
                    return;
                case 2:
                    break;
                case 1:
                    System.out.print("Enter a choice for the GUI: ");
                    choices.add(kybd.nextLine());
                    break;
                default:
                    break;
            }
        }

        new FactoryMethodPatternGUIProj();
    }

    public static void displayMenu()
    {
        String s = "1. Add choice\n";
        s += "2. Display Choices GUI\n";
        s += "9. Exit";

        System.out.println(s);
    }

}
