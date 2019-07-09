package dao;

import org.apache.ibatis.annotations.Param;

public interface SuperuserDao {
    boolean checkLogin(@Param("name") String name, @Param("password") String password);
}
