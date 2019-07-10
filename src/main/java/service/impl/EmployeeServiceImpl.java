package service.impl;

import dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.CurQuery;
import pojo.Employee;
import service.EmployeeService;
import utils.GenerateConditionalStmt;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void queryByGet(HttpServletRequest request) {
        int deptno = -1;
        if (request.getParameter("deptno") != null) {
            deptno = Integer.valueOf(request.getParameter("deptno"));
            request.setAttribute("hiddenList", false);
            request.setAttribute("employeeList", employeeDao.queryEmployee(String.format("deptno=%d", deptno)));
        } else {
            request.setAttribute("hiddenList", true);
            request.setAttribute("employeeList", new ArrayList<Employee>());
        }
        request.setAttribute("curQuery", new Employee("", "", "", -1, -1, -1, Integer.valueOf(deptno)));
    }

    @Override
    public void queryByPost(HttpServletRequest request) {
        request.setAttribute("hiddenList", false);
        CurQuery cq = new CurQuery(
                request.getParameter("name"),
                request.getParameter("job"),
                request.getParameter("sal"),
                request.getParameter("comm"),
                request.getParameter("hiredateStr"),
                request.getParameter("mgr"),
                request.getParameter("dept")
        );
        request.setAttribute("employeeList", employeeDao.queryEmployee(new GenerateConditionalStmt().getGcs(cq)));
        request.setAttribute("curQuery", new Employee(
                cq.name,
                cq.job,
                cq.hiredateStr,
                cq.sal.equals("") ? -1 : Integer.valueOf(cq.sal),
                cq.comm.equals("") ? -1 : Double.valueOf(cq.comm),
                Integer.valueOf(cq.mgr),
                Integer.valueOf(cq.dept)
        ));
    }

    @Override
    public void getEmployee(int id, HttpServletRequest request) {
        request.setAttribute("curEmployee", employeeDao.getEmployee(id));
        request.setAttribute("avatar", employeeDao.getAvatar(id));
    }

    @Override
    public void addEmployee(String name, String job, String hiredateStr, int sal, double comm, int mgr, int dept) {
        employeeDao.addEmployee(new Employee(name, job, hiredateStr, sal, comm, mgr, dept));
    }

    @Override
    public int getMaxId() {
        return employeeDao.getMaxId();
    }

    @Override
    public void updateEmployee(HttpServletRequest request) {
        employeeDao.updateEmployee(new Employee(
                Integer.valueOf(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("job"),
                request.getParameter("hiredateStr"),
                Integer.valueOf(request.getParameter("sal")),
                Double.valueOf(request.getParameter("comm")),
                Integer.valueOf(request.getParameter("mgr")),
                Integer.valueOf(request.getParameter("dept"))
        ));
    }

    @Override
    public void updateAvatar(String avatar, int id) {
        employeeDao.updateAvatar(avatar, id);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public void deleteAllQuery(CurQuery cq) {
        employeeDao.deleteAllQuery(new GenerateConditionalStmt().getGcs(cq));
    }
}
