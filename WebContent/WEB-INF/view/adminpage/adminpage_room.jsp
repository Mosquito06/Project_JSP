<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminpage/adminUser.css?ver=1">
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
						<h1 id="title">객실관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">객실관리</span>
						</div>
					</div>
					<div>
						<table id="t1">
							<tr>
								<th></th>
								<th>객실정보번호</th>
								<th>룸이름</th>
								<th>등급</th>
								<th>전망타입</th>
								<th>침대타입</th>
								<th>객실크기</th>
								<th>이미지경로</th>
								<th>예약이미지경로</th>
							</tr>
							<c:forEach items="${roomInfo}" var="item">
								<tr>
									<td><input type="checkbox"></td>
									<td>${item.roomInfoNum}</td>
									<td>${item.roomInfoName}</td>
									<td>${item.roomGrade}</td>
									<td>${item.viewType}</td>
									<td>${item.bedType}</td>
									<td>${item.roomSize}</td>
									<td>${item.roomImg}</td>
									<td>${item.reservationImg}</td>
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