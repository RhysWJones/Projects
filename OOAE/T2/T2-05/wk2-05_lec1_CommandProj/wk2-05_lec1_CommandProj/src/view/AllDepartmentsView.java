package view;

import database.Department;
import java.util.ArrayList;

public class AllDepartmentsView
{

    ArrayList<Department> departments;

    public AllDepartmentsView(ArrayList<Department> departments)
    {
        this.departments = departments;
    }

    public void print()
    {
        System.out.println("All departments");
        System.out.println("===============");
        for (Department dept : departments)
        {
            System.out.printf("\t%5d   %10s   %10s\n",
                    dept.getID(),
                    dept.getName(),
                    dept.getLocation());
        }
    }
}
