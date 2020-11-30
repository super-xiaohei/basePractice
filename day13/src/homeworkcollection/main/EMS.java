package homeworkcollection.main;


import homeworkcollection.dao.EmployeeDao;
import homeworkcollection.dao.EmployeeDaoImpl;
import homeworkcollection.entity.Employee;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class EMS {
   private EmployeeDao employeeDao;
   private Scanner scanner4Command;
   private Scanner scanner4Information;
   private String filePath;

   public EMS(String filePath) {
      this.employeeDao = new EmployeeDaoImpl(new File(filePath));
      this.scanner4Command = new Scanner(System.in);
      this.scanner4Information = new Scanner(System.in);
      this.filePath = filePath;
   }
   public int getCommand(){
      int rs = -1;
      System.out.println("请输入命令(select/add/del/update)");
      String line = scanner4Command.nextLine().trim().toLowerCase();
      switch(line){
         case "select":
            rs = SysStatics.OPERATION_QUERY;
            break;
         case "add":
            rs = SysStatics.OPERATION_ADD;
            break;
         case "update":
            rs = SysStatics.OPERATION_MODIFY;
            break;
         case "del":
            rs = SysStatics.OPERATION_REMOVE;
            break;
         case "exit":
            rs = SysStatics.EXIT;
            break;
      }
      return rs;
   }

   public void start() {
      System.out.println("欢迎使用人员管理系统......");
      while (true) {
         int command = getCommand();
         if (command == SysStatics.OPERATION_ADD) {
            this.addEmployee();
         } else if (command == SysStatics.OPERATION_REMOVE) {
            this.removeEmployee();
         } else if (command == SysStatics.OPERATION_MODIFY) {
            this.modifyEmployee();
         } else if (command == SysStatics.OPERATION_QUERY) {
            this.queryEmployee();
         } else if (command == SysStatics.EXIT) {
            System.out.println("成功退出系统！");
            break;
         }else {
            System.out.println("命令错误，请重新按照指令进行输入！");
            continue;
         }
      }
   }

   private void removeEmployee() {
      System.out.println("请输入需要删除的员工编号");
      String s = scanner4Information.nextLine();
      employeeDao.deleteEmployeeByEmpNo(s.trim());
      System.out.println("删除成功！");
   }

   private void modifyEmployee() {
      System.out.println("请输入更改的员工信息:格式(员工编号,姓名,性别,年龄,入职日期).如: 1001,张三,男,16,2020-09-23");
      String s = scanner4Information.nextLine();
      String[] split = s.split(",");
      Employee employee = new Employee();
      employee.setEmpNo(split[0].trim());
      employee.setName(split[1].trim());
      employee.setSex(split[2].trim());
      employee.setAge(Integer.parseInt(split[3].trim()));
      employee.setHireDate(split[4].trim());
      employeeDao.updateEmployeeByEmpNo(employee);
      System.out.println("修改成功！");
   }

   private void queryEmployee() {
      System.out.println("请输入员工编号 , 输入 ALL 显示所有员工");
      String s = scanner4Information.nextLine().trim();
      if(s != null && s.toUpperCase().trim().equals("ALL")){
         Map<String, Employee> map = employeeDao.selectAllEmp();
         System.out.println("--------------- 查询结果(ALL) ------------");
         for (String key : map.keySet()) {
            System.out.println(map.get(key));
         }
         System.out.println("--------------- ------------- ------------");
      }else {
         Employee employee = employeeDao.selectEmployeeByEmpNo(s.trim());
         if(employee != null){
            System.out.println("--------------- 查询结果 ------------");
            System.out.println(employee);
            System.out.println("--------------- -------- ------------");
         }else {
            System.out.println("查无此人！");
         }
      }

   }

   private void addEmployee() {
      System.out.println("请输入员工信息:格式(员工编号,姓名,性别,年龄,入职日期).如: 1001,张三,男,16,2020-09-23");
      String s = scanner4Information.nextLine();
      String[] split = s.split(",");
      Employee employee = new Employee();
      employee.setEmpNo(split[0].trim());
      employee.setName(split[1].trim());
      employee.setSex(split[2].trim());
      employee.setAge(Integer.parseInt(split[3].trim()));
      employee.setHireDate(split[4].trim());
      employeeDao.addEmployee(employee);
   }
}
