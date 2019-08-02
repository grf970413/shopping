<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>商品列表</title>
		<link rel="stylesheet" type="text/css" href="/shoppingmall/static/css/style.css">
		 <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="http://www.mi.com/" target="_blank">美妆商城</a></li>
						<li>|</li>
						<li><a href="">${name}</a></li>
						<li>|</li>
						<li><a href="">闲聊</a></li>
						<li>|</li>
						<li><a href="">游戏</a></li>
						<li>|</li>
						<li><a href="">多看阅读</a></li>
						<li>|</li>
						<li><a href="">云服务</a></li>
						<li>|</li>
						<li><a href="">金融</a></li>
						<li>|</li>
						<li><a href="">美妆商城移动版</a></li>
						<li>|</li>
						<li><a href="">问题反馈</a></li>
						<li>|</li>
						<li><a href="">Select Region</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="">购物车</a></div>
					<div class="fr">
						<ul>
							<li><a href="./login.html" target="_blank">登录</a></li>
							<li>|</li>
							<li><a href="./register.html" target="_blank" >注册</a></li>
							<li>|</li>
							<li><a href="">消息通知</a></li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href="./index.html" target="_blank"><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="">ysl口红</a></li>
					<li><a href="">红腰子</a></li>
					<li><a href="">防晒霜</a></li>
					<li><a href="">神仙水</a></li>
					<li><a href="">资生堂</a></li>
					<li><a href="">Channel</a></li>
					<li><a href="">纪梵希</a></li>
					<li><a href="">黛珂</a></li>
					<li><a href="">香水</a></li>
					
				</ul>
			</div>
			<div class="search fr">
				<form action="" method="post">
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="Dior999&nbsp;现货">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
		</div>
<!-- end banner_x -->

	<!-- start banner_y -->
	<!-- end banner -->

	<!-- start danpin -->
		<div class="danpin center">
			
				
			
			<div class="biaoti center">${by}</div>
			<div class="main center">
			<c:forEach items="${list}" var="list">
				<div onclick="detail('${list.productName}','${list.imageAddress}','${list.price}')" class="mingxing fl mb20" style="border:2px solid #fff;width:230px;cursor:pointer;" onmouseout="this.style.border='2px solid #fff'" onmousemove="this.style.border='2px solid red'">
					<div class="sub_mingxing"><img src="/shoppingmall/static/image/${list.imageAddress}" alt=""></div>
					<div class="pinpai">${list.productName}</div>
					<div class="youhui">${list.info}</div>
					<div class="jiage">${list.price}</div>
				</div>
				</c:forEach>
				
				<div class="clear"></div>
			</div>
			
		</div>
		



	</body>
	<script>
		function detail(productName,imageAddress,price){ //跳转到详情页面
			window.location.href="/shoppingmall/Detail/detail?productName="+productName+"&imageAddress="+imageAddress+"&price="+price;
		}
	</script>
</html>