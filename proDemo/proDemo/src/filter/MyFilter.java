package filter;

import common.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        if(Constant.URI_LOGIN.equals(requestURI)||Constant.URL_ROOT.equals(requestURI)||Constant.URI_REGISTER.equals(requestURI)||requestURI.contains(Constant.URI_REC)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        Object loginUser = session.getAttribute(Constant.LOGIN_USER);
        if(loginUser!=null){
            //放走请求
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            //没有登录信息
            servletRequest.setAttribute("errorMsg","还未登录");
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
