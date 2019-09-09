<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>确认订单</title>
		<link rel="stylesheet" type="text/css" href="/shoppingmall/static/css/style.css">
		<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
	</head>
	<body>

		<div class="banner_x center">
			<a href="./index.html" target="_blank"><div class="logo fl"></div></a>
			
			<div class="wdgwc fl ml40">确认订单</div>
			<div class="dlzc fr"></div>
			<div class="clear"></div>
		</div>
		<div class="xiantiao"></div>
		<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center">
					<div class="sub_top fl">
					</div>
					<div class="sub_top fl">商品名称</div>
					<div class="sub_top fl">单价</div>
					<div class="sub_top fl">数量</div>
					<div class="clear"></div>
				</div>
				
				
				<div class="content2 center">
					<div class="sub_content fl ">
					</div>
					<div class="sub_content fl"><img src="/shoppingmall/static/image/${imgageAddress}"></div>
					<div class="sub_content fl ft20" id="productName">${productName}</div>
					<div class="sub_content fl " id="price">${price}</div>
					<div class="sub_content fl">
						<input id="amount" class="shuliang" type="number" value="${amount}" step="1" min="1" >
					</div>
					
					
					<div class="clear"></div>
				</div>
				
			</div>
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="/Index/index">继续购物</a></li>
						<li>|</li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl">合计（不含运费）：<span id="total">${price}元</span></div>
					<div class="jsanniu fr"><input id="order" class="jsan" type="button" name="jiesuan"  value="订购"/></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</body>
	<script>
		$(document).ready(function(){
			amount();	
			order();
		});
		function amount(){ //产品数量加减
			$("#amount").click(function(){
				var price = $("#price").text();
				price = price.substr(0,price.length-1);
				$("#total").text($("#amount").val()*price+'元');    
			});
		}
		function order() { //订购
			$("#buy").click(function(){
				$.ajax({
					url:"/shoppingmall/Order/commitOrder",
					data:{"productName":$("#productName").text(),"amount":$("#amount").val()},
					dataType:"json",
					contentType:"application/json",
					success:function(data){
						if(1==data.res){
							alert(data.msg); //显示购买成功
							window.location.href="/Detail/detail?productName="+$("#productName").text(); //跳转至产品详情页
						} else {
							alert(data.msg); //预期是余额不足或者库存不足
						}
					},
					error:function(){
						alert('error');
					}			
				});
			});
		}
	</script>
</html>
