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
							<c:forEach items="${client}" var="item">
								<tr>
									<td>${item.clientNum}</td>
									<td>${item.id}</td>
									<td>${item.nameKo}</td>
									<td>${item.nameEn}</td>
									<td>${item.birth}</td>
									<td>${item.email}</td>
									<td>${item.phone}</td>
									<td>${item.home}</td>
									<td>${item.address}</td>
									<td>${item.clientGrade}</td>
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