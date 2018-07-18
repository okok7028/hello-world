<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset=UTF-8">
<title>글 세부 정보</title>
</head>
<body>
	<c:choose>
	<c:when test="${empty board }">
		<script type="text/javascript">
			alert("존재하지 않는 글입니다. 목록으로 돌아갑니다.");
			location.href="boardList.do";
		</script>
	</c:when>
	<c:otherwise>
	<div align="center">
		<table border="1">
			<tr>
				<td width="100">글번호</td>
				<td width="100">${board.boardNum+1 }</td>
				<td width="100">작성자</td>
				<td width="100">${board.writer }</td>
				<td width="100">작성일시</td>
				<td width="100">${board.writedate }</td>
			</tr>
			<tr>
				<td width="100">제목</td>
				<td colspan="3">${board.title }</td>
				<td width="100">조회수</td>
				<td width="100">${board.readCount }</td>
			</tr>
			<tr>
				<td width="100">글내용</td>
				<td colspan="5">${board.content }</td>
			</tr>
		</table>
	</div>
	</c:otherwise>
	</c:choose>
	<div align="center">
		<a href="boardList.do?p=${p }">[목록으로]</a><br>
		<a href="modifyCheck.do?n=${board.boardNum }">[글수정]</a><br>
		<a href="deleteCheck.do?n=${board.boardNum }">[글삭제]</a><br>
		<a href="writeForm.do?n=${board.boardNum }">[답글]</a>
	</div>
</body>
</html>