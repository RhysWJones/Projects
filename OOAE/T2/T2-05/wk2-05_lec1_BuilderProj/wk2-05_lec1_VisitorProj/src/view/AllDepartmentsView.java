package view;

import department.Department;
import department.DepartmentPrinter;
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
        DepartmentPrinter deptPrinter = new DepartmentPrinter();
        
        System.out.println("All departments");
        System.out.println("===============");
        for (Department dept : departments)
        {
            dept.accept(deptPrinter);
        }
    }
}
