<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户详情</title>
</head>
<body>

<div>
 
<c:choose>
      <c:when test="${user!=null && user.name!=''}">
      <br>
      	&nbsp;&nbsp;
      	<span style="color:#333">昵称：${user.name}</span>
      	</br>
      	<br>
      	&nbsp;&nbsp;
      	<span style="color:#333">用户名：${user.mid}</span>
      	</br>
      	<br>
      	&nbsp;&nbsp;
      	<span style="color:#333">关注：${user.attention}</span>
      	</br>
      	<br>
      	&nbsp;&nbsp;
      	<span style="color:#333">粉丝：${user.fans}</span>
      	</br>
      	<br>
      	&nbsp;&nbsp;
      	<span style="color:#333">硬币：${user.coin}</span>
      	</br>
      	<br>
      	&nbsp;&nbsp;   
        <img src="${user.face}" width="40" height="30" />
        </br>
        &nbsp;&nbsp;
      	<a href="/user/upload">上传头像</a>
      	&nbsp;&nbsp;
      	<a href="/user/alterpassword">修改密码</a>
      	&nbsp;&nbsp;
      	<a href="/user/logout">退出登录</a>
      </c:when>
      <c:otherwise>
      	&nbsp;&nbsp;
		<a href="/user/register">注册</a>
		&nbsp;&nbsp;
		<a href="/user/login">登录</a>
      </c:otherwise>
</c:choose>

</div>
</body>
</html>