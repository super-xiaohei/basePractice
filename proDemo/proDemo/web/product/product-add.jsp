<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                添加商品
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">商品管理</a></li>
                <li class="active">添加商品</li>
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
                                <h3 class="box-title">商品信息</h3>
                            </div>
                            <!-- /.box-header -->
                            <!-- form start -->
                            <form class="form-horizontal" id="proForm">
                                <div class="box-body">
                                    <div class="form-group">
                                        <label for="pname" class="col-sm-2 control-label">商品名称</label>

                                        <div class="col-sm-10">
                                            <input type="text" class="form-control"  name="pname" id="pname" placeholder="商品名">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="price" class="col-sm-2 control-label">商品价格</label>

                                        <div class="col-sm-10">
                                            <input type="text" class="form-control"  name="price" id="price" placeholder="商品价格">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="category_id" class="col-sm-2 control-label">商品类别</label>
                                        <div class="col-sm-10">
                                            <select id="category_id" name="category_id" class="form-control">
                                                <c:forEach items="${category}" var="c">
                                                    <c:choose>
                                                        <c:when test="${c.cid=='c001'}">
                                                            <option value=${c.cid} selected>${c.cname}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value=${c.cid}>${c.cname}</option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="flag" class="col-sm-2 control-label">是否上架</label>

                                        <div class="col-sm-10">
                                            <select id="flag" name="flag" class="form-control">
                                                <option value="1" selected>上架</option>
                                                <option value="0">下架</option>
                                            </select>
                                        </div>
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
            $("#pname").val("");
            $("#price").val("");
            $("#category_id").val("c001");
            $("#flag").val("1");
        })
        $("#commit").click(function () {
            //ajax交互
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/product?method=add',
                data:$("#proForm").serialize(),
                success:function (res) {
                    if(res){
                        layer.msg("添加商品成功，即将跳转商品列表界面",{icon:1,time:3000},function () {
                            window.location ="${pageContext.request.contextPath}/product?method=list&pageSize=5&pageNo=1";
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


