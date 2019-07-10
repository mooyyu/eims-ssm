package service;

import pojo.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartmentList();

    Department getDeptInfo(int id);
}
