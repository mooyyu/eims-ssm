<%--
  Created by IntelliJ IDEA.
  User: mooyyu
  Date: 2019-07-10
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="employeeInfo" class="row">
    <div id="filterForm" class="col-8">
        <nav class="navbar navbar-expand-lg navbar-light bg-light border border-dark border-bottom-0">
            <div class="container">
                <a class="navbar-brand">编辑雇员</a>
            </div>
        </nav>
        <form id="filter" class="border border-dark p-4" method="post" action="./employee/update">
            <input class="d-none" type="hidden" name="id" value="${curEmployee.id}">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputName">Name</label>
                        </div>
                        <input v-model:value="name" name="name" maxlength="10" type="text" readonly="readonly" class="form-control" id="inputName" placeholder="Jack">
                    </div>
                    <small class="form-text text-muted">
                        name's maxlength is 10.
                    </small>
                </div>
                <div class="form-group col-md-6">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputHiredateStr">Hiredate</label>
                        </div>
                        <input v-model:value="hiredateStr" name="hiredateStr" maxlength="10" type="text" class="form-control" id="inputHiredateStr" placeholder="xxxx-xx-xx">
                    </div>
                    <small class="form-text text-muted">
                        hiredate is from 2000-01-01 to 2020-12-31.
                    </small>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-12">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputJob">Job</label>
                        </div>
                        <input v-model:value="job" name="job" maxlength="100" type="text" class="form-control" id="inputJob" placeholder="攻城狮">
                    </div>
                    <small class="form-text text-muted">
                        job's maxlength is 100.
                    </small>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputSal">Sal</label>
                        </div>
                        <input v-model:value="sal" name="sal" oninput="if(value.length>9)value=value.slice(0,9)" min="0" max="100000000" type="number" class="form-control" id="inputSal" placeholder="8000">
                    </div>
                    <small class="form-text text-muted">
                        sal between 0 and 100000000. step 1.
                    </small>
                </div>
                <div class="form-group col-md-6">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputComm">Comm</label>
                        </div>
                        <input v-model:value="comm" name="comm" oninput="if(value.length>9)value=value.slice(0,9)" step="0.1" min="0" max="100000000" type="number" class="form-control" id="inputComm" placeholder="312.5">
                    </div>
                    <small class="form-text text-muted">
                        comm between 0 and 100000000. step 0.1.
                    </small>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="MgrSelect">MGR</label>
                        </div>
                        <select name="mgr" class="custom-select" id="MgrSelect" v-model="mgr">
                            <c:forEach var="item" items="${MgrNameList}">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="DeptSelect">Dept</label>
                        </div>
                        <select name="dept" class="custom-select" id="DeptSelect" v-model="dept">
                            <c:forEach var="item" items="${DeptNameList}">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <button id="submit" type="submit" class="btn btn-block btn-outline-success">更新</button>
        </form>
    </div>
    <div class="col-1"></div>
    <div class="col-3">
        <img id="avatarIMG" class="rounded w-100 mb-1" src="${empty avatar ? './resources/img/index.jpg' : avatar}">
        <div class="custom-file">
            <label class="custom-file-label" for="inputGroupIMG" style="font-size: 12px;">780*1134;48k</label>
            <input type="file" onchange="checkIMG(this)" accept="image/jpg" class="custom-file-input" id="inputGroupIMG">
        </div>
        <hr>
        <div class="w-100">
            <button class="btn btn-outline-primary d-block mx-auto" type="button" onclick="submitIMG()">更新图片</button>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="tipModal" tabindex="-1" role="dialog" aria-labelledby="tipModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="tipModalLabel">日期错误</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div v-bind:class="hiredate_modal_class">
                        请确保日期满足以下条件!
                        <ul>
                            <li>日期合法</li>
                            <li>日期格式为xxxx-xx-xx</li>
                            <li>日期在2000-01-01至2020-12-31之间</li>
                        </ul>
                    </div>
                    <div v-bind:class="integrity_modal_class">
                        请将信息填写完整!
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="imgModal" tabindex="-1" role="dialog" aria-labelledby="imgModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="imgModalLabel">更新图片</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div id="imgModalBody" class="modal-body"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script>
    var curEmployeeId = ${curEmployee.id};
    var employeeInfoApp = new Vue({
        el: "div#employeeInfo",
        data: {
            name: "${curEmployee.name}",
            job: "${curEmployee.job}",
            sal: "${curEmployee.sal < 0 ? "" : curEmployee.sal}",
            comm: "${curEmployee.comm < 0 ? "" : curEmployee.comm}",
            hiredateStr: "${curEmployee.hiredateStr}",
            mgr: "${curEmployee.mgr}",
            dept: "${curEmployee.deptno}",
            hiredate_modal_class: "",
            integrity_modal_class: ""
        },
        methods: {
            checkIntegrity: function() {
                if (this.name != "" &&
                    this.job != "" &&
                    this.hiredateStr != "" &&
                    this.sal != "" &&
                    this.comm != ""
                ) {
                    return true;
                } else {
                    this.hiredate_modal_class = "d-none";
                    this.integrity_modal_class = "";
                    return false;
                }
            },
            checkHiredate: function() {
                if (this.hiredateStr.length == 0) {
                    return true;
                } else if (this.hiredateStr.length == 10 &&
                    this.hiredateStr.split('-').length == 3 &&
                    new Date(this.hiredateStr).toString() != "Invalid Date" &&
                    new Date(this.hiredateStr) >= new Date("2000-01-01") &&
                    new Date(this.hiredateStr) <= new Date("2020-12-31")) {
                    return true;
                } else {
                    this.hiredate_modal_class = "";
                    this.integrity_modal_class = "d-none";
                    return false;
                }
            }
        }
    });
    $('form#filter').submit(function() {
        if (employeeInfoApp.checkIntegrity() && employeeInfoApp.checkHiredate()) {
            return true;
        } else {
            $('div#tipModal').modal('show');
            return false;
        }
    });
    if (employeeInfoApp.comm != "") {
        employeeInfoApp.comm = Number(employeeInfoApp.comm.match(/^\d+(?:\.\d{0,1})?/)).toString();
    }
</script>

<script src="./resources/func/uploadIMG.js?v=0.70"></script>