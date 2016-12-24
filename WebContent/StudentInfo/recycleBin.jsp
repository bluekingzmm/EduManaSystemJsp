<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.edu.db.DataBase"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.edu.dto.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回收站列表</title>
<style type="text/css">
#search {
	text-align: center;
	letter-spacing: 5px;
}
</style>
</head>
<body>

	<%@include file="/Admin/nav.jsp"%>

	<form
	action="<%=request.getContextPath()%>/StudentAction?operate=searchStu"
	method="post">
		<div id="search"><br /> 查询学生&nbsp;<input type="text" name="num"
			maxlength="5 " required placeholder="请输入学号" style="color: #999999" />
			<button type="submit">查询</button></div>
</form>
	<span><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>

	<br>
	<h4>学生列表</h4>
	<table class="table">
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>身份证号码</td>
			<td>系部</td>
			<td>选课课程号</td>
			<td>操作</td>
			<td>操作</td>
			<%!public static final int PAGESIZE = 5;//定义变量
					int pageCount;
					int curPage = 1;%>
			<%
				//一页放5个  
				Connection con = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
					con = DataBase.getConn();
					String sql = "select * from student where status=?";
					//ResultSet.TYPE_FORWORD_ONLY 结果集的游标只能向下滚动。
					//不能用结果集更新数据库中的表。 ResultSet.CONCUR_READ_ONLY		
					ps = con.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
					ps.setString(1, "0");
					rs = ps.executeQuery();
					rs.last();
					int size = rs.getRow();
					/*  
					rs.last();
					int size = rs.getRow();	
					public void last() 将游标移到结果集的最后一行。
					public boolean isLast() 判断游标是否指向结果集的最后一行。
					即可得到结果的个数。
					*/
					pageCount = (size % PAGESIZE == 0) ? (size / PAGESIZE) : (size / PAGESIZE + 1);
					/* 如果一页能够放5条记录，则
					int pageCount = (size%5==0)?(size/5):(size/5+1);
					即可获得需要分几页 */
					String tmp = request.getParameter("curPage");
					if (tmp == null) {
						tmp = "1";
					}
					curPage = Integer.parseInt(tmp);
					if (curPage >= pageCount)
						curPage = pageCount;
					boolean flag = rs.absolute((curPage - 1) * PAGESIZE + 1);
					/* 把结果集指针调整到当前页应该显示的记录的开始.
					比如如果一页显示5条记录，当前页是第二页，则需要把指针调整到6，当前页是第三页，则需要把指针调整为11. */
					int count = 0;
					do {
						if (count >= PAGESIZE)
							break;
						String stuName = rs.getString(2);
						String stuNum = rs.getString(1);
						String stuSex = rs.getString(3);
						String Id = rs.getString(4);
						String department = rs.getString(6);
						String courseid = rs.getString(7);
						count++;
			%>
	
	<tr>
			<td><%=stuNum%></td>
			<td><%=stuName%></td>
			<td><%=stuSex%></td>
			<td><%=Id%></td>
			<td><%=department%></td>
			<td><%=courseid%></td>

			<td><a
				href="<%=request.getContextPath()%>/StudentAction?operate=recover&num=<%=stuNum%>">还原</a>
		</td>
			<td><a
				href="<%=request.getContextPath()%>/StudentAction?operate=move&num=<%=stuNum%>">彻底删除</a>
		</td>
	</tr>
		<%
			} while (rs.next());
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {

			}
		%>
</table>

	<br>
	<div style="text-align: center; font-size: 18px;"><a
		href="StudentAction?operate=recycleBin&curPage=1">首页</a> <a
		href="StudentAction?operate=recycleBin&curPage=<%=curPage - 1%>">上一页</a>
		<a href="StudentAction?operate=recycleBin&curPage=<%=curPage + 1%>">下一页</a>
		<a href="StudentAction?operate=recycleBin&curPage=<%=pageCount%>">尾页</a>
		第<%=curPage%>页/共<%=pageCount%>页 <a
		href="<%=request.getContextPath()%>/StudentAction?operate=clearRecycleBin">清空回收站</a>

</div>
</body>
</html>