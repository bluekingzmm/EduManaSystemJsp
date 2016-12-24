<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.edu.dao.impl.CourseImpl"%>
<%@ page import="com.edu.dao.ICourse"%>
<%@ page import="com.edu.dto.Course"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
<title>单个课程</title>
</head>
<body>
<%@include file="/Admin/nav.jsp" %>
<h4>单个课程列表</h4>
	<table class="table">
		<tr>
			<td>课程号</td>
			<td>课程名</td>
			<td>地点</td>
			<td>课时</td>
			<td>学生人数</td>
			<td>操作</td>
			<td>操作</td>
	</tr>
		<%
			Course cou=(Course) request.getAttribute("CourseInfo");
		%>
		<tr>
			
			<td><%=cou.getCourse_id()%></td>
			<td><%=cou.getCourse_name()%></td>
			<td><%=cou.getPlace()%></td>
			<td><%=cou.getTime()%></td>
			<td><%=cou.getStucount()%></td>
			<td><a
				href="<%=request.getContextPath()%>/CourseAction?operate=deleteCou&courseid=<%=cou.getCourse_id()%>">删除</a>
		</td>
			<td><a
				href="<%=request.getContextPath()%>/CourseAction?operate=updateCou&courseid=<%=cou.getCourse_id()%>">修改</a></td>
	</tr>
	
</table>

	
	<span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>

</body>
</html>