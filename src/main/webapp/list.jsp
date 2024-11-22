<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  JSTL을 사용하기 위한 선언문 -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>목록보기</h2>
	<a href="write.do">쓰기</a>
	<ol>
	<c:forEach items="${ oneList }" var="row">
		<li>${ row.subject }
			<a href="delete.do?subject=${ row.subject }">[삭제]</a>
			<a href="edit.do?subject=${ row.subject }">[수정]</a>
			
		</li>
	</c:forEach>
	</ol>
</body>
</html>