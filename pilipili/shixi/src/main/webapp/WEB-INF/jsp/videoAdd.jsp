<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bili短视频添加</title>
</head>
<body>
<form action="/video/addPost" method="post">
	bili短视频添加<br>
	aid：<input type="text" name="aid" value="" placeholder="请输入aid" />
	<br/>
	bvid：<input type="text" name="bvid" value="" placeholder="请输入bvid" />
	<br/>
	cid：<input type="text" name="cid" value="" placeholder="请输入cid" />
	<br/>
	图片：<input type="text" name="pic" value="" placeholder="请输入视频图片地址" />
	<br/>
	标题：<input type="text" name="title" value="" placeholder="请输入视频标题" />
	<br/>
	描述：<input type="text" name="descript" value="" placeholder="请输入视频描述" />
	<br/>
	<input type="submit" value="提交" />
</form>
</body>
</html>