<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function popup(){
		console.log("cookie => ","${cook}")
		if("${cook}" == ""){
			window.open("popup","new","width=300,height=200,top=500,left=500");
		}
	}
</script>
</head>
<body onload="popup()">
	index.jsp
	<br>
	<form action="success">
		<input type="text" placeholder="id" name="id"><br> <input
			type="password" placeholder="password" name="pwd"> <input
			type="submit" value="login">
	</form>
	<a href="insert">회원가입</a>
	<a href="list">모든 회원보기</a>
</body>
</html>