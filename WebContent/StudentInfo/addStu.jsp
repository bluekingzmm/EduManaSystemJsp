<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link href="<%=request.getContextPath()%>/css/list.css" rel="stylesheet">
</head>
<body>
	<%@include file="/StudentInfo/stuNav.jsp"%>
	<form
	action="<%=request.getContextPath()%>/StudentAction?operate=addStu"
	method="post">
		<table class="table">
			<tr><td>请输入学号：</td>
				<td><input type="text" name="num" id="num" maxlength="12"
					required onkeyup="value=this.value.replace(/\D+/g,'')"
					onfocus="this.value=''"
					onblur="if(this.value==''){this.value='请输入数字'};"
					style="color: #999999"></td></tr>
			<tr><td>请输入姓名：</td>
				<td><input type="text" name="name" id="name" maxlength="5"
					required style="color: #999999" onfocus="this.value=''"
					onblur="if(this.value==''){this.value='请输入文字'}"
					onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')"></td></tr>
			<tr><td>请输入性别：</td>
				<td>男<input type="radio" name="sex" value="男" checked="checked">女<input
					type="radio" name="sex" value="女"></td></tr>
			<tr><td>请输入身份证号码</td>
				<td><input type="text" name="Id" name="id" maxlength="18"
					required style="color: #999999" onfocus="this.value=''"
					onblur="if(this.value==''){this.value='请输入数字'}"
					onkeyup="value=value.replace(/^[a-zA-Z]+\D*|^\d{0,16}[a-zA-Z]+|[^0-9Xx]/g,'') "></td></tr>
			<tr><td>请选择系部</td>
				<td><select name="xb">
						<option value="null" id="xb" required>==请选择==</option>
						<option selected="selected" value="信息系">信息系</option>
						<option value="传媒系">传媒系</option>
						<option value="汽车系">汽车系</option>
						<option value="食品环境系">食品环境系</option>
						<option value="经贸系">经贸系</option>
				</select></td></tr>

	</table>
		<div class="input"><input type="submit" value="添加"
			style="width: 10%; color: red; height: 40px"></div> <br /> 
			<span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>

</form>


</body>
</html>