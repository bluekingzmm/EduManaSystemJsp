<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.edu.dto.Teacher"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
<title>教师个人信息</title>
</head>
<body>
	<%@include file="/Admin/nav.jsp"%>
	<h4>单个课程列表</h4>
	<table class="table">
		<tr>
			<td>教工号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>所教课程号</td>
			<td>手机号码</td>
			<td>等级</td>
			<td>评价</td>
			<td>操作</td>
			<td>操作</td>
	</tr>
		<%
			Teacher tea = (Teacher) request.getAttribute("TeacherInfo");
		%>
		<tr>

			<td><%=tea.getNum()%></td>
			<td><%=tea.getName()%></td>
			<td><%=tea.getSex()%></td>
			<td><%=tea.getCourse_id()%></td>
			<td><%=tea.getTeatel()%></td>
			<td><%=tea.getMemo()%></td>
			<td><%=tea.getAssess()%></td>
			<td><a
				href="<%=request.getContextPath()%>/TeacherAction?operate=deleteTea&num=<%=tea.getNum()%>">删除</a>
		</td>
			<td><a
				href="<%=request.getContextPath()%>/TeacherAction?operate=updateTea&num=<%=tea.getNum()%>">修改</a></td>

	</tr>

</table>


	<span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>
</body>
</html>