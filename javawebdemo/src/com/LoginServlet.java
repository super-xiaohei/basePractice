package com;

import com.common.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //PrintWriter writer = resp.getWriter();
        Connection connection = JdbcUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from admin_user where name = ? and pwd = ?");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            Cookie cookie0 = new Cookie("username",username);
            Cookie cookie1 = new Cookie("password",password);
            resp.addCookie(cookie0);//没有设置时长的cookie叫做非持久化cookie
            resp.addCookie(cookie1);
            //cookie0.setMaxAge(60);//设置cookie保存时间
            if(resultSet.next()){
                System.out.println("登录成功");//后台
                //writer.write("登录成功");//页面
                //req.getRequestDispatcher("/success.jsp").forward(req,resp);//转发
                resp.sendRedirect(req.getContextPath() + "/main.jsp");//重定向
            }else {
                System.out.println("登录失败");
                //writer.write("登录失败");
                resp.sendRedirect(req.getContextPath() + "/fail.jsp"); //重定向
            }
            //writer.flush();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
