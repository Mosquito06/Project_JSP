<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입완료 ㅣThe Shilla Hotel</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/join/joinSuccess.css?v=2">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script> 
<script src="js/common/common.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp"/>
		<section>
			<div id="join_wrap">
			<div id="join_title">
				<h1>신라리워즈 가입</h1>
					<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">신라리워즈 가입</span>
					</div>	
			</div>
			
			<div id="join_title_info">
				<ul>
					<li>회원정보입력</li>
					<li>가입완료</li>
				</ul>	
			</div>
			<div id="success_info">
				<h1>감사합니다.</h1>
				<h2>${name } 님께서는 신라리워즈에 정상적으로 가입되셨습니다.</h2>
				<div id="info1">
					<span id="id_title">아이디</span> <span id="id">${id }</span><br><br><br>
					<div id="info2">
						신라리워즈의 다양한 서비스는 이메일을 통해 안내 받을수있습니다.<br>
						로그인 하신 후 다양한 혜택과 서비스를 경험해보시기 바랍니다.
					</div>	
				</div>
			</div>
			<div id="btn">
					<a href="login.do"><button id="login">로그인</button></a>
					<a href="index.jsp"><button id="main">메인화면</button></a>
				</div>
			</div>
		</section>
	<jsp:include page="/WEB-INF/common/footer.jsp"/>
</body>
</html>