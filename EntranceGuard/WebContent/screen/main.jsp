<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<title>门禁管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/page/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link
	href="${pageContext.request.contextPath}/page/css/bootstrap-theme.min.css"
	rel="stylesheet" media="screen">

<!-- Bootstrap Admin Theme -->
<link
	href="${pageContext.request.contextPath}/page/css/bootstrap-admin-theme.css"
	rel="stylesheet" media="screen">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="page/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/twitter-bootstrap-hover-dropdown.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/layer/js/layer.js"></script>
</head>
<body class="bootstrap-admin-with-small-navbar" onload="search()">
	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top "
		role="navigation">
		<div class="container">
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" style="width: 30em">
					<li class="active"><a href="#">首页</a></li>
				</ul>
				<div class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="请输入用户名查询"
							id="username">
					</div>
					<button class="btn btn-default" onclick="search()">搜索</button>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">管理员<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#" onclick="addUser()">添加管理员</a></li>
							<li><a href="#" onclick="logout()">退出登录</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="col-md-2 bootstrap-admin-col-left">
			<ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
				<li class="active"><a
					href="${pageContext.request.contextPath}/main.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>用户</a></li>
				<li><a
					href="${pageContext.request.contextPath}/tclass.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>班级</a></li>

				<li><a href="${pageContext.request.contextPath}/tdaka.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>打卡记录</a></li>

				<li><a href="${pageContext.request.contextPath}/tstudent.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>学生信息</a></li>

				<li><a href="${pageContext.request.contextPath}/tdept.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>系别</a></li>

				<li><a href="${pageContext.request.contextPath}/tyuanqu.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>园区</a></li>
			</ul>
		</div>
		<div class="col-md-10">
			<div class="row bootstrap-admin-no-edges-padding">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="text-muted bootstrap-admin-box-title">用户</div>
						</div>
						<div class="bootstrap-admin-panel-content">
							<table id="usertable"
								class="table table-striped table-bordered table-hover">
								<tr class="text-center active">
									<th>姓名</th>
									<th>密码</th>
									<th>状态</th>
								</tr>
								<tr id="user"></tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function addUser() {
		layer.open({
			type : 2,
			title : '添加用户',
			maxmin : false,
			//点击遮罩不关闭层
			shadeClose : true,
			//弹出框大小
			area : [ '500px', '500px' ],
			//弹出框地址
			content : '/EntranceGuard/addUser.htm',
			//点击关闭按钮事件
			end : function() {
			}
		});
	}
	function search() {
		var username = $("#username").val();
		$.ajax({
			type : "POST",
			contentType : 'application/json',
			url : "/EntranceGuard/main.htm?username="+username,
			dataType : "json",
			success : function(data) {
				if (data.result == "error") {
					alert(data.message);
					$('#username').val("");
				} else {
					//alert(data.message);
					var dataObj = data.map.user;
					$("#usertable  tr:not(:first)").empty();
					$('#username').val("");
					//alert(dataObj)
					$.each(dataObj, function(index, item) {
						var $tr = $("<tr></tr>"); //表格的一行，在里面可以加各种属性;
						var $td = $("<td></td>"); //行中的元素
						$tr.append($td.clone().text(item.username));
						$tr.append($td.clone().text(item.password));
						$tr.append($td.clone().text(item.isuse));
						$("#user").after($tr);//最后要把内容放入要绑定的地方
					});
				}
			}
		});
	}

	function logout() {
		$.ajax({
			type : "POST",
			contentType : 'application/json',
			url : "/EntranceGuard/logout.htm",
			dataType : "json",
			success : function(data) {
				if (data.result == "error") {
					alert(data.message);
					var url = data.data;
					parent.window.location.href = url;
				} else {
					alert(data.message);
					var url = data.data;
					parent.window.location.href = url;
				}
			}
		});
	}
</script>
</html>