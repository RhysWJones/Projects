package Department;

/**
 *
 * @author Rhys Jones
 */
public class DepartmentPrinter extends DepartmentVisitor
{
    @Override
    public void visitDepartment(Department d)
    {
            System.out.printf("%-5d   %-10s   %-10s\n",
                    d.getID(),
                    d.getName(),
                    d.getLocation());
    }
}
