<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册会员</title>
<link rel="stylesheet" href="../../static/loginstyle.css">
</head>

<body scroll = no>  <!-- 图片不随滚动条滚动 -->
<form action="/user/registerPost" method="post">
       <h2 align="center">bili会员注册</h2>
	
	<table border="1"  align="center">
		<tr>
			<td colspan="2">bili会员注册登录</td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="userName" value="" placeholder="请输入用户名" /></td>
		</tr>
		<tr>
			<td>昵称：</td>
			<td><input type="text" name="Name" value="" placeholder="请输入昵称" /></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password" value="" placeholder="请输入密码" /></td>
		</tr>
		<tr>
			<td>确认密码：</td>
			<td><input type="password" name="passwordRep" value="" placeholder="请输入确认密码" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="注册" /></td>
		</tr>
	</table>
</form>
</body>
</html>