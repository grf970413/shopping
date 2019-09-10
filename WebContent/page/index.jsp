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
		<script src="/shoppingmall/static/lib/layer/2.4/layer.js"></script>
	</head> 
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="#">首页</a></li>
						<li>|</li>
						<li><a href="">MIUI</a></li>
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
					<div class="gouwuche fr"><a href="/shoppingmall/Shopcart/shopcart">购物车</a></div>
					<div class="fr">
						<ul>
							<li><a id="userName" href="/shoppingmall/PersonalCenter/personalCenter"></a>
							<li></li>
							<li><a id="quit">[退出]</a></li>
							
							
							<li><a id="login" href="/shoppingmall/Login/login" >登录</a></li>
							<li>|</li>
							<li><a href="/shoppingmall/Sign/sign" >注册</a></li>
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
				<c:forEach items="${typeAndSortList}" var="typeList">
					<li class="productType">
						<a>${typeList.typeId}</a>
						<c:set value="${typeList.sortList}" var="sortList" />
						 <div class="pop">
							<div class="left fl">
								<c:forEach items="${sortList}" var="sort" begin="0" end="5">
									<div>
										<div class="xuangou_left fl">
											<a href="">
											<div class="img fl"><img src="/shoppingmall/static/image/${sort.imgAddress}" alt=""></div>
												<span class="fl">${sort.sortName}</span>
											<div class="clear"></div>
											</a>
											</div>
											<div class="xuangou_right fr"><a href="/shoppingmall/Index/pick?main=${sort.typeId}&by=${sort.id}">选购</a></div>
										<div class="clear"></div>
									</div>
								 </c:forEach>
							</div>
							<div class="ctn fl">
								<c:forEach items="${sortList}" var="sort" begin="6" end="11">
									
									<div>
										<div class="xuangou_left fl">
											<a href="">
											<div class="img fl"><img src="/shoppingmall/static/image/${sort.imgAddress}" alt=""></div>
												<span class="fl">${sort.sortName}</span>
											<div class="clear"></div>
											</a>
											</div>
											<div class="xuangou_right fr"><a href="/shoppingmall/Index/pick?main=${sort.imgAddress}&by=${sort.id}">选购</a></div>
										<div class="clear"></div>
									</div>
								</c:forEach>	
							</div>
							<div class="right fl">
								<c:forEach items="${sortList}" var="sort" begin="12" end="18">
									<div>
										<div class="xuangou_left fl">
											<a href="">
											<div class="img fl"><img src="/shoppingmall/static/image/${sort.imgAddress}" alt=""></div>
												<span class="fl">${sort.sortName}</span>
											<div class="clear"></div>
											</a>
											</div>
											<div class="xuangou_right fr"><a href="/shoppingmall/Index/pick?main=${sort.imgAddress}&by=${sort.id}">选购</a></div>
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
			}
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
						$("#userName").hide();
					},
					error:function(){
						alert('error');
					}
				});
			});
		}
	</script>
	</body>
</html>