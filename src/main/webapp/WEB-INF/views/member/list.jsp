<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<caption>list</caption>
		<tr>
			<th>id</th>
			<th>password</th>
			<th>name</th>
		</tr>
		<c:choose>
			<c:when test="${list.size() != 0 }">
				<c:forEach var="dto" items="${list }">
					<tr>
						<td>${dto.id }</td><!-- ${list[0].id}해도 됨 -->
						<td>${dto.pwd }</td>
						<td><a href="memberPage?id=${dto.id}&pwd=${dto.pwd }&name=${dto.name }">${dto.name }</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<th colspan="3">데이터 없음</th>
				</tr>

			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="3"><a href="${contextPath }/index">index 이동</a></td>
		</tr>
	</table>
</body>
</html>