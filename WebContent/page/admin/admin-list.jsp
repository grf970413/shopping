﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/admin/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/admin/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/admin/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/admin/static/h-ui.admin/css/style.css" />
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<title>管理员列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 管理员列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a id="addAdmin" href="javascript:;"  class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加管理员</a></span>  </div>
	<table class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">管理员列表</th>
			</tr>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="40">ID</th>
				<th width="150">用户名</th>
				<th width="150">密码</th>
				<th width="90">手机</th>
				<th>角色</th>
				<th width="100">是否已启用</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${adminList}" var="admin">
			<tr class="text-c">
				<td><input type="checkbox" value="1" name=""></td>
				<td>${admin.id}</td>
				<td class="adminName">${admin.adminName}</td>
				<td>${admin.password}</td>
				<td>${admin.mobile}</td>
				<td>${admin.role}</td>
				<td class="td-status"><span class="label label-success radius">${admin.status}</span></td>
				<td class="td-manage"><a title="编辑" href="javascript:;" onclick="admin_edit('编辑','${pageContext.request.contextPath}/AdminManage/admin-update?id=${admin.id}&adminName=${admin.adminName}&mobile=${admin.mobile}&password=${admin.password}','1','800','500','${admin.adminName}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a> </td>
				
			</tr>
		</c:forEach>	
		</tbody>
	</table>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/static/h-ui.admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/*管理员-增加*/
function admin_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*管理员-删除*/
function admin_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}

/*管理员-编辑*/
function admin_edit(title,url,id,w,h,adminName){
	$.ajax({
		url:"${pageContext.request.contextPath}/AdminManage/validate",
		type:"get",
		dataType:"json",
		contenType:"apllication/json",
		data:{"adminName":adminName},
		success:function(data){
			if(data.res==1){
				layer_show(title,url,w,h);	 
			} else {
				layer.msg('只能编辑自己的账户!',{icon: 5,time:1000}); 
			}	
		},
		error:function(){
			alert('error');
		}
	});
	
	
	
	
}
/*管理员-停用*/
function admin_stop(obj,id){
	layer.confirm('确认要停用吗？',function(index){
		var adminName = $(obj).parents("tr").find(".adminName").text();
		$.ajax({
			url:"${pageContext.request.contextPath}/AdminManage/stopAdmin",
			type:"get",
			contentType:"application/json",
			dataType:"json",
			async:false,
			data:{"adminName":adminName},
			success:function(data){
				if(data.res==1){
					$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
					$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已停用</span>');
					$(obj).remove();
					layer.msg('已停用!',{icon: 5,time:1000}); 
				} else {
					layer.msg('超级管理员不能停用!',{icon: 5,time:1000}); 
				}
			},
			error:function(){
				alert('error');
			}
		});
		
	});
}

/*管理员-启用*/
function admin_start(obj,id){
	layer.confirm('确认要启用吗？',function(index){
		//此处请求后台程序，下方是成功后的前台处理……
		var adminName = $(obj).parents("tr").find(".adminName").text();
		$.ajax({
			url:"${pageContext.request.contextPath}/AdminManage/startAdmin",
			type:"get",
			contentType:"application/json",
			dataType:"json",
			data:{"adminName":adminName},
			success:function(data){
				$(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
				$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
				$(obj).remove();
				layer.msg('已启用!', {icon: 6,time:1000});
			},
			error:function(){
				alert('error');
			}
		});
		
		
	});
}
function transStatus(){ //把状态的数字改为文字
	var ele = $(".td-status");
	$.each(ele,function(index,value){
		if($(this).children().text()=="1") {	
			var tmp = $(this).children();
			$(this).prepend('<span class="label label-success radius">已启用</span>');
			tmp.remove();
			$(this).next().prepend('<a onClick="admin_stop(this,id)" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
				 
				
			} else {
		
				//$(this).children().text('已停用');
				var tmp = $(this).children();
				$(this).prepend('<span class="label label-default radius">已停用</span>');
				tmp.remove();
				$(this).next().prepend('<a onClick="admin_start(this,id)" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
			}
	});
}
function addAdmin(){
	$("#addAdmin").click(function(){
		$.ajax({
			url:"${pageContext.request.contextPath}/AdminManage/validate",
			type:"get",
			dataType:"json",
			data:{},
			success:function(data){
				
				if(data.res==1){
					//alert('超管');
					admin_add('添加管理员','${pageContext.request.contextPath}/AdminManage/admin-add','800','500');
				} else {
					layer.msg('您没有添加管理员的权限!', {icon: 5,time:1000});
				}
			},
			error:function(){
				alert('error');
			}
		});
	});
}
$(document).ready(function(){
	transStatus();
	addAdmin();
}); 
</script>
</body>
</html>