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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/twitter-bootstrap-hover-dropdown.min.js"></script>
</head>
<body class="bootstrap-admin-with-small-navbar" onload="search()">
	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top "
		role="navigation">
		<div class="container">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" style="width: 30em">
					<li class="active"><a
						href="${pageContext.request.contextPath}/main.htm">首页</a></li>
				</ul>
				<div class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" id="name"
							placeholder="请输入学号查询">
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

		<!-- content -->
		<div class="col-md-10">
			<div class="row bootstrap-admin-no-edges-padding">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="text-muted bootstrap-admin-box-title">学生信息</div>
							<div
								class="text-muted bootstrap-admin-box-title pull-right text-warning"
								style="cursor: pointer" onclick="add()">添加学生信息</div>
						</div>
						<div class="bootstrap-admin-panel-content">
							<table class="table table-striped table-bordered table-hover"
								id="tstudenttable">
								<tr>
									<th>学号</th>
									<th>姓名</th>
									<th>班级编号</th>
									<th>楼层编号</th>
									<th>寝室</th>
									<th>园区编号</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
								<tr id="tstudent">
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
					url : "/EntranceGuard/tstudent.htm?name=" + name,
					dataType : "json",
					success : function(data) {
						if (data.result == "error") {
							alert(data.message);
							$('#name').val("");
						} else {
							//alert(data.message);
							var dataObj = data.map.tStudent;
							$("#tstudenttable  tr:not(:first)").empty();
							$('#name').val("");
							$.each(dataObj,function(index, item) {
								var $tr = $("<tr></tr>"); //表格的一行，在里面可以加各种属性;
								var $td = $("<td></td>"); //行中的元素
								$tr.append($td.clone().text(item.stuid));
								$tr.append($td.clone().text(item.stuname));
								$tr.append($td.clone().text(item.classid));
								$tr.append($td.clone().text(item.louhaoid));
								$tr.append($td.clone().text(item.qinshihao));
								$tr.append($td.clone().text(item.yuanquid));
								$tr.append($td.clone().text(item.isuse));
								$tr.append($td.clone().html('<input type="button" value="修改"  class="btn btn-primary" onclick="update('+ item.id+ ');" />'));
								$("#tstudent").after($tr);//最后要把内容放入要绑定的地方
							});
						}
					}
				});
	}
	
	
</script>
</html>