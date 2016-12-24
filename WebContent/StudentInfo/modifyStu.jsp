<%@page import="com.edu.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生</title>
</head>
<body>

	<%@include file="/Admin/nav.jsp"%>
	<h2 style="text-align: center">修改</h2>
	<%
		Student stu = (Student) request.getAttribute("StudentInfo");
	%>
	<form action="<%=request.getContextPath()%>/StudentAction?operate=modifyStu"
	method="post">
	
		<table>
			<tr>
				<td>学号</td>
				<td><input type="text" name="num" value="<%=stu.getNum()%>"
					readonly="readonly" /></td>
		</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="name" value="<%=stu.getName()%>"
					maxlength="5" style="color: #999999" onfocus="this.value=''"
					onblur="if(this.value==''){this.value='<%=stu.getName()%>'}"
					onkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')" />
					<td>&nbsp;</td>
			
		</tr>
			<tr>
				<td>身份证号码</td>
				<td><input type="text" name="Id" value="<%=stu.getID()%>"
					maxlength="18" style="color: #999999" onfocus="this.value=''"
					onblur="if(this.value==''){this.value='<%=stu.getID()%>'}"
					onkeyup="value=value.replace(/^[a-zA-Z]+\D*|^\d{0,16}[a-zA-Z]+|[^0-9Xx]/g,'') " />
					<td>&nbsp;</td>
			
			
		<tr><td>请选择系部</td>
				<td><select name="xb">
						<option selected="selected" value="<%=stu.getDepartment() %>" id="xb">==请选择==</option>
						<option value="信息系">信息系</option>
						<option value="传媒系">传媒系</option>
						<option value="汽车系">汽车系</option>
						<option value="食品环境系">食品环境系</option>
						<option value="经贸系">经贸系</option>
				</select></td>
				<td>&nbsp;</td>
				</tr>
				<tr>
			<td><input type="submit" name="submit" value="更新"
					style="width: 80px; height: 30px; color: blue;" /></td>
					<td><input type="reset" name="reset" value="重置"style="width: 80px; height: 30px; color: blue;"/></td>
					<td><%=request.getAttribute("msg")==null?"":request.getAttribute("msg").toString() %></td>
				</tr>
			
					
					

	</table></form>

</body>
</html>