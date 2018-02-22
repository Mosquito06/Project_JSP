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
	href="${pageContext.request.contextPath}/css/adminpage/admin_user_read.css?var=11">
<link rel="stylesheet" type="text/css"
	href="css/reservation/jsCalendar.css">
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
	<c:if test="${error == 1}">
		<script type="text/javascript">
			alert("멤버가 아닙니다.");
		</script>
	</c:if>
	<c:if test="${error == 2}">
		<script type="text/javascript">
			alert("블랙리스트가 아닙니다.");
		</script>
	</c:if>
	<c:if test="${error == 3}">
		<script type="text/javascript">
			alert("일반회원으로 변경할 수 없습니다.");
		</script>
	</c:if>

	<div>
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp" />
		</header>

		<section>
			<div id="contentWrap">
				<jsp:include page="admin_leftMenu.jsp" />
				<div id="rightArea">
					<div id="wrap_title">
						<h1 id="title">회원관리</h1>
						<div id="wrap_home">
							<img
								src="${pageContext.request.contextPath}/img/common/locaton.gif"
								id="home"> > <span id="board">관리자</span> > <span
								id="board">회원관리</span>
						</div>
					</div>

					<div id="wrap_table">
						<table id="t1">
							<caption>회원 정보</caption>
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
								<td><fmt:formatDate value="${client.birth}"
										pattern="yyyy.MM.dd" /></td>
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
						<table id="t2">
							<caption>예약이력</caption>
							<tr>

								<th>번호</th>
								<th>호수</th>
								<th>체크인</th>
								<th>체크아웃</th>
								<th>최종가격</th>
								<th class="count">투숙인원</th>
								<th>결제날짜</th>
								<th>상태</th>
							</tr>
							<c:forEach items="${reserve}" var="item">
								<tr>

									<td class="reserve_num">${item.reservationNum}</td>

									<td>${item.roomNum.roomNum}</td>
									<td><fmt:formatDate value="${item.checkIn}"
											pattern="yyyy.MM.dd" /></td>
									<td><fmt:formatDate value="${item.checkOut}"
											pattern="yyyy.MM.dd" /></td>
									<td>${item.totalPrice}</td>
									<td class="count">${item.personnel}</td>
									<td><fmt:formatDate value="${item.payDate}"
											pattern="yyyy.MM.dd" /></td>
									<td><c:if test="${item.state == 'COMPLETE'}">
											완료
										</c:if> <c:if test="${item.state == 'CANCEL'}">
											취소
										</c:if> <c:if test="${item.state == 'RESERVE'}">
											예약
										</c:if></td>
								</tr>
							</c:forEach>
						</table>



					</div>
					<div id="wrap_admin_btn">
						<a href="adminUser.do" class="admin_btn">돌아가기</a> <a
							href="adminUserUpdate.do?set=1&num=${client.clientNum}"
							class="admin_btn">블랙리스트 추가</a> <a
							href="adminUserUpdate.do?set=2&num=${client.clientNum}"
							class="admin_btn">블랙리스트 해제</a> 
							<a href="adminUserUpdate.do?set=4&num=${client.clientNum}"
							class="admin_btn">일반회원 변경</a>
							<a href="adminUserUpdate.do?set=3&num=${client.clientNum}"
							class="admin_btn">관리자 변경</a>
							<a href="adminUserDelete.do?set=1&num=${client.clientNum}"
							class="admin_btn" id="del_btn">회원정보 삭제</a>
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