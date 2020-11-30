package homeworkcollection.dao;

import homeworkcollection.entity.Employee;
import homeworkcollection.exception.EmployeeExistsException;
import homeworkcollection.exception.EmployeeNotExistsException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeDaoImpl implements EmployeeDao{
    private File file;

    public EmployeeDaoImpl(File file) {
        this.file = file;
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 添加员工
     * @param employee
     */
    @Override
    public void addEmployee(Employee employee) {
        String empNo = employee.getEmpNo();
        if(empNo != null){
            Employee emp = selectEmployeeByEmpNo(empNo);
            if(emp != null){
                throw new EmployeeExistsException("员工号已经存在" + emp.getEmpNo());
            }
        }
        this.writeToFile(employee.toString(),true);
    }

    private void writeToFile(String str,boolean append){
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream(file,append));
            out.println(str);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据员工编号查询
     * @param empNo
     * @return
     */
    @Override
    public Employee selectEmployeeByEmpNo(String empNo) {
        return selectAllEmp().get(empNo);
    }

    /**
     * 查询全部员工
     * @return
     */
    @Override
    public Map<String, Employee> selectAllEmp() {
        Map<String,Employee> map = new HashMap<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine().trim();
                String[] split = line.split("\\s+");
                Employee employee = new Employee();
                employee.setEmpNo(split[0].trim());
                employee.setName(split[1].trim());
                employee.setSex(split[2].trim());
                employee.setAge(Integer.parseInt(split[3].trim()));
                employee.setHireDate(split[4].trim());
                map.put(employee.getEmpNo(),employee);
            }
            scanner.close();
            System.out.println(scanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 根据员工号删除员工
     * @param empNo
     */
    @Override
    public void deleteEmployeeByEmpNo(String empNo) {
        Map<String,Employee> all =this.selectAllEmp();
        all.remove(empNo);
        updateAll(all);
    }

    /**
     * 更改员工信息
     * @param employee
     */
    @Override
    public void updateEmployeeByEmpNo(Employee employee) {
        Map<String, Employee> allEmp = this.selectAllEmp();
        Employee employee1 = allEmp.get(employee.getEmpNo());
        if(employee1 == null){
            throw new EmployeeNotExistsException("员工编号不存在");
        }
        allEmp.put(employee1.getEmpNo(),employee);
        updateAll(allEmp);
    }

    /**
     * 更新全部
     */
    private void updateAll(Map<String,Employee> all){
        this.file.delete();
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String key : all.keySet()) {
            Employee employee = all.get(key);
            this.addEmployee(employee);
        }
    }
}
