<%--
  Created by IntelliJ IDEA.
  User: mooyyu
  Date: 2019-07-08
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="aside" value="${empty param.aside ? 'default' : param.aside}"></c:set>
<div class="list-group">
    <a href="?aside=default" class="list-group-item list-group-item-action ${aside=='default' ? 'active disabled' : ''}">信息总览</a>
    <a href="?aside=departmentList" class="list-group-item list-group-item-action ${aside=='departmentList' ? 'active disabled' : ''}">部门列表</a>
    <a class="list-group-item list-group-item-action disabled ${aside=='departmentInfo' ? 'active' : ''}">部门详情</a>
    <hr>
    <a href="?aside=employeeList" class="list-group-item list-group-item-action ${aside=='employeeList' ? 'active disabled' : ''}">雇员查询</a>
    <a href="?aside=addEmployee" class="list-group-item list-group-item-action ${aside=='addEmployee' ? 'active disabled' : ''}">添加雇员</a>
    <a class="list-group-item list-group-item-action disabled ${aside=='employeeInfo' ? 'active' : ''}">编辑雇员</a>
</div>