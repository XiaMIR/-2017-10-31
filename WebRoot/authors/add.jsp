<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/function.js"></script>
<script type="text/javascript">
	function checkForm(myform) {
		var fName = myform.firstName.value;
		var lName = myform.lastName.value;
		if (fName == "") {
			alert('名不能为空！');
			myform.firstName.focus();
			return;
		}
		if (lName == "") {
			alert('姓不能为空！');
			myform.lastName.focus();
			return;
		}
		//提交表单
		myform.submit();
		
		alert("点击刷新！");
		refreshOpener();
	}
</script>
</head>
<body>

	<form action="" name="addAuthor" method="post">
		<table>
			<caption>添加作者</caption>
			<tr>
				<td>
					作者姓：
				</td>
				<td>
					<input type="text" name="firstName">
				</td>
			</tr>
			<tr>
				<td>
					作者名：
				</td>
				<td>
					<input type="text" name="lastName">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="保存" onclick="checkForm(addAuthor);">
					<input type="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>