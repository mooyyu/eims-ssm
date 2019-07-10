package pojo;

import java.util.Date;

public class Employee {
    private int rownum;
    private int id;
    private String name;
    private String job;
    private Date hiredate;
    private int sal;
    private double comm;
    private int mgr;
    private int deptno;
    private String mgrName;
    private String deptName;
    private String hiredateStr;

    public Employee() {}
    public Employee(String name, String job, String hiredateStr, int sal, double comm, int mgr, int deptno) {
        this.name = name;
        this.job = job;
        this.hiredateStr = hiredateStr;
        this.sal = sal;
        this.comm = comm;
        this.mgr = mgr;
        this.deptno = deptno;
    }
    public Employee(int id, String name, String job, String hiredateStr, int sal, double comm, int mgr, int deptno) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.sal = sal;
        this.comm = comm;
        this.mgr = mgr;
        this.deptno = deptno;
        this.hiredateStr = hiredateStr;
    }

    public int getRownum() {
        return rownum;
    }

    public void setRownum(int rownum) {
        this.rownum = rownum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getHiredateStr() {
        return hiredateStr;
    }

    public void setHiredateStr(String hiredateStr) {
        this.hiredateStr = hiredateStr;
    }
}
