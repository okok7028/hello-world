<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset=UTF-8">
<title>글 작성 완료</title>
</head>
<body>
	<h2 align="center">게시글 작성이 완료되었습니다.</h2>
	<div align="center">
		<table border="1">
			<tr>
				<td width="100">글번호</td>
				<td width="100">${resultBoard.boardNum }</td>
				<td width="100">작성자</td>
				<td width="100">${resultBoard.writer }</td>
			</tr>
			<tr>
				<td width="100">제목</td>
				<td colspan="3">${resultBoard.title }</td>
			</tr>
			<tr>
				<td width="100">글내용</td>
				<td colspan="3">${resultBoard.content }</td>
			</tr>
		</table>
	</div>
	<div align="center">
		<a href="boardList.do">[목록으로]</a>
	</div>
</body>
</html>