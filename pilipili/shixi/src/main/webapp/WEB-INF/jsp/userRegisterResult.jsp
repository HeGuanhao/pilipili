<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册结果</title>
</head>
<body>
<c:choose>
      <c:when test="${errorMsg!=null && errorMsg!=''}"><div style="color:red">${errorMsg}</div></c:when>
      <c:otherwise>
      	用户注册成功！<br>
      	<a href="/user/login"><button>登录</button></a>
      </c:otherwise>
</c:choose>
</body>
</html>