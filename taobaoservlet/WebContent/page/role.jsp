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
</head>
<body class="bootstrap-admin-with-small-navbar">
	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top "
		role="navigation">
		<div class="container">
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" style="width: 30em">
					<li class="active"><a
						href="${pageContext.request.contextPath}/page/main.jsp">首页</a></li>
				</ul>
				<form class="navbar-form navbar-left" role="search" method="post"
					action="${pageContext.request.contextPath}/RoleSelectAllServlet">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="请输入内容"
							name="roles">
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>
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

		<!-- content -->
		<div class="col-md-10">
			<div class="row bootstrap-admin-no-edges-padding">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="text-muted bootstrap-admin-box-title">角色</div>
						</div>
						<div class="bootstrap-admin-panel-content">
							<table class="table table-striped">
								<thead>
									<tr>
										<th>编号</th>
										<th>名称</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<c:forEach items="${role}" var="item">
									<tr>
										<td>${item.id}</td>
										<td>${item.name}</td>
										<td>${item.status}</td>
										<td><input type="button" value="修改"
											onclick="update(${item.id})" class="btn btn-primary" /> <input
											type="button" value="删除" onclick="del(${item.id})"
											class="btn btn-warning" /></td>
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
</html>