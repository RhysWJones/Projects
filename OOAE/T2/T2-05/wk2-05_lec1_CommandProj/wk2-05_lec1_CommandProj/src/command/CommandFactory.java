package command;

import model.DepartmentHandler;
import model.EmployeeHandler;

public class CommandFactory
{

    public static final int VIEW_ALL_DEPARTMENTS = 1;
    public static final int VIEW_ALL_EMPLOYEES = 2;

    public static Command create(int typeOfCommand)
    {
        switch (typeOfCommand)
        {
            case VIEW_ALL_DEPARTMENTS:
                return new GetAllDeptsCommand(new DepartmentHandler());
            case VIEW_ALL_EMPLOYEES:
                return new GetAllEmployeesCommand(new EmployeeHandler());
            default:
                return null;
        }
    }
}
