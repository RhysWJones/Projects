
import customer.Customer;
import customer.CustomerInteraction;
import customer.DeleteCustomer;
import customer.GetCustomer;
import customer.InsertCustomer;
import java.util.Scanner;

public class MyApplication
{

    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        int option = getOption();
        CustomerInteraction interaction;

        switch (option)
        {
            case 1: //get customer
                System.out.print("Customer id: > ");
                int custId = kybd.nextInt();
                interaction = new GetCustomer(custId);
                interaction.execute();
                Customer cust = interaction.getCustomer();
                break;
            case 2: //delete customer
                System.out.print("Customer id: > ");
                custId = kybd.nextInt();
                interaction = new DeleteCustomer(custId);
                interaction.execute();
                int numberOfCustomersDeleted = interaction.getRows();
                break;
            case 3: //insert customer
                System.out.print("Customer name: > ");
                String name = kybd.nextLine();
                interaction = new InsertCustomer(name);
                interaction.execute();
                int numberOfCustomersInserted = interaction.getRows();
                break;
        }
    }

    private static int getOption()
    {
        int option = -1;
        // prompt use for option
        // read option from keyboard
        // flush keyboard buffer
        return option;
    }
}
