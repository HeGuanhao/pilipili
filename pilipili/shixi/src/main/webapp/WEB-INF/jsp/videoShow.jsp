<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>视频播放</title>
</head>
<body>


<div style="width: 500px; float: left">
	<iframe
		src="//player.bilibili.com/player.html?aid=${video.aid}&bvid=${video.bvid}&cid=${video.cid}&page=1"
		scrolling="no" border="0" frameborder="no" framespacing="0"
		allowfullscreen="true" width="500" height="500"> </iframe>
	<div style="width: 500px">${video.title}</div>
	<div style="width: 500px; color: #99a2aa">${video.descc}</div>
</div>


<div style="width: 700px; float: left">
	  
	<div>
		<c:choose>
			<c:when test="${user!=null && user.name!=''}">
		      	&nbsp;&nbsp;
		      	<span style="color: #333">昵称：${user.name}</span>
		      	&nbsp;&nbsp;
		      	<span style="color: #333">用户名：${user.mid}</span>
		      	&nbsp;&nbsp;   
              <img src="${user.face}" width="20" height="18" />
		      	&nbsp;&nbsp;
		      	<a href="/user/logout">退出登录</a>
			</c:when>
			<c:otherwise>
		      	&nbsp;&nbsp;
				<a href="/uer/register">注册</a>
				&nbsp;&nbsp;
				<a href="/user/login">登录</a>
				&nbsp;&nbsp;
				<span style="font-size:10px;color:#99a2aa">登录之后才可以评论！</span>
			</c:otherwise>
		</c:choose>
	</div>

	<form action="/comment/add" method="post">
		<div style="padding:15px 0 0 15px">
			<textarea rows="10" cols="80" placeholder="进行评论" name="content"></textarea>
		</div>
		<div>
			<c:if test="${user!=null && user.mid!=''}">
				<input type="hidden" name="userId" value="${user.mid}" />
				<input type="hidden" name="aid" value="${video.aid}" />
			<!--  	<input type="hidden" name="userName" value="${user.name}" />-->
		      	&nbsp;&nbsp;
		      	<input type="submit" value="评论" />
			</c:if>
		</div>
	</form>
	
	<div style="padding:15px 0 0 15px;float:left">
		<table width="550" border="1" cellpadding="10" cellspacing="0" align="center" style="border-collapse:collapse;border-color:#e2e2e2;color:#666">
			<tr>
				<td width="60">评论人</td>
				<td>内容</td>
				<td width="100">日期</td>
			</tr>
			<c:forEach items="${commentList}" var="comment">
			<tr>
				<td>${comment.mid}</td>
				<td>${comment.content}</td>
                <!--<fmt:parseDate value="${ item.localdateTime}" pattern="y-M-dd'T'H:m" var="myParseDate"></fmt:parseDate> 
                <fmt:formatDate value="${myParseDate}"  pattern="yyyy.MM.dd HH:mm"></fmt:formatDate >
				<td><fmt:formatDate value="${comment.create_time}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate ></td>
				<td>${comment.create_time}</td>
				<td>${comment.update_time}</td>-->
			  	<td>${fn:replace(comment.create_time, "T", " ")}</td>
			</tr>
			</c:forEach>
		</table>
		</div>	
</div>

</body>
</html>