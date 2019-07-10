package service;

import pojo.CurQuery;

import javax.servlet.http.HttpServletRequest;

public interface EmployeeService {
    void queryByGet(HttpServletRequest request);

    void queryByPost(HttpServletRequest request);

    void getEmployee(int id, HttpServletRequest request);

    void addEmployee(String name, String job, String hiredateStr, int sal, double comm, int mgr, int dept);

    int getMaxId();

    void updateEmployee(HttpServletRequest request);

    void updateAvatar(String avatar, int id);

    void deleteEmployee(int id);

    void deleteAllQuery(CurQuery cq);
}
