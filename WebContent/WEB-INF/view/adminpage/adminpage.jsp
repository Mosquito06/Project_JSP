<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminpage/adminpage.css?v=122">
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
						<h1 id="title">관리자 모드</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span>
						</div>
					</div>
						
					<div id="wrap_admin_btn">
						<a href="${pageContext.request.contextPath}/adminUser.do" class="admin">회원관리</a>
						<a href="${pageContext.request.contextPath}/adminReservation.do?set=0" class="admin">예약관리</a>
						<a href="${pageContext.request.contextPath}/adminRoom.do" class="admin">객실관리</a>
						<a href="${pageContext.request.contextPath}/adminQnA.do" class="admin">문의관리</a>
			 			<a href="${pageContext.request.contextPath}/adminBoard.do" class="admin"><span>후기관리</span></a>  
			 			<a href="${pageContext.request.contextPath}/adminBanner.do" class="admin"><span>메인 관리</span></a>  
			 			<a href="${pageContext.request.contextPath}/event/eventlist.do" class="admin">이벤트관리</a>
			 			<a href="${pageContext.request.contextPath}/adminGallery.do" class="admin"><span>갤러리 관리</span></a>  
						
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