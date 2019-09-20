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
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/SL/pages/admin/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="/SL/pages/admin/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="/SL/pages/admin/static/h-ui.admin/css/style.css" />
<script type="text/javascript" src="/SL/pages/admin/lib/layer/2.4/layer.js"></script>
<title></title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${userName}" placeholder="" id="userName" name="userName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>真实姓名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${realName}" placeholder="" id="realName" name="realName">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${password}" placeholder="" id="password" name="password">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${mobile}" placeholder="" id="mobile" name="mobile">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>地址：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${address}" placeholder="" id="address" name="address">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>余额：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="" id="balance" value="${balance}">
			</div>
		</div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input id="add" class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			
			</div>
		</div>
	</form>
</article>
<script type="text/javascript" src="/SL/pages/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/SL/pages/admin/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="/SL/pages/admin/static/h-ui.admin/js/H-ui.admin.js"></script>
</body>
	<script>
		$(document).ready(function(){
			add();
		});
		function add(){ //添加用户
			$("#add").click(function(){
				if(validate()){
					var userName = $("#userName").val();
					var password = $("#password").val();
					var mobile = $("#mobile").val();
					var address = $("#address").val();
					var realName = $("#realName").val();
					$.ajax({
						url:"/SL/UserManage/add",
						type:"get",
						dataType:"json",
						data:{
							"userName":userName,
							"password":password,
							"mobile":mobile,
							"address":address,
							"realName":realName
						},
						async:false,
						success:function(data){
							if(data.res==1){
								
								
								
								parent.layer.msg('添加成功',{icon:1,time:2000});
								var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
								parent.layer.close(index); //再执行关闭
								window.parent.location.reload(); //刷新不了
								
							} else {
								layer.msg('用户名已存在',{icon:0,time:2000});
							}
						},
						error:function(){
							alert('error');
						}
					});
				}
			});
		}
		function validate(){ //验证输入的准确性
			var res = true;
			var userName = $("#userName").val();
			var password = $("#password").val();
			var mobile = $("#mobile").val();
			var realName = $('#realName').val();
			var address = $("#address").val();
			if(address==''){
				layer.msg('地址不为空',{icon:0,time:2000});
				res = false;
			}
			if(mobile==''){
				layer.msg('电话不为空',{icon:0,time:2000});
				res = false;
			}
			if(realName==''){
				layer.msg('真实姓名不为空',{icon:0,time:2000});
				res = false;
			}
			if(password==''){
				layer.msg('密码不为空',{icon:0,time:2000});
				res = false;
			}
			if(userName==''){
				layer.msg('用户名不为空',{icon:0,time:2000});
				res = false;
			}
			return res;
		}
	</script>
</html>