<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>图书管理信息系统-作者管理</title>
<link rel=stylesheet
	href="${pageContext.request.contextPath }/inc/main.css" type="text/css">
<style type="text/css">
</style>
</head>
<body>

	<!-- 引入head.jsp文件 -->
	<%@include file="/inc/head.jsp"%>
	<table align="center" width="980">
		<tr>
			<td align="right"><a href="#"
				onclick="window.open('${pageContext.request.contextPath }/LoginServlet?method=toAdd','','width=300,height=250')">添加用户</a></td>
		</tr>
	</table>
	<table style="" align="center" width="980" class="head" cellpadding="0"
		cellspacing="0">
		<caption>用户列表</caption>
		<tr>
			<!-- <th width="150">用户序号</th> -->
			<th style="width: 150px">用户序号</th>
			<th style="width: 300px">登录帐户</th>
			<th style="width: 300px">真实姓名</th>
			<th style="width: 230px">操 作</th>
		</tr>



		<c:if test="${not empty requestScope.users }">
			<c:forEach items="${requestScope.users }" var="user"
				varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${user.userName}</td>
					<td>${user.realName}</td>
					<td aigin="center">
						<!-- 判断当前用户是否是登陆用户。是则删除不了不是就能删除 --> <%-- <c:if test="${user.id eq sessScope.LoginUser.id}"> --%>

						<a
						href="${pageContext.request.contextPath }/LoginServlet?method=delete&id=${user.id}"
						onclick="return confirm('确定删除吗？删除后不可恢复')">删除</a> <%-- </c:if> --%>
						<a href="#"
						onclick="window.open('${pageContext.request.contextPath }/LoginServlet?method=toEdit&id=${user.id }','','width=300,height=250')">修改</a>
					</td>
					
				</tr>
			</c:forEach>
		</c:if>
	</table>
		<a href="#">首&nbsp;页</a>
		<!-- 此处请求传输页数参数，页数序号根据获取的数据总数计算 -->
		<%String num=request.getAttribute("pageNum").toString();
		 %>
		
		<%for(int i=0;i<Integer.parseInt(num);i++){ %>
		<a href="/LoginServlet?currentPage=<%=i+1 %>"><%=i+1 %></a>
		
		<%} %>
		
</body>
</html>