<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>개 인 정 보</h1>
<h3>아이디: ${member.id }</h3>
<h3>패스워드: ${member.pwd }</h3>
<h3>이름: ${member.name }</h3>
<hr>
<a href="list">목록으로 이동</a>
</body>
</html>