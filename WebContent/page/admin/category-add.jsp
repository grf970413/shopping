<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">

<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/admin/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/admin/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/admin/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/admin/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/admin/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/page/admin/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<title>添加产品分类</title>
</head>
<body>
<div class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-user-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">
				<span class="c-red">*</span>
				分类名称</label>
			<div class="formControls col-xs-6 col-sm-6">
				<input type="text" class="input-text" value="" placeholder="" id="user-name" name="product-category-name">
			</div>
		</div>
	<!-- 	<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">备注:</label>
			<div class="formControls col-xs-6 col-sm-6">
				<textarea name="" cols="" rows="" class="textarea"  placeholder="说点什么..." onKeyUp="$.Huitextarealength(this,100)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/100</p>
			</div>
		</div>
		 -->
		<div class="row cl">
			<div class="col-9 col-offset-2">
				<input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;添加&nbsp;&nbsp;">
				<input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;删除&nbsp;&nbsp;">
				
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script> 
<script type="text/javascript">
$(function(){
	
});
</script>
</body>
</html>