<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/reservation/Loading.css">
<link rel="stylesheet" type="text/css" href="css/reservation/step2.css?a=d">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/common/common.js"></script>
<script type="text/javascript" src="js/reservation/Loading.js"></script>
</head>
<body>
	<div id="container">
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp" />
		</header>
		<section>
			<div id="main">
				<table id="resultTable">
					<tr>
						<th>STEP1 날짜/인원/객실 선택 <img src="/Project_JSP/img/reservation/BtnNext.gif"></th>
						<th>STEP2 옵션 선택 <img src="/Project_JSP/img/reservation/BtnNext.gif"></th>
						<th class="noSelect">STEP3 고객 정보 입력 <img src="/Project_JSP/img/reservation/BtnNext(no).png"></th>
						<th class="noSelect">STEP4 예약 완료 <img src="/Project_JSP/img/reservation/BtnNext(no).png"></th>
					</tr>
				</table>
				<div id="leftDiv">
					
				</div>
				<div id="RightDiv">
					
				</div>
				
			</div>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp" />
		</footer>
	</div>
</body>
</html>