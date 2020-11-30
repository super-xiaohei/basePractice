<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/5
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <a href="/springmvcDemo_war_exploded/hello/66">跳转到hello.jsp</a><br/>

  <form action="/springmvcDemo_war_exploded/test" method="get">
    <input type="text" name="id"/>
    <input type="submit"/>
  </form>


  <form action="/springmvcDemo_war_exploded/login" method="get">
    <input type="text" name="username"/><br/>
    <input type="password" name="password"/>
    <input type="submit"/>
  </form>

  <form action="/springmvcDemo_war_exploded/loginCopy" method="get">
    <input type="text" name="username"/><br/>
    <input type="password" name="password"/>
    <input type="submit"/>
  </form>
  <br/>
  <button id="btn">发送ajax请求</button>
  </body>
</html>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script>
    $("#btn").click(function () {
      $.ajax({
          type:"get",
          dataType:"json",
          url:"${pageContext.request.contextPath}/ajax",
          success:function (data) {
            if(data.code === "200"){

            }
            console.info(data)
          },
          error:function () {
            console.info("出错了")
          }
      })
    })
</script>
