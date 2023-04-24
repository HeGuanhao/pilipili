<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>bilibili首页</title>
<link rel="stylesheet" href="../../static/homestyle.css">

</head>
<%--
<body scroll = no>  <!-- 图片不随滚动条滚动 -->
	<!--  <img alt = "图片无法加载" src="https://img.zcool.cn/community/0112cd5dc021daa801209e1f8cec04.png@1280w_1l_2o_100sh.png" id="body">
-->
	<img
		src="https://tse1-mm.cn.bing.net/th/id/R-C.7ea208c9376470855d248a344947a54e?rik=fcAewjVOUEfKzw&riu=http%3a%2f%2fi2.hdslb.com%2fbfs%2farchive%2fcb90a1633cfea0274f2bb361f439801dcd138c23.jpg&ehk=r%2bjddqU6uOVYMdVAWEePaSGvBiyZSisPjgtNZ0Z3fcg%3d&risl=&pid=ImgRaw"
		alt="bili" width="150" />
	<img
		src="https://tse4-mm.cn.bing.net/th/id/OIP-C.vY_PmKmd6XqPwHk--x6EIQHaDu?pid=ImgDet&rs=1"
		width="1342" height="150" />
	<h2>bilibili</h2>
--%>

	<!--<a href="#">首页</a>

	<a href="#">登录</a>


	<a href="#">注册</a>
-->
<%--<div class="biaoqian">
	<div class="biaoqian_con">
		<c:choose>
			<c:when test="${user!=null && user.name!=''}">
				&nbsp;&nbsp;
			<h4><span style="color:#333">昵称：${user.name}</span>
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
				<a href="/user/login">登录</a></c:otherwise></h4>
			</c:otherwise>
		</c:choose>
	</div>
</div>--%>
<
<style>
	li{float:left;}
</style>
</body>

<!--头部-->
<div class="head">
	<div class="head_con">
		<h1 class="logo"><a href="#"><img src="https://p9-bcy.byteimg.com/img/banciyuan/805da526c70f4a4c90a5b0e8ff95701e~tplv-banciyuan-w650.image" alt=""></a> </h1>
		<u1 class="top_list">
			<li class="current"><a href="#">昵称：${user.name}</a></li>
			<li class="current2"><a href="#">用户名:${user.mid} </a></li>
			<li><a href="#"><img src="${user.face}" width="30" height="28" /></a></li>
			<li><a href="/user/logout">退出登录</a></li>
			<li><a href="/user/detail">用户详情 </a></li>
			<li><a href="/user/register">注册 </a></li>
			<li><a href="/user/login">登录 </a></li>
		</u1>
		<div class="head_search">
			<input type="text" class=sear_input" placeholder="看看有什么想搜索的吧~~~~~~~~~~~~~~">
			<button>
				<i></i>
			</button>
	</div>
		<form name="form1">
			　<input type="file" name="picpath" id="picpath" style="display:none;" onChange="document.form1.path.value=this.value">
			　<input type="button" value="上传文件" onclick="document.form1.picpath.click()">
		</form>
</div>
</div>
<div class="headback">
	<div class="headback_con">
		<img src="https://wx2.sinaimg.cn/mw690/007BLNAMgy1gslklq6bi7j31hc050q59.jpg"
			 width="1580" height="130"
		/>
	</div>
</div>

	<!--分区展示-->
	<div class="part_reco">
		<div class="reco_con">
			<h2 class="tit">分区展示</h2>
			<ul class="reco_list">
				<li>
					<div class="list_pic">
						<a href="/video/wudao"><img alt="动漫"
							src="https://gss0.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/a08b87d6277f9e2fe61919391a30e924b899f3d7.jpg"
							width="300"></a>
					</div>
					<h4 class="list_tit">
						<a href="/video/dongman">动漫 
						</a>
					</h4>
				</li>
				<li>
					<div class="list_pic">
						<a href="/video/wudao"><img alt="舞蹈"
							src="https://tse1-mm.cn.bing.net/th/id/R-C.9949df1d6a6c4409c0f0f1e7eb2354eb?rik=Hc92aMJYNKY%2fHg&riu=http%3a%2f%2fimage.yjcf360.com%2fu%2fcms%2fwww%2f202102%2f18163348615d.jpg&ehk=%2b0Ud3hThhkTJ5XagM1b6jry9WfRwkSWH%2fFCHIxeS1SE%3d&risl=&pid=ImgRaw"
							width="300"></a>
					</div>
					<h4 class="list_tit">
						<a href="/video/wudao">舞蹈
						</a>
					</h4>
				</li>
				<li>
					<div class="list_pic">
						<a href="#"><img alt="游戏"
							src="https://pic4.zhimg.com/v2-a8523958a7b9ece928b22aa59c20e9c5_r.jpg?source=172ae18b"
							width="300" height="150"></a>
					</div>
					<h4 class="list_tit">
						<a href="#">游戏 </a>
					</h4>
				</li>
				<li>
					<div class="list_pic">
						<a href="#"><img alt="音乐"
							src="https://tse1-mm.cn.bing.net/th/id/R-C.36464a6922277245c85e9fe241a72582?rik=HKdEXX4c3r%2fLMg&riu=http%3a%2f%2fi0.sinaimg.cn%2fent%2f2014%2f1231%2fU10967P28DT20141231043739.jpg&ehk=fKrOQm5xou%2bRp11iycaFGvNOchyDPVo%2fTbXXpfeZOXA%3d&risl=&pid=ImgRaw"
							width="300" height="150"></a>
					</div>
					<h4 class="list_tit">
						<a href="#">音乐 </a>
					</h4>
				</li>
				<li>
					<div class="list_pic">
						<a href="#"><img alt="鬼畜"
							src="https://tse1-mm.cn.bing.net/th/id/R-C.aa57207d5820e31f7d2ad83fa4cd5fa6?rik=HNSHf7Z5t%2bzXAw&riu=http%3a%2f%2fi1.hdslb.com%2fbfs%2farchive%2ffe27c23fc3ea9084f513e6e4c5d23c79d7d8c60b.jpg&ehk=RfIMd%2bL5L7rD4sKzQYEwIItT2aOeT6Lu4dgz%2f1lQXtQ%3d&risl=&pid=ImgRaw"
							width="300" height="150"></a>
					</div>
					<h4 class="list_tit">
						<a href="#">鬼畜 </a>
					</h4>
				</li>
			</ul>
		</div>
	</div>

	<!-- 推广 -->
	<div class="part_reco">
		<div class="reco_con">
			<h2 class="tit">推广</h2>
			<div
				style="width: 48%; height: 150px; overflow: hidden; float: left; border: #ccc 1px solid; border-radius: 5px; margin-top: 10px; margin-right: 20px; padding: 15px 0px">
				<div
					style="width: 250px; float: left; text-align: center; font-size: 0px">
					<a href="/spring-bili/video/show?aid=206496157" target="_blank"><img
						src="https://img1.baidu.com/it/u=4056393322,3846855487&fm=26&fmt=auto&gp=0.jpg"
						width="228" height="140" /></a>
				</div>
				<div style="width: 280px; float: left">
					<ul>
						<li><a href="/spring-bili/video/show?aid=206496157"
							target="_blank" style="color: #222">在终端中使用 qrencode 显示二维码</a></li>
						<li
							style="height: 70px; overflow: hidden; margin-top: 10px; line-height: 22px; color: #330033">
							shell 终端生成二维码</li>
					</ul>
				</div>
			</div>
			<div
				style="width: 48%; height: 150px; overflow: hidden; float: left; border: #ccc 1px solid; border-radius: 5px; margin-top: 10px; margin-right: 20px; padding: 15px 0px">
				<div
					style="width: 250px; float: left; text-align: center; font-size: 0px">
					<a href="/spring-bili/video/show?aid=360227614" target="_blank"><img
						src="https://bpic.588ku.com/art_water_pic/19/05/11/3415c9c4b3e0d6463c9f5cd82e231db9.jpg"
						width="228" height="140" /></a>
				</div>
				<div style="width: 280px; float: left">
					<ul>
						<li><a href="/spring-bili/video/show?aid=360227614"
							target="_blank" style="color: #222">唱支Rap给党听</a></li>
						<li
							style="height: 70px; overflow: hidden; margin-top: 10px; line-height: 22px; color: #330033">
							央视新闻推出原创国漫MV《振山河》90后导演首次填词、演唱希望这次“跨界”的尝试也能唱出你的心之所想</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<!-- 人气 -->

</body>
</html>