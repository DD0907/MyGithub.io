<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html class="bootstrap-admin-vertical-centered">
<head>
<title>用户登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="page/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="page/css/bootstrap-theme.min.css" rel="stylesheet"
	media="screen">
<!-- Bootstrap Admin Theme -->
<link href="page/css/bootstrap-admin-theme.css" rel="stylesheet"
	media="screen">
<script type="text/javascript" src="page/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="page/js/bootstrap.min.js"></script>
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
			<div class="bootstrap-admin-login-form">
				<h1>登录</h1>
				<div class="form-group">
					<input class="form-control" type="text" name="username"
						id="username" placeholder="用户名">
				</div>
				<div class="form-group">
					<input class="form-control" type="password" name="password"
						id="password" placeholder="密码">
				</div>
				<button id="btn-login" class="btn btn-lg btn-primary"
					onclick="login()">登录</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('input[name="username"]').focus();
			var formWidth = $('.bootstrap-admin-login-form').innerWidth();
			var alertPadding = parseInt($('.alert').css('padding'));
			$('.alert').width(formWidth - 2 * alertPadding);
		});

		function login() {
			var username = $("#username").val();
			var password = $("#password").val();
			if (username == '' || username == undefined || username == null) {
				alert("输入的用户名为空")
			} else if (password == '' || password == undefined
					|| password == null) {
				alert("输入的密码为空")
			} else {
				$.ajax({
					type : "POST",
					url : "/EntranceGuard/login.htm",
					data : {
						username : username,
						password : password
					},
					dataType : "json",
					success : function(data) {
						//	alert(JSON.stringify(data));
						if (data.result == "errors") {
							alert(data.message);
							var url = data.data;
							window.location.href = url;
						} else if (data.result == "error") {
							alert(data.message);
							var url = data.data;
							window.location.href = url;
						} else {
							alert(data.message);
							var url = data.data;
							window.location.href = url;
						}
					}
				});
			}
		}
	</script>
</body>
</html>
