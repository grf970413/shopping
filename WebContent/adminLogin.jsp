<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="${pageContext.request.contextPath}/page/admin/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/page/admin/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/page/admin/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/page/admin/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<title>管理员登录</title>
  <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
   	<script src="${pageContext.request.contextPath}/static/lib/layer/2.4/layer.js"></script>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />

<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="adminName" name="" type="text" placeholder="账户" class="input-text size-L" autocomplete="off">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="password" name="" type="password" placeholder="密码" class="input-text size-L" autocomplete="off">
        </div>
      </div>
    
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          	
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input id="login" type="button" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
 
</body>
<script type="text/javascript">
	$(document).ready(function(){
		login();	
	});
	function login(){ //登录
		$("#login").click(function(){
			if(!validate()){
				layer.msg('请输入正确的账户和密码',{icon:0,time:2000});
			} else {
				var adminName = $("#adminName").val();
				var password = $("#password").val();
				$.ajax({
					url:"${pageContext.request.contextPath}/AdminIndex/validate",
					type:"get",
					data:{"adminName":adminName,"password":password},
					dataType:"json",
					async:false,
					success:function(data){
						if(data.res==1){
							layer.msg('登录成功',{icon:1,time:2000});
							window.location.href="${pageContext.request.contextPath}/AdminIndex/index";//跳转到index页面
						}
						if(data.res==0){
							layer.msg('管理员不存在',{icon:0,time:2000});					
						}
						if(data.res==2){
							layer.msg('管理员被停用',{icon:0,time:2000});
						}
						if(data.res==3){
							layer.msg('密码错误',{icon:0,time:2000});
						}
					},
					error:function(){
						alert('error');
					}
				});
			}
		});
	}
			
	
	function validate(){ //输入正确性验证
		var res = true;
		var adminName = $("#adminName").val();
		var password = $("#password").val();
		if(adminName==''){
			res = false;
		}
		if(password==''){
			res = false;
		}
		return res;
	}
</script>
</html>