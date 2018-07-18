<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset=UTF-8">
<title>글작성</title>
</head>
<body>
	<div align="center">
<%-- 	<c:choose> --%>
<%-- 	<c:when test="${empty sessionScope.loginId }"> --%>
<!-- 		<script type="text/javascript"> -->
<!-- // 			alert("글작성을 하실려면 로그인을 해야 합니다."); -->
<%-- // 			location.href='${pageContext.request.contextPath}'; --%>
<!-- 		</script> -->
<%-- 	</c:when> --%>
<%-- 	<c:otherwise> --%>
	<form action="writeProc.do" method="post">
		<input type="hidden" name="num" value="${num }">
		<input type="hidden" name="boardRef" value="${boardRef }">
		<input type="hidden" name="replySeq" value="${replySeq }">
		<input type="hidden" name="replyLevel" value="${replyLevel }">
		<input type="hidden" name="writer" value="${writer }">
		<table border="1">
			<tr>
				<td width="100">제목 : </td>
				<td width="300">
					<c:if test="${num eq 0 }">
						<input type="text" name="title" size="20">
					</c:if>
					<c:if test="${num ne 0 }">
						<input type="text" name="title" size="20" value="[답글]">
					</c:if>
				</td>
			</tr>
			<tr>
				<td>작성자 : </td>
				<td>${writer }</td>
			</tr>
			<tr>
				<td>내용 : </td>
				<td>
					<textarea rows="10" cols="20" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="4">
					<input type="submit" value="글쓰기">
				</td>
			</tr>
		</table>
	</form>
<%-- 	</c:otherwise> --%>
<%-- 	</c:choose> --%>
	</div>
</body>
</html>