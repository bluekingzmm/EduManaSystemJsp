<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理</title>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/stuNav.css">
<style type="text/css">
#search {
	width: 400px;
	height: auto;
	text-align: center;
	margin-top: 20px;
}

.nav {
	width: 900PX;
}

.nav ul li {
	width: 150px;
}

#search a {
	text-decoration: none;
	color: blue;
	font-family: "微软雅黑";
}

#search a:HOVER {
	background: #a346ff;
}
</style>
</head>
<body>


	<div id="section">
		<div class="header">
			<div class="nav"><ul>
					<li><a href="<%=request.getContextPath()%>/index.jsp">首页</a></li>
					<li><a
						href="<%=request.getContextPath()%>/TeacherAction/selectCourse.jsp">显示本班学生</a></li>
					<li><a
						href="<%=request.getContextPath()%>/TeacherAction/selectCourse.jsp">删除本班学生</a></li>
					<li><a
						href="<%=request.getContextPath()%>/TeacherAction/selectCourse.jsp">修改本班学生</a></li>
					<li><a
						href="<%=request.getContextPath()%>/StudentAction?operate=loginOut">修改个人密码</a></li>
					<li><a href="<%=request.getContextPath()%>/login.jsp">注销</a></li>
			</ul></div> <span>欢迎你<%=session.getAttribute("student")%>老师
		</span>
	</div>
		<div id="search">查询本班学生信息:&nbsp;&nbsp;&nbsp;<input type="text"
			name="search" placeholder="请输入学生学号" onkeyup="value=this.value.replace(/\D+/g,'')" maxlength="12" />&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/TeacherInfo?">查&nbsp;询</a></div>
</div>
</html>