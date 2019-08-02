<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>美妆商城</title>
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
					
					<li><a href="./liebiao.html" target="_blank">ysl口红</a></li>
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
						<input type="text" class="shuru"  placeholder="Dior999&nbsp;现货秒杀">
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
				<c:forEach items="${mainAndByList}" var="mainList">
					<li class="productType">
						<a>${mainList.mainPro}</a>
						<c:set value="${mainList.byList}" var="byList" />
						 <div class="pop">
							<div class="left fl">
								<c:forEach items="${byList}" var="by" begin="0" end="5">
									<div>
										<div class="xuangou_left fl">
											<a href="">
											<div class="img fl"><img src="/shoppingmall/static/image/${by.imgAddress}" alt=""></div>
												<span class="fl">${by.byProName}</span>
											<div class="clear"></div>
											</a>
											</div>
											<div class="xuangou_right fr"><a href="/shoppingmall/Index/pick?main=${by.mainProId}&by=${by.id}">选购</a></div>
										<div class="clear"></div>
									</div>
								 </c:forEach>
							</div>
							<div class="ctn fl">
								<c:forEach items="${byList}" var="by" begin="6" end="11">
									
									<div>
										<div class="xuangou_left fl">
											<a href="">
											<div class="img fl"><img src="/shoppingmall/static/image/${by.imgAddress}" alt=""></div>
												<span class="fl">${by.byProName}</span>
											<div class="clear"></div>
											</a>
											</div>
											<div class="xuangou_right fr"><a href="/shoppingmall/Index/pick?main=${by.mainProId}&by=${by.id}">选购</a></div>
										<div class="clear"></div>
									</div>
								</c:forEach>	
							</div>
							<div class="right fl">
								<c:forEach items="${byList}" var="by" begin="12" end="18">
									<div>
										<div class="xuangou_left fl">
											<a href="">
											<div class="img fl"><img src="/shoppingmall/static/image/${by.imgAddress}" alt=""></div>
												<span class="fl">${by.byProName}</span>
											<div class="clear"></div>
											</a>
											</div>
											<div class="xuangou_right fr"><a href="/shoppingmall/Index/pick?main=${by.mainProId}&by=${by.id}">选购</a></div>
										<div class="clear"></div>
									</div>
								</c:forEach>	
							</div>
						</div>
						<div class="clear">
						</div>
					</li>
				</c:forEach>
				</ul>
			</div>
		</div>	
		<div class="sub_banner center">
			<div class="sidebar fl">
				<div class="fl"><a href=""><img src="/shoppingmall/static/image/01.png"></a></div>
				<div class="fl"><a href=""><img src="/shoppingmall/static/image/02.png"></a></div>
				<div class="fl"><a href=""><img src="/shoppingmall/static/image/03.png"></a></div>
				<div class="fl"><a href=""><img src="/shoppingmall/static/image/04.png"></a></div>
				<div class="fl"><a href=""><img src="/shoppingmall/static/image/05.png"></a></div>
				<div class="fl"><a href=""><img src="/shoppingmall/static/image/06.png"></a></div>
				<div class="clear"></div>
			</div>
			<div class="datu fl"><a href=""><img src="/shoppingmall/static/image/dilan.png" alt=""></a></div>
			<div class="datu fl"><a href=""><img src="/shoppingmall/static/image/dilan2.png" alt=""></a></div>
			<div class="datu fr"><a href=""><img src="/shoppingmall/static/image/dilan3.png" alt=""></a></div>
			<div class="clear"></div>


		</div>
	<script type="text/javascript">
		$(document).ready(function(){
			
		});
	</script>
	</body>
</html>