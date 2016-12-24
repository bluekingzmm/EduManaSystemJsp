<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

.input{

}
</style>
</head>
<body>
	<%@include file="/StudentInfo/stuNav.jsp"%>
	<form
	action="<%=request.getContextPath()%>/StudentAction?operate=changePsw"
	method="post">
		<table>
			<tr><td>学号：</td>
				<td><input type="text" name="num" id="num"
					value="<%=session.getAttribute("stuNum")%>" readonly="readonly"></td></tr>
			<tr><td>请输入原密码：</td>
				<td><input type="password" name="oldPsw" id="oldPsw" required
					placeholder="请输入原密码"></td></tr>
			<tr><td>请输入新密码：</td>
				<td><input type="password" name="newPsw" id="newPsw" required
					placeholder="请输入新密码"></td></tr>
			<tr><td>请再次输入新密码：</td>
				<td><input type="password" name="againPsw" id="againPsw"
					required placeholder="请再次输入新密码"></td></tr>
			<tr><td>&nbsp;</td>
				<td><input type="submit" onclick="xg();" value="修改" class="input"
					style="width: 50%; color: red;"></td>
		</tr>
			<tr>
				<td style="color: red"><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></td>
		</tr>
	</table>
</form>

</body>
</html>