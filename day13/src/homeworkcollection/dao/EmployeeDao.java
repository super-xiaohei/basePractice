package homeworkcollection.dao;

import homeworkcollection.entity.Employee;

import java.util.Map;

public interface EmployeeDao {
    /**
     * 添加员工
     */
    public void addEmployee(Employee employee);

    /**
     * 根据员工编号查询
     */
    public Employee selectEmployeeByEmpNo(String empNo);

    /**
     * 查询全部员工
     */
    public Map<String,Employee> selectAllEmp();

    /**
     * 根据员工号删除员工
     */
    public void deleteEmployeeByEmpNo(String empNo);

    /**
     * 更改员工信息
     */
    public void updateEmployeeByEmpNo(Employee employee);
}
