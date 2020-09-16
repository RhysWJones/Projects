package regularexpressionsproj;

import java.util.Scanner;

public class RegularExpressionsProj
{

    public static void main(String[] args)
    {
        String input = "";
        Scanner kybd = new Scanner(System.in);

        while (!input.equals("0"))
        {
            System.out.print("Please enter a name, or 0 to exit:>");
            input = kybd.nextLine();

            if (input.matches("(Will|William)"))
            {
                System.out.println("Name matches either Will or William");
            }
            else if(input.matches("0"))
            {
                return;
            }
            else
            {
                System.out.println("Name does not match");
            }
        }
    }

}
