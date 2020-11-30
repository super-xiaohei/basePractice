package homeworkcollection.test;


import homeworkcollection.dao.EmployeeDao;
import homeworkcollection.dao.EmployeeDaoImpl;
import homeworkcollection.entity.Employee;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Map;

public class EmployeeDaoTest {
    private EmployeeDao employeeDao;

    @Before
    public void before(){
        employeeDao = new EmployeeDaoImpl(new File("E://emps.txt"));
    }

    @Test
    public void testAddEmployee(){
        for (int i = 1; i <= 10; i++) {
            Employee employee = new Employee("NO" + i,"姓名" + i,"男",i + 10,"1998-06-06" );
            employeeDao.addEmployee(employee);
        }
        System.out.println("添加成功！");
    }

    @Test
    public void testSelectEmployeeByEmpNo(){
        Employee employee = employeeDao.selectEmployeeByEmpNo("NO1");
        System.out.println(employee);
    }
    @Test
    public void testSelectAllEmp(){
        Map<String, Employee> map = employeeDao.selectAllEmp();
        //System.out.println(map.get("NO2"));
    }
    @Test
    public void testDeleteEmployeeByEmpNo(){
        employeeDao.deleteEmployeeByEmpNo("NO" + 4);
        System.out.println("删除成功！");
    }
    @Test
    public void testUpdateEmployeeByEmpNo(){
        Employee employee = new Employee("NO3","彭于晏","男神",20,"1998-05-29");
        employeeDao.updateEmployeeByEmpNo(employee);
        System.out.println("修改成功！！！");
    }
}
