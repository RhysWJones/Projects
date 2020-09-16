package Employee;

import java.util.Date;

/**
 *
 * @author Rhys Jones
 */
public class Employee implements EmployeeVisitNode
{
    private int employeeNumber;
    private String employeeName;
    private String job;
    private int manager;
    private Date hireDate;
    private int salary;
    private int comm;
    private int deptNo;

    public Employee(int employeeNumber, String employeeName, String job, int manager, Date hireDate, int salary, int comm, int deptNo)
    {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.job = job;
        this.manager = manager;
        this.hireDate = hireDate;
        this.salary = salary;
        this.comm = comm;
        this.deptNo = deptNo;
    }

    public int getEmployeeNumber()
    {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber)
    {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }

    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
    }

    public String getJob()
    {
        return job;
    }

    public void setJob(String job)
    {
        this.job = job;
    }

    public int getManager()
    {
        return manager;
    }

    public void setManager(int manager)
    {
        this.manager = manager;
    }

    public Date getHireDate()
    {
        return hireDate;
    }

    public void setHireDate(Date hireDate)
    {
        this.hireDate = hireDate;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public int getComm()
    {
        return comm;
    }

    public void setComm(int comm)
    {
        this.comm = comm;
    }

    public int getDeptNo()
    {
        return deptNo;
    }

    public void setDeptNo(int deptNo)
    {
        this.deptNo = deptNo;
    }

    @Override
    public void accept(EmployeeVisitor visitor)
    {
        visitor.visitEmployee(this);
    }
    
    
}
