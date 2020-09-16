
import DTO.DeptDTO;
import java.util.*;
import Source.DbSource;
import Source.FileSource;
import Source.Source;
import java.sql.SQLException;

public class MainApp
{
    
    private static Source source;
    private static ArrayList<DeptDTO> departments = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        String username, password;

        System.out.print("Do you wish to login to Oracle? (Yes/No): > ");
        String useOracle = kybd.next();

        if (useOracle.equalsIgnoreCase("yes"))
        {

            System.out.print("Oracle username: > ");
            username = kybd.next();
            System.out.print("Oracle password: > ");
            password = kybd.next();

            if (username.equals("") || password.equals(""))
            {
                System.out.println("Invalid username or password");
            }

            else
            {
                source = new DbSource(username, password);
//                DatabaseManager.getInstance().setUsername(username);
//                DatabaseManager.getInstance().setPassword(password);
                try
                {
                    displayData();

                    insert(kybd);

                    displayData();

                    delete(kybd);

                    displayData();
                }
                catch (SQLException sqle)
                {
                    System.out.println("ERROR: Incorrect username or password or query error.");
                    System.out.println("\nExiting...");
                    System.out.println(sqle);
                }
                catch (Exception e)
                {
                    System.out.println("ERROR: Exiting...");
                    System.out.println("\n" + e);
                }
            }
        }
        else
        {
            source = new FileSource();
            try
            {
                displayData();

                insert(kybd);

                displayData();

                delete(kybd);

                displayData();
            }
            catch (Exception e)
            {
                System.out.println("ERROR: Exiting...");
                System.out.println("\n" + e);
            }
        }
    }

    public static void insert(Scanner kybd) throws Exception
    {
        boolean successful;

        System.out.println("INSERT\n====================================");
        DeptDTO dept = createDepartment(kybd);
        
        successful = source.insertDepartment(dept);

        if (successful)
        {
            departments.add(dept);
            System.out.println("Insert successful.");
        }
        else
        {
            System.out.println("Insert unsuccessful.");
        }

    }

    public static void delete(Scanner kybd) throws Exception
    {
        boolean deptNumValid = false;
        boolean successful = false;

        System.out.println("DELETE\n====================================");

        while (!deptNumValid)
        {
            System.out.print("Department number of department to be deleted: > ");
            int deptNum = kybd.nextInt();
            kybd.nextLine(); //flush buffer

            for (DeptDTO dept : departments)
            {
                if (dept.getDepartmentNumber() == deptNum)
                {
                    deptNumValid = true;
                    
                    successful = source.deleteDepartment(dept);
                    
                    if (successful)
                    {
                        departments.remove(dept);
                        return;
                    }
                }
            }
            System.out.println("Department number not valid.");
        }
    }

    public static void displayData() throws Exception
    {
        System.out.println("\n" + "DISPLAY ALL");
        System.out.println("====================================");
        System.out.println("DEPTNO.\tDEPTNAME\tDEPTLOCATION");
        System.out.println("\n------------------------------------");

        departments.removeAll(departments);
        
        departments = source.getAllDepartments();

        for (DeptDTO dept : departments)
        {
            String deptName = dept.getDepartmentName();
            if (deptName.length() < 8)
            {
                deptName += "\t";
            }
            System.out.println(dept.getDepartmentNumber() + "\t" + deptName + "\t" + dept.getDepartmentLocation());
        }

        System.out.println("====================================\n");
    }

    public static DeptDTO createDepartment(Scanner kybd)
    {
        System.out.print("Department number: > ");
        int dNum = kybd.nextInt();
        kybd.nextLine(); //flush buffer

        System.out.print("Department name: > ");
        String dName = kybd.nextLine();

        System.out.print("Location: > ");
        String location = kybd.nextLine();

        DeptDTO dept = new DeptDTO(dNum, dName, location);
        return dept;
    }
}
