<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/25
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>aside</title>
</head>
<body>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img id="userImg" src="${pageContext.request.contextPath}${loginUser.url}" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${loginUser==null?"暂无数据":loginUser.username}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-users"></i> <span>用户管理</span>
                    <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/user/user-add.jsp"><i class="fa fa-user-plus"></i> 添加用户</a></li>
                    <li><a href="${pageContext.request.contextPath}/user?method=list&pageSize=5&pageNo=1"><i class="fa fa-list-alt"></i> 用户列表</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-th-large"></i> <span>类别管理</span>
                    <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/category/category-add.jsp"><i class="fa fa-plus"></i> 添加类别</a></li>
                    <li><a href="${pageContext.request.contextPath}/category?method=list&pageSize=5&pageNo=1"><i class="fa fa-th-list "></i> 类别列表</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-th"></i> <span>商品管理</span>
                    <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${pageContext.request.contextPath}/product?method=href"><i class="fa fa-plus"></i> 添加商品</a></li>
                    <li><a href="${pageContext.request.contextPath}/product?method=list&pageSize=5&pageNo=1"><i class="fa fa-list "></i> 商品列表</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-share"></i> <span>多级菜单（备用）</span>
                    <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-circle-o"></i> Level One</a></li>
                    <li class="treeview">
                        <a href="#"><i class="fa fa-circle-o"></i> Level One
                            <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="#"><i class="fa fa-circle-o"></i> Level Two</a></li>
                            <li class="treeview">
                                <a href="#"><i class="fa fa-circle-o"></i> Level Two
                                    <span class="pull-right-container">
                      <i class="fa fa-angle-left pull-right"></i>
                    </span>
                                </a>
                                <ul class="treeview-menu">
                                    <li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
                                    <li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li><a href="#"><i class="fa fa-circle-o"></i> Level One</a></li>
                </ul>
            </li>
            <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-circle-o text-red"></i> <span>退出登录</span></a></li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<!--修改头像的模态框 -->
<div class="modal fade" id="updateImgModel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">修改头像</h4>
            </div>
            <div class="modal-body">
                <!-- Horizontal Form -->
                <div class="box box-info">
                    当前用户头像<img src="${pageContext.request.contextPath}${loginUser.url}" alt="当前头像">
                    <!-- form start -->
                    <form class="form-horizontal" id="imgForm">
                        <div class="box-body">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input type="file" id="myImg" >
                                    <p class="help-block">点击浏览上传新的头像</p>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- /.box -->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="upload">上传</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
</body>
</html>
<!-- jQuery 3 -->
<script src="${pageContext.request.contextPath}/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath}/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!--Layer弹窗-->
<script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
<script>
    $("li").click(function () {
        $(this).addClass("active");
    })

    $("#userImg").click(function () {
        $("#updateImgModel").modal("show")
    });

    $("#upload").click(function(){
            //获取用户选择的文件
            let file=$("#myImg")[0].files[0];
            let filename =file.name;
            //查找文件后缀
            let index = filename.lastIndexOf(".");
            //文件合法判断
            let ext = filename.substring(index+1).toLowerCase();
            let strRegex = "(jpg|jpeg|png|gif)$";
            let re=new RegExp(strRegex);
            if (!re.test(ext)) {
                alert("格式错误，只支持主流图片格式");
                return false;
            }
                let param=new FormData();
                param.append("content",file);
                //调用ajax将文件上传到服务器
                $.ajax({
                    url:'${pageContext.request.contextPath}/user?method=updateImg',
                    type:'post',
                    async:true,
                    data:param,
                    contentType:false,
                    processData:false,
                    mimeType:'multipart/form-data',
                    success:function(res){
                        if(res){
                            layer.msg("修改头像成功",{icon:1,time:3000},function () {
                                $("#updateImgModel").modal("hide");
                                window.location.reload();
                            });
                        }else{
                            alert(res)
                        };
                    }
                });

    });
</script>
