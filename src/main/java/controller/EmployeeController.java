package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.CurQuery;
import service.EmployeeService;
import service.UtilsService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UtilsService utilsService;

    @RequestMapping("add")
    public String add(HttpServletRequest request) {
        utilsService.getOptions(request);
        return "components/addEmployee";
    }

    @RequestMapping(value = "doAdd", method = {RequestMethod.POST})
    public String doAdd(
            @RequestParam String name,
            @RequestParam String job,
            @RequestParam String hiredateStr,
            @RequestParam int sal,
            @RequestParam double comm,
            @RequestParam int mgr,
            @RequestParam int dept
    ) {
        employeeService.addEmployee(name, job, hiredateStr, sal, comm, mgr, dept);
        return String.format("redirect:/admin?aside=employeeInfo&id=%d", employeeService.getMaxId() );
    }

    @RequestMapping("edit")
    public String edit(@RequestParam int id, HttpServletRequest request) {
        utilsService.getOptions(request);
        employeeService.getEmployee(id, request);
        return "components/employeeInfo";
    }

    @RequestMapping(value = "query", method = {RequestMethod.GET})
    public String query(HttpServletRequest request) {
        utilsService.getOptions(request);
        employeeService.queryByGet(request);
        return "components/employeeList";
    }

    @RequestMapping(value = "query", method = {RequestMethod.POST})
    public String doQuery(HttpServletRequest request) {
        utilsService.getOptions(request);
        employeeService.queryByPost(request);
        return "components/employeeList";
    }

    @RequestMapping(value = "delete", method = {RequestMethod.GET})
    @ResponseBody
    public String doDelete(@RequestParam int id) {
        employeeService.deleteEmployee(id);
        return "ok";
    }

    @RequestMapping(value = "delete", method = {RequestMethod.POST})
    @ResponseBody
    public String doDeleteQuery(@RequestBody CurQuery cq) {
        employeeService.deleteAllQuery(cq);
        return "ok";
    }

    @RequestMapping("update")
    public String update(HttpServletRequest request) {
        employeeService.updateEmployee(request);
        return "redirect:/admin?aside=employeeInfo&id=" + request.getParameter("id");
    }

    @RequestMapping("uploadAvatar")
    @ResponseBody
    public String uploadAvatar(@RequestBody Map map) {
        employeeService.updateAvatar((String)map.get("avatar"), (Integer)map.get("id"));
        return "ok";
    }
}
