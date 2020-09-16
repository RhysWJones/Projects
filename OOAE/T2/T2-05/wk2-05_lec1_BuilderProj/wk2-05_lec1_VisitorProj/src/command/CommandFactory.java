package command;

import model.ConsultantHandler;
import model.DepartmentHandler;
import model.EmployeeHandler;

public class CommandFactory
{

    public static final int VIEW_ALL_DEPARTMENTS = 1;
    public static final int VIEW_ALL_EMPLOYEES = 2;
    public static final int VIEW_ALL_CONSULTANTS = 3;

    public static Command create(int typeOfCommand)
    {
        switch (typeOfCommand)
        {
            case VIEW_ALL_DEPARTMENTS:
                return new GetAllDeptsCommand(new DepartmentHandler());
            case VIEW_ALL_EMPLOYEES:
                return new GetAllEmployeesCommand(new EmployeeHandler());
            case VIEW_ALL_CONSULTANTS:
                return new GetAllConsultantsCommand(new ConsultantHandler());
            default:
                return null;
        }
    }
}
