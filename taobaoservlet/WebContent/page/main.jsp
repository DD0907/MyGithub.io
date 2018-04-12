<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<title>后台管理</title>
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
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/jquery-2.1.4.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/twitter-bootstrap-hover-dropdown.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/layer/js/layer.js"></script>
</head>
<body class="bootstrap-admin-with-small-navbar">
	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top "
		role="navigation">
		<div class="container">
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" style="width: 30em">
					<li class="active"><a href="#">首页</a></li>
				</ul>
				<form id="myForm" class="navbar-form navbar-left" role="search"
					method="post"
					action="${pageContext.request.contextPath}/UserSelectAllServlet">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="请输入内容"
							name="users">
					</div>
					<button class="btn btn-default">搜索</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">管理员<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/page/reg.jsp">添加用户</a></li>
							<li><a href="#">设置</a></li>
							<li><a
								href="${pageContext.request.contextPath}/UserLogoutServlet">退出登录</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="col-md-2 bootstrap-admin-col-left">
			<ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
				<li class="active"><a
					href="${pageContext.request.contextPath}/page/main.jsp"><i
						class="glyphicon glyphicon-chevron-right"></i>用户</a></li>

				<li><a
					href="${pageContext.request.contextPath}/page/permission.jsp"><i
						class="glyphicon glyphicon-chevron-right"></i>权限</a></li>

				<li><a href="${pageContext.request.contextPath}/page/role.jsp"><i
						class="glyphicon glyphicon-chevron-right"></i>角色</a></li>

				<li><a href="${pageContext.request.contextPath}/page/mall.jsp"><i
						class="glyphicon glyphicon-chevron-right"></i>商城</a></li>

				<li><a href="${pageContext.request.contextPath}/page/shop.jsp"><i
						class="glyphicon glyphicon-chevron-right"></i>店铺</a></li>

				<li><a href="${pageContext.request.contextPath}/page/item.jsp"><i
						class="glyphicon glyphicon-chevron-right"></i>商品</a></li>

				<li><a
					href="${pageContext.request.contextPath}/page/activity.jsp"><i
						class="glyphicon glyphicon-chevron-right"></i>活动</a></li>

				<li><a
					href="${pageContext.request.contextPath}/page/coupon.jsp"><i
						class="glyphicon glyphicon-chevron-right"></i>优惠券</a></li>
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
							<table class="table table-striped">
								<tr>
									<td>手机号</td>
									<td>姓名</td>
									<td>salt</td>
									<td>密码</td>
									<td>操作</td>
								</tr>
								<c:forEach items="${user}" var="item">
									<tr>
										<td>${item.phone}</td>
										<td>${item.name}</td>
										<td>${item.salt}</td>
										<td>${item.hashpassword}</td>
										<td><input type="button" value="修改"
											onclick="update(${item.phone})" class="btn btn-primary" /></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function update(phone){
	layer.open({
		type: 2,
		title: '修改用户',
		maxmin: false,
		//点击遮罩不关闭层
		shadeClose: true,
		//弹出框大小
		area: ['500px', '400px'],
		//弹出框地址
		content: 'page/updateUser.jsp?phone='+phone,
		//点击关闭按钮事件
		end: function() {
		}
	});
}
</script>
</html>