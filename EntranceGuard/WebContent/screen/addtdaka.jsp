<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html class="bootstrap-admin-vertical-centered">
<head>
<title>添加打卡记录</title>
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
				请输入正确的打卡记录！
			</div>
			<div class="bootstrap-admin-login-form">
				<h1>添加打卡记录</h1>
				<div class="form-group">
					<input class="form-control" type="number" name="stuid"
						id="stuid" placeholder="学号">
				</div>
				<div class="form-group">
					<input class="form-control" type="datetime-local" name="time"
						id="time" placeholder="打卡时间">
				</div>
				<button class="btn btn-lg btn-primary" onclick="add()">提交</button>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('input[name="phone"]').focus();
			var formWidth = $('.bootstrap-admin-login-form').innerWidth();
			var alertPadding = parseInt($('.alert').css('padding'));
			$('.alert').width(formWidth - 2 * alertPadding);
		});
		function add() {
			var stuid = $("#stuid").val();
			var time = $("#time").val();
			alert(time)
			$.ajax({
				type : "POST",
				contentType : 'application/json',
				url : "/EntranceGuard/addtdaka.htm?stuid=" + stuid
						+ "&time=" + time,
				dataType : "json",
				success : function(data) {
					if (data.result == "error") {
						alert(data.message);
						var url = data.data;
						window.location.href = url;
						var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
						parent.layer.close(index);
					} else {
						alert(data.message);
						var url = data.data;
						parent.window.location.href = url;
						var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
						parent.layer.close(index);
					}
				}
			});
		}
	</script>
</body>
</html>
