<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title>회원가입 입력 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="views/js/joinCheck.js"></script>
</head>
<body>
	<div align="center">
	<form action="joinProc.do" method="post">
		<fieldset>
			<legend>회원가입 양식</legend>
			<label>아이디 : </label><input type="text" name="memberId" onkeyup="idDuplicate()"><br>
			<button id="idCheck">아이디 중복체크</button>
			<div id="idCheckResult"></div>
			<label>패스워드 : </label><input type="password" name="memberPw"><br>
			<label>패스워드 확인 : </label><input type="password" name="memberPwre" onkeyup="pwCheck()"><br>
			<div id="pwCheckResult"></div>
			<label>이름 : </label><input type="text" name="memberName"><br>
			<label>닉네임 : </label><input type="text" name="memberNick" onkeyup="nickDuplicate()"><br>
			<button id="nickCheck">닉네임 중복체크</button>
			<div id="nickCheckResult"></div>
			<input type="submit" value="회원가입">
		</fieldset>
	</form>
	</div>
</body>
</html>