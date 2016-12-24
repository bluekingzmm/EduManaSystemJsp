<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/list.css" rel="stylesheet">
<title>添加教师</title>
</head>
<body>
<%@include file="/Admin/nav.jsp" %>
<form action="<%=request.getContextPath()%>/TeacherAction?operate=addTea"
	method="post">
		<table class="table">
			<tr><td>请输入教工号：</td>
				<td><input type="text" name="num" id="num" maxlength="12"
					 onkeyup="value=this.value.replace(/\D+/g,'')" onfocus="this.value=''"
					onblur="if(this.value==''){this.value='请输入教工号'};"style="color: #999999"></td></tr>
			<tr><td>请输入姓名：</td>
				<td><input type="text" name="name" id="name" maxlength="5"
					style="color: #999999" onfocus="this.value=''"
					onblur="if(this.value==''){this.value='请输入姓名'}" onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')"></td></tr>
			<tr><td>请输入性别：</td>
				<td>男<input type="radio" name="sex" value="男" checked="checked">女<input
					type="radio" name="sex" value="女"></td></tr>
					<tr>
					<td>手机号码：</td>
					<td><input type="text" name="tel" id="tel" maxlength="11"
					 onkeyup="value=value.replace(/^0{0,1}(13[0-9]|15[7-9]|153|156|18[7-9])[0-9]{8}$/g,'')" onfocus="this.value=''"
					onblur="if(this.value==''){this.value='请输入手机号'};"style="color: #999999"></td></tr>
			<tr><td>请输入所教课程号</td>
				<td><input type="text" name="courseid"  maxlength="5"
					onkeyup="value=this.value.replace(/\D+/g,'')" onfocus="this.value=''"
					onblur="if(this.value==''){this.value='请输入课程号'};"style="color: #999999"></td></tr>
			
			
	</table>
		<div class="input"><input type="submit" value="添加"
			style="width: 10%; color: red; height: 40px"></div></form>
		
	<span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>

</body>
</html>