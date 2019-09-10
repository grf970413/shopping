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
				<a href="./index.html" target="_blank"><img src="./image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<form  method="post" action="/shoppingmall/Login/validate" class="form center">
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">会员登录</div>
					<div class="right fr">您还不是我们的会员？<a href="./register.html" target="_self">立即注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">用户名:&nbsp;<input id="userName" class="shurukuang" type="text" name="userName" autocomplete="off"  placeholder="请输入你的用户名" required="required"/></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input id="password" autocomplete="off" class="shurukuang" type="password" name="password" placeholder="请输入你的密码" required="required"></div>
					<div class="username">
						<div class="left fl">验证码:&nbsp;<input class="yanzhengma" type="text" autocomplete="off" name="username" placeholder="请输入验证码" required="required"/></div>
						<div class="right fl"><img id="img" style="width:100px;height: 50px;" src="/shoppingmall/ValidCode/validCode"></div>
						<div class="clear"></div>
						
						
						
						
					</div>
				</div>
				<div class="login_submit">
				<input type="hidden" name="page" value="${page}"/>
				<input type="hidden" name="productName" value="${productName}"/>
					<input id="login" class="submit" type="submit" name="submit" value="立即登录" >
				</div>
				
			</div>
		</div>
		</form>
		
	</body>
	<script type="text/javascript">
		$(document).ready(function(){
			imgClick();
		});
		 function imgClick(){
			 $("#img").click(function(){
				 $("#img").attr("src","/shoppingmall/ValidCode/validCode?data="+ new Date()); 
			 });
	     }  
	</script>
</html>