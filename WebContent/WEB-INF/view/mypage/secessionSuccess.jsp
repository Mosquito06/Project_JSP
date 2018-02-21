<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신라리워즈 탈퇴 요청 | 개인정보 | MyPage |The Shilla Hotel</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/leftMenu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/secessionSuccess.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mypage/secessionSuccess.js?v=1"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp" />
		<section>
			<div id="contentWrap">
				<jsp:include page="mypageLeftMenu.jsp" />
				<div id="rightArea">

					<div id="wrap_title">
						<h1 id="title">신라리워즈 탈회 요청</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> >My Page>개인정보> <span
								id="board">신라리워즈 탈회 요청</span>
						</div>	
					</div>
					<div id="content">
						<div id="title_info">
							 탈회를 신청하시기 전에 아래의 유의사항을 한 번 더 확인해 주시기 바랍니다.
						</div>
						<div id="info">
							<p>- 개인정보보호법에 따라 고객님의 호텔 이용기록, 개인정보 및 문의내역 기록도 모두 삭제됩니다.</p>
							<p>- 고객님의 모든 데이터의 복구는 불가능 합니다.</p>
							<p>- 탈회 신청이 완료되면 즉시 홈페이지 로그인이 제한됩니다.</p>
						</div>
						<div id="btn">
						<form id="bye" action="secessionProcessing.do" method="post">
							<input type="hidden" value=${client.clientNum } name="hiddenNum">
						</form>
							<a href="#" id="btnConfirm"><img src="${pageContext.request.contextPath}/img/mypage/btn_application.gif"></a>
							<a href="mypage.do"><img src="${pageContext.request.contextPath}/img/login/popFindIdBtnCancel.gif"></a>
						</div>
					</div>
						
				</div>
			</div>
		</section>
	<jsp:include page="/WEB-INF/common/footer.jsp" />
</body>
</html>