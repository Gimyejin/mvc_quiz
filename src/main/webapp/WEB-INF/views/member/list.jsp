<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<c:when test="${list != null }">
				<c:forEach var="dto" items="${list }">
					<tr>
						<td>${dto.id }</td>
						<td>${dto.pwd }</td>
						<td>${dto.name }</td>
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
			<td colspan="3"><a href="index">index 이동</a></td>
		</tr>
	</table>
</body>
</html>