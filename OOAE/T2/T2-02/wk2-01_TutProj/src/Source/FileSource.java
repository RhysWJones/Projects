package Source;

import DTO.DeptDTO;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileSource implements Source
{

    private File departmentFile = new File("dept.txt");
    private Scanner inFile;

    @Override
    public ArrayList<DeptDTO> getAllDepartments() throws Exception
    {
        ArrayList<DeptDTO> departments = new ArrayList<>();

        inFile = new Scanner(departmentFile);

        String line = inFile.nextLine();
        String[] stringArray; // Skip over the column names

        //data lines
        while (inFile.hasNextLine())
        {
            line = inFile.nextLine();
            stringArray = line.split(":");

            DeptDTO dept = new DeptDTO((Integer.parseInt(stringArray[0])), stringArray[1], stringArray[2]);
            departments.add(dept);

        }
        inFile.close();

        return departments;
    }

    @Override
    public boolean insertDepartment(DeptDTO dept) throws Exception
    {
        inFile = new Scanner(departmentFile);
        String content;
        String[] stringArray;

        //header line
        String line = inFile.nextLine();
        content = line;

        ArrayList<DeptDTO> departments = getAllDepartments();

        departments.add(dept);
        Collections.sort(departments);

        for (DeptDTO d : departments)
        {
            content += "\r\n" + d.toString();
        }

        inFile.close();

        PrintWriter outFile = new PrintWriter(departmentFile);
        outFile.print(content);
        outFile.close();

        return true;
    }

    @Override
    public boolean deleteDepartment(DeptDTO dept) throws Exception
    {
        inFile = new Scanner(departmentFile);
        String content;
        String[] stringArray;

        //header line
        String line = inFile.nextLine();
        content = line;

        ArrayList<DeptDTO> departments = getAllDepartments();

        for (DeptDTO d : departments)
        {
            if (!((d.getDepartmentNumber() == dept.getDepartmentNumber())
                    && (d.getDepartmentName().equalsIgnoreCase(dept.getDepartmentName()))
                    && (d.getDepartmentLocation().equalsIgnoreCase(dept.getDepartmentLocation()))))
            {
                content += "\r\n" + d.toString();
            }
        }
        inFile.close();

        PrintWriter outFile = new PrintWriter(departmentFile);
        outFile.print(content);
        outFile.close();

        return true;
    }
}
