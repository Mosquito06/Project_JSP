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
	href="${pageContext.request.contextPath }/css/common/common.css?ver=2">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminpage/adminUser.css?var=2">
	<link rel="stylesheet" type="text/css" href="css/reservation/jsCalendar.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/adminpage/admin.js?v=12"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/adminpage/admin_reserve.js?v=1"></script>
<script type="text/javascript" src="js/reservation/jsCalendar.js"></script>
<script type="text/javascript" src="js/reservation/jsCalendar.lang.de.js"></script>

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
					<div id="wrap_">
						<div id="start-calendar"></div>
						<div id="end-calendar"></div>
						
						<c:if test="${set == 1}">
							<script type="text/javascript">
								$(function(){
									$("#search_user").css("display","none");
									$("#search_date").css("display","block");
									$(".search_type").eq(0).attr("checked","checked");
									$("#set_type").val("1");
								})
							</script>
						</c:if>
						<c:if test="${set == 2}">
							<script type="text/javascript">
								$(function(){
									$("#search_date").css("display","none");
									$("#search_user").css("display","block");
									$(".search_type").eq(1).attr("checked","checked");
									$("#id").val("${id}");
									$("#set_type").val("2");
								})								
							</script>
						</c:if>
						
						<input type="radio" name="search_type" class="search_type" value="1" checked="checked">날짜검색
						<input type="radio" name="search_type" class="search_type" value="2">회원검색
						
						<div id="wrap_form">
							<form method="post" action="adminReservation.do" id="form">
								<input type="hidden" name="set" id="set_type">
									<div id="search_date">
										<label>검색날짜</label>
										<c:if test="${sDay !=null && eDay !=null}">
											<input type="text" id="sDay" class="date" name="sDay" value="${sDay}">~
											<input type="text" id="eDay" class="date" name="eDay" value="${eDay}">
										</c:if>
										<c:if test="${sDay ==null}">
											<input type="text" id="sDay" class="date" name="sDay" >~
											<input type="text" id="eDay" class="date" name="eDay" >
										</c:if>
										
										<input type="submit" value="검색" class="submit">
									</div>
									
									<div id="search_user">
										<label>회원아이디</label>
										
										<input type="text"  name="id" id="id">
										<input type="submit" value="검색" class="submit">
									</div>
							</form>
						</div>
						<div id="wrap_admin_btn">
							<a href="adminReservation.do?set=0" class="btn_admin">전체보기</a>
							<a href="adminReservation.do?set=1" class="btn_admin">예약현황보기</a>
							<a href="adminReservation.do?set=2" class="btn_admin">예약완료보기</a>
							<a href="adminReservation.do?set=3" class="btn_admin">예약취소보기</a>
							<a href="adminReservation.do?set=4" class="btn_admin">오늘체크아웃보기</a>
							<a href="" class="btn_admin" id="del_list">삭제</a>
						</div>
						
						<table id="t1">
							<tr>
								<th></th>
								<th>예약번호</th>
								<th>고객번호</th>
								<th>호수</th>
								<th>체크인</th>
								<th>체크아웃</th>
								<th>최종가격</th>
								<th>투숙인원</th>
								<th>옵션내용</th>
								<th>결제날짜</th>
								<th>대여상태</th>
								<th>고객요청</th>
							</tr>
							<c:if test="${reserve.size() == 0 || reserve == null}">
								<tr><th colspan="12" id="noClick"><b>조건에 맞는 예약현황이 없습니다.</b></th></tr>
							</c:if>
							<c:forEach items="${reserve}" var="item">
								<tr>
									<td class="check"><input type="checkbox" value="${item.reservationNum}"></td>
									<td class="reserve_num">${item.reservationNum}</td>
									<td>${item.clientNum.clientNum}</td>
									<td>${item.roomNum.roomNum}</td>
									<td><fmt:formatDate value="${item.checkIn}" pattern="yyyy.MM.dd"/></td>
									<td><fmt:formatDate value="${item.checkOut}" pattern="yyyy.MM.dd"/></td>
									<td>${item.totalPrice}</td>
									<td>${item.personnel}</td>
									<td>${item.option}</td>
									<td><fmt:formatDate value="${item.payDate}" pattern="yyyy.MM.dd"/></td>
									<td>
										<c:if test="${item.state == 'COMPLETE'}">
											완료
										</c:if>
										<c:if test="${item.state == 'CANCEL'}">
											취소
										</c:if>
										<c:if test="${item.state == 'RESERVE'}">
											예약
										</c:if>
									
									</td>
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