<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.edu.dto.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
<title>Insert title here</title>
</head>
<body>
<%@include file="/Admin/nav.jsp"%>
	<h4>单个学生列表</h4>
	<table class="table">
		<tr>
			<td>姓名</td>
			<td>学号</td>
			<td>性别</td>
			<td>身份证号码</td>
			<td>系部</td>
			<td>选课课程号</td>
			<td>操作</td>
			<td>操作</td>
	</tr>
		<%
			Student s = (Student) request.getAttribute("student");
		%>
		<tr>

			<td><%=s.getName()%></td>
			<td><%=s.getNum()%></td>
			<td><%=s.getSex()%></td>
			<td><%=s.getID()%></td>
			<td><%=s.getDepartment()%></td>
			<td><%=s.getCourse_id()%></td>
		<td><a
				href="<%=request.getContextPath()%>/StudentAction?operate=deleteStu&num=<%=s.getNum()%>">删除</a>
		</td>
			<td><a
				href="<%=request.getContextPath()%>/StudentAction?operate=updateStu&num=<%=s.getNum()%>">修改</a></td>


	</tr>

</table>


	<span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>
</body>
</html>