<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title>로그인 화면</title>
<style type="text/css">
	li{list-style-type: none; margin: 10px;}
</style>
</head>
<body>
	<c:choose>
	<c:when test="${empty sessionScope.loginId }">
	<form action="loginProc.do" method="post">
	<fieldset>
		<legend>로그인</legend>
		<ul>
		<li><label>아이디</label>   <input type="text" name="userId"></li>
		<li><label>비밀번호</label>   <input type="password" name="userPw"></li>
		<li><input type="submit" value="로그인"></li>
		<li><a href="${pageContext.request.contextPath}">메인페이지</a></li>
		</ul>
	</fieldset>
	</form>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("이미 로그인 된 사용자 입니다.");
			location.href='${pageContext.request.contextPath}';
		</script>
	</c:otherwise>
	</c:choose>
</body>
</html>