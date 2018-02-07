<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/login/loginForm.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script> 
<script src="js/common/common.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp"/>
	<div id="loginForm_wrap">
		<div id="loginForm_title">
			<h2>로그인</h2>
		</div>
		
		<h2>신라호텔에 오신 것을 환영합니다.</h2>
		
		<fieldset>
			<form action="login.do" method="post">
				<input type="radio" name="">회원
				<input type="radio" name="">비회원
				<br>
				<input type="text" placeholder="아이디">
				<input type="password" placeholder="비밀번호">
				<input type="submit" value="로그인">
				<br>
				<a href=""><button type="button">회원가입</button></a>
				<a href=""><button type="button">아이디 찾기</button></a>
				<a href=""><button type="button">비밀번호 찾기</button></a>
			</form>
		</fieldset>
		<div id="">
			이메일, 연락처 등의 정보가 변경되면 웹 사이트(마이페이지)에서 회원정보를 수정해주시기 바랍니다.
		</div>
	</div>
	<jsp:include page="/WEB-INF/common/footer.jsp"/>
</body>
</html>