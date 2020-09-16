package DTO;

/**
 *
 * @author Rhys Jones
 */
public class DeptDTO implements Comparable<DeptDTO>
{
    private int departmentNumber;
    private String departmentName;
    private String departmentLocation;

    public DeptDTO(int departmentNumber, String departmentName, String departmentLocation)
    {
        this.departmentNumber = departmentNumber;
        this.departmentName = departmentName;
        this.departmentLocation = departmentLocation;
    }

    public int getDepartmentNumber()
    {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber)
    {
        this.departmentNumber = departmentNumber;
    }

    public String getDepartmentName()
    {
        return departmentName;
    }

    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }

    public String getDepartmentLocation()
    {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation)
    {
        this.departmentLocation = departmentLocation;
    }

    @Override
    public int compareTo(DeptDTO compareDept)
    {
        return Integer.compare(this.departmentNumber, compareDept.getDepartmentNumber());
    }
    
    @Override
    public String toString()
    {
        return this.departmentNumber + ":" + this.departmentName + ":" + this.departmentLocation;
    }
}
