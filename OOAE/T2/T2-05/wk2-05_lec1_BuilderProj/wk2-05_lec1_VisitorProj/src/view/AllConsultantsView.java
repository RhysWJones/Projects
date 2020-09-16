package view;

import database.Consultant;
import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public class AllConsultantsView 
{
    ArrayList<Consultant> consultants;

    public AllConsultantsView(ArrayList<Consultant> consultants)
    {
        this.consultants = consultants;
    }

    public void print()
    {
        System.out.println("All consultants");
        System.out.println("===============");
        for (Consultant c : consultants)
        {
            System.out.printf("%-5d   %-15s   %-5d\n",
                    c.getID(),
                    c.getName(),
                    c.getPrice());
        }
    }
}
