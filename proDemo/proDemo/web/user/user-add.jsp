<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/25
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/24
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商品管理系统 | 后台</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/Ionicons/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/dist/css/skins/_all-skins.min.css">
    <!--[endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@ include file="../common/header.jsp"%>
    <!-- Left side column. contains the logo and sidebar -->
    <%@ include file="../common/aside.jsp"%>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                添加用户
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">用户管理</a></li>
                <li class="active">添加用户</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="col-md-6">
                        <!-- Horizontal Form -->
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">用户信息</h3>
                            </div>
                            <!-- /.box-header -->
                            <!-- form start -->
                            <form class="form-horizontal">
                                <div class="box-body">
                                    <div class="form-group">
                                        <label for="username" class="col-sm-2 control-label">用户名</label>

                                        <div class="col-sm-10">
                                            <input type="text" class="form-control"  name="username" id="username" placeholder="用户名">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="col-sm-2 control-label">密码</label>

                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" name="password" id="password" placeholder="密码">
                                        </div>
                                    </div>
                                    <div class="form-group text-center">
                                        <label for="repassword" class="col-sm-2 control-label">确认密码</label>

                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="repassword" placeholder="确认密码">
                                        </div>
                                        <span id="msg" style="color: red"></span>
                                    </div>
                                </div>
                                <!-- /.box-body -->
                                <div class="box-footer">
                                    <button type="button" class="btn btn-info pull-right" id="commit">保存</button>
                                    <button type="button" class="btn btn-danger pull-right" id="reset">重置</button>
                                </div>
                                <!-- /.box-footer -->
                            </form>
                        </div>
                        <!-- /.box -->
                    </div>
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <%@ include file="../common/footer.jsp"%>

</div>
<!-- ./wrapper -->

<!-- DataTables -->
<script src="${pageContext.request.contextPath}/static/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="${pageContext.request.contextPath}/static/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/static/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/static/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/static/dist/js/demo.js"></script>
<!--Layer弹窗-->
<script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<!-- page script -->

<script>
    $(function () {
        $("#reset").click(function () {
            $("#username").val("");
            $("#password").val("");
            $("#repassword").val("");
        })
        $("#commit").click(function () {
            let pwd1 = $("#password").val();
            let pwd2 = $("#repassword").val();
            console.info(pwd1,pwd2);
            if(pwd1!=pwd2){
                $("#msg").text("两次密码不一致");
                return false;
            }else {
                $("#msg").text("");
            };
            //ajax交互
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/user?method=add',
                data:{"username":$("#username").val(),"password":$("#password").val()},
                success:function (res) {
                    if(res){
                        layer.msg("添加用户成功，即将跳转用户列表界面",{icon:1,time:3000},function () {
                            window.location ="${pageContext.request.contextPath}/user?method=list&pageSize=5&pageNo=1";
                        })
                    }
                }
                // error:function (res) {
                //
                // }
            })
        });
    })
</script>
</body>
</html>


