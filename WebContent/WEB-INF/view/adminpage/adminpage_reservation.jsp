<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminpage/adminUser.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
</head>
<body>
	<div> 
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp" />
		</header>

		<section>
			<div id="contentWrap">
				<jsp:include page="admin_leftMenu.jsp" />
				<div id="rightArea">
					<div id="wrap_title">
						<h1 id="title">예약관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">예약관리</span>
						</div>
					</div>
					<div>
						<table>
							<tr>
								<th>예약번호</th>
								<th>고객번호</th>
								<th>호수</th>
								<th>체크인</th>
								<th>체크아웃</th>
								<th>최종가격</th>
								<th>투숙인원</th>
								<th>옵션가격</th>
								<th>결제날짜</th>
								<th>대여상태</th>
								<th>고객요청</th>
							</tr>
							<c:forEach items="${reserve}" var="item">
								<tr>
									<td>${item.reservationNum}</td>
									<td>${item.clientNum.clientNum}</td>
									<td>${item.roomNum.roomNum}</td>
									<td><fmt:formatDate value="${item.checkIn}" pattern="yyyy.MM.dd"/></td>
									<td><fmt:formatDate value="${item.checkOut}" pattern="yyyy.MM.dd"/></td>
									<td>${item.totalPrice}</td>
									<td>${item.personnel}</td>
									<td>${item.optionPrice}</td>
									<td><fmt:formatDate value="${item.payDate}" pattern="yyyy.MM.dd"/></td>
									<td>${item.state}</td>
									<td>
										<c:if test="${item.clientReq !=null}">
											O
										</c:if>
										<c:if test="${item.clientReq ==''}">
											X
										</c:if>
									
									</td>
								</tr>
							</c:forEach>
						</table>
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