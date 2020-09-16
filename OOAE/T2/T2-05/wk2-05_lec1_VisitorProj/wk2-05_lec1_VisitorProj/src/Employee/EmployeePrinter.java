package Employee;

import java.text.SimpleDateFormat;

/**
 *
 * @author Rhys Jones
 */
public class EmployeePrinter extends EmployeeVisitor
{
    @Override
    public void visitEmployee(Employee e)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%-5d   %-10s   %-10s   %-5d   %-10s   %-5d   %-5d   %-5d\n",
                    e.getEmployeeNumber(),
                    e.getEmployeeName(),
                    e.getJob(),
                    e.getManager(),
                    sdf.format(e.getHireDate()),
                    e.getSalary(),
                    e.getComm(),
                    e.getDeptNo());
        
    }
}
