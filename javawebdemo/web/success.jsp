<%@ page import="java.util.List" %>
<%@ page import="com.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/23
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int[] arr = {1,2,3};
    request.setAttribute("aa",arr);
%>
登录成功啦！<br/>
当前登录用户1:<%=session.getAttribute("loginUser")%><br/>
当前登录用户2:${sessionScope.loginUser}<br/><%--//使用EL表达式--%>
当前登录用户3:${sessionScope.loginUser.name}<br/><%--//使用EL表达式--%>
当前登录用户4:${sessionScope.loginUser["name"]}<br/><%--//使用EL表达式--%>
SessionId:<%=session.getId()%>

<br/>

<%--将后台的user遍历一遍--%>
<table>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
        for (int i = 0; i < users.size(); i++) {
     %>
    <tr>
        <td><%=users.get(i).getName()%></td>
        <td><%=users.get(i).getPwd()%></td>
    </tr>
    <%
        }
    %>
</table>
<br/>
<br/>
<c:out value="hello"/><br/>
<%="hello"%><br/>
<%out.println("hello");%><br/>

<c:set value="zqq" var="username" scope="request"/>
<%--<%request.setAttribute("username","zqq");%>--%>
<c:out value="${username}"/>
<br/>
<c:if test="${5==5}" var="flag" scope="request"/>
<c:out value="${flag}"/>
<br/>
<c:set var="score" value="90"/>
<c:choose>
    <c:when test="${score > 80}">
        <span>成绩大于80</span>
    </c:when>
    <c:otherwise>
        <span>成绩小于80</span>
    </c:otherwise>
</c:choose>
<br/>


<table>
    <c:forEach items="${users}" var="user" varStatus="status">
    <tr>
        <td>${status.index}</td>
        <td>${status.count}</td>
        <td>${status.first}</td>
        <td>${status.last}</td>
        <td>${user.name}</td>
        <td>${user.pwd}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
