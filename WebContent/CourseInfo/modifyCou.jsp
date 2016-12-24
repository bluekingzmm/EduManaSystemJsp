<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.edu.dto.Course"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改课程</title>
<style type="text/css">
fieldset {
	border: 0;
	text-align: center;
}

</style>
</head>
<body>
	<%@include file="/Admin/nav.jsp"%>
	<h2 style="text-align: center">修改</h2>
	<%
		Course cou = (Course) request.getAttribute("CourseInfo");
	%>
	<form
	action="<%=request.getContextPath()%>/CourseAction?operate=modifyCou"
	method="post">

		<table>
			<tr>
				<td>课程号</td>
				<td><input type="text" name="courseid"
					value="<%=cou.getCourse_id()%>" readonly="readonly" /></td>
		</tr>
			<tr>
				<td>课程名</td>
				<td><input type="text" name="coursename"
					value="<%=cou.getCourse_name()%>" maxlength="10"
					style="color: #999999" onfocus="this.value=''"
					onblur="if(this.value==''){this.value='<%=cou.getCourse_name()%>'}"
					onkeyup="value=value.replace(/[^[A-Za-z\u4e00-\u9fa5]+$/g,'')"
					required />
		</tr>
			<tr>
				<td>上课地点</td>
				<td><input type="text" name="place" value="<%=cou.getPlace()%>"
					maxlength="5" style="color: #999999" onfocus="this.value=''"
					required
					onblur="if(this.value==''){this.value='<%=cou.getPlace()%>'}"
					onkeyup="value=this.value.replace(/\D+/g,'')"
					style="color: #999999" />
		<tr><td>课时</td>
				<td><input type="text" name="time" value="<%=cou.getTime()%>"
					maxlength="11" style="color: #999999" onfocus="this.value=''"
					required
					onblur="if(this.value==''){this.value='<%=cou.getTime()%>'}"
					onkeyup="value=this.value.replace(/\D+/g,'')"
					style="color: #999999" /></td>
		</tr>

			<tr><td>上课人数</td>
				<td><input type="text" name="stucount"
					value="<%=cou.getStucount()%>" maxlength="11"
					style="color: #999999" onfocus="this.value=''" required
					onblur="if(this.value==''){this.value='<%=cou.getStucount()%>'}"
					onkeyup="value=this.value.replace(/\D+/g,'')"
					style="color: #999999" /></td>


		</tr>
	</table>
		<fieldset><input type="submit" name="submit" value="更新"
			style="width: 80px; height: 30px; color: blue;" /> <input
			type="reset" name="reset" value="重置"
			style="width: 80px; height: 30px; color: blue;" /> <br /> <span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>
	</fieldset>
</form>
</body>
</html>