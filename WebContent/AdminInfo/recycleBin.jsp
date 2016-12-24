<%@page import="com.edu.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.edu.db.DataBase"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.edu.dto.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回收站列表</title>
<style type="text/css">
#search {
	text-align: center;
	letter-spacing: 5px;
}
</style>
</head>
<body>

	<%@include file="/Admin/nav.jsp"%>

	<span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>
<%
		List<Admin> aList = (ArrayList<Admin>) request.getAttribute("aList");
	%>
	<br>
	<h4>管理员列表</h4>
	<table class="table">
		<tr>
			<td>序号</td>
			<td>用户名</td>
			<td>密码</td>
			<td>姓名</td>
			<td>操作</td>
			<td>操作</td>
	</tr>
		<%
			Admin ad = null;
			for (int i = 0; i < aList.size(); i++) {
				ad = aList.get(i);
		%>
		<tr>
			<td><%=ad.getId()%></td>
			<td><%=ad.getUsername()%></td>
			<td><%=ad.getPws()%></td>
			<td><%=ad.getName()%></td>

			<td><a
				href="<%=request.getContextPath()%>/AdminAction?operate=recover&id=<%=ad.getId()%>">还原</a>
		</td>
			<td><a
				href="<%=request.getContextPath()%>/AdminAction?operate=move&id=<%=ad.getId()%>">彻底删除</a>
		</td>
	</tr>
	<%} %>
</table>

	
		 <a
		href="<%=request.getContextPath()%>/AdminAction?operate=clearRecycleBin">清空回收站</a>

</body>
</html>