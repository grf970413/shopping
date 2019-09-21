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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/jquery.sPage.css">

<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/page/admin/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<style type="text/css">
.w1200{width: 1200px; margin:0 auto;}
.commod-cont-wrap{background: #f8f8f8; padding: 50px 0 90px 0;}
.left-nav{width: 200px; line-height: 38px; background: #fff; float: left; margin-right: 58px;}
.left-nav .list-box{border:1px solid #eeeeee;}
.left-nav .title{color: #fff; font-size: 16px; background:#5A98DE; text-align: center;} 
.left-nav .list-box dt,.commodity-content .commod-cont .left-nav .list-box dd{border-bottom:1px dashed #eeeeee; cursor: pointer;}
.left-nav .list-box dd:hover a{color:#ff5500;}
.left-nav .list-box dt{font-size: 14px; color: #333; padding-left: 30px; background: url(${pageContext.request.contextPath}/static/image/off-icon.png) 8px -2px no-repeat; cursor: pointer;}
.left-nav .list-box dt.active{background-position: 8px -40px;}
.left-nav .list-box dd a{padding-left: 42px; color: #888888;}
.left-nav .list-box dl:last-child dd:last-child{border-bottom: 0;}
</style>
</head>
<body class="pos-r">
<div class="pos-a" style="width:200px;left:0;top:0; bottom:0; height:100%; border-right:1px solid #e5e5e5; background-color:#f5f5f5; overflow:auto;">
	<!-- <ul id="treeDemo" class="ztree"></ul>  -->
	 
	  <div class="commod-cont-wrap">
      <div class="commod-cont w1200 layui-clear">
	 <div class="left-nav">
	 <div class="title">所有分类</div>
	 <div class="list-box">
	 <c:forEach items="${typeAndSortList}" var="t">
            <dl>
             <dt>${t}</dt>
             <c:set value="${t.sortList}" var="test" />
             <c:forEach items="${test}" var="t">
            	 <dd onclick="showProduct('${t}')"><a href="javascript:;">${t}</a></dd>
            	 <!-- 这里的a标签是要跳转的页面 -->
          	 </c:forEach>
            </dl>
        </c:forEach>
     </div>
     </div>
     </div>
     </div>
</div>
<div style="margin-left:200px;">
	<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 产品管理 <span class="c-gray en">&gt;</span> 产品列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a class="btn btn-primary radius" onclick="product_add('添加产品','${pageContext.request.contextPath}/ProductManage/product-add')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加产品</a></span> </div>
		<div class="mt-20">
			<table id="table" class="table table-border table-bordered table-bg table-hover">
				<thead>
					<tr class="text-c">
						<th width="40"><input name="" type="checkbox" value=""></th>
						<th width="40">ID</th>
						<th width="60">产品图片</th>
						<th width="100">产品名称</th>
						<th>描述信息</th>
						<th width="100">单价</th>
						<th width="100">库存</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody id="tbody">
					
					
				</tbody>
			</table>
		</div>
	</div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath}/page/admin/lib/laypage/1.2/laypage.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery.sPage.js"></script>
<script type="text/javascript">
var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				//demoIframe.attr("src",treeNode.file + ".html");
				return true;
			}
		}
	}
};
var zNodes =[
	{ id:1, pId:0, name:"一级分类", open:true},
	{ id:11, pId:1, name:"二级分类"},
	{ id:12, pId:1, name:"二级分类 1-2"},
	{ id:2, pId:0, name:"二级分类", open:true},
];
$(document).ready(function(){
	
	//var t = $("#treeDemo");
	//t = $.fn.zTree.init(t, setting, zNodes); //注释掉
	
	//demoIframe = $("#testIframe");
	//demoIframe.on("load", loadReady);
	//var zTree = $.fn.zTree.getZTreeObj("tree");
	//zTree.selectNode(zTree.getNodeByParam("id",'11'));
});

$('.table-sort').dataTable({
	"aaSorting": [[ 1, "desc" ]],//默认第几个排序
	"bStateSave": true,//状态保存
	"aoColumnDefs": [
	  {"orderable":false,"aTargets":[0,7]}// 制定列不参与排序
	]
});
/*产品-添加*/
function product_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*产品-查看*/
function product_show(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*产品-编辑*/
function product_edit(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*产品-删除*/
function product_del(obj,id){
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
</script>
</body>
<script type="text/javascript">
//var currentPage = 1;
function showProduct(sortName){ //显示相应产品列表
	var pageSize = 1; //页面大小
	var currentPage = 1; //当前页
	$.ajax({
		url:"${pageContext.request.contextPath}/Paging/getProductPagingData",			
		dataType:"json",
		contentType:"application/json;charset=utf-8",
		cache:false,
		async:false,
		data:{"sortName":sortName,"pageSize":pageSize,"currentPage":currentPage},
		success:function(data){
			$("#tbody").html("");
			$("#myPage").html("");
			$.each(data.list,function(n,value){
				$("#tbody").append(
					'<tr class="text-c va-m">'+
						'<td><input name="" type="checkbox" value=""></td>'+
						'<td>'+value.id+'</td>'+
						'<td><img width="60" class="product-thumb" src="${pageContext.request.contextPath}/static/image/'+value.imageAddress+'"></a></td>'+
						'<td class="text-l">'+value.productName+'</a></td>'+
						'<td class="text-l">'+value.info+'</td>'+
						'<td><span class="price">'+value.price+'</span></td>'+
						
						'<td><span class="price">'+value.stock+'</span></td>'+
						
						'<td class="td-manage"><a style="text-decoration:none" class="ml-5" onclick=updateProduct("'+value.productName+'") href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5"  onclick=deleteProduct("'+value.productName+'") href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>'+
					'</tr>'	
				 );
			});
			$("#table").after('<div id="myPage" align="center" class="demo"></div>');
			$("#myPage").sPage({ //对分页条进行数据填充
          	    page:data.currentPage,//当前页码，必填   
                total:data.totalCount,//数据总条数，必填    //后台拿
	            pageSize:pageSize,//每页显示多少条数据，默认10条
	            showTotal:true,//是否显示总条数，默认关闭：false
                totalTxt:'共'+data.totalCount+'条',//数据总条数文字描述，{total}为占位符，默认"共{total}条"
	            showSkip:true,//是否显示跳页，默认关闭：false
	            showPN:true,//是否显示上下翻页，默认开启：true
	            prevPage:"上一页",//上翻页文字描述，默认“上一页”
	            nextPage:"下一页",//下翻页文字描述，默认“下一页”
                backFun:function(page){
                	///////////////////
                	currentPage = page;
                	$.ajax({
						url:"${pageContext.request.contextPath}/Paging/getProductPagingData",			
						dataType:"json",
						contentType:"application/json;charset=utf-8",
						cache:false,
						async:false,
						data:{"sortName":sortName,"pageSize":pageSize,"currentPage":page},
						success:function(data){
							$("#tbody").html("");
							
							$.each(data.list,function(n,value){
								$("#tbody").append(
										'<tr class="text-c va-m">'+
											'<td><input name="" type="checkbox" value=""></td>'+
											'<td>'+value.id+'</td>'+
											'<td><img width="60" class="product-thumb" src="${pageContext.request.contextPath}/static/image/'+value.imageAddress+'"></a></td>'+
											'<td class="text-l">'+value.productName+'</a></td>'+
											'<td class="text-l">'+value.info+'</td>'+ 	
											'<td><span class="price">'+value.price+'</span></td>'+
											'<td><span class="price">'+value.stock+'</span></td>'+
											'<td class="td-manage"><a style="text-decoration:none" class="ml-5" onclick=updateProduct("'+value.productName+'") title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5"  onclick=deleteProduct("'+value.productName+'") href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>'+
										'</tr>'	
								);
							});
						},
						error:function(){
							alert("error");
						}
                	});
                }
        });
		},
		error:function() {
			alert("error");
		}
	});
}
function updateProduct(productName){ //更新产品信息
	window.location.href="${pageContext.request.contextPath}/ProductManage/product-update?productName="+productName+"&currentPage="+"1";
}

function typeListInit(){
	$(".list-box dl dt").each(function(){
		$(this).addClass('active').siblings('dd').hide();
	    $(this).attr('off',true);
	});
	$('.list-box dl dt').on('click',function(){
	    if($(this).attr('off')){
	      $(this).removeClass('active').siblings('dd').show();
	      $(this).attr('off','');
	    }else{
	      $(this).addClass('active').siblings('dd').hide();
	      $(this).attr('off',true);
	    }
	  });
	if("${typeName}"!="0"){
		//先回到刚才打开的列表
		var typeList = $(".list-box").find("dt");//获取所有一级分类的元素
		$.each(typeList,function(){
			if($(this).text()=="${typeName}"){
				$(this).addClass('active').siblings('dd').show();
				$(this).attr("off",false);
				//alert("${typeName}");
			}
		});
		//再回到选择的页面
		test();//改叫pageBack
	}
	
}
$(document).ready(function(){
	typeListInit();//分类列表初始化
});
function test(){ //页面返回时要还原原来的产品列表
	var sortName = "${sortName}";
	var pageSize = 1; //页面大小
	var currentPage1 = 1; //当前页 
	$.ajax({
		url:"${pageContext.request.contextPath}/Paging/getProductPagingData",			
		dataType:"json",
		contentType:"application/json;charset=utf-8",
		cache:false,
		async:false,
		data:{"sortName":sortName,"pageSize":pageSize,"currentPage":currentPage1},
		success:function(data){
			$("#tbody").html("");
			$("#myPage").html("");
			$.each(data.list,function(n,value){
				$("#tbody").append(
					'<tr class="text-c va-m">'+
						'<td><input name="" type="checkbox" value=""></td>'+
						'<td>'+value.id+'</td>'+
						'<td><img width="60" class="product-thumb" src="${pageContext.request.contextPath}/static/image/'+value.imageAddress+'"></a></td>'+
						'<td class="text-l">'+value.productName+'</a></td>'+
						'<td class="text-l">'+value.info+'</td>'+
						'<td><span class="price">'+value.price+'</span></td>'+
						'<td><span class="price">'+value.stock+'</span></td>'+
						'<td class="td-manage"><a style="text-decoration:none" class="ml-5" onclick=updateProduct("'+value.productName+'") href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5"   onclick=deleteProduct("'+value.productName+'") href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>'+
					'</tr>'	
				 );
			});
			$("#table").after('<div id="myPage" align="center" class="demo"></div>');
			$("#myPage").sPage({ //对分页条进行数据填充
          	    page:data.currentPage,//当前页码，必填   
                total:data.totalCount,//数据总条数，必填    //后台拿
	            pageSize:pageSize,//每页显示多少条数据，默认10条
	            showTotal:true,//是否显示总条数，默认关闭：false
                totalTxt:'共'+data.totalCount+'条',//数据总条数文字描述，{total}为占位符，默认"共{total}条"
	            showSkip:true,//是否显示跳页，默认关闭：false
	            showPN:true,//是否显示上下翻页，默认开启：true
	            prevPage:"上一页",//上翻页文字描述，默认“上一页”
	            nextPage:"下一页",//下翻页文字描述，默认“下一页”
                backFun:function(page){
                	currentPage1 = page;
                	$.ajax({
						url:"${pageContext.request.contextPath}/Paging/getProductPagingData",			
						dataType:"json",
						contentType:"application/json;charset=utf-8",
						cache:false,
						async:false,
						data:{"sortName":sortName,"pageSize":pageSize,"currentPage":page},
						success:function(data){
							$("#tbody").html("");
							
							$.each(data.list,function(n,value){
								$("#tbody").append(
										'<tr class="text-c va-m">'+
											'<td><input name="" type="checkbox" value=""></td>'+
											'<td>'+value.id+'</td>'+
											'<td><img width="60" class="product-thumb" src="${pageContext.request.contextPath}/static/image/'+value.imageAddress+'"></a></td>'+
											'<td class="text-l">'+value.productName+'</a></td>'+
											'<td class="text-l">'+value.info+'</td>'+ 	
											'<td><span class="price">'+value.price+'</span></td>'+
											'<td><span class="price">'+value.stock+'</span></td>'+
											'<td class="td-manage"><a style="text-decoration:none" class="ml-5" onclick=updateProduct("'+value.productName+'") href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5"   onclick=deleteProduct("'+value.productName+'") title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>'+
										'</tr>'	
								);
							});
						},
						error:function(){
							alert("error");
						}
                	});
                }
      	  });
			
			
		},
		error:function() {
			alert("error");
		}
	});
}
function deleteByquery(){ //批量删除
	
}
function deleteProduct(productName){ //删除某个产品
	$.ajax({
		url:"${pageContext.request.contextPath}/ProductManage/delete",
		type:"get",
		dataType:"json",
		data:{"productName":productName},
		success:function(data){
			if(data.res==1){
				layer.msg('删除成功',{icon:1,time:2000});
				location.reload();
			}
		},
		error:function(){
			alert('error');
		}
	});
}

</script>
</html>