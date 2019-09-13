<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>会员登录</title>
		<link rel="stylesheet" type="text/css" href="/shoppingmall/static/css/login.css">
		<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
		<script src="/shoppingmall/static/lib/layer/2.4/layer.js"></script>
	</head>
	<body>
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="#"><img src="./image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<form class="form center">
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">会员登录</div>
					<div class="right fr">您还不是我们的会员？<a href="/shoppingmall/Register/register">立即注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">用户名:&nbsp;<input id="userName" class="shurukuang" type="text" name="userName" autocomplete="off"  placeholder="请输入你的用户名" required="required"/></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input id="password" autocomplete="off" class="shurukuang" type="password" name="password" placeholder="请输入你的密码" required="required"></div>
					<div class="username">
						<div class="left fl">验证码:&nbsp;<input id="validCode" class="yanzhengma" type="text" autocomplete="off" name="username" placeholder="请输入验证码" required="required"/></div>
						<div class="right fl"><img id="img" style="width:100px;height: 50px;" src="/shoppingmall/ValidCode/validCode"></div>
						<div class="clear"></div>
						
						
						
						
					</div>
				</div>
				<div class="login_submit">
					<input type="hidden" name="page" value="${page}"/>
					<input type="hidden" name="productName" value="${productName}"/>
					<input id="login" class="submit" type="button" name="submit" value="立即登录" ><span>&nbsp&nbsp<a href="/shoppingmall/${url}"><font color="#FFFFFF">返回</font></a></span>
				</div>
				
			</div>
		</div>
		</form>
		
	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			imgClick();
			login();
		});
		 function imgClick(){
			 $("#img").click(function(){
				 $("#img").attr("src","/shoppingmall/ValidCode/validCode?data="+ new Date()); 
			 });
	     } 
		 function login(){ //登录
			 $("#login").click(function(){
				 if(validate()){
					 var userName = $("#userName").val();
					 var password = $("#password").val();
					 var validCode = $("#validCode").val();
					 $.ajax({
						url:"/shoppingmall/Login/validate",
						type:"get",
						data:{"userName":userName,"password":password,"validCode":validCode},
						dataType:"json",
						success:function(data){
							if(data.res==1){
								layer.msg('登录成功',{icon:1,time:1500});
								window.location.href="/shoppingmall/${url}";
							}
							if(data.res==0){
								layer.msg('用户不存在',{icon:0,time:1500});
							}
							if(data.res==2){
								layer.msg('密码错误',{icon:0,time:1500});
							}
							if(data.res==3){	
								layer.msg('验证码错误',{icon:0,time:1500});
							}
						},
						error:function(){
							alert('error');
						}
					 }); 
				 }
			 });
		 }
		 function validate(){
			 var res = true;
			 var userName = $("#userName").val();
			 var password = $("#password").val();
			 var validCode = $("#validCode").val();
			
		     
		     if(validCode.length==0){
				layer.msg('请输入验证码',{icon:5,time:1000});
				res = false;
		     }
		     if(password.length==0){
					layer.msg('请输入密码',{icon:5,time:1000});
					res = false;
			 }
		     if(userName.length==0){
					layer.msg('请输入用户名',{icon:5,time:1000});
					res = false;
			 }
			 return res;
		 }
	</script>
</html>