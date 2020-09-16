
import command.CommandFactory;
import java.util.Scanner;

public class Client
{

    public static void main(String[] args)
    {
        int choice = displayMenu();
        CommandFactory.create(choice).execute();
    }
    
    public static int displayMenu()
    {
        Scanner kybd = new Scanner(System.in);
        
        System.out.println("1. Display all departments");
        System.out.println("2. Display all employees");
        System.out.println("3. Display all consultants");
        System.out.print("Option: >");
        int choice = kybd.nextInt();
        kybd.nextLine(); // Flush Buffer
        return choice;
    }
}
