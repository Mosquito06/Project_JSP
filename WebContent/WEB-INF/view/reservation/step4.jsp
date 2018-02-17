<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STEP4 완료&확인</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/reservation/Loading.css">
<link rel="stylesheet" type="text/css" href="css/reservation/step4.css?b=ddd">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/reservation/Loading.js"></script>
<script type="text/javascript" src="js/common/common.js"></script>
<script type="text/javascript" src="js/reservation/step4.js?a=dd"></script>
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
						<th>STEP3 고객 정보 입력 <img src="/Project_JSP/img/reservation/BtnNext.gif"></th>
						<th>STEP4 예약 완료 <img src="/Project_JSP/img/reservation/BtnNext.gif"></th>
					</tr>
				</table>
				
				<div id="completeFirstDiv">
					<div id="completeLeft">
						<span>고객님 감사합니다.</span><br><br><br>
						<span class="completeText">예약이 완료되었습니다.</span><br><br><br>
						<span>예약하신 내용이 예약 시 입력하신 이메일로 발송되었습니다.<br>
							예약 번호를 메모해두시면 빠르고 편리하게 예약을 확인하실 수 있습니다.<br>
							현재 미결제 상태이며, 체크인시 결제가 진행됩니다.<br>
						</span>
					</div>
					<div id="completeRight">
						<span class="complteBoldTextColor">예약번호</span>
						<span>${result.reservation.reservationNum }</span>
					</div>
					<div id="completeBottom">
						<div class="completeBottomDiv">
							<span class="complteBoldTextColor">고객명</span>
							<span>${result.client.nameKo }</span>
						</div>
						<div class="completeBottomDiv">
							<span class="complteBoldTextColor">연락처</span>
							<span>${result.client.phone }</span>
						</div>
						<div class="completeBottomDiv">
							<span class="complteBoldTextColor">이메일</span>
							<span>${result.client.email }</span>
						</div>
					</div>
				</div>
				<div id="completeMiddleDiv">
					<div class="complteMiddle">
						<span class="complteBoldText">호텔</span>
						<span class="complteBoldText">대구신라호텔</span><br><br>
						<span class="complteBoldText">날짜/투숙인원</span>
						<ul>
							<li><span class="complteTextColor">체크인
								</span><span class="completeTextTextSmall">
									<fmt:formatDate value="${result.reservation.checkIn }" pattern="yyyy.MM.dd"/>
								</span>
							</li>
							<li><span class="complteTextColor">체크아웃</span>
								<span class="completeTextTextSmall">
									<fmt:formatDate value="${result.reservation.checkOut }" pattern="yyyy.MM.dd"/>
								</span>
							</li>
							<li><span class="complteTextColor">숙박일수</span><span class="completeTextTextSmall">${result.stay }박</span></li>
							<li><span class="complteTextColor">투숙인원</span><span class="completeTextTextSmall">${result.reservation.personnel }</span></li>
						</ul>
					</div>
					<div class="complteMiddle">
						<span class="complteBoldText">객실/패키지</span>
						<ul>
							<li><span class="complteTextColor">객실</span><span class="completeTextTextSmall">${result.roomName }</span></li>
							<li><span class="complteTextColor">침대타입</span><span class="completeTextTextSmall">${result.bedType }</span></li>
							<li><span class="complteTextColor">객실요금</span><span class="completeTextTextSmall">
							<fmt:formatNumber value="${result.basicPrice }" pattern="00,000"/> 원</span></li>
						</ul>
					</div>
					<div class="complteMiddle">
						<ul>
							<li><span class="complteTextColor">봉사료</span><span class="completeTextTextSmall">
								<fmt:formatNumber value="${result.ServiceCharge }" pattern="00,000"/> 원</span></li>
							<li><span class="complteTextColor">세금</span><span class="completeTextTextSmall">
								<fmt:formatNumber value="${result.Tax }" pattern="00,000"/>
							 원</span></li>
						</ul>
						<div id="finalPrice">
							<span class="complteBoldText">요금합계</span>
							<span><fmt:formatNumber value="${result.reservation.totalPrice }" pattern="00,000"/> 원</span>
						</div>
					</div>
					<div id="completeAlertDiv">
						<ul>
							<li>※ 10% service charge and 11% Tax Included.</li>
							<li>※ 예약한 내용 확인 및 변경, 취소는 My page에서 가능합니다.</li>
							<li>※ 비회원으로 예약한 경우에는, 예약번호로 예약 내용 확인, 변경, 취소가 가능합니다.</li>
							<li>※ 현재 미결제 상태이며, 체크인시 결제가 진행됩니다.</li>
						</ul>
					</div>
				</div>
				<div id="completeBtn">
					<img src="/Project_JSP/img/reservation/confirmBtn.gif">
				</div>
				
			</div>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp" />
		</footer>
	
	</div>
</body>
</html>