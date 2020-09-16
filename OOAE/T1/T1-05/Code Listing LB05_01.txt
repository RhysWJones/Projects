package lb05_01;

import java.util.*;

public class LB05_01
{

    static Scanner kybd = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Valid integer input was: " + inputInt());
        System.out.println("");
        System.out.println("Valid double input was: " + inputDouble());
    }

    public static int inputInt()
    {
        int num = 0;
        boolean valid = false;
        
        while (valid == false)
        {
            try
            {
                System.out.print("Enter a number: ");
                num = kybd.nextInt();
                valid = true;
            }

            catch (Exception e)
            {
                System.out.println("Integers only please");
                kybd.next();
            }
        }
        
        return num;
    }

    public static double inputDouble()
    {
        double doubleNum = 0;
        boolean valid = false;
        
        while (valid == false)
        {
            try
            {
                System.out.print("Enter a number: ");
                doubleNum = kybd.nextDouble();
                valid = true;
            }

            catch (Exception e)
            {
                System.out.println("Doubles only please");
                kybd.next();
            }
        }
        return doubleNum;
    }
}
