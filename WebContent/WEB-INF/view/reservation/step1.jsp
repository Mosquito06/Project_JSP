<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STEP1 날짜&인원 선택</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/reservation/common.css?a=df">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/common/common.js"></script>
</head>
<body>
	<div>
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp" />
		</header>
		<section>
			<div id="main">
				<table>
					<tr>
						<th>STEP1 날짜/인원/객실 선택 </th>
						<th class="noSelect">STEP1 옵션 선택</th>
						<th class="noSelect">STEP2 고객 정보 입력</th>
						<th class="noSelect">STEP3 예약 완료</th>
					</tr>
					<tr>
						<td colspan="3">
							<div class="selectText">제주신라호텔</div>
							<div>
								<div class="selectText">체크인</div>
								<div class="selectDay">
									<div class="dayWrap">
										<div class="year">2018</div>
										<div class="month">02</div>
									</div>
									<div class="day">07</div>
								</div>
							</div>
							<div>
								<div class="selectText">체크아웃</div>
								<div class="selectDay">
									<div class="dayWrap">
										<div class="year">2018</div>
										<div class="month">02</div>
									</div>
									<div class="day">07</div>
								</div>
							</div>
							<div class="selectType">
								<div class="selectText">성인</div>
								<div class="selectNum">
									<div class="num">1</div>
									<img src="/Project_JSP/img/reservation/selectBtn.jpg">
								</div>
							</div>
							<div class="selectType">
								<div class="selectText">어린이</div>
								<img class="div#main table tr td" src="/Project_JSP/img/reservation/important.png">
								<div class="selectNum">
									<div class="num">1</div>
									<img src="/Project_JSP/img/reservation/selectBtn.jpg">
								</div>
							</div>
							<div class="selectType">
								<div class="selectText">유아</div>
								<img class="importantImg" src="/Project_JSP/img/reservation/important.png">
								<div class="selectNum">
									<div class="num">1</div>
									<img src="/Project_JSP/img/reservation/selectBtn.jpg">
								</div>
							</div>
						</td>
						<td id="searchBtn">
							<img src="/Project_JSP/img/reservation/searchBtn.jpg">
						</td>
					</tr>
					<tr>
						<td colspan="4" id="tdText">
							예약을 원하시면 호텔, 날짜, 인원을 선택 후 검색 버튼을 눌러주세요.
						</td>
					</tr>
				</table>
			</div>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp" />
		</footer>
	</div>
</body>
</html>