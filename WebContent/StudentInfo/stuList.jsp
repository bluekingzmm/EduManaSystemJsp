<%@page import="com.edu.dao.IStudent"%>
<%@page import="com.edu.dao.impl.StudentImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.edu.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
<style type="text/css">
#search {
	text-align: center;
	letter-spacing: 5px;
}
</style>
</head>
<body>
	<%@include file="/Admin/nav.jsp"%>
	<%
		List<Student> sList = (ArrayList<Student>) request.getAttribute("sList");
		IStudent student = new StudentImpl();
	%>
	<form
	action="<%=request.getContextPath()%>/StudentAction?operate=searchStu"
	method="post">
		<div id="search"><br /> 查询学生&nbsp;<input type="text" name="num"
			maxlength="5 " required placeholder="请输入学号" style="color: #999999" />
			<button type="submit">查询</button></div>
</form>
	<span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>

	<br>
	<h4>学生列表</h4>
	<table class="table">
		<tr>
			<td>序号</td>
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
			Student s = null;
			for (int i = 0; i < sList.size(); i++) {
				s = sList.get(i);
		%>
		<tr>
			<td><%=i + 1%></td>
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
		<%
			}
		%>
</table>


	<div class="input"><a
		href="<%=request.getContextPath()%>/StudentInfo/addStu.jsp">添加学生</a>
	<a
		href="<%=request.getContextPath()%>/StudentAction?operate=recycleBin">回收站</a>
</div>


</body>
</html>