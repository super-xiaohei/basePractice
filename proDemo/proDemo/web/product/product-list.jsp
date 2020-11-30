<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/24
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
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
                商品列表
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">商品管理</a></li>
                <li class="active">商品列表</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <table id="#example2"  class="table table-bordered table-hover">
                        <tr>
                            <th>ID</th>
                            <th>商品名</th>
                            <th>价格</th>
                            <th>类别</th>
                            <th>状态</th>
                        </tr>
                        <c:forEach items="${page.list}" var="product">
                            <tr>
                                <td>${product.pid}</td>
                                <td>${product.pname}</td>
                                <td>${product.price}</td>
                                <c:forEach items="${category}" var="c">
                                    <c:if test="${product.category_id==c.cid}">
                                        <td>${c.cname}</td>
                                    </c:if>
                                </c:forEach>
                                <td>${product.flag==0?'已下架':'已上架'}</td>
                                <td><button id="${product.pid}" class="btn btn-danger delete">删除</button> <button id="${product.pid}" class="btn btn-info update">修改</button></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div class="col-xs-4">
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <c:choose>
                                    <c:when test="${page.havePrevious}">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/product?method=list&pageSize=${page.pageSize}&pageNo=${page.pageNo-1}" aria-label="Previous">
                                                <span aria-hidden="true">&laquo;</span>
                                            </a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="disabled">
                                            <a  href="javascript:void(0);" aria-label="Previous">
                                                <span aria-hidden="true">&laquo;</span>
                                            </a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>

                                <c:forEach begin="${page.startPage}" end="${page.endPage}" var="pageNum">
                                    <c:choose>
                                        <c:when test="${pageNum == page.pageNo}">
                                            <li class="active">
                                                <a href="${pageContext.request.contextPath}/product?method=list&pageSize=${page.pageSize}&pageNo=${pageNum}" >
                                                    <span aria-hidden="true">${pageNum}</span>
                                                </a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li>
                                                <a href="${pageContext.request.contextPath}/product?method=list&pageSize=${page.pageSize}&pageNo=${pageNum}">
                                                    <span aria-hidden="true">${pageNum}</span>
                                                </a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                                <c:choose>
                                    <c:when test="${page.haveNext}">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/product?method=list&pageSize=${page.pageSize}&pageNo=${page.pageNo+1}" aria-label="Next">
                                                <span aria-hidden="true">&raquo;</span>
                                            </a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="disabled">
                                            <a  href="javascript:void(0);" aria-label="Next">
                                                <span aria-hidden="true">&raquo;</span>
                                            </a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-xs-4" style="margin: 20px -200px;">
                        <div class="col-xs-2"style="margin: 6px"><span>每页显示</span></div>
                        <div class="col-xs-2"><select id="pageSize" class="form-control" style="width: 70px">
                            <option value="5">5</option>
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="50">50</option>
                            <option value="100">100</option>
                        </select></div>
                    </div>
                    <div class="col-xs-4" style="margin: 23px -90px;">
                        第${page.pageNo}页 共${page.pageCount}页 共${page.total}条 跳转到 <input id="page" type="text"> 页
                        <button id="jump">跳转</button>
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
<!--修改商品信息的模态框 -->
<div class="modal fade" id="updateProductModel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改商品信息</h4>
            </div>
            <div class="modal-body">
                <!-- Horizontal Form -->
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">商品信息</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <form class="form-horizontal" id="productForm">
                        <div class="box-body">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input type="hidden" class="form-control"  name="pid" id="pid" placeholder="PID">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="pname" class="col-sm-2 control-label">商品名</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control"  name="pname" id="pname" placeholder="商品名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="price" class="col-sm-2 control-label">价格</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control"  name="price" id="price" placeholder="价格">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="flag"  class="col-sm-2 control-label">状态</label>
                                <div class="col-sm-10">
                                    <select id="flag" name="flag" class="form-control">
                                        <option value="1">上架</option>
                                        <option value="0">下架</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="category_id" class="col-sm-2 control-label">分类</label>
                                <div class="col-sm-10">
                                    <select id="category_id" name="category_id" class="form-control">
                                        <c:forEach items="${category}" var="c">
                                        <option value=${c.cid}>${c.cname}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- /.box -->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="save">保存</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

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
        $("#pageSize").val(${page.pageSize});

        $(".delete").click(function () {
            let id = $(this).attr("id");
            $.ajax({
                type:"get",
                url:"${pageContext.request.contextPath}/product?method=delete&id="+id,
                success:function (res) {
                    if(res){
                        layer.msg("删除商品成功，即将跳转商品列表界面",{icon:1,time:3000},function () {
                            window.location ="${pageContext.request.contextPath}/product?method=list&pageSize=5&pageNo=1";
                        })
                    }
                }
            })

        });

        $(".update").click(function () {
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/product?method=selectProductById&id="+$(this).attr("id"),
                dataType: "json",
                success:function (product) {
                    if(product!=null){
                        $("#pid").val(product.pid);
                        $("#pname").val(product.pname);
                        $("#price").val(product.price);
                        $("#flag").val(product.flag);
                        $("#category_id").val(product.category_id);
                        $("#updateProductModel").modal("show");
                    }
                }
            });
        });
        $("#save").click(function () {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/product?method=save",
                data: $("#productForm").serialize(),//表单序列化，简化参数
                success:function (res) {
                    if(res){
                        layer.msg("保存商品信息成功，即将跳转商品列表界面",{icon:1,time:3000},function () {
                            $("#updateProductModel").modal("hide");
                            window.location ="${pageContext.request.contextPath}/product?method=list&pageSize=5&pageNo=1";
                        });
                    }
                }
            });
        });

        $("#jump").click(function (){
           let page = $("#page").val();
           if(page > ${page.pageCount}){
               page=${page.pageCount};
           }
           if(page < 1){
               page=1;
           }
           window.location="${pageContext.request.contextPath}/product?method=list&pageSize=${page.pageSize}&pageNo="+page;
        });

        $("#pageSize").change(function () {
            window.location="${pageContext.request.contextPath}/product?method=list&pageSize="+$(this).val()+"&pageNo=1";
        });




    })
</script>
</body>
</html>


