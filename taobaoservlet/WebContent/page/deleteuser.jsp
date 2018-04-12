<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除用户测试</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/UserDeleteServlet" method="POST">
		<fieldset>
			<legend>删除用户测试</legend>
			手机号：<input type="number" name="phone"><br>
			<input type="submit" value="删除">
			<input type="reset" value="重置"/>
		</fieldset>
	</form>
</body>
</html>