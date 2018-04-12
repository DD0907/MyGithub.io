<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html class="bootstrap-admin-vertical-centered">
<head>
<title>修改用户</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
<!-- Bootstrap Admin Theme -->
<link href="css/bootstrap-admin-theme.css" rel="stylesheet"
	media="screen">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- Custom styles -->
<style type="text/css">
.alert {
	margin: 0 auto 20px;
}
</style>
</head>
<body class="bootstrap-admin-without-padding">
	<div class="container">
		<div class="row">
			<div class="alert alert-info">
				<a class="close" data-dismiss="alert" href="#">&times;</a>
				请输入正确的用户名和密码！
			</div>
			<input type="hidden" id="phone"
				value="<%=request.getParameter("phone")%>" />
			<form class="bootstrap-admin-login-form" method="post"
				action="${pageContext.request.contextPath}/UserUpdateServlet?phone=${phone}">
				<h1>修改用户</h1>
				<div class="form-group">
					<input class="form-control" type="text" name="name" id="name"
						placeholder="用户名">
				</div>
				<div class="form-group">
					<input class="form-control" type="password" name="password"
						id="password" placeholder="密码">
				</div>
				<button class="btn btn-lg btn-primary" type="submit">确定</button>
<%-- 				<button class="btn btn-lg btn-primary" onclick="update(${phone})">确定</button> --%>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('input[name="phone"]').focus();
			var formWidth = $('.bootstrap-admin-login-form').innerWidth();
			var alertPadding = parseInt($('.alert').css('padding'));
			$('.alert').width(formWidth - 2 * alertPadding);
		});

// 		function update(phone) {
// 			var name = $("#name").val();
// 			var password = $("#password").val();
// 			var src = "${pageContext.request.contextPath}/UserUpdateServlet";
// 			jQuery.post(src, {
// 				phone : phone,
// 				name : name,
// 				password : password
// 			}, function(data) {
// 				var returnJson = eval("(" + data + ")");
// 				alert(returnJson);
// 					alert("修改成功");
// 					//关闭修改窗口，返回查询页面
// 					parent.window.location.href = "page/main.jsp";
// 					var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
// 					parent.layer.close(index); 
// 			}, "json");
// 		}
	</script>
</body>
</html>
