<%@page
	import="org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.edu.db.DataBase"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.edu.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<td>学号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>身份证号码</td>
			<td>系部</td>
			<td>选课课程号</td>
			<td>操作</td>
			<td>操作</td>
	</tr>
		<c:forEach items="${sList}" var="Student">
			<tr>
				<td>${Student.num}</td>
				<td>${Student.name}</td>
				<td>${Student.sex}</td>
				<td>${Student.ID}</td>
				<td>${Student.department}</td>
				<td>${Student.course_id}</td>
				<td><a
					href="<%=request.getContextPath()%>/StudentAction?operate=deleteStu&num=">删除</a>
			</td>
				<td><a
					href="<%=request.getContextPath()%>/StudentAction?operate=updateStu&num=">修改</a></td>
			</tr>

		</c:forEach>

</table>
	<div class="input"><a
		href="<%=request.getContextPath()%>/StudentInfo/addStu.jsp">添加学生</a></div>
	<br>
	<div style="text-align: center; font-size: 18px;">
	<a>共有${count }条记录，当前第${pageNo}/${totalPage}页</a>
		<a href="StudentAction?operate=listStu&pageNo=1">首页</a> <a
		href="StudentAction?operate=listStu&pageNo=${pageNo- 1}">上一页</a> <a
		href="StudentAction?operate=listStu&pageNo=${pageNo+ 1}">下一页</a> <a
		href="StudentAction?operate=listStu&pageNo=${totalPage}">尾页</a> <a
		href="<%=request.getContextPath()%>/StudentAction?operate=recycleBin">回收站</a>

</div>
</body>
</html>