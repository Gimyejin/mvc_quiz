<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp</h1>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:set var="contextPath" value="${pageContext.request.contextPath }" />
	1.<img alt="a" src="<c:url value='/resources/ing.png'/>" width="100px"	height="100px">
	2.<img alt="a" src="${contextPath }/resources/ing.png" width="100px"	height="100px">
	3.<img src="/member/resources/ing.png" width="100px" height="100px">
	<hr>
	4.<img src="/member/resources/test/ing.png"width="100px"height="100px">
	5.<img src="/member/test/event.png"width="100px"height="100px">
	<hr>
	<form action="result">
		<input type="text" name="id"><br> <input type="submit"
			value="전송">
	</form>
</body>
</html>