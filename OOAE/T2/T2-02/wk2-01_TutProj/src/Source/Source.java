package Source;

import DTO.DeptDTO;
import java.util.ArrayList;

public interface Source
{
    public ArrayList<DeptDTO> getAllDepartments() throws Exception;
    public boolean insertDepartment(DeptDTO dept) throws Exception;
    public boolean deleteDepartment(DeptDTO dept) throws Exception;
}
