<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.edu.dto.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
</head>
<body>

	<%@include file="/StudentInfo/stuNav.jsp"%>
	<h4>个人列表</h4>
	<table class="table">
		<%
			Student stu = (Student) request.getAttribute("student");
		%>
		<tr>
			<td>学号</td>
			<td><%=stu.getNum()%></td>
	<tr>
			<td>姓名</td>
			<td><%=stu.getName()%></td>
	</tr>
	
		<tr><td>身份证号码</td>
			<td><%=stu.getID()%></td>
	</tr>
		<tr><td>密码</td>
			<td><%=stu.getPassword()%></td>
	</tr>
		<tr>
			<td>系部</td>
			<td><%=stu.getDepartment()%></td>
	</tr>
		<tr><td>选课号</td>
			<td><%=stu.getCourse_id()%></td>
	</tr>

		<%-- 		<td><a
				href="<%=request.getContextPath()%>/AdminAction?operate=update&username=<%=stu.getNum()%>">修改</a></td>

	</tr> --%>

</table>


</body>
</html>