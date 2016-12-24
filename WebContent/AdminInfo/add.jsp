<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/main.js"></script>
<title>添加管理员</title>
<link href="<%=request.getContextPath()%>/css/list.css" rel="stylesheet">
<style type="text/css">
fieldset {
	border: none;
	text-align: center;
}
</style>
</head>
<body>
	<%@include file="/Admin/nav.jsp"%>
	<form action="<%=request.getContextPath()%>/AdminAction?operate=add"
	method="post">
		<table>
			<tr><td>请输入用户名：</td>
				<td><input type="text" name="username" required></td></tr>
			<tr><td>请输入密码：</td>
				<td><input type="password" name="psw" maxlength="12" required placeholder="请输入密码"></td></tr>
			<tr><td>请输入姓名：</td>
				<td><input type="text" name="name" maxlength="5" required
					style="color: #999999" onfocus="this.value=''"
					placeholder="请输入姓名"></td></tr>

	</table>
		<fieldset><span><input type="submit" value="添加"
				style="color: red;"></span> <span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>

	</fieldset>


</form>
</body>
</html>