<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/reservation/Loading.css">
<link rel="stylesheet" type="text/css" href="css/reservation/step2.css?b=ddd">
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
					<div id="optionTextDiv">
						<span id="optionSpan1">옵션 사항</span><span id="optionSpan2">객실이용에 필요한 옵션사항을 선택하세요.</span>
					</div>
					<div id="optionDiv">
						<ul class="optionUl">
							<li class="optionLi">
								<div class="optionLiLeftDiv">
									<input type="checkbox">
									<span class="optionName">DailyExtra Bed</span><br>
									<span class="optionPrice">40,000원</span>
								</div>
								<div class="optionLiRightDiv">
									<select class="optionSelect">
										<option>0</option>
										<option>1</option>
										<option>2</option>
									</select>
									<span class="optionFinalPrice">40,000원</span>
								</div>
							</li>
							<li class="optionLi">
								<div class="optionLiLeftDiv">
									<input type="checkbox">
									<span class="optionName">Daily Breakfast for Adult</span><br>
									<span class="optionPrice">32,000원</span>
								</div>
								<div class="optionLiRightDiv">
									<select class="optionSelect">
										<option>0</option>
										<option>1</option>
										<option>2</option>
									</select>
								<span class="optionFinalPrice">32,000원</span>
								</div>
							</li>
							<li class="optionLi">
								<div class="optionLiLeftDiv">
									<input type="checkbox">
									<span class="optionName">Daily Breakfast for Adult</span><br>
									<span class="optionPrice">32,000원</span>
								</div>
								<div class="optionLiRightDiv">
									<select class="optionSelect">
									<option>0</option>
									<option>1</option>
									<option>2</option>
								</select>
								<span class="optionFinalPrice">32,000원</span>
								</div>
							</li>
							<li class="optionAlertText">
								※ 37개월 미만의 유아 동반 시 조식에 대한 요금은 무료입니다.
							</li>
						</ul>
						
						<div class="additionForm">
							<div class="formTop">
								<span class="formText">추가 요청사항</span>
								<span class="arrowSpan">
									<img src="/Project_JSP/img/reservation/upArrow.png">
								</span>
							</div>
							<div class="formBottom">
								<input type="text" placeholder="공항 교통편 문의 또는 호텔 이용 시 문의하실 사항이 있으시면 입력해 주십시오.">
								<ul class="formUl">
									<li>전망은 체크인 당일 사정에 따라 달라질 수 있습니다.</li>
									<li>전 객실은 금연실로 운영중입니다.</li>
								</ul>
							</div>
						</div>
						
						<div class="additionForm">
							<div class="formTop">
								<span class="formText">유의사항</span>
								<span class="arrowSpan">
									<img src="/Project_JSP/img/reservation/upArrow.png">
								</span>
							</div>
							<div class="formBottom">
								<ul class="formUl">
									<li>2인 1실 기준입니다.</li>
									<li>37개월 미만의 유아 동반 시 추가 인원 요금 및 조식은 무료입니다.</li>
									<li>37개월 이상 ~ 성인 동반 시 추가 요금이 적용됩니다.</li>
									<li><span class="importantText">본 홈페이지 요금은 할인 적용된 요금이며, 중복 할인은 적용되지 않습니다.</span></li>
								</ul>
								<br>
								<span class="importantText">[12/1일부터 공항 데스크 운영 종료에 따른 셔틀버스 탑승 방법 변경]</span>
								<ul class="formUl">
									<li>운행 시간 : 왕복3회 | 공항→호텔 13:30,14:30,16:30 / 호텔→공항 11:30,12:10,15:00</li>
									<li>공항→호텔 간 셔틀 버스 탑승은 사전 예약제로 운명되며, 투숙 고객에 한해 이용이 가능합니다.</li>
									<li>공항→호텔 간 셔틀 버스 탑승 사전 예약을 원하시면 '추가 요청 사항'에 탑승 시간을 기재하여 주시기 바랍니다.</li>
									<li>사전 신청이 되었더라도 출발 시간까지 미도착시 연락을 드리지 않으며, 정시에 출발합니다.</li>
									<li>공항 도착 GATE에서 탑승 장소까지 도보로 약5분 소요됩니다.</li>
								</ul>
							</div>
						</div>
						
						<div id="btnDiv">
							<div id="leftBtn">
								<img src="/Project_JSP/img/reservation/backStep1.gif">
							</div>
							<div id="rightBtns">
								<img src="/Project_JSP/img/reservation/nonUserReserv.gif">
								<img src="/Project_JSP/img/reservation/userReserv.gif">
							</div>
						</div>
						
					</div>
				</div>
				<div id="RightDiv">
					<div id="firstDiv">
						<span class="importantText">예약정보</span>
						<span id="resetSpan">
							<img src="/Project_JSP/img/reservation/refresh.gif">
							<span class="rightTextColor">예약 초기화</span>
						</span>
					</div>
					<div id="secondDiv">
						<span class="rightTextColor">호텔</span>
						<span class="importantText">제주신라호텔</span>
					</div>
					<div id="thirdDiv">
						<div>
							<span class="rightTextColor">체크인</span>
							<span class="rightText">2018.02.12</span>
						</div>
						<div>
							<span class="rightTextColor">체크아웃</span>
							<span class="rightText">2018.02.13</span>
						</div>
						<div>
							<span class="rightTextColor">숙박일수</span>
							<span class="rightText">1박</span>
						</div>
						<div>
							<span class="rightTextColor">투숙인원</span>
							<span class="rightText">성인: 1 어린이: 0 유아: 0</span>
						</div>
						<div>
							<span class="rightTextColor">객실타입</span>
							<span class="rightText">Double</span>
						</div>
					</div>
					<div id="fourthDiv">
						<span class="importantText">객실/패키지</span><br><br>
						<span class="rightText">[Suite] Corner Suite / Mountain / Double</span><br><br>
						<span class="rightText">2018.02.12</span>
						<span class="rightPrice">720,000원</span><br>
						<span class="rightPriceBold">720,000 원(1박)</span>
						<img src="/Project_JSP/img/reservation/room/(Suite)Corner Suites.jpg">
					</div>
					<div id="fiveDiv">
						<span class="importantText">옵션</span><br><br>
						<span class="rightTextColor">DailyExtra Bed</span>
							<span class="rightText">40,000</span>
					</div>
					<div id="sixDiv">
						<div>
							<span class="rightTextColor">봉사료</span>
							<span class="rightText">72,000</span>
						</div>
						<div>
							<span class="rightTextColor">세금</span>
							<span class="rightText">79,200</span>
						</div>
					</div>
					<div id="sevenDiv">
						<span class="importantText">요금합계</span>
						<span class="finalPrice">919,600 원</span>
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