package suncaper.admin;

import sun.nio.cs.US_ASCII;
import suncaper.admin.entity.Category;
import suncaper.admin.entity.User;
import suncaper.admin.service.UserService;

import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);
    private static UserService userService = new UserService();
    private static User currentLoginUser = null;
    public static void main(String[] args) {
        mainBox();
    }
    private static void mainBox() {
        System.out.println("------------------用户后台管理系统登录--------------");
        System.out.println("1.登录");
        System.out.println("2.注册");
        scanner = new Scanner(System.in);
        System.out.println("请输入你的选择:");
        int yourInput = scanner.nextInt();
        switch (yourInput){
            case 1:
                login();
                break;
            case 2:
                regist();
                break;
            default:
                System.out.println("输入不符合规范，请重新输入！");
                mainBox();
        }
    }

    private static void login() {
        System.out.println("请输入用户名");
        String username = scanner.next();
        System.out.println("请输入密码");
        String password = scanner.next();
        User loginUser = userService.login(new User(username,password));
        if (loginUser != null) {
            System.out.println("登录成功");
            currentLoginUser = loginUser;
            manageBox();
        }else {
            System.out.println("用户名或者密码错误，请重新登录");
            login();
        }
    }

    private static void manageBox() { //用户管理
        System.out.println("--------------用户后台商品管理系统------------------");
        System.out.println("1.修改密码");
        System.out.println("2.返回登录");
        System.out.println("3.进入商品分类管理系统");
        System.out.println("4.进入商品管理系统");
        System.out.println("请输入你的选择");
        int yourInput2 = scanner.nextInt();
        switch (yourInput2){
            case 1:
                updatePwd();
                break;
            case 2:
                logout();
                break;
            case 3:
                manageBox2();
                break;
            case 4:
                manageBox3();
                break;
             default:
                 System.out.println("输入错误，请按照提示输入！");
                 manageBox();
        }
    }

    private static void manageBox2() {//商品分类管理
        System.out.println("-------------商品分类管理-------------------");
        System.out.println("1.添加商品分类");
        System.out.println("2,更新商品分类");
        int i = scanner.nextInt();
        switch (i){
            case 1:
                addCategory();
                break;
            case 2:
                updateCategory();
                break;
            default:
                System.out.println("输入错误，请按照提示输入！");
                manageBox2();
        }
    }

    private static void manageBox3() { //商品管理
        System.out.println("--------------商品管理------------------");
        System.out.println("1.添加商品");
        System.out.println("2.更新商品");
        int i = scanner.nextInt();
        switch (i){

        }
    }

    private static void logout() {
        currentLoginUser = null;
        mainBox();
    }

    private static void updatePwd() {
        System.out.println("请输入您的新密码");
        String newPwd = scanner.next();
        currentLoginUser.setPwd(newPwd);
        if(userService.updatePwd(currentLoginUser)){
            System.out.println("密码修改成功，请使用新密码登录");
            login();
        }else {
            System.out.println("密码修改失败，请重新尝试修改");
            logout();
        }
    }

    private static void regist(){
        System.out.println("请输入用户名");
        String username = scanner.next();
        System.out.println("请输入密码");
        String password = scanner.next();
        if(userService.regist(new User(username,password))){
            System.out.println("注册成功,请登录账号！");
            login();
        }else {
            System.out.println("注册失败，请重新注册");
            regist();
        }
    }

    private static void addCategory() {
        System.out.println("请输入要添加的商品分类的id");
        String cid = scanner.next();
        System.out.println("请输入要添加的商品分类的名称");
        String cname = scanner.next();
        if(userService.addCategory(new Category(cid,cname))){
            System.out.println("添加商品分类成功，是否继续添加（y/s）");
            String yourInput3 = scanner.next();
            if(yourInput3.toLowerCase().trim().equals("y")){
                manageBox2();
            }else {
                System.out.println("操作成功，可以退出了！");
            }
        }else {
            System.out.println("添加商品失败，请重新添加");
            manageBox();
        }
    }

    private static void updateCategory() {

    }
}
