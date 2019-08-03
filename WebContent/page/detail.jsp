<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>小米6立即购买-小米商城</title>
		<link rel="stylesheet" type="text/css" href="/shoppingmall/static/css/style.css">
		<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="/shoppingmall/static/css/main.css">
  		<link rel="stylesheet" type="text/css" href="/shoppingmall/static/css/layui.css">
  		<script type="text/javascript" src="/shoppingmall/static/js/layui.js"></script>
		<style type="text/css">
			.title{margin-right: 34px; float: left;  margin-bottom: 0;}
			.number-cont .cut{}
			.title{float: left;}
			.number-cont{display: inline-block; float: left; line-height: 30px; }
			.number-cont{display: inline-block; float: left; line-height: 30px; }
			.number-cont .btn{display: inline-block; padding:0 6px; border:1px solid #dddddd; background: #f8f8f8; width: 20px; text-align: center; font-size: 26px; cursor: pointer; float: left;-webkit-user-select: none;
			.choose-attrs .number .btn{display: inline-block; padding:0 6px; border:1px solid #dddddd; background: #f8f8f8; width: 20px; text-align: center; font-size: 26px; cursor: pointer; float: left;-webkit-user-select: none;
-moz-user-focus: none;
-moz-user-select: none;}
		</style>
		<script type="text/javascript">
		
		</script>
	</head>
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
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
					<div class="gouwuche fr"><a href="">购物车</a></div>
					<div class="fr">
						<ul>
							<li><a id="one" href="/shoppingmall/Detail/login?page=detail&productName=${productName}">登录</a></li>
							<li><a id="two">欢迎您,${userName}</a></li>
							<li><a id="quit">[退出]</a></li>
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
					<li><a href="">小米手机</a></li>
					<li><a href="">红米</a></li>
					<li><a href="">平板·笔记本</a></li>
					<li><a href="">电视</a></li>
					<li><a href="">盒子·影音</a></li>
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



	<form id="form1" action="" method="get">	
	<div class="jieshao mt20 w">
		<div class="left fl"><img src="/shoppingmall/static/image/${imageAddress}"></div>
		<div class="right fr">
			<div class="h3 ml20 mt20" id="productName">${productName}</div>
			<div class="jianjie mr40 ml20 mt10">${info}</div>
			<div class="jiage ml20 mt10">${price}元</div>
			
			
			<div class="xqxq mt20 ml20">
				<div class="top1 mt10">
				
				 <div class="content content-nav-base datails-content">
				 <div class="data-cont-wrap w1200">
					<div class="product-intro layui-clear">
					    <div class="itemInfo-wrap">
					        <div class="itemInfo">
					        <div class="summary">
					        	<p class="address-box"><span>送&nbsp;&nbsp;&nbsp;&nbsp;至</span><strong class="address">福建&nbsp;&nbsp;福州&nbsp;&nbsp;晋安区</strong></p>
					        </div>
					            <div class="choose-attrs">
					              <div class="number layui-clear"><span class="title">数&nbsp;&nbsp;&nbsp;&nbsp;量</span><div class="number-cont"><span class="cut btn">-</span><input id="amount" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" maxlength="4" type="text" name="" value="1" disabled="disabled"><span class="add btn">+</span></div></div>
					            </div>
					        </div>
					    </div>
					</div>
				</div>
				</div>	
					
					
				<div class="clear"></div>
				</div>
				
			</div>
			<div class="xiadan ml20 mt20">
					<div class="bot mt20 ft20 ftbc" id="total">总计:${price}元</div>
					<input class="jrgwc"  type="button" name="jrgwc" id="buy" value="立即选购" />
					<input class="jrgwc" type="button" name="jrgwc" value="加入购物车" />
				
			</div>
		</div>
		<div class="clear"></div>
	</div>
	</form>
</body>
<script type="text/javascript">

	$(document).ready(function(){
		$("#one").hide();
		$("#two").hide();
		$("#quit").hide();
		sub_add();
		$("#buy").click(function(){
			buy();
		});
		validateLogin();
		$("#quit").click(function(){
			withdraw();	
		});
	});
	function sub_add(){ //点击加号和减号
		var cur = $('.number-cont input').val();
		var price = ${price};
		$('.number-cont .btn').on('click',function(){
		  if($(this).hasClass('add')){
			  cur++;
			  $("#total").text('总计'+price*(cur)+'元');
		  }else{
		    if(cur > 1){
		      cur--;
		      $("#total").text('总计'+price*(cur)+'元');
		    }  
		  }
		  $('.number-cont input').val(cur);
		});
	}
	function buy(){ //购买
		var res = 0;
		$.ajax({
			url:"/shoppingmall/Login/validateLogin",//验证用户是否登录
			type:"get",
			dataType:"json",
			data:{},
			success:function(data){
				if(1==data.res) {
					$("#form1").prop("action","/shoppingmall/Detail/buy?productName="+$("#productName").text()+"&amount="+$("#amount").val());
					$("#form1").submit();
				} else {
					$("#form1").prop("action","");
					alert('请先登录');
				}
			},
			error:function(){
				alert('error');
			}
		});
	}
	function validateLogin(){ //
		$.ajax({
			url:"/shoppingmall/Login/validateLogin",//验证用户是否登录
			type:"get",
			dataType:"json",
			data:{},
			success:function(data){
				if(1==data.res) {
					$("#two").show();
					$("#quit").show();
					$("#one").hide();
					$("#two").text('欢迎您,'+data.userName);
				} else {
					$("#one").show();
				}
			},
			error:function(){
				alert('error');
			}
		});
	}
	function withdraw(){
		$.ajax({
			url:"/shoppingmall/Login/withdraw",
			type:"get",
			data:{},
			dataType:"json",
			success:function(data){
				$("#one").show();
				$("#two").hide();
				$("#quit").hide();
			},
			error:function(){
				alert('error');	
			}
		});
	}
</script>
</html>