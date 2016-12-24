<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统登录</title>
<link href="css/login.css" rel="stylesheet" rev="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<!-- <script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>   -->
<script type="text/javascript" src="js/main.js"></script>
<link href="<%=request.getContextPath()%>/css/button.css"
	rel="stylesheet">
<script language="javascript">
	function myReload() {
		document.getElementById("CreateCheckCode").src = document
				.getElementById("CreateCheckCode").src
				+ "?nocache=" + new Date().getTime();
	}
</script>
</head>
<body>
	<div class="header">
		<h1 class="headerLogo"><a title="后台管理系统" target="_blank"
			href="http://sc.chinaz.com/"><img alt="logo" src="" /></a></h1>
		<div class="headerNav"><a target="_blank"
			href="<%=request.getContextPath()%>/login.jsp">后台登陆</a> <a
			target="_blank"
			href="<%=request.getContextPath()%>/StudentInfo/addStu.jsp">注册</a></div>
</div>
	<div class="banner">
		<div class="login-aside">
			<div id="o-box-up"></div>
			<div class="madeng"><marquee direction="left" behavior="scroll"
				loop="-1" onmouseover="this.stop()" onmouseout="this.start()"
				scrollamount="4">欢迎光临本站 滁州职业技术学院学籍管理系统,学生注册时密码为000 </marquee></div>
			<div id="o-box-down" style="table-layout: fixed;">
				<div class="error-box"></div>
				<form class="registerform"
				action="<%=request.getContextPath()%>/StudentAction?operate=stuLogin"
				method="post">
					<div class="fm-item"><label for="logonId" class="form-label">学生学号：</label>
						<input type="text" maxlength="12" name="stuNum" id="num" required
						class="i-text" onkeyup="value=this.value.replace(/\D+/g,'')"
						onfocus="this.value=''"
						onblur="if(this.value==''){this.value='请输入学号'};"
						style="color: #999999" />
						<div class="ui-form-explain"></div></div>

					<div class="fm-item"><label for="logonId" class="form-label">登陆密码：</label>
						<input type="password" value="" maxlength="12" name="password"
						required id="psw" class="i-text" placeholder="请输入密码！" />
						<div class="ui-form-explain"></div></div>
					<div class="fm-item pos-r"><label for="logonId"
						class="form-label">验证码</label> <input type="text"
						placeholder="输入验证码" maxlength="100" id="checkCode"
						name="checkCode" class="i-text yzm" nullmsg="请输入验证码！" required />
						<div class="ui-form-explain"><img id="CreateCheckCode"
							src="<%=request.getContextPath()%>/StudentAction?operate=yzm"
							class="yzm-img" /><a onclick="myReload()" href="">看不清？换一张试试</a></div></div> <label
					for="logonId" class="form-label"></label>
					<fieldset><input type="submit" value="" tabindex="4"
						id="send-btn" class="btn-login" /><br> <span
						style="text-align: center;"><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%></span>
				</fieldset>
			</form>
		</div>
	</div>
		<div class="bd">
			<ul>
				<li
				style="background: url(themes/theme-pic1.jpg) center 0 no-repeat;"><a
					target="_blank"></a></li>
				<li
				style="background: url(themes/theme-pic2.jpg) center 0 no-repeat;"><a
					target="_blank"></a></li>
		</ul>
	</div>

		<div class="hd"><ul></ul></div>
</div>

	<div class="banner-shadow"></div>

	<div class="footer"></div>
</body>
</html>