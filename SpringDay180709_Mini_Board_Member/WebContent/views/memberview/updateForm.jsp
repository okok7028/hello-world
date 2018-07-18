<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title>회원정보 수정</title>
</head>
<body>
	<form action="updateProc.do" method="post">
		<fieldset>
			<legend>회원정보 수정</legend>
			<label>아이디 : </label>${id }<input type="hidden" name="memberId" value="${id }"><br>
			<label>변경할 패스워드 : </label><input type="password" name="memberPw"><br>
			<label>기존 패스워드 : </label><input type="password" name="memberPw2"><br>
			<label>이름 : </label><input type="text" name="memberName" value="${name }"><br>
			<label>닉네임 : </label><input type="text" name="memberNick" value="${nick }"><br>
			<input type="submit" value="정보수정">
		</fieldset>
	</form>
</body>
</html>