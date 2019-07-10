<%--
  Created by IntelliJ IDEA.
  User: mooyyu
  Date: 2019-07-10
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
    var itemlistsize = ${employeeList.size()};
</script>

<script src="./resources/js/FileSaver.min.js"></script>
<script src="./resources/js/tableExport.min.js"></script>

<jsp:include page="/WEB-INF/components/filterForm.jsp"></jsp:include>

<div id="main" class="${hiddenList ? "d-none" : ""}">
    <nav class="navbar navbar-expand-lg navbar-light bg-light border border-dark border-bottom-0">
        <div class="container">
            <a class="navbar-brand">${employeeList.size() == 0 ? "查无此人" : ""}<c:if test="${employeeList.size() > 0}">雇员列表 查询到${employeeList.size()}条记录</c:if></a>
            <span>
                <button type="button" class="btn btn-outline-info ${employeeList.size() == 0 ? "d-none" : ""}" onclick="$('table#employeeList').tableExport({fileName: '雇员列表', ignoreColumn:[8, 9], type:'csv'});">导出表格</button>
                <button type="button" class="btn btn-outline-danger ${employeeList.size() == 0 ? "d-none" : ""}" onclick="employeeListModalApp.show('deleteAll');">删除该查询下的所有记录</button>
            </span>
        </div>
    </nav>

    <div class="table-responsive border border-dark">
        <table id="employeeList" class="table table-sm table-striped table-dark text-nowrap ${employeeList.size() == 0 ? "d-none" : ""}">
            <thead>
            <tr>
                <th scope="col" style="width: 48px;">#</th>
                <th scope="col">Name</th>
                <th scope="col">Job</th>
                <th scope="col">Hiredate</th>
                <th scope="col">Sal</th>
                <th scope="col">Comm</th>
                <th scope="col">MGR</th>
                <th scope="col">Dept</th>
                <th scope="col" style="width: 60px;">Edit</th>
                <th scope="col" style="width: 50px;">Del</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${employeeList}">
                <tr class="d-none" id="${item.rownum}">
                    <th scope="row">${item.rownum}</th>
                    <td>${item.name}</td>
                    <td>${item.job}</td>
                    <td>${item.hiredateStr}</td>
                    <td>${item.sal}</td>
                    <td>${item.comm}</td>
                    <td>${item.mgrName}</td>
                    <td><a href="?aside=departmentInfo&id=${item.deptno}" class="btn btn-sm btn-outline-warning" role="button" aria-disabled="true">${item.deptName}</a></td>
                    <td><a href="?aside=employeeInfo&id=${item.id}" class="btn btn-sm btn-outline-primary" role="button" aria-disabled="true">编辑</a></td>
                    <td><button class="btn btn-sm btn-outline-danger" onclick="employeeListModalApp.show('${item.id}');">×</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <hr>
    <jsp:include page="/WEB-INF/components/pagination.jsp"></jsp:include>
</div>

<!-- Modal -->
<div class="modal fade" id="employeeListModal" tabindex="-1" role="dialog" aria-labelledby="employeeListModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="employeeListModalLabel">操作警告</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                {{showInfo}}
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger" v-on:click="doDelete">Delete</button>
            </div>
        </div>
    </div>
</div>

<script>
    var employeeListModalApp = new Vue({
        el: "div#employeeListModal",
        data: {
            showInfo: "",
            curBTN: ""
        },
        methods: {
            show: function(curBTN) {
                this.curBTN = curBTN;
                if (curBTN == "deleteAll") {
                    this.showInfo = "是否确认删除该查询下所有记录？";
                } else {
                    this.showInfo = "是否确认删除该此条记录？"
                }
                $('div#employeeListModal').modal('show');
            },
            doDelete: function() {
                if (this.curBTN == "deleteAll") {
                    axios.post('./employee/delete', {
                        name: filterFormApp.name,
                        job: filterFormApp.job,
                        sal: filterFormApp.sal,
                        comm: filterFormApp.comm,
                        hiredateStr: filterFormApp.hiredateStr,
                        mgr: filterFormApp.mgr,
                        dept: filterFormApp.dept
                    }).then(function() {
                        window.location.reload();
                    }).catch(function(error) {
                        console.info(error);
                    });
                } else {
                    axios.get('./employee/delete?id=' + this.curBTN)
                        .then(function() {
                            window.location.reload();
                        }).catch(function(error) {
                        console.info(error);
                    });
                }
            }
        }
    })
</script>

<script src="./resources/func/pagination.js"></script>