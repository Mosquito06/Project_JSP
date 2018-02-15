<%@page import="Project_JSP.dto.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STEP3 고객 정보 입력</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/reservation/Loading.css">
<link rel="stylesheet" type="text/css" href="css/reservation/step3.css?b=d">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/reservation/Loading.js"></script>
<script type="text/javascript" src="js/common/common.js"></script>
<script type="text/javascript" src="js/reservation/step3.js?a=ddd"></script>
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
						<th class="noSelect">STEP4 예약 완료 <img src="/Project_JSP/img/reservation/BtnNext(no).png"></th>
					</tr>
				</table>
				
				<div id="leftDiv">
					<div id="optionTextDiv">
						<span id="optionSpan1">고객 정보 입력</span><span id="optionSpan2">
						<span class="redText">*</span>표시 필수 입력사항</span>
					</div>
					<div id="optionDiv">
						
						<div id="clientInfoDiv">
							<div id="clientLeft">
								<span class="clientInfoBold">투숙자 정보 입력</span>							
								<form>
									<label for="name(kor)"><span class="redText">*</span>성명(한글)</label>
									<input type="text" id="name(kor)" name="name" value="${sessionScope.MEMBER.nameKo }"><br>
									<label for="name(eng)"><span class="redText">*</span>성명(영문)</label>
									<input type="text" id="name(eng)" name="firstName" placeholder="FIRST NAME(이름)"
									 value="${sessionScope.MEMBER.nameEn.split(' ')[0] }">
									<input type="text" name="lastName" placeholder="LAST NAME(성)"
									 value="${sessionScope.MEMBER.nameEn.split(' ')[1] }"><br>
									<label for="email"><span class="redText">*</span>이메일</label>
									<input type="text" id="email" name="email" value="${sessionScope.MEMBER.email }"><br>
									<label for="tel"><span class="redText">*</span>연락처</label>
									<select>
										<option>휴대전화</option>
										<option>자택</option>
									</select>
									<input type="number" id="tel" name="tel" value="${sessionScope.MEMBER.phone }">
								</form>
							</div>
							<div id="clientRight">
								<span class="clientInfoBold">카드 정보 입력</span><br>
								<label for="cardType"><span class="redText">*</span>카드종류</label>
								<select>
									<option>BC CARD</option>
									<option>LOTTE CARD</option>
									<option>SAMSUNG CARD</option>
									<option>SHINHAN CARD</option>
									<option>HYUBDAI CARD</option>
									<option>CITTYBANK CARD</option>
								</select><br>
								
								<label for="cardNum"><span class="redText">*</span>카드번호</label>
								<input type="number" id="cardNum"> - <input type="number" id="cardNum"> 
								- <input type="number" id="cardNum"> - <input type="number" id="cardNum"><br> 
								<label for="cardNum"><span class="redText">*</span>만기일</label>
								<select>
									<option>월</option>
									<option>01</option>
									<option>02</option>
									<option>03</option>
									<option>04</option>
									<option>05</option>
									<option>06</option>
									<option>07</option>
									<option>08</option>
									<option>09</option>
									<option>10</option>
									<option>11</option>
									<option>12</option>
								</select>
								<select>
									<option>년</option>
									<option>2028</option>
									<option>2027</option>
									<option>2026</option>
									<option>2025</option>
									<option>2024</option>
									<option>2023</option>
									<option>2022</option>
									<option>2021</option>
									<option>2020</option>
									<option>2019</option>
									<option>2018</option>
								</select>
								<div id="clientRightText">
									<span>※</span>
									 신용카드 정보는 고객님의 투숙에 의한 개런티 외에는 어떤 목적으로도 사용되지 않습니다.<br>
									본 정보는 온라인 예약 시 직접 결제가 이루어지지 않으며, 최종 결제는 체크인 시 프런트 데스크에서 해주시기 바랍니다.
								</div>
							</div>
						</div>
									
						<div class="Step3additionForm">
							<span class="importantText">예약 취소/변경 및 No-Show 안내</span><br>
							<span class="textUnderline">성수기(5월 ~ 10월, 12월 24일 ~ 31일)</span>
							<ul>
								<li>숙박 예정일 7일 전까지는 위약금 없이 취소 및 변경됩니다.</li>
								<li>숙박 예정일 6일 전 ~ 1일 전 18시까지 취소 및 변경 시, 최초 1박 요금의 20%가 위약금으로 부과됩니다.</li>
								<li>숙박 예정일 1일 전 18시 이후 취소/변경하거나 노쇼(No-Show) 시, 최초 1박 요금의 80%가 위약금으로 부과됩니다.</li>
							</ul>
							<span class="textUnderline">비수기(성수기 외 기간)</span>
							<ul>
								<li>숙박 예정일 1일 전 18시까지는 위약금 없이 취소 및 변경됩니다.</li>
								<li>숙박 예정일 1일 전 18시 이후 취소/변경하거나 노쇼(No-Show) 시, 최초 1박 요금의 10%가 위약금으로 부과됩니다.</li>
							</ul>
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
						
						<div id="agreeDiv">
							<div id="agreeText">
								필수정보 개인정보 수집이용에 동의하십니까?
							</div>
							<div id="agreeLeft">
								<div class="agreeContent">
									신라호텔 객실예약과 관련하여 귀사가 아래와 같이 본인의 개인정보를 수집 및 이용하는데 동의합니다.<br><br>
									<필수적인 개인정보의 수집 ㆍ이용에 관한 사항><br>
									① 수집 이용 항목 | 성명, 국적, 생년월일, 이메일 주소, 연락처, 예약정보, 결제정보<br>
									② 수집 이용 목적 | 호텔 예약 및 고객 응대<br>
									③ 보유 이용 기간 | 예약일 후 1년<br><br>

									※위 사항에 대한 동의를 거부할 수 있으나, 이에 대한 동의가 없을 경우 예약 서비스 제공과 관련된 제반 절차 진행이 불가능 할 수 있음을 알려드립니다.	
								</div>
								<div class="agreeRadio">
									<input type="radio" name="leftAgree"> 동의함
									<input type="radio" name="leftAgree" checked="checked"> 동의하지 않음
								</div>
							</div>
							<div id="agreeRight">
								<div class="agreeContent">
									<개인정보 제3자 제공에 대한 동의><br>
									① 제공받는 자 | (주)신라스테이<br>
									② 제공 목적 | 호텔 예약 및 고객 응대<br>
									③ 제공하는 항목 | 성명, 국적, 생년월일, 이메일 주소, 연락처, 예약정보, 결제정보<br>
									④ 제공 기간 | 예약일 후 1년간<br><br>
									
									※위 사항에 대한 동의를 거부할 수 있으나, 이에 대한 동의가 없을 경우 신라 리워즈 회원가입 및 서비스 제공이 불가능함을 알려드립니다.
								</div>
								<div class="agreeRadio">
									<input type="radio" name="rightAgree"> 동의함
									<input type="radio" name="rightAgree" checked="checked"> 동의하지 않음
								</div>
							</div>
						</div>
												
						<div id="btnDiv">
							<div id="leftBtn">
								<img src="/Project_JSP/img/reservation/backStep2.gif">
							</div>
							<div id="rightBtn">
								<img src="/Project_JSP/img/reservation/completeReserv.gif">
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
							<span class="rightText">${result.checkIn }</span>
						</div>
						<div>
							<span class="rightTextColor">체크아웃</span>
							<span class="rightText">${result.checkOut }</span>
						</div>
						<div>
							<span class="rightTextColor">숙박일수</span>
							<span class="rightText">${result.stay }박</span>
						</div>
						<div>
							<span class="rightTextColor">투숙인원</span>
							<span class="rightText">${result.stayNum }</span>
						</div>
						<div>
							<span class="rightTextColor">객실타입</span>
							<span class="rightText">${result.bedType }</span>
						</div>
					</div>
					<div id="fourthDiv">
						<span class="importantText">객실/패키지</span><br><br>
						<span class="rightText">${result.roomInfo}</span><br><br>
						<span class="rightText">${result.checkIn }</span>
						<span class="rightPrice"><span id="basicPrice">${result.basicPrice }</span> 원</span><br>
						<span class="rightPriceBold">${result.basicPrice*result.stay } 원(${result.stay }박)</span>
						<img src="${result.roomImg }">
					</div>
					<div id="fiveDiv">
						<span class="importantText">옵션</span><br><br>
						<c:if test="${result.option != 'false' }">
							<c:forEach var="item" items="${result.option }">
								<div>
									<span id="optionRightTextColor${item.optionNum }">${item.optionContent }</span>
									<span id="optionRightPrice${item.optionNum }"><span class="sumPrice">${item.optionPrice }</span>  원</span>
								</div>
							</c:forEach>
						</c:if>
					</div>
					<div id="sixDiv">
						<div>
							<span class="rightTextColor">봉사료</span>
							<span class="rightText" id="ServiceCharge"><span class="sumPrice">72000</span> 원</span>
						</div>
						<div>
							<span class="rightTextColor">세금</span>
							<span class="rightText" id="Tax"><span class="sumPrice">79200</span> 원</span>
						</div>
					</div>
					<div id="sevenDiv">
						<span class="importantText">요금합계</span>
						<span class="finalPrice" id="finalPrice">${result.finalPrice } 원</span>
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