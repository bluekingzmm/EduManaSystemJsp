<%@page import="com.edu.dao.impl.AdminImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.edu.dto.Admin"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改管理员</title>
<style type="text/css">
fieldset {
	border: 0px;
	text-align: center;
}
</style>
</head>
<body>
	<%@include file="/Admin/nav.jsp"%>
	<h2 style="text-align: center;">修改</h2>
	<%
		Admin ad = (Admin) request.getAttribute("adminInfo");
	%>
	<form action="<%=request.getContextPath()%>/AdminAction?operate=modify"
	method="post">
		<table>
			<tr><td>&nbsp;</td>
				<td>
		<tr><td><input type="hidden" name="id"
					value="<%=ad.getId()%>" /></td></tr>
			<tr><td>登录名</td>

				<td><input type="text" name="username" placeholder="用户名"
					value="<%=ad.getUsername()%>" readonly="readonly"></td></tr>
			<tr><td>密码</td>
				<td><input type="text" name="password" required
					value="<%=ad.getPws()%>" /></td>
		<tr><td>姓名</td>
				<td><input type="text" name="adminName" required
					value="<%=ad.getName()%>" /></td>
	</table>
		<fieldset><input type="submit" name="submit" value="更新"
			style="width: 80px; height: 30px; color: blue;" /> <input
			type="reset" name="reset" value="重置"
			style="width: 80px; height: 30px; color: blue;" /> <span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>
	</fieldset>

</form>

</body>
</html>