<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>小米商城</title>
		<link rel="stylesheet" type="text/css" href="/shoppingmall/static/css/style.css">
	</head> 
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
						<li>|</li>
						<li><a href="">${name}</a></li>
						<li>|</li>
						<li><a href="">米聊</a></li>
						<li>|</li>
						<li><a href="">游戏</a></li>
						<li>|</li>
						<li><a href="">多看阅读</a></li>
						<li>|</li>
						<li><a href="">云服务</a></li>
						<li>|</li>
						<li><a href="">金融</a></li>
						<li>|</li>
						<li><a href="">小米商城移动版</a></li>
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
					
					<li><a href="./liebiao.html" target="_blank">小米手机</a></li>
					<li><a href="">红米</a></li>
					<li><a href="">平板</a></li>
					<li><a href="">电视</a></li>
					<li><a href="">盒子</a></li>
					<li><a href="">路由器</a></li>
					<li><a href="">智能硬件</a></li>
					<li><a href="">服务</a></li>
					<li><a href="">社区</a></li>
					
				</ul>
			</div>
			<div class="search fr">
				<form action="" method="post">
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="小米6&nbsp;小米MIX现货">
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
		<div class="banner_y center">
			<div class="nav">				
				<ul>
					<li>
						<c:forEach>
							<a href="">手机</a>
						</c:forEach>
							<!--  <div class="pop">
								<div class="left fl">
									<div>
										<div class="xuangou_left fl">
											<a href="">
												<div class="img fl"><img src="/shoppingmall/static/image/xm6_80.png" alt=""></div>
												<span class="fl">t</span>
												<div class="clear"></div>
											</a>
										</div>
										<div class="xuangou_right fr"><a href="/shoppingmall/static/xiangqing.html" target="_blank">选购</a></div>
										<div class="clear"></div>
									</div>								
								</div>
								-->
							<div class="ctn fl">
								
								
								
								
							</div>
							<div class="right fl">
								
								
							</div>
							<div class="clear"></div>
						</div>
						
					</li>
					
					
					
				</ul>
			</div>
		
		</div>	

		<div class="sub_banner center">
			<div class="sidebar fl">
				<div class="fl"><a href=""><img src="/shoppingmall/static/image/hjh_01.gif"></a></div>
				<div class="fl"><a href=""><img src="/shoppingmall/static/image/hjh_02.gif"></a></div>
				<div class="fl"><a href=""><img src="/shoppingmall/static/image/hjh_03.gif"></a></div>
				<div class="fl"><a href=""><img src="/shoppingmall/static/image/hjh_04.gif"></a></div>
				<div class="fl"><a href=""><img src="/shoppingmall/static/image/hjh_05.gif"></a></div>
				<div class="fl"><a href=""><img src="/shoppingmall/static/image/hjh_06.gif"></a></div>
				<div class="clear"></div>
			</div>
			<div class="datu fl"><a href=""><img src="/shoppingmall/static/image/hongmi4x.png" alt=""></a></div>
			<div class="datu fl"><a href=""><img src="/shoppingmall/static/image/xiaomi5.jpg" alt=""></a></div>
			<div class="datu fr"><a href=""><img src="/shoppingmall/static/image/pinghengche.jpg" alt=""></a></div>
			<div class="clear"></div>


		</div>
	</body>
</html>