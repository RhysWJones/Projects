package Department;

public class Department implements DepartmentVisitNode
{
    private int deptNo;
    private String dName;
    private String location;

    public Department()
    {
        this(-1, "", "");
    }

    public Department(int deptNo, String dName, String location)
    {
        this.deptNo = deptNo;
        this.dName = dName;
        this.location = location;
    }
    
    public int getID()
    {
        return deptNo;
    }

    public String getName()
    {
        return dName;
    }

    public String getLocation()
    {
        return location;
    }

    public void setID(int deptNo)
    {
        this.deptNo = deptNo;
    }

    public void setName(String dName)
    {
        this.dName = dName;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    @Override
    public void accept(DepartmentVisitor visitor)
    {
        visitor.visitDepartment(this);
    }
}
