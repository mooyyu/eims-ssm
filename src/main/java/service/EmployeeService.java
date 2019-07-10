package service;

import pojo.Employee;

import javax.servlet.http.HttpServletRequest;

public interface EmployeeService {
    void queryByGet(HttpServletRequest request);

    void queryByPost(HttpServletRequest request);

    void getEmployee(int id, HttpServletRequest request);

    void addEmployee(String name, String job, String hiredateStr, int sal, double comm, int mgr, int dept);

    int getMaxId();

    int updateEmployee(Employee e);

    void updateAvatar(String avatar, int id);

    String getAvatar(int id);

    void deleteEmployee(int id);

    void deleteAllQuery(String gcs);
}
