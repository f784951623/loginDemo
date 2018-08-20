<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

					<h1>
						用戶列表
					</h1>
					<table class="table">
						
					</table>
					<a href="${pageContext.request.contextPath}/index.do">返回登入頁面</a>
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(function(){
	getAllUser();
});


function getAllUser(){
	$.ajax({
		url : "${pageContext.request.contextPath}/getUserList.do",
		data : "",
		type : "get",
		dateType : "json",
		success : function(obj) {
			var title='<tr><td>ID</td><td>用戶名</td><td>密碼</td></tr>';
				$(".table").html(title);
			for(i=0;i<obj.data.length;i++){
				var str ='<tr><td>'+
						 obj.data[i].id+
						 '</td><td>'+
						 obj.data[i].username+
						 '</td><td>'+
						 obj.data[i].password+
						 '</td></tr>';
				$(".table").append(str);
			}
			
		}
	});
}
</script>
</body>
</html>