package view;

import database.Employee;
import java.text.SimpleDateFormat;
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("All employees\n");
        for(int i = 0; i < 60; i++);
        {
            System.out.print("=");
        }
        
        for (Employee emp : employees)
        {
            System.out.printf("\t%5d   %10s   %10s   %5d   %10s   %5d   %5d   %5d\n",
                    emp.getEmployeeNumber(),
                    emp.getEmployeeName(),
                    emp.getJob(),
                    emp.getManager(),
                    sdf.format(emp.getHireDate()),
                    emp.getSalary(),
                    emp.getComm(),
                    emp.getDeptNo());
        }
    }
}
