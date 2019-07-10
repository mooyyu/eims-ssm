package dao;

import pojo.Department;
import java.util.List;

public interface DepartmentDao {
    List<Department> getDepartmentList();

    List<Department> getDepartmentNameList();

    Department getDeptInfo(int id);

    int countDepartments();
}
