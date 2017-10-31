<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<table align="center" width="980" id="headtb"
	style="background: #4D6DA1">
	<tr>
		<td colspan="2"><img src="<%=request.getContextPath() %>/images/head.jpg"></td>
	</tr>

	<tr style="background: url(<%=request.getContextPath() %>/images/headbg.jpg) repeat-x;">
		<td>
		欢迎  &nbsp;  &nbsp;${sessionScope.LoginUser.realName}&nbsp;  &nbsp; 
		[<a href="${pageContext.request.contextPath }/LoginServlet?method=logout">退出系统</a>]
		
		</td>
		<td align="right" height="25">
		<a href="#">作者管理</a> 
		| <a href="#">出版社管理</a> | <a href="#">图书管理</a> | 
		<a href="#">图书查询</a> | 
		<a href="${pageContext.request.contextPath }/LoginServlet">用户管理</a> 
		|</td>
	</tr>
</table>
