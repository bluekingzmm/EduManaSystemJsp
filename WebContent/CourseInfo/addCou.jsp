<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/list.css" rel="stylesheet">
<title>添加课程</title>
<style type="text/css">
fieldset {
	border: 0;
}

</style>
</head>
<body>
	<%@include file="/Admin/nav.jsp"%>
	<form
	action="<%=request.getContextPath()%>/CourseAction?operate=addCou"
	method="post">
		<table class="table">
			<tr><td>请输入课程号：</td>
				<td><input type="text" name="courseid" maxlength="12"
					onkeyup="value=this.value.replace(/\D+/g,'')"
					onfocus="this.value=''"
					onblur="if(this.value==''){this.value='请输入课程号'};"
					style="color: #999999" required></td></tr>
			<tr><td>请输入课程名：</td>
				<td><input type="text" name="coursename" maxlength="5"
					style="color: #999999" onfocus="this.value=''" required
					onblur="if(this.value==''){this.value='请输入课程名'}"
					onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')"></td></tr>
			<tr><td>上课地点：</td>
				<td><input type="text" name="place" maxlength="11"
					onkeyup="value=value.replace(/^0{0,1}(13[0-9]|15[7-9]|153|156|18[7-9])[0-9]{8}$/g,'')"
					onfocus="this.value=''"
					onblur="if(this.value==''){this.value='请输入上课地点'};" required
					style="color: #999999"></td></tr>
			<tr><td>课时</td>
				<td><input type="text" name="time" maxlength="5"
					onkeyup="value=this.value.replace(/\D+/g,'')" required
					onfocus="this.value=''"
					onblur="if(this.value==''){this.value='请输入课时'};"
					style="color: #999999"></td></tr>
			<tr><td>上课人数：</td>
				<td><input type="text" name="stucount" id="num" maxlength="12"
					required onkeyup="value=this.value.replace(/\D+/g,'')"
					onfocus="this.value=''"
					onblur="if(this.value==''){this.value='请输入上课人数'};"
					style="color: #999999"></td></tr>

	</table>
		<fieldset>
			<div class="input"><input type="submit" value="添加"
				style="width: 10%; color: red; height: 40px"></div> <br> <span
			style="color: red; text-align: center;"><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>
	</fieldset>
</form>
</body>
</html>