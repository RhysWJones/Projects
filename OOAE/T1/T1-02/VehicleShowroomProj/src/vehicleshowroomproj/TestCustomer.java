package vehicleshowroomproj;

public class TestCustomer
{
    public static void main(String[] args)
    {
        Customer customer1 = new Customer("David Blake", "DavidB87@gmail.com");
        System.out.println(" " + customer1.getName());
        System.out.println(" " + customer1.getContactDetails());

        customer1.setName("Jacob Bocaj");
        customer1.setContactDetails("07721145832");
        
        System.out.println("\n setName and setContactDetails called to change the original attributes \n");
        System.out.println(" " + customer1.getName());
        System.out.println(" " + customer1.getContactDetails());
        
        System.out.println("\n Now we will call toString");
        System.out.println(" " + customer1.toString());
    }
}
