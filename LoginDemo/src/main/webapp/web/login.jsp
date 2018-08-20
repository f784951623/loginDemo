<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>登入測試</h1>
	<form action="../login.do" method="post">
		用戶帳號:
		<input type="text" name="username" id="username">帳號若不存在，按下登錄按鈕後會顯示帳號不存在<br>
		用戶密碼:
		<input type="password" name="password" id="password">密碼若不匹配，按下登錄按鈕後會顯示密碼錯誤<br>
		<input class="button_login" type="button" value="登錄" id="bt-login"/>
	</form>
	<div id="showResult"></div>
	
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    $('#bt-login').click(function(){
        $.ajax({
        	url:"${pageContext.request.contextPath}/login.do",
        	data:"username="+$("#username").val()+
        	      "&password="+$("#password").val(),
        	type:"post",
        	dataType:"json",
        	success:function(obj){
        		//顯示錯誤信息
        		if(obj.state==0){
        			//設置錯誤信息
        			$("#showResult").html(obj.message);
        			//給錯誤信息的 文本設置為red
        			$("#showResult").css("color","red");
        		}else{
        			//清空錯誤信息
        			$("#showResult").html("");
        			//顯示首頁
        			location.href='success.do';
        		}
        	}
        });
    });
</script>
</body>
</html>