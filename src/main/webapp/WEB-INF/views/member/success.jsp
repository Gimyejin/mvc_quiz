<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check(chk){
		if(chk == 0)alert('비밀번호 불일치')
		else if(chk ==-1)alert('아이디 불일치')
	}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${check.chk == 1}">
			<img src="<c:url value='/resources/coffee2.png'/>" width="100px"
				height="100px">
			<h1>${check.name }님환영합니다.</h1>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				check(${check.chk})
				location.href="index"
			</script>
		</c:otherwise>
	</c:choose>

	<a href="list">모든 회원보기</a>
</body>
</html>