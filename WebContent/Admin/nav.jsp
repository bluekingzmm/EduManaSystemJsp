<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>导航栏</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/nav1.css">
</head>
<body>
<div id="section">
<div class="header">
<div class="nav"><ul>
	<li><a href="<%=request.getContextPath()%>/index.jsp">首页</a></li>
	<li><a
		href="<%=request.getContextPath()%>/StudentAction?operate=listStu">学生管理</a></li>
	<li><a
		href="<%=request.getContextPath()%>/AdminAction?operate=list">管理员管理</a></li>
	<li><a
		href="<%=request.getContextPath()%>/CourseAction?operate=listCou">课程管理</a></li>
	<li><a
		href="<%=request.getContextPath()%>/TeacherAction?operate=listTea">教师管理</a></li>
		<li><a
		href="<%=request.getContextPath()%>/AdminAction?operate=loginOut">注销</a></li>
</ul>
</div>
</div>
</div>
</body>
</html>