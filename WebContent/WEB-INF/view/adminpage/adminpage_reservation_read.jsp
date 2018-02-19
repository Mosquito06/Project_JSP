<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css?ver=2">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminpage/admin_reserve_read.css?var=31">

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript">
$(function(){
	$("#del_btn").click(function(){
		var yes=confirm("정말 삭제 하시겠습니까?");
		if(!yes){
			return false;
		}
	})
})
</script>
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
							<img
								src="${pageContext.request.contextPath}/img/common/locaton.gif"
								id="home"> > <span id="board">관리자</span> > <span
								id="board">예약관리</span>
						</div>
					</div>
					
					<div id="wrap_table">
						<table id="t1">
							<caption>예약정보</caption>
							<tr>
								<th>예약번호</th>
								<td>${reservation.reservationNum}</td>
							</tr>
							<tr>
								<th>호수</th>
								<td>${reservation.roomNum.roomNum}</td>
							</tr>
							<tr>
								<th>고객번호</th>
								<td>${reservation.clientNum.clientNum}</td>
							</tr><tr>
								<th>체크인</th>
								<td>
									<fmt:formatDate value="${reservation.checkIn}" pattern="yyyy.MM.dd"/>
								</td>
							</tr>
							<tr>
								<th>체크아웃</th>
								<td>
									<fmt:formatDate value="${reservation.checkOut}" pattern="yyyy.MM.dd"/>
								</td>
							</tr>
							<tr>
								<th>인원</th>
								<td>${reservation.personnel}</td>
							</tr>
							<tr>
								<th>결제날짜</th>
								<td>
									<fmt:formatDate value="${reservation.payDate}" pattern="yyyy.MM.dd"/>
								</td>
							</tr>
							<tr>
								<th>옵션내용</th>
								<td>${reservation.option}</td>
							</tr>
							<tr>
								<th>총 가격</th>
								<td>${reservation.totalPrice}</td>
							</tr>
							<tr>
								<th>대여상태</th>
								<td>${reservation.state}</td>
							</tr>
							<tr>
								<th>고객요청</th>
								<td>${reservation.clientReq}</td>
							</tr>
						</table>
						
						<table id="t2">
							<caption>예약자 정보</caption>
							<tr>
								<th>고객번호</th>
								<td>${client.clientNum}</td>
							</tr>
							<tr>
								<th>아이디</th>
								<td>${client.id}</td>
							</tr>
							<tr>
								<th>성명</th>
								<td>${client.nameKo}</td>
							</tr>
							<tr>
								<th>성명(영)</th>
								<td>${client.nameEn}</td>
							</tr>
							
							<tr>
								<th>생년월일</th>
								<td><fmt:formatDate value="${client.birth}" pattern="yyyy.MM.dd"/></td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>${client.email}</td>
							</tr>
							
							<tr>
								<th>휴대전화</th>
								<td>${client.phone}</td>
							</tr>
							<tr>
								<th>자택전화</th>
								<td>${client.home}</td>
							</tr>
							
							<tr>
								<th>주소</th>
								<td>${client.address}</td>
							</tr>
							<tr>
								<th>등급</th>
								<td>${client.clientGrade}</td>
							</tr>
						</table>
					</div>
					<div id="wrap_admin_btn">
						<a href="adminReservation.do?set=0" class="admin_btn">돌아가기</a>
						<a href="adminReserveDelete.do?set=1&num=${reservation.reservationNum}" class="admin_btn" id="del_btn">삭제</a>
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