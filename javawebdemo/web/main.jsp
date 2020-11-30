<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/24
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
<h3>登录成功,这里是main界面哦，你现在来到了main界面</h3>
<%
    String username = request.getParameter("username");
    boolean flag = false;//是否存在名字为username的cookie
    if(username != null){
        //表示是正常手段进行登录
        flag = true;
        Cookie cookie = new Cookie("username",username);
        cookie.setMaxAge(10);
        response.addCookie(cookie);
    }else{
        //表示非正常手段进行登录
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if("username".equals(cookie.getName())) {
                flag = true;
                break;
            }
        }
    }
    if(!flag){
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
%>
</html>
