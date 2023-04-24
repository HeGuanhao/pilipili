<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>会员登录</title>
<link rel="stylesheet" href="../../static/loginstyle.css">
</head>
<body scroll = no>  <!-- 图片不随滚动条滚动 -->

<form action="/user/loginPost" method="post">
	<h2 align="center">用户登录</h2>
	<table border="1"  align="center">
		<tr>
			<td colspan="2">bili会员登录</td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="userName" value="" placeholder="请输入用户名" /></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password" value="" placeholder="请输入密码" /></td>
		</tr>
		<tr>
			<input type="hidden" name="referer" value="<%=request.getHeader("Referer")%>" />
			<td colspan="2"><input type="submit" value="登录" /></td>
			<div class="register">
				<a href = "http://localhost:8080/user/register">注册</a>		
			</div>

		</tr>
	</table>
</form>
</body>
</html>