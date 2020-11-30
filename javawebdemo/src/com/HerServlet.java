package com;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class HerServlet implements Servlet {
    ServletConfig servletConfig;
    public HerServlet() {
        System.out.println("构造函数");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);//hh2
        //----------------------------------------------
        System.out.println("init");//init
        String username = servletConfig.getInitParameter("username");
        String password = servletConfig.getInitParameter("password");
        System.out.println(username + ":" +password);//admin:666666
        //----------------------------------------------
        Enumeration<String> names = servletConfig.getInitParameterNames();
        while (names.hasMoreElements()){
            String s = names.nextElement();
            String value = servletConfig.getInitParameter(s);
            System.out.println(s + ":" + value);//password:666666  username:admin

        }
        //================================================================================

        ServletContext servletContext = servletConfig.getServletContext();
        String password1 = servletContext.getInitParameter("password1");
        System.out.println(password1);//888888
        String realPath = servletContext.getRealPath("com.HerServlet");
        System.out.println(realPath);//C:\Users\Administrator\IdeaProjects\suncaper2\out\artifacts\javawebdemo_war_exploded\com.HerServlet 服务器路径

        servletContext.setAttribute("count",1);
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig");
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletContext servletContext = this.servletConfig.getServletContext();
        Integer count = (Integer)servletContext.getAttribute("count");
        System.out.println(count);
        servletContext.setAttribute("count",count+1);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
