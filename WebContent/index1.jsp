<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>滁州职业学籍管理系统</title>
<link type="text/css" rel="stylesheet" href="css/nav.css">
<script type="text/javascript" src="js/main.js">
</script>
</head>
<body>
		<span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>

	<div id="section">
		<div class="header">
			<div class="nav">
				<div class="madeng"><marquee direction="left"
					behavior="scroll" loop="-1" onmouseover="this.stop()"
					onmouseout="this.start()" scrollamount="4">欢迎光临本站
						滁州职业技术学院学籍管理系统 </marquee></div>
						<div class="form">
				<form action="<%=request.getContextPath()%>/StudentAction"
				method="post">
				<input type="hidden" name="operate"
					value="stuLogin" /> 学号：<input type="text" name="stuNum" id="num"
					placeholder="学号"> 密码：<input type="password" name="password" id="psw"
					placeholder="密码"> <input type="button" name="登录"
					value="登录" onclick="tjstu();"/></form></div>
				<div class="a"><a href="<%=request.getContextPath()%>/login.jsp">后台登录</a>&nbsp;&nbsp;
			<a href="<%=request.getContextPath()%>/StudentInfo/addStu.jsp">注册</a></div>
		</div>
	</div>
</div>
	<div id="section">
		<div class="content"></div>
</div>
	<div id="section">
		<div class="footer"></div>
</div>
</body>
</html>