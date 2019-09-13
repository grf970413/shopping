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
		<script src="/shoppingmall/static/lib/layer/2.4/layer.js"></script>
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="/shoppingmall/Index/index">首页</a></li>
						<li>|</li>
						<li><a href="/shoppingmall/Index/index">返回</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="/shoppingmall/Shopcart/shopcart">购物车</a></div>
					<div class="fr">
						<ul>
							<li><a id="userName" href="/shoppingmall/OrderCenter/orderCenter"></a>
							<li></li>
							<li><a id="quit">[退出]</a></li>
							<li><a id="login" href="/shoppingmall/Login/login" >登录</a></li>
						
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
			<a href=""><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="">YSL口红</a></li>
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
			
				
			
			<div class="biaoti center">${sortName}</div>
			<div class="main center">
			<c:forEach items="${productList}" var="list">
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
		$(document).ready(function(){
			showUserTag();
			logout();
		});
		function showUserTag(){ //控制登录按钮和用户信息的切换
			$("#login").hide();
			$("#userName").hide();
			$("#quit").hide();
			var userName = "${userName}";
			if(userName==''){ //未登录
				$("#login").show();
				
			} else { //已登录
				$("#userName").text('欢迎您,'+userName);
				$("#userName").show();
				$("#quit").show();
				//$("#login").hide();
			}
		}
		function detail(productName,imageAddress,price){ //跳转到详情页面
			window.location.href="/shoppingmall/Detail/detail?productName="+productName;
		}
		function logout(){ //注销
			$("#quit").click(function(){
				$.ajax({
					type:"get",
					url:"/shoppingmall/Login/logout",
					data:{},
					dataType:"json",
					success:function(data){
						layer.msg('注销成功',{icon:1,time:1500});
						$("#login").show();
						$("#quit").hide();
						$("#userName").text('');
						$("#userName").hide();
					},
					error:function(){
						alert('error');
					}
				});
			});
		}
	</script>
</html>