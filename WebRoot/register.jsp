<%-- <%@page import="org.apache.commons.lang3.StringUtils"%> --%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>图书管理信息系统-注册</title>
<style type="text/css">
table {
	font-size: 12px;
}

table caption {
	font-size: 14px;
}
</style>
<script type="text/javascript">
	function checkForm(myForm) {
		var msg = "";
		var setFocused = false;
		if (myForm.account.value == "") {
			msg += "帐号不能为空！\n";
			myForm.account.focus();
			setFocused = true;
		}

		if (myForm.password.value == "") {
			msg += "密码不能为空！\n";
			if (!setFocused) {
				myForm.password.focus();
				setFocused = true;
			}
		}

		if (msg != "") {
			alert(msg);
			return false;
		}

		return true;

	}
</script>
</head>
<body>
	<table align="center">
		<tr>
			<td><img src="<%=request.getContextPath()%>/images/head.jpg">
			</td>
		</tr>
	</table>
	<form action="Register" name="form1" method="post"
		onsubmit="return checkForm(this);">
		<input type="hidden" name="method" value="login">
		<table align="center">
			<caption>用户注册</caption>
			<tr>
				<td>用户帐号：</td>
				<td><input type="text" style="width: 150px" name="userName">
				</td>
			</tr>
			<tr>
				<td>真实姓名：</td>
				<td><input type="text" style="width: 150px" name="realName">
				</td>
			</tr>
			<tr>
				<td>用户密码：</td>
				<td><input type="password" style="width: 150px" name="passWord">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="注册">
					<input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>