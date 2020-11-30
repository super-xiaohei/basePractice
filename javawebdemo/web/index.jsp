<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/23
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--<%
    String s = "hello";
    /*System.out.println(9/0);会出异常，自动跳转到error.jsp页面*/
  %>
  <%
    Date date = new Date();
    for (int i = 0; i < 5; i++) {
  %>
  <a href="#">hello</a>
  <%
    }
  %>
  $END$胡金宝是憨憨<br/>--%>

  <%
    Integer appCount = (Integer) application.getAttribute("appCount");
    if(appCount == null){
      application.setAttribute("appCount",0);
    }else{
      application.setAttribute("appCount",appCount + 1);
    }
    //------------------------------------------------------------------
    Integer sesCount = (Integer) session.getAttribute("sesCount");
    if(sesCount == null){
      session.setAttribute("sesCount",0);
    }else{
      session.setAttribute("sesCount",sesCount + 1);
    }
    //---------------------------------------------------------------------
    Integer reqCount = (Integer) request.getAttribute("reqCount");
    if(reqCount == null){
      request.setAttribute("reqCount",1);
    }else{
      request.setAttribute("reqCount",reqCount + 1);
    }
    //----------------------------------------------------------------------------
    Integer pagCount = (Integer) pageContext.getAttribute("pagCount");
    if(pagCount == null){
      pageContext.setAttribute("pagCount",1);
    }else{
      pageContext.setAttribute("pagCount",pagCount + 1);
    }
  %>
  application访问次数：<%=application.getAttribute("appCount")%><br/>
  session访问次数：<%=session.getAttribute("sesCount")%><br/>
  request访问次数：<%=request.getAttribute("reqCount")%><br/>
  pageContext访问次数：<%=pageContext.getAttribute("pagCount")%><br/>
  <form action="${pageContext.request.contextPath}/x" method="get">
    <input type="text" name="username"><span style="color: red">${requestScope.msg}</span><br/><br/>
    <input type="text" name="password"><br/><br/>
    <input type="submit" value="登录">
  </form>
  <%--脚本片段--%>
  <%
    //java代码
  %>

 <%-- <%@ include file="new.jsp"%>--%>
  <%--<jsp:include page="new.jsp">--%>
  </body>
</html>
