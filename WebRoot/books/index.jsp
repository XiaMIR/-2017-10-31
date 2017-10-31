<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>图书管理信息系统-图书管理</title>
<link rel=stylesheet href="../inc/main.css" type="text/css">
<style type="text/css">
</style>
</head>
<body>
	<%@include file="/inc/head.jsp"%>
	<table align="center" width="980">
		<caption>图书列表</caption>
		<tr>
			<td colspan="8">
				<a href="#">+添加新图书</a>
			</td>
		</tr>
		<tr>
			<th width="50">序号</th>
			<th width="130">图书ISBN</th>
			<th width="300">书名</th>
			<th width="150">出版社名称</th>
			<th width="70">价格</th>
			<th width="70">版本号</th>
			<th width="80">出版年份</th>
			<th width="130">操作</th>
		</tr>
	</table>
</html>