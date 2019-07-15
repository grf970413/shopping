<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>test</title>
	<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<div id="show"></div>	
	<button id="btn">提交</button>
	<div>${productName}${m}</div>
</body>
<script>
	
	$("#btn").on('click',function(){
		$.ajax({
			url:"/shoppingmall/Test/test1",
			type:"get",
			dataType:"json",
			data:{"productName":"电视机"},
			success:function(data) {
				$("#show").text(data.id+''+data.price);
			},
			error:function(){
				alert("error");
			}
		});
		$.ajax({
			
		});
	});
</script>
</html>