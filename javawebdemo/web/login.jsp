<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/24
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h3>这里是登录界面哦，提交信息之后跳转到main界面</h3>
<form action="/javawebdemo_war_exploded/main.jsp" method="get">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="submit" value="提交哦">
</form>
</body>
</html>
