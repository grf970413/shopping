<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>个人中心</title>
		<link rel="stylesheet" type="text/css" href="/shoppingmall/static/css/style.css">
		 <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="/shoppingmall/Index/index">首页</a></li>
						<li>|</li>
						<li><a href="/shoppingmall/${url}">返回</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="/shoppingmall/Shopcart/shopcart">购物车</a></div>
					
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->
	<!-- start banner_x -->
		<div class="banner_x center">
			<a href="#"><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			
			
		</div>
<!-- end banner_x -->
<!-- self_info -->
	<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
				
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="/shoppingmall/PersonalCenter/personalCenter">我的个人中心</a></li>
				
				</ul>
			</div>
		</div>
		<div class="rtcont fr">
			<div class="ddzxbt">交易订单</div>
			<c:forEach items="${orderList}" var="order">
				<c:set value="${order.product}" var="product"/>
				<div class="ddxq">
					<div class="ddspt fl"><img src="/shoppingmall/static/image/${product.imageAddress}" alt="" width="80px" height="80px"></div>
					<div class="ddbh fl">订单号:${order.id}</div>
					<div class="ztxx fr">
						<ul>
							<li>已发货</li>
							<li>￥${product.price}</li>
							<li>${order.orderTime}</li>
							<li><a href="">订单详情></a></li>
							<div class="clear"></div>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
			</c:forEach>
			
		</div>
		<div class="clear"></div>
		</div>
	</div>

	</body>
</html>