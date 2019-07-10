package service.impl;

import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.MgrDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UtilsService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class UtilsServiceImpl implements UtilsService {
    @Autowired
    private MgrDao mgrDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void getOptions(HttpServletRequest request) {
        request.setAttribute("MgrNameList", mgrDao.getMGRNameList());
        request.setAttribute("DeptNameList", departmentDao.getDepartmentNameList());
    }

    @Override
    public void overView(HttpServletRequest request) {
        Map map = new HashMap();
        map.put("departments", departmentDao.countDepartments());
        map.put("managers", mgrDao.countMgrs());
        map.put("employees", employeeDao.countEmployees());
        map.put("salSum", employeeDao.getSalSum());
        if (map.get("salSum") == null) {
            map.put("salSum", 0);
        }
        request.setAttribute("eims", map);
    }
}
