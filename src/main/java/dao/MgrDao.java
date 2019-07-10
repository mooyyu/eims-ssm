package dao;

import pojo.Mgr;

import java.util.List;

public interface MgrDao {
    List<Mgr> getMGRNameList();

    int countMgrs();
}
