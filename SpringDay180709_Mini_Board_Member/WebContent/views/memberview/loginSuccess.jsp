<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title>로그인 성공 페이지</title>
</head>
<body>
	<c:set var="nick" value="${nick }"/>
	<h2>로그인이 완료되었습니다.</h2>
	${nick }님 환영 합니다.<br>
	<a href="loginForm.do">로그인 페이지</a><br>
	<a href="boardList.do">게시판</a>
</body>
</html>