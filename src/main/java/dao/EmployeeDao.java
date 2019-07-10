package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> queryEmployee(@Param("gcs") String gcs);

    Employee getEmployee(int id);

    void addEmployee(Employee e);

    int getMaxId();

    int updateEmployee(Employee e);

    void updateAvatar(@Param("avatar") String avatar, @Param("id") int id);

    String getAvatar(int id);

    void deleteEmployee(int id);

    void deleteAllQuery(String gcs);

    int countEmployees();

    //Integer 而不是 int, 因为有可能 null
    Integer getSalSum();
}
