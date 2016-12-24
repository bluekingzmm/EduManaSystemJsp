
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.edu.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员列表</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
<%-- <script type="text/javascript">
function del(obj){
	if(window.confirm("确定删除！")){
		location.href="<%=request.getContextPath()%>/AdminAction?operate=delete&username="+obj;
		return true;
	}else{
		return false;
	}
}

</script> --%>
<style type="text/css">
#search {
	text-align: center;
	letter-spacing: 5px;
}
</style>
</head>
<body>

	<%
		if (session.getAttribute("AdminName") == null) {
			response.sendRedirect("login.jsp");
		} else {

		}
	%>
	<%@include file="/Admin/nav.jsp"%>
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
			<td>
				<%-- <a onclick="del(<%=ad.getUsername()%>)"
				href="javaScript:void(0)">删除</a>  --%> <a
				href="<%=request.getContextPath()%>/AdminAction?operate=delete&id=<%=ad.getId()%>">删除</a>
		</td>
			<td><a
				href="<%=request.getContextPath()%>/AdminAction?operate=update&id=<%=ad.getId()%>">修改</a></td>

	</tr>
		<%
			}
		%>
</table>

	<div class="input"><a
		href="<%=request.getContextPath()%>/AdminAction?operate=create">添加管理员</a>
		<a href="<%=request.getContextPath()%>/AdminAction?operate=recycleBin">回收站</a>

</div>

	<span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>

</body>
</html>