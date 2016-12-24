<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.edu.dto.Admin"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link href="css/button.css" rel="stylesheet" type="text/css">
<link href="css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/main.js"></script>
<!-- 当需要使用带下拉菜单的按钮时才需要加载下面的 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="js/buttons.js"></script>


<style type="text/css">
fieldset {
	border: none;
}

fieldset span {
	font-size: 18px;
	text-align: center;
}

span {
	text-align: center;
}

#msg {
	color: #FF0000;
}
</style>
</head>

<body>

	<%-- <%
		Cookie cookies[] = request.getCookies();
		Cookie cookie = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("username")) {
				cookie = cookies[i];
			}
  
		}
		if (cookie != null) {
	%>
	<script type="text/javascript">
		if (confirm("直接登录吗")) {
			location.href="AdminInfo/list.jsp";
		} else {

		}
	</script>
	<%
		}
	%> --%>
	<div id="content"><span><a style="text-decoration: none;"
			href="<%=request.getContextPath()%>/index.jsp">返回首页</a></span> <!-- request.getContextPath()能够更有效的防治连接的失效。 -->
		<form action="<%=request.getContextPath()%>/AdminAction?operate=login" method="post">
			<div class="admin"><h2 style="padding-left: 42px;">登&nbsp;&nbsp;录</h2></div>
			<div class="table">
				<table>
					<tr><td>身份</td>
						<td><select name="s" id="s" style="width: 200px;height: 30px;border-radius:5px;">
						<option value=""  >========请选择========</option>
						<option value="admin" style="font-size:16px; text-align: center;">========管理员========
							</option>
								<option value="teacher" style="font-size:16px; text-align: center;">========教师========</option></select></td></tr>

					<tr><td>登录名</td>
						<td><input type="text" name="username" placeholder="请输入用户名" 
							value=""  autofocus required style="font-size:16px;width: 200px;height: 30px;border-radius:5px;"></td>


				</tr>
					<tr><td>密码</td>
						<td><input type="password" name="psw" placeholder="请输入密码" style=" font-size:16px;width: 200px;height: 30px;border-radius:5px;"
							value=""  required></td>
				</tr>
			</table>

				<fieldset>&nbsp;
					<div class="denglu"><input type="submit" value="登录"
						class="button button-glow button-border button-rounded button-primary">
						<br>
						<div id="msg"><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></div>
				</div>
			</fieldset></div></form></div>

</body>
</html>