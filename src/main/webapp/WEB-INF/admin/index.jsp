<%--
  Created by IntelliJ IDEA.
  User: mooyyu
  Date: 2019-07-08
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./resources/css/bootstrap.css">

    <title>雇员信息管理系统</title>
</head>
<body style="min-height: 100vh; min-width: 1100px; position: relative;">
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="./resources/js/jquery.min.js"></script>
<script src="./resources/js/popper.min.js"></script>
<script src="./resources/js/bootstrap.min.js"></script>

<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="./resources/js/vue.js"></script>

<script src="./resources/js/axios.min.js"></script>

<div class="row">
    <div class="col-2 bg-dark mx-0 p-0" style="overflow-y: auto; height: 100vh;">
        <div class="text-center my-5 w-100">
            <h4 class="text-white-50">雇员信息管理系统</h4>
            <h1 class="text-white">EIMS</h1>
            <p class="text-center text-white-50" style="font-size: small;">当前管理员:${cookie.name.value}<br><a href="./exitLogin" class="badge badge-pill badge-light">退出</a></p>
        </div>
        <div class="pr-2">
            <jsp:include page="/WEB-INF/components/aside.jsp"></jsp:include>
        </div>
        <hr class="my-3">
        <div class="text-center my-3 w-100">
            <p class="text-muted" style="font-size: small;">Beta 0.26<br>©mooyyu</p>
        </div>
    </div>
    <div class="col-10 p-5" style="overflow-y: auto; height: 100vh;">
        <c:set var="aside" value="${empty param.aside ? 'default' : param.aside}"></c:set>
        <c:choose>
            <c:when test="${aside.equals('employeeList')}">
                <jsp:include page="/employee/query"></jsp:include>
            </c:when>
            <c:when test="${aside.equals('employeeInfo')}">
                <jsp:include page="/employee/edit"></jsp:include>
            </c:when>
            <c:when test="${aside.equals('departmentList')}">
                <jsp:include page="/department/list"></jsp:include>
            </c:when>
            <c:when test="${aside.equals('departmentInfo')}">
                <jsp:include page="/department/info"></jsp:include>
            </c:when>
            <c:when test="${aside.equals('addEmployee')}">
                <jsp:include page="/employee/add"></jsp:include>
            </c:when>
            <c:otherwise>
                <jsp:include page="/overview"></jsp:include>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>