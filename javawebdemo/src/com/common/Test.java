package com.common;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Test extends HttpServlet {
    public Test() {
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("cookie","java");
        resp.addCookie(cookie);

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie1 : cookies) {
            //取出cookie的键
            String key = cookie1.getName();
            //取出cookie的值
            String value = cookie1.getValue();
            System.out.println(key + " : " + value);
        }
    }

}
