<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>商品管理 | 注册页面</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="${pageContext.request.contextPath}/login.jsp"><b>商品管理系统</b></a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">注册新的账号</p>

    <form >
      <div class="form-group has-feedback">
        <input  id="username" name="username" type="text" class="form-control" placeholder="用户名">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input id="password" name="password" type="password" class="form-control" placeholder="密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input id="repassword" type="password" class="form-control" placeholder="确认密码">
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
        <span style="color: red" id="msg"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> 同意 <a href="#">注册条款</a>
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" id="commit" class="btn btn-primary btn-block btn-flat">注册</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
    <a href="${pageContext.request.contextPath}" class="text-center">返回登录</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 3 -->
<script src="${pageContext.request.contextPath}/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath}/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/static/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<script>
  $(function () {
    $("#commit").click(function () {
      let pwd1 = $("#password").val();
      let pwd2 = $("#repassword").val();
      if(pwd1!=pwd2){
        $("#msg").text("两次密码不一致");
        return false;
      }else {
        $("#msg").text("");
      };
      //ajax交互
      $.ajax({
        type:'post',
        url:'${pageContext.request.contextPath}/register',
        data:{"username":$("#username").val(),"password":$("#password").val()},
        success:function (res) {
          if(res){
            layer.msg("注册信息成功提交，等待管理员审核，即将跳转登录界面",{icon:1,time:3000},function () {
              window.location ="${pageContext.request.contextPath}";
            })
          }
        },
        error:function (res) {
          alert("未知错误0000");
        }
      })
    })
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' /* optional */
    });
  });
</script>
</body>
</html>
