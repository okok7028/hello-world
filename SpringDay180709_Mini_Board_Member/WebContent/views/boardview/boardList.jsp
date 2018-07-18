<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta charset=UTF-8">
<title>게시판 목록화면</title>
</head>
<body>
	<div align="center">
	<table border="1">
		<tr height="30">
			<th width="100">글번호</th>
			<th width="200">제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="100">조회수</th>
		</tr>
		<c:if test="${empty boardPage.boardList }">
		<tr>
			<td colspan="5">아직 작성된 글이 없습니다.</td>
		</tr>
		</c:if>
		<c:if test="${not empty boardPage.boardList }">
			<c:set var="number" value="${boardPage.number }"/>
			<c:forEach items="${boardPage.boardList }" var="b" varStatus="i">
				<tr height="30">
					<td>${number-i.index }</td>
					<td>
					<c:if test="${b.replyLevel gt 0 }">
						<c:set var="wid" value="${b.replyLevel*5 }"/>
						<img src="views/img/level.gif" width="${wid }" height="16">
						<img src="views/img/re.gif">
					</c:if>
					<a href="read.do?n=${b.boardNum }&p=${boardPage.currentPage}">${b.title }</a>
					<c:if test="${b.readCount ge 20 }">
					<img alt="" src="views/img/hot.gif"  border="0" height="16">
					</c:if>
					</td>
					<td>${b.writer }</td>
					<td>${b.writedate }</td>
					<td>${b.readCount }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	</div>
	<div align="center">
		<c:if test="${boardPage.startPage gt 1 }">
			<a href="boardList.do?p=${boardPage.startPage-1 }">[이전]</a>
		</c:if>
		<c:forEach begin="${boardPage.startPage }" end="${boardPage.endPage }" var="i">
			<a href="boardList.do?p=${i }">[${i }]</a>
		</c:forEach>
		<c:if test="${boardPage.endPage lt boardPage.totalPageCount }">
			<a href="boardList.do?p=${boardPage.endPage+1 }">[다음]</a>
		</c:if>
	</div>
	<div align="center">
	<a href="writeForm.do"><button>글쓰기</button></a><br>
	<a href="${pageContext.request.contextPath}">메인</a>
	</div>
</body>
</html>