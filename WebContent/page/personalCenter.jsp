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
			<a href="./index.html" target="_blank"><div class="logo fl"></div></a>
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
					<li><a href="/shoppingmall/OrderCenter/orderCenter" >我的订单</a></li>
					
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="" style="color:#ff6700;font-weight:bold;">我的个人中心</a></li>
					
				</ul>
			</div>
		</div>
		<div class="rtcont fr">
			<div class="grzlbt ml40">我的资料</div>
			<div class="subgrzl ml40"><span>用户名</span><span>${user.userName}</span><span><a href="">编辑</a></span></div>
			<div class="subgrzl ml40"><span>密码</span><span>******</span><span><a href="">编辑</a></span></div>
			<div class="subgrzl ml40"><span>手机号</span><span>${user.mobile}</span><span><a href="">编辑</a></span></div>
			<div class="subgrzl ml40"><span>收货地址</span><span>${user.address}</span><span><a href="">编辑</a></span></div>
			<div class="subgrzl ml40"><span>余额</span><span>${user.balance}</span><span><a href="">充值</a></span></div>
			
		</div>
		<div class="clear"></div>
		</div>
	</div>

	</body>
	<script>
		
	
	
	
	</script>
</html>