<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>수정하기</h2>
	<!-- 
	수정의 경우 쓰기폼과 완전히 동일하므로 복사해서 사용하면 된다. 
	단 요청명과 값을 설정하기 위한 value 속성 등이 추가되어야 한다.  
	 -->
	<form action="edit.do" method="post">
		<!-- 일련번호와 같이 update 문의 조건으로 사용할 값 -->
		<input type="hid-den" name="prev_subj" value="${ oneDTO.subject }" readonly >
		
		<!-- 실제 수정을 위해 set절에 사용할 값  -->
		<input type="text" name="subject" value="${ oneDTO.subject }"/>
		<input type="submit" value="제출하기"/>
	</form>
</body>
</html>