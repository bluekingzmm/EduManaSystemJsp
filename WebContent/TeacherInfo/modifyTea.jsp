<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.edu.dto.Teacher" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改教师</title>
</head>
<body>
<%@include file="/Admin/nav.jsp"%>
	<h2 style="text-align: center">修改</h2>
	<%
		Teacher tea = (Teacher) request.getAttribute("TeacherInfo");
	%>
	<form action="<%=request.getContextPath()%>/TeacherAction?operate=modifyTea"
	method="post">
	
		<table>
			<tr>
				<td>教工号</td>
				<td><input type="text" name="num" value="<%=tea.getNum()%>"
					readonly="readonly" /></td>
		</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" value="<%=tea.getName()%>"
					maxlength="5" style="color: #999999" onfocus="this.value=''"
					onblur="if(this.value==''){this.value='<%=tea.getName()%>'}"
					onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')" />
					<td>&nbsp;</td>
		
		</tr>
			<tr>
				<td>所教课程号</td>
				<td><input type="text" name="courseid" value="<%=tea.getCourse_id()%>"
					maxlength="5" style="color: #999999" onfocus="this.value=''"
					onblur="if(this.value==''){this.value='<%=tea.getCourse_id()%>'}"
					 onkeyup="value=this.value.replace(/\D+/g,'')" 
					style="color: #999999" />
					<td>&nbsp;</td>
			
		</tr>
			
		<tr><td>手机号码</td>
				<td><input type="text" name="tel" value="<%=tea.getTeatel()%>"
					maxlength="11" style="color: #999999" onfocus="this.value=''"
					onblur="if(this.value==''){this.value='<%=tea.getTeatel()%>'}"
					 onkeyup="value=this.value.replace(/\D+/g,'')" 
					style="color: #999999" /></td>
				<td>&nbsp;</td></tr>
				<tr>
				
			<td><input type="submit" name="submit" value="更新"
					style="width: 80px; height: 30px; color: blue;" /></td>
					<td><input type="reset" name="reset" value="重置"style="width: 80px; height: 30px; color: blue;"/></td>
				<td><%=request.getAttribute("msg")==null?"":request.getAttribute("msg").toString() %></td>
				</tr>
			
					
					

	</table></form>

</body>
</html>