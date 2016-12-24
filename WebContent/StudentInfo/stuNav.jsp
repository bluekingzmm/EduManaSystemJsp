<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.edu.dto.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理</title>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/stuNav.css">
<style type="text/css" >
.nav {
	width: 1000px;
}


</style>
</head>
<body>

	<div id="section">
		<div class="header">
			<div class="nav"><ul>
					<li><a href="<%=request.getContextPath()%>/index.jsp">首页</a></li>
					<li><a
						href="<%=request.getContextPath()%>/StudentAction?operate=listone&num=<%=session.getAttribute("stuNum")%>">个人信息</a></li>
					<li><a href="<%=request.getContextPath()%>/StudentInfo/changePsw.jsp">修改密码</a></li>
					<li><a
						href="<%=request.getContextPath()%>/StudentAction/selectCourse.jsp">选课</a></li>
					<li><a
						href="<%=request.getContextPath()%>/StudentAction?operate=loginOut">注销</a></li>
			</ul></div> <span>欢迎你<%=session.getAttribute("stuNum")%>同学
		</span> 
	</div>
</div>
</body>
</html>