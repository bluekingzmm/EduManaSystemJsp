<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.edu.dao.impl.TeacherImpl"%>
<%@ page import="com.edu.dao.ITeacher"%>
<%@ page import="com.edu.dto.Teacher"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师列表</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
<style type="text/css">
#search {
	text-align: center;
	letter-spacing: 5px;
}
</style>
</head>
<body>
	<%@include file="/Admin/nav.jsp"%>
	<%List<Teacher> tList=(ArrayList<Teacher>) request.getAttribute("tList"); %>
		<form
	action="<%=request.getContextPath()%>/TeacherAction?operate=searchTea" method="post">
		<div id="search"><br /> 查询教师&nbsp;<input type="text"
			name="num" maxlength="5 " required
			onkeyup="value=this.value.replace(/\D+/g,'')" onfocus="this.value=''"
			onblur="if(this.value==''){this.value='请输入教工号'};"
			style="color: #999999" />
			<button type="submit">查询</button></div>
</form>
	<span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>

	<br>
	<h4>教师列表</h4>
	<table class="table">
		<tr>
			<td>序号</td>
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
		Teacher  tea=null;
			for (int i = 0; i < tList.size(); i++) {
				tea = tList.get(i);
		%>
		<tr>
			<td><%=i + 1%></td>
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
		<%
			}
		%>
</table>

	<div class="input"><a
		href="<%=request.getContextPath()%>/TeacherInfo/addTea.jsp">添加教师</a></div>

</body>
</html>