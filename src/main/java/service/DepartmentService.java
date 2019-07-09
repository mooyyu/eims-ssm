package service;

import pojo.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartmentList();

    List<Department> getDepartmentNameList();

    Department getDeptInfo(int id);
}
