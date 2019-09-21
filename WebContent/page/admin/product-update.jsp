<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<link href="${pageContext.request.contextPath}/page/admin/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<script src="/shoppingmall/static/lib/layer/2.4/layer.js"></script>
</head>
<body>
<div class="page-container">
	<form action="" method="post" class="form form-horizontal" id="form-article-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>产品名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${productName}" placeholder="" id="productName" name="">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>一级分类：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select id="typeName" name="" class="select" onchange="select()">
						<option value="0">--请选择--</option>
						<c:forEach items="${typeList}" var="type" varStatus="sta">
							<option value="${sta.index+1}">${type}</option>
						</c:forEach>
					</select>
				</span> 
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>二级分类：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select id="sortName" name="" class="select">
						<option value="0">--请选择--</option>
					
					</select>
				</span> 
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="" id="price" placeholder="" value="${price}" class="input-text" style="width:90%">
				元</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">库存：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" name="" id="stock" placeholder="" value="${stock}" class="input-text">
			</div>
		</div>
		
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">产品摘要：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea id="info" name="" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符">${info}</textarea>
				
			</div>
		</div>
	
		
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button id="save" class="btn btn-primary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
				<button id="closeBtn" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript">
$(document).ready(function(){
	
	closeWindow();
	$("#typeName").val("${typeId}");//循序不能乱
	select(); //循序不能乱
	save();
});


function select(){ 
	$.ajax({
		type:"get",
		url:"${pageContext.request.contextPath}/ProductManage/getSortListByTypeName",
		dataType:"json",
		contentType:"application/json",
		data:{"typeName":$("#typeName option:selected").text()},
		success:function(data){
			if(data==""){
				$("#sortName").html("");
				$("#sortName").append(
						'<option value="0">--暂无数据--</option>'		
				);	
			} else {
				$("#sortName").html("");
				$("#sortName").append(
						'<option value="0">--请选择--</option>'		
				);
				$.each(data,function(value,sortName){
					var tmp = value+1;
					$("#sortName").append(
						'<option value='+tmp+'>'+sortName+'</option>'		
					);	
				});
				//选中第二分类
				$("#sortName").val("${sortId}");
			}
			
		},
		error:function(){
			alert('error');	
		}
	});
}

function closeWindow(){  //取消按钮事件
	var typeName = "${typeName}"; 
	
	$("#closeBtn").click(function(){
		window.location.href="${pageContext.request.contextPath}/ProductManage/product-manage?typeName=${typeName}&currentPage=${currentPage}&productName=${productName}";
	});
}
function save(){//保存按钮
	//alert($("#sortName").val());
	$("#save").click(function(){
		if ($("#sortName option:selected").val()==0) {
			layer.msg('请选择分类',{icon:5,time:2000});
		} else {
			$.ajax({
				url:"${pageContext.request.contextPath}/ProductManage/update",
				type:"get",
				dataType:"json",
				async:false,	
				contentType:"application/json",
				data:{"productName":$("#productName").val(),"price":$("#price").val(),"typeName":$("#typeName option:selected").text(),"sortName":$("#sortName option:selected").text(),"refPrice":$("#refPrice").val(),"stock":$("#stock").val(),"info":$("#info").val()},
				success:function(data){
					if(data.res==1){
						
						layer.msg('修改成功',{icon:1,time:2000});
						$("#closeBtn").trigger('click');
					} else {
						alert("更新失败");
					}
					
				},
				error:function(){
					alert("error");
				}
			});
		}
	});
}
</script>
</body>
</html>