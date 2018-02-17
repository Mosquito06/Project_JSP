<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약확인/취소</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css?d=s">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/mypage/leftMenu.css?v=2d">
<link rel="stylesheet" type="text/css" href="css/mypage/myReservation.css?v=2dd">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/common/common.js"></script>

</head>
<body>
	<div id="container">
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp" />
		</header>
		<section>
				<div id="contentWrap">
					<jsp:include page="mypageLeftMenu.jsp" />
					<div id="rightArea">
						<div id="wrap_title">
							<h1 id="title">예약확인/취소</h1>
							<div id="wrap_home">
								<img src="/Project_JSP/img/common/locaton.gif" id="home"> >My Page> 
									<span id="board">예약확인/취소</span>
							</div>	
						</div>
						
						<div id="reservationTextDiv">
							<img src="/Project_JSP/img/mypage/searchText.gif">
						</div>
						
						<div id="reservationMainDiv">
							<div id="reservationBtnDiv">
								<img src="/Project_JSP/img/mypage/dateSearchText.gif">
								<img src="/Project_JSP/img/mypage/allBtn.png">
								<input type="text">
								<img src="/Project_JSP/img/mypage/calenrdar.gif">
								<input type="text">
								<img src="/Project_JSP/img/mypage/calenrdar.gif">
								<img src="/Project_JSP/img/mypage/Btnsearch.gif">
							</div>
						
						</div>
						
					</div>
				</div>
				
				
		</section>
		
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp" />
		</footer>
	</div>
</body>
</html>