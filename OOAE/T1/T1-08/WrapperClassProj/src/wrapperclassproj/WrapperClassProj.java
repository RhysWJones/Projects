package wrapperclassproj;

import java.util.ArrayList;
import java.util.Scanner;

public class WrapperClassProj
{
    static Scanner kybd = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        ArrayList<Double> numbers = new ArrayList(5);
        
        System.out.print("Please enter 5 doubles:> ");
        
        for(int i=0; i < 5; i++)
        {
            numbers.add(numberInput());
        }
        
        printDoublesBackwards(numbers);
    }
    
    public static double numberInput()
    {
        Double input;
        
        input = kybd.nextDouble();
        kybd.nextLine();
        
        return input;
    }
    
    public static void printDoublesBackwards(ArrayList<Double> numbers)
    {
        System.out.println("\nPrinting the doubles backwards!" + 
                            "\n===============================");
        for (int i = 4; i >= 0; i--)
        {
            System.out.println(numbers.get(i));
        }
    }
    
}
