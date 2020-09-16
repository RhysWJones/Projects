package view;

import employee.Employee;
import employee.EmployeePrinter;
import java.util.ArrayList;

/**
 *
 * @author Rhys Jones
 */
public class AllEmployeesView
{
    ArrayList<Employee> employees;

    public AllEmployeesView(ArrayList<Employee> employees)
    {
        this.employees = employees;
    }

    public void print()
    {
        EmployeePrinter empPrinter = new EmployeePrinter();
        
        System.out.println("All employees");
        System.out.println("===============");
        
        for (Employee emp : employees)
        {
            emp.accept(empPrinter);
        }
    }
}
