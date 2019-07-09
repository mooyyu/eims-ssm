<%--
  Created by IntelliJ IDEA.
  User: mooyyu
  Date: 2019-07-09
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light border border-dark">
    <div class="container">
        <a class="navbar-brand">${dept.name}详细情况</a>
    </div>
</nav>
<div class="table-responsive border border-dark">
    <table class="table table-striped table-dark text-nowrap">
        <thead>
        <tr>
            <th scope="col">Key</th>
            <th scope="col">Value</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>部门名称</td>
            <td>${dept.name}</td>
        </tr>
        <tr>
            <td>部门地址</td>
            <td>${dept.address}</td>
        </tr>
        <tr>
            <td>部门总人数</td>
            <td>${dept.totalPeople}</td>
        </tr>
        <tr>
            <td>部门最高工资</td>
            <td>${dept.maxWage}</td>
        </tr>
        <tr>
            <td>部门最低工资</td>
            <td>${dept.minWage}</td>
        </tr>
        <tr>
            <td>部门总工资</td>
            <td>${dept.totalSalary}</td>
        </tr>
        <tr>
            <td>部门平均工资</td>
            <td>${dept.avgSalary}</td>
        </tr>
        </tbody>
    </table>
</div>