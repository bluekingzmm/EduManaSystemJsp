<%@page import="java.util.ArrayList"%>
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
<title>课程列表</title>
<style type="text/css">
#search {
	text-align: center;
	letter-spacing: 5px;
}
</style>
</head>
<body>


	<%@include file="/Admin/nav.jsp"%>
	<%List<Course> cList=(ArrayList<Course>) request.getAttribute("cList") ;%>
	<form
	action="<%=request.getContextPath()%>/CourseAction?operate=searchCou" method="post">
		<div id="search"><br /> 查询课程&nbsp;<input type="text"
			name="courseid" maxlength="5 "
			placeholder="请输入课程号" required
			style="color: #999999" />
			<button type="submit">查询</button>
			</div>
</form>
	<span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>

	<br>
	<h4>课程列表</h4>
	<table class="table">
		<tr>
			<td>序号</td>
			<td>课程号</td>
			<td>课程名</td>
			<td>地点</td>
			<td>课时</td>
			<td>学生人数</td>
			<td>操作</td>
			<td>操作</td>
	</tr>
		<%
			
			for (int i = 0; i < cList.size(); i++) {
				Course cou = cList.get(i);
		%>
		<tr>
			<td><%=i + 1%></td>
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
		<%
			}
		%>
</table>

	<div class="input"><a
		href="<%=request.getContextPath()%>/CourseInfo/addCou.jsp">添加课程</a></div>

</body>
</html>