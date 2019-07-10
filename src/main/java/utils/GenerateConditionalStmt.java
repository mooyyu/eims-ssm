package utils;

import pojo.CurQuery;

public class GenerateConditionalStmt {
    public String getGcs(CurQuery cq) {
        StringBuilder gcs = new StringBuilder("1 = 1");
        if (!cq.name.equals("")) {
            gcs.append(" and employee.name like '%").append(cq.name).append("%'");
        }
        if (!cq.job.equals("")) {
            gcs.append(" and job like '%").append(cq.job).append("%'");
        }
        if (!cq.hiredateStr.equals("")) {
            gcs.append(" and date_format(hiredate, '%Y-%m-%d')='").append(cq.hiredateStr).append("'");
        }
        if (!cq.sal.equals("")) {
            gcs.append(" and sal=").append(cq.sal);
        }
        if (!cq.comm.equals("")) {
            gcs.append(" and comm=").append(cq.comm);
        }
        if (!cq.mgr.equals("-1")) {
            gcs.append(" and mgr=").append(cq.mgr);
        }
        if (!cq.dept.equals("-1")) {
            gcs.append(" and deptno=").append(cq.dept);
        }
        return gcs.toString();
    }
}
