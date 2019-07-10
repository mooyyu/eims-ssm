package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DepartmentDao;
import pojo.Department;
import service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getDepartmentList() {
        return departmentDao.getDepartmentList();
    }

    @Override
    public Department getDeptInfo(int id) {
        return departmentDao.getDeptInfo(id);
    }
}
