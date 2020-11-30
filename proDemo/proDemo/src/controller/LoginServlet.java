package controller;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用登录方法
        User user = userService.login(new User(username,password));
        if (user==null){
            //用户名或密码错误
            req.setAttribute("errorMsg","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }else {
            //登录成功
            //保存登录信息
            HttpSession session = req.getSession();
            user.setPassword(null);
            session.setAttribute("loginUser",user);
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }
    }
}
