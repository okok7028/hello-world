<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h1>이곳은 우리 사이트의 메인화면입니다.</h1>
	<c:choose>
	<c:when test="${empty sessionScope.loginId }">
	<a href="loginForm.do">로그인</a><br>
	<a href="joinForm.do">회원가입</a><br>
	</c:when>
	<c:otherwise>
	<a href="logout.do">로그아웃</a><br>
	<a href="updateForm.do">회원정보수정</a><br>
	</c:otherwise>
	</c:choose>
	<a href="boardList.do">게시판</a>
	
</body>
</html>