<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>商品详情</title>
		<link rel="stylesheet" type="text/css" href="/shoppingmall/static/css/style.css">
		<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="/shoppingmall/static/css/main.css">
  		<link rel="stylesheet" type="text/css" href="/shoppingmall/static/css/layui.css">
  		<script src="/shoppingmall/static/lib/layer/2.4/layer.js"></script>
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
						<li><a href="/shoppingmall/Index/index">首页</a></li>
						<li>|</li>
						<li><a href="${prePage}">返回</a></li>
					
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
							<!-- <li>|</li>
							<li><a href="/shoppingmall/Register/register">注册</a></li> -->
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
		
		</div>



	<form id="form1" action="" method="get">	
	<div class="jieshao mt20 w">
		<div class="left fl" align="center"><img src="/shoppingmall/static/image/${imageAddress}" width="250px" height="350px" ></div>
		<div class="right fr">
			<input name="productName" type="hidden" value="${productName}"/>
			<div class="h3 ml20 mt20" id="productName" >${productName}</div>
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
					              <div class="number layui-clear"><span class="title">数&nbsp;&nbsp;&nbsp;&nbsp;量</span><div class="number-cont"><span class="cut btn">-</span><input name="amount" id="amount" onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}" maxlength="4" type="text" name="" value="1" disabled="disabled"><span class="add btn">+</span></div></div>
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
					<input id="addShopcart" class="jrgwc" type="button" name="jrgwc" value="加入购物车" />
				
			</div>
		</div>
		<div class="clear"></div>
	</div>
	</form>
</body>
<script type="text/javascript">

	$(document).ready(function(){
		//alert('${prePage}');	
	
		addShopcart();
		sub_add();
		$("#buy").click(function(){
			buy();
		});
		showUserTag();
		logout();
		$("#quit").click(function(){
			withdraw();	
		});
	});
	function addShopcart(){ //添加购物车
		$("#addShopcart").click(function(){
			
			if($("#userName").text()==''){ //未登录
				layer.msg('请先登录',{icon:0,time:1000});
			} else {
				var productName = '${productName}';
				var amount = $("#amount").val();
				$.ajax({
					type:"get",
					url:"/shoppingmall/Detail/addShopcart",
					data:{"productName":productName,"amount":amount},
					success:function(data){
						layer.msg('加入购物车成功',{icon:1,time:1000});
					},
					error:function(){
						alert('error');
					}
				});
				
			}
			
		});
	}
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
		if($("#userName").text()==''){ //未登录
			$("#form1").prop("action","");
			layer.msg('请先登录',{icon:0,time:1000});
		} else {	
			$("#form1").prop("action","/shoppingmall/Detail/buy");
			$("#form1").submit();
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
					$("#userName").text('').
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