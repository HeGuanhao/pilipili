<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>动漫列表</title>
<meta name="referrer" content="no-referrer">
<style>
* {marign:0;padding:0}
ul {list-style-type: none;margin:0;padding:0}
</style>
</head>
<body>
<div>
<a href="/video/add" target="_blank"><button>添加视频</button></a>
 
<c:choose>
      <c:when test="${user!=null && user.name!=''}">
      	&nbsp;&nbsp;
      	<span style="color:#333">昵称：${user.name}</span>
      	&nbsp;&nbsp;
      	<span style="color:#333">用户名：${user.mid}</span> 
      	&nbsp;&nbsp;   
        <img src="${user.face}" width="20" height="18" />
      	&nbsp;&nbsp;
      	<a href="/user/logout">退出登录</a>
      	&nbsp;&nbsp;
		<a href="/user/detail">用户详情</a>
      </c:when>
      <c:otherwise>
      	&nbsp;&nbsp;
		<a href="/user/register">注册</a>
		&nbsp;&nbsp;
		<a href="/user/login">登录</a>
      </c:otherwise>
</c:choose>

</div>

<c:forEach items="${videoList}" var="video">
<div style="width:48%;height:150px;overflow:hidden;float:left;border:#ccc 1px solid;border-radius:5px;margin-top:10px;margin-right:20px;padding:15px 0px">
	<div style="width:250px;float:left;text-align:center;font-size:0px">
		<a href="/video/show?aid=${video.aid}" target="_blank"><img src="${video.pic}" width="228" height="140" /></a>
	</div>
	<div style="width:280px;float:left">
		<ul>
			<li>
				<a href="/video/show?aid=${video.aid}"  target="_blank" style="color:#222">${video.title}</a>
			</li>
			<li style="height:70px;overflow:hidden;margin-top:10px;line-height:22px;color:#99a2aa">
				${video.descc}
			</li>
		</ul>
	</div>
	
</div>
</c:forEach>

</body>
</html>