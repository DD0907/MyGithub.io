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
						<input type="text" class="form-control" placeholder="请输入手机号查询"
							id="phone">
					</div>
					<button class="btn btn-default" onclick="search()">搜索</button>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">管理员<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#" onclick="addUser()">添加用户</a></li>
							<li><a href="#">设置</a></li>
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
					href="${pageContext.request.contextPath}/permission.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>权限</a></li>

				<li><a href="${pageContext.request.contextPath}/role.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>角色</a></li>

				<li><a href="${pageContext.request.contextPath}/mall.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>商城</a></li>

				<li><a href="${pageContext.request.contextPath}/shop.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>店铺</a></li>

				<li><a href="${pageContext.request.contextPath}/item.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>商品</a></li>

				<li><a
					href="${pageContext.request.contextPath}/activity.htm"><i
						class="glyphicon glyphicon-chevron-right"></i>活动</a></li>

				<li><a
					href="${pageContext.request.contextPath}/coupon.htm"><i
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
							<table id="usertable"
								class="table table-striped table-bordered table-hover">
								<tr class="text-center active">
									<th>手机号</th>
									<th>姓名</th>
									<th>salt</th>
									<th>密码</th>
									<th>操作</th>
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
			content : '/taobaos/addUser.htm',
			//点击关闭按钮事件
			end : function() {
			}
		});
	}

	function updateUser(phone) {
		layer.open({
			type : 2,
			title : '修改用户',
			maxmin : false,
			//点击遮罩不关闭层
			shadeClose : true,
			//弹出框大小
			area : [ '500px', '400px' ],
			//弹出框地址
			content : '/taobaos/updateUser.htm?phone=' + phone,
			//点击关闭按钮事件
			end : function() {
			}
		});
	}

	function search() {
		var phone = $("#phone").val();
		$.ajax({
			type : "POST",
			contentType : 'application/json',
			url : "/taobaos/main.htm?phone=" + phone,
			dataType : "json",
			success : function(data) {
				if (data.result == "error") {
					alert(data.message);
					$('#phone').val("");
					// 							var user = data.map.user;
					// 							//alert(JSON.stringify(user));
					// 							$("#usertable  tr:not(:first)").empty();
					// 							$("#usertable").html(
					// 									'<div style="text-align: center">' + '<h3>'
					// 											+ data.message + '</div>')
					// 							var url = data.data;
					// 							window.location.href = url;

				} else {
					//alert(data.message);
					var dataObj = data.map.user;
					$("#usertable  tr:not(:first)").empty();
					$('#phone').val("");
					//alert(dataObj)
					$.each(dataObj, function(index, item) {
						var $tr = $("<tr></tr>"); //表格的一行，在里面可以加各种属性;
						var $td = $("<td></td>"); //行中的元素
						$tr.append($td.clone().text(item.phone));
						$tr.append($td.clone().text(item.name));
						$tr.append($td.clone().text(item.salt));
						$tr.append($td.clone().text(item.hashpassword));
						$tr.append($td.clone().html(
								'<input type="button" value="修改"  class="btn btn-primary" onclick="updateUser('
										+ item.phone + ');" />'));
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
			url : "/taobaos/logout.htm",
			dataType : "json",
			success : function(data) {
				//alert(JSON.stringify(data));
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