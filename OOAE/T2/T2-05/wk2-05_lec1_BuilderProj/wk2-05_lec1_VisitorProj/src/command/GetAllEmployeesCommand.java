package command;

import model.EmployeeHandler;
import view.AllEmployeesView;

/**
 *
 * @author Rhys Jones
 */
public class GetAllEmployeesCommand implements Command
{
    EmployeeHandler receiver;

    public GetAllEmployeesCommand(EmployeeHandler receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute()
    {
        new AllEmployeesView(receiver.findAllEmployees()).print();
    }
}
