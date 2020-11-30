package com;


import com.common.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

//@WebServlet(urlPatterns = "/x")
public class MyServlet extends HttpServlet {
    //导入相关的包

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*//request对象方法 getMethod()获取客户端的请求方式
        String method = req.getMethod();
        System.out.println(method);//GET

        //方法 String getRequestURI() 获取请求服务器路径
        //方法 StringBuffer getRequestURL() 获取请求服务器路径
        String URI = req.getRequestURI();
        StringBuffer URL = req.getRequestURL();
        System.out.println("URI=="+URI);//URI==/javawebdemo_war_exploded/x
        System.out.println("URL=="+URL);//URL==http://localhost:8080/javawebdemo_war_exploded/x

        //方法 String getQueryString()获取请求行,?后面的所有参数
        String query = req.getQueryString();
        System.out.println(query);//

        //获取WEB应用名称  String getContextPath()
        String contextPath = req.getContextPath();
        System.out.println(contextPath);//javawebdemo_war_exploded*/



        /*System.out.println("我是get方法");
        ServletContext servletContext = getServletContext();
        Integer count = (Integer)servletContext.getAttribute("count");
        System.out.println(count);
        servletContext.setAttribute("count",count+1);*/


        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + ":" + password);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //PrintWriter writer = resp.getWriter();
        Connection connection = JdbcUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from admin_user where name = ? and pwd = ?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            /*Cookie cookie0 = new Cookie("name",username);
            Cookie cookie1 = new Cookie("password",password);
            resp.addCookie(cookie0);//没有设置时长的cookie叫做非持久化cookie
            resp.addCookie(cookie1);*/
            //cookie0.setMaxAge(60*60);//设置cookie保存时间
            if(resultSet.next()){
                System.out.println("登录成功");//后台
                HttpSession session = req.getSession();
                //session.setAttribute("loginUser",username);
                session.setAttribute("loginUser",new User(username,null));
                //session.invalidate();//使session无效
                List<User> users =  Arrays.asList(new User("hello1", "hello1"),new User("hello2", "hello2"),new User("hello3", "hello3"));
                req.setAttribute("users",users);
                //writer.write("登录成功");//页面
                req.getRequestDispatcher("/success.jsp").forward(req,resp);//转发
                //resp.sendRedirect(req.getContextPath() + "/success.jsp");//重定向
            }else {
                System.out.println("登录失败");
                //writer.write("登录失败");
                req.setAttribute("msg","用户名或密码错误");
                req.getRequestDispatcher("/index.jsp").forward(req,resp);//转发
                //resp.sendRedirect(req.getContextPath() + "/fail.jsp"); //重定向
            }
            //writer.flush();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是post方法");
    }
}
