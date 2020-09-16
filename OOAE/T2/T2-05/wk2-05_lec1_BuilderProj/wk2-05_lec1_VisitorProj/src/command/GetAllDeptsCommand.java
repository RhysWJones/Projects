package command;

import model.DepartmentHandler;
import view.AllDepartmentsView;

public class GetAllDeptsCommand implements Command
{

    DepartmentHandler receiver;

    public GetAllDeptsCommand(DepartmentHandler receiver)
    {
        this.receiver = receiver;
    }

    @Override
    public void execute()
    {
        new AllDepartmentsView(receiver.findAllDepartments()).print();
    }

}
