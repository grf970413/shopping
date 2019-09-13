<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>用户注册</title>
		<link rel="stylesheet" type="text/css" href="/shoppingmall/static/css/login.css">
		<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
		 <script src="/shoppingmall/static/lib/layer/2.4/layer.js"></script>
	</head>
	<body>
		<form>
		<div class="regist">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl">会员注册</div>
					<div class="right fr"></div>
					<div class="right fr"><a href="/shoppingmall/Index/index">首页</a>&nbsp<a href="/shoppingmall/${url}">返回</a></div>
					
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="regist_main center">
					<div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input id="userName" class="shurukuang" type="text" name="userName" placeholder="请输入你的用户名" autocomplete="off" required="required"/><span>用户名</span></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input id="password" class="shurukuang" type="password" name="password" placeholder="请输入你的密码" autocomplete="off" required="required"/><span>请输入6位以上字符</span></div>
					<div class="username">确认密码:&nbsp;&nbsp;<input id="password1" class="shurukuang" type="password" name="repassword" placeholder="请确认你的密码" autocomplete="off" required="required"/><span>两次密码要输入一致哦</span></div>
					<div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input id="mobile" class="shurukuang" type="text" name="mobile" placeholder="请填写正确的手机号" autocomplete="off" required="required"/><span>填写下手机号吧，方便我们联系您！</span></div>
					<div class="username">收货地址:&nbsp;&nbsp;<input id="address" class="shurukuang" type="text" name="address" placeholder="请填写收货地址" autocomplete="off" required="required"/><span>收货地址</span></div>	
				</div>
				<div class="regist_submit">
					<input id="signIn" class="submit" type="button"  value="立即注册" />
				</div>
				
			</div>
		</div>
		</form>
	</body>
	<script>
		$(document).ready(function(){
			submit();
				
			
		});
	function submit(){ //提交
		
			$("#signIn").click(function(){
				if(validate()){
					var userName = $("#userName").val();
					var password = $("#password1").val();
					var mobile = $("#mobile").val();
					var address = $("#address").val();
					$.ajax({
						url:"/shoppingmall/Register/signIn",
						type:"get",
						dataType:"json",
						data:{"userName":userName,"password":password,"mobile":mobile,"address":address},
						contentType:"application/json;charset=utf-8",
						async:false,
						success:function(data){
							if(data.res==1){
								layer.msg('注册成功',{icon:1,time:2000});
								window.location.href="/shoppingmall/${url}";
							} else {
								layer.msg('用户名已存在',{icon:0,time:2000});	
							}
						},
						error:function(){
							alert('error');
						}
					});
				} else {
					layer.msg('输入有误',{icon:1,time:2000});
				}		
		});
	
		
	}	
		
	function validate(){ //验证输入的正确性
		var res = true;
	 	//密码输入验证
		if($("#password").val()!=$("#password1").val()){
			res = false;
		} 
	 	//电话号码长度验证
	 	if($("#address").val().length==0){
	 		res = false;	
	 	}
		if($("#mobile").val().length==0){
			res = false;
	 	}
		if($("#userName").val().length==0){
			res = false;
		}
		if($("#password1").val().length==0){
			res = false;
		}
		if($("#password").val().length==0){
			res = false;
		}
		return res;
	}
	
	
	</script>
</html>