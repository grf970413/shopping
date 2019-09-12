<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>我的购物车</title>
		<link rel="stylesheet" type="text/css" href="/shoppingmall/static/css/style.css">
		<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
		 <script src="/shoppingmall/static/lib/layer/2.4/layer.js"></script>
	</head>
	<body>
	<!-- start header -->
	<!--end header -->

<!-- start banner_x -->
		<div class="banner_x center">
			<a href=""><div class="logo fl"></div></a>
			
			<div class="wdgwc fl ml40">我的购物车</div>
			<div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
			<div class="dlzc fr">
				
			</div>
			<div class="clear"></div>
		</div>
		<div class="xiantiao"></div>
		<div class="gwcxqbj">
			<div class="gwcxd center">
				<div class="top2 center">
					<div class="sub_top fl">
						<input type="checkbox" value="quanxuan" class="quanxuan" id="checkedAll"/>全选
					</div>
					<div class="sub_top fl">商品名称</div>
					<div class="sub_top fl">单价</div>
					<div class="sub_top fl">数量</div>
					<div class="sub_top fl">小计</div>
					<div class="sub_top fr">操作</div>
					<div class="clear"></div>
				</div>
				<c:forEach items="${shopcartList}" var="s">
					<c:set value="${s.product}" var="p" />
					<c:set value="${s.amount}" var="amount" />
					<c:set value="${p.price}" var="price" />
						<div id="test" class="content2 center">
							<div class="sub_content fl">
								<input type="checkbox" value="quanxuan" class="quanxuan" />
							</div>
							<div class="sub_content fl"><img src="/shoppingmall/static/image/${p.imageAddress}" height="100" width="100"></div>
							<div class="sub_content fl ft20">${p.productName}</div>
							<div class="sub_content fl ">${p.price}</div>
							<div class="sub_content fl">
								<input class="shuliang" type="number" value="${s.amount}" step="1" min="1" >
							</div>
							<div class="sub_content fl"></div><!-- 小计  -->
							<div class="sub_content fl"><a>×</a></div>
							<div class="clear"></div>
						</div>
				</c:forEach>
			</div>
			<div class="jiesuandan mt20 center">
				<div class="tishi fl ml20">
					<ul>
						<li><a href="/shoppingmall/Index/index">继续购物</a></li>
						<li>|</li>
						<li><a href="/shoppingmall/${prePage}">返回</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="jiesuan fr">
					<div class="jiesuanjiage fl">合计（不含运费）：<span id="total">0.0</span><span>元</span></div>
					<div class="jsanniu fr"><input class="jsan" type="submit" name="jiesuan"  value="去结算" id="account"/></div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</body>
	<script>
		$(document).ready(function(){
			xiaoji();
			checkedAll();
			amount();
			deleteShopcart();
			 //结算
			check();
		
			
		});
		function check(){ //结算
			
			$("#account").click(function(){
				var productList = new Array();//选中的产品列表
				var ele = $(".sub_content").find(".quanxuan");
					$.each(ele,function(index){
						if(this.checked) {
							var p = $(this).parent();
							var productName = p.next().next().text(); //产品名称
							var price = p.next().next().next().text(); //价格
							price = price.substr(0,price.length-1);
							var amount = p.next().next().next().next().children().val(); //数量	
							var shopcart = {
								"amount" : amount,
								product : {
									"productName" : productName,
								}
							}
							productList[productList.length] = shopcart;
						}
					});	
					if(productList.length!=0){
						$.ajax({  //提交到后台
							url:"/shoppingmall/Shopcart/settleAccount",
							type:"get",
							contentType:"application/json",
							data:{"productList":JSON.stringify(productList)},
							dataType:"json",
							success:function(){
								layer.msg('购买成功',{icon:1,time:1000});
							},
							error:function(){
								alert('error');
							}
						});
					} else {
						layer.msg('至少选择一个商品',{icon:2,time:1000});
					}
			});
		}
		function xiaoji(){ //计算每条记录的小计
			var ele = $(".sub_content").find(".shuliang");
			$.each(ele,function(index){
				var price = parseFloat($(this).parent().prev().text());
				var amount = parseFloat($(this).val());
				var xiaoji = Math.floor(price*amount*100)/100; 
				$(this).parent().next().text(xiaoji);
			});
		}
		function checkedAll(){ //全选
			var ele = $(".sub_content").find(".quanxuan"); //每一个复选框
			$.each(ele,function(index){//处理每个复选框点击对全选键的影响
				$(this).click(function(){
					if(!$(this).is(":checked")){
						$("#checkedAll").prop("checked",false);
						var price = $(this).parent().next().next().next().next().next().text();
						price = parseFloat(price);
						var total = parseFloat($("#total").text());
						$("#total").text(total-price);
					} else {
						var price = $(this).parent().next().next().next().next().next().text();
						price = parseFloat(price);
						var total = parseFloat($("#total").text());
						$("#total").text(total+price);
					}
					var res = true;
					$.each(ele,function(index){//每次复选框做完点击，去遍历所有的复选框看看是否都勾选了
						if(!$(this).is(":checked")){
							res = false;
						}
					});
					if (true==res) {
						$("#checkedAll").prop("checked",true);
					}
			});
			$("#checkedAll").click(function(){	
				var tmp = $(".sub_content").find(".quanxuan");
				var ele = $(".sub_content").find(".quanxuan");
				if (tmp.length!=0) {
					if($("#checkedAll").is(':checked')){
						$("#total").text('0');
						$.each(ele,function(index){
							$(this).prop("checked",true);
							//把金额加到总金额上
							var price = $(this).parent().next().next().next().text(); //单价
							var amount = $(this).parent().next().next().next().next().children().val(); //数量	
							var total = $("#total").text();
							total = parseFloat(total);
							total = total+(Math.floor(price*amount*100)/100);
							$("#total").text(total);
						});	
					} else {
						$.each(ele,function(index){
							$(this).prop("checked",false);
							$("#total").text("0");
						});
					}
				}
			});
		});
			}
		
		function amount(){ //产品数量加减
			var ele = $(".sub_content").find(".shuliang");
			$.each(ele,function(index){
				$(this).click(function(){
					var price = $(this).parent().prev().text();//单价
					var xiaoji = $(this).parent().next().text();//小计
					xiaoji = parseFloat(xiaoji);
					if ($(this).parent().prev().prev().prev().prev().find(".quanxuan").is(":checked")) { //如果已经被选中，就把金额加到总金额
						var total = parseFloat($("#total").text());
						total -= xiaoji;
						xiaoji = parseFloat(Math.floor($(this).val()*price*100)/100);
						$(this).parent().next().text(Math.floor($(this).val()*price*100)/100); 
						$("#total").text(total+xiaoji);
					} else {
						$(this).parent().next().text(Math.floor($(this).val()*price*100)/100);
					}
				});
			});
		}
		function deleteShopcart(){ //删除某条记录
			var del = $(".sub_content").find("a");//获取所有删除按钮
			$.each(del,function(index){
				$(this).click(function(){
					var productEle = $(this).parent().parent(); //一条记录的对象
					var total = parseFloat($("#total").text());//总金额
					var ele = $(this).parent().prev().prev().prev().prev().prev().prev().children();//复选框
					var productName =  $(this).parent().prev().prev().prev().prev().text();
					var price = $(this).parent().prev().text();//小计
					layer.confirm('您确认要删除吗？',{btn:['确定','取消']},
						function(){
							//马上点击马上去数据库删除该条信息
							$.ajax({  //提交到后台
								url:"/shoppingmall/Shopcart/deleteShopcart",
								type:"get",
								contentType:"application/json",
								data:{"productName":productName}, //只传商品名称，用户名去session拿
								async:"false",
								dataType:"json",
								success:function(){
									layer.msg('删除成功!',{icon: 6,time:1000});
									//金额要减掉
									productEle.remove(); //删除记录
									if(ele.is(':checked')) {
										price = parseFloat(price);
										$("#total").text(total-price);
									}
								},
								error:function(){
									alert('error');
								}
							});
					});
				});
			});
		}
		
	</script>
</html>
    