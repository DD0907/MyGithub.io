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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/jquery-2.1.4.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/twitter-bootstrap-hover-dropdown.min.js"></script>
</head>
<body class="bootstrap-admin-with-small-navbar" onload="search()">
	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top "
		role="navigation">
		<div class="container">
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" style="width: 30em">
					<li class="active"><a
						href="${pageContext.request.contextPath}/main.htm">首页</a></li>
				</ul>
				<div class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="请输入商城查询"
							id=name>
					</div>
					<button type="submit" class="btn btn-default" onclick="search()">搜索</button>
				</div>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="col-md-2 bootstrap-admin-col-left">
			<ul class="nav navbar-collapse collapse bootstrap-admin-navbar-side">
				<li class="active"><a
					href="${pageContext.request.contextPath}/main.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>用户</a></li>
				<li><a href="${pageContext.request.contextPath}/permission.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>权限</a></li>

				<li><a href="${pageContext.request.contextPath}/role.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>角色</a></li>

				<li><a href="${pageContext.request.contextPath}/mall.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>商城</a></li>

				<li><a href="${pageContext.request.contextPath}/shop.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>店铺</a></li>

				<li><a href="${pageContext.request.contextPath}/item.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>商品</a></li>

				<li><a href="${pageContext.request.contextPath}/activity.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>活动</a></li>

				<li><a href="${pageContext.request.contextPath}/coupon.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>优惠券</a></li>
			</ul>
		</div>

		<!-- content -->
		<div class="col-md-10">
			<div class="row bootstrap-admin-no-edges-padding">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="text-muted bootstrap-admin-box-title">商城</div>
						<div
								class="text-muted bootstrap-admin-box-title pull-right text-warning"
								style="cursor: pointer" onclick="add()">添加商城</div></div>
						<div class="bootstrap-admin-panel-content">
							<table class="table table-striped table-bordered table-hover" id="malltable">
								<thead>
									<tr class="text-center active">
										<th>编号</th>
										<th>名称</th>
										<th>图标地址</th>
										<th>地址</th>
										<th>描述</th>
										<th>状态</th>
										<th>操作</th>
									</tr>
								</thead>
								<tr id="mall">
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function search() {
		var name = $("#name").val();
		$.ajax({
			type : "POST",
			contentType : 'application/json',
			url : "/taobaos/mall.htm?name=" + name,
			dataType : "json",
			success : function(data) {
				//alert(JSON.stringify(data));
				if (data.result == "error") {
					alert(data.message);
					$('#name').val("");
				} else {
					//alert(data.message);
					var dataObj = data.map.mall;
					$("#malltable  tr:not(:first)").empty();
					$('#name').val("");
					$.each(dataObj,function(index, item) {
					var $tr = $("<tr></tr>"); //表格的一行，在里面可以加各种属性;
					var $td = $("<td></td>"); //行中的元素
					$tr.append($td.clone().text(item.id));
					$tr.append($td.clone().text(item.name));
					$tr.append($td.clone().text(item.logUrl));
					$tr.append($td.clone().text(item.note));
					$tr.append($td.clone().text(item.url));
					$tr.append($td.clone().text(item.status));
					$tr.append($td.clone().html('<input type="button" value="修改"  class="btn btn-primary" onclick="update('+ item.id
					+ ');" /> <input type="button" value="禁用"  class="btn btn-warning" onclick="del('
					+ item.id+ ');" />'));
					$("#mall").after($tr);//最后要把内容放入要绑定的地方
				});
				}
			}
		});
	}
</script>
</html>