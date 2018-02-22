<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약확인/취소</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css?d=s">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/mypage/leftMenu.css?v=2d">
<link rel="stylesheet" type="text/css" href="css/mypage/myReservation.css?v=ddd">
<link rel="stylesheet" type="text/css" href="css/reservation/jsCalendar.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/common/common.js"></script>
<script type="text/javascript" src="js/mypage/myReservation.js?a=dd"></script>
<script type="text/javascript" src="js/reservation/jsCalendar.js"></script>
<script type="text/javascript" src="js/reservation/jsCalendar.lang.de.js"></script>

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
						
						<div id="reservationTableDiv">
							<div>
								<img src="/Project_JSP/img/mypage/dateSearchText2.gif">
							</div>
							<div id="TotalDiv">
								<c:choose>
									<c:when test="${result == 'Empty'}">
										Total : 0	
									</c:when>
									<c:otherwise>
										Total : ${result.size() }
									</c:otherwise>
								</c:choose>
							</div>
							<div id="TableDiv">
								<table>
									<tr>
										<th>예약번호</th>
										<th>호텔</th>
										<th>객실</th>
										<th>체크인</th>
										<th>체크아웃</th>
										<th>예약상태</th>		
									</tr>
									<c:choose>
										<c:when test="${result == 'Empty'}">
											<tr class="emptyTr">
												<td colspan="6">자료가 없습니다.</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="reserv" items="${result }">
												<tr class="reservationTr">
													<td>${reserv.reservationNum } </td>
													<td>대구신라호텔</td>
													<td>[${reserv.roomNum.roomInfoNum.roomGrade }] ${reserv.roomNum.roomInfoNum.roomInfoName }</td>
													<td><fmt:formatDate value="${reserv.checkIn }" pattern="yyyy.MM.dd"/></td>
													<td><fmt:formatDate value="${reserv.checkOut }" pattern="yyyy.MM.dd"/></td>
													<td>
														<c:choose>
															<c:when test="${reserv.state == 'RESERVE' }">
																예약
															</c:when>
															<c:when test="${reserv.state == 'CANCEL' }">
																취소
															</c:when>
															<c:otherwise>
																완료
															</c:otherwise>		
														</c:choose>
													</td>
												</tr>
												<tr class="roomInfo${reserv.reservationNum }">
													<th>투숙인원</th>
													<td colspan='2'>${reserv.personnel }</td>
													<th>침대타입/전망</th>
													<td colspan='2'>${reserv.roomNum.roomInfoNum.bedType} / ${reserv.roomNum.roomInfoNum.viewType}</td>
												</tr>
												<tr class="roomInfo${reserv.reservationNum }">
													<th>요구사항</th>
													<td colspan='2'>${reserv.clientReq }</td>
													<th>선택옵션</th>
													<td colspan='2'>${reserv.option}</td>
												</tr>
												<tr class="roomInfo${reserv.reservationNum }">
													<th>예약일</th>
													<td colspan='2'><fmt:formatDate value="${reserv.payDate }" pattern="yyyy.MM.dd"/></td>
													<th>최종가격</th>
													<td colspan='2'>${reserv.totalPrice}</td>
												</tr>
												<tr class="roomInfo${reserv.reservationNum }">
													<td colspan='6'>
													<img src='/Project_JSP/img/mypage/btnConfirm.gif'> 
													<c:if test="${reserv.state != 'CANCEL' }">
														<img src='/Project_JSP/img/mypage/btnCancel.png'>
													</c:if>
													</td>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
																
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="start-calendar"></div>
			<div id="end-calendar"></div>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp" />
		</footer>
	</div>
</body>
</html>