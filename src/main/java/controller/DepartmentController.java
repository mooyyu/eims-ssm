package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DepartmentService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("list")
    public String getList(HttpServletRequest request) {
        request.setAttribute("departmentList", departmentService.getDepartmentList());
        return "components/departmentList";
    }

    @RequestMapping("info")
    public String getInfo(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("dept", departmentService.getDeptInfo(id));
        return "components/departmentInfo";
    }
}
