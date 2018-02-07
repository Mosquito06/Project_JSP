<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/join/joinForm.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script> 
<script src="js/common/common.js"></script>
</head>
	<jsp:include page="/WEB-INF/common/header.jsp"/>
	<section>
		<div id="join_wrap">
			<div id="join_title">
				
				<h1>회원가입</h1>
				<ul>
					<li>회원정보입력</li>
					<li>가입완료</li>
				</ul>	
			</div>
			
			<div id="info_insert">
				<h1>회원정보입력</h1>
				<div>
					<h1>기본 입력</h1>
					<h1><span class="star">표시 필수입력사항</span></h1>
				</div>
			</div>
			
		</div>
	</section>
	<jsp:include page="/WEB-INF/common/footer.jsp"/>
<body>
</body>
</html>