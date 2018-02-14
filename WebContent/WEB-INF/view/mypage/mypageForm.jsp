<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>신라리워즈 등급 | MyPage |The Shilla Hotel</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/leftMenu.css?v=2">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/mypageMain.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/common.js"></script>
</head>
<body>
	<div>
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp" />
		</header>

		<section>
			<div id="contentWrap">
				<jsp:include page="mypageLeftMenu.jsp" />
				<div id="rightArea">

					<div id="wrap_title">
						<h1 id="title">신라리워즈 등급</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> >My Page> <span
								id="board">신라리워즈 등급</span>
						</div>	
					</div>
					<div id="content">
						<div id="title_info">
							 <span id="name">${MEMBER.nameEn }님</span> 의 신라리워즈 등급에 대한 안내입니다.
						</div>
				 		<div id="title_info2">
							<span class="info1">신라리워즈 회원등급</span><span class="info2">SILVER</span>
							<span class="info1">신라리워즈 아이디</span><span class="info2">${MEMBER.id }</span>
						</div>
						
						<div id="card">
							<div id="card_img">
								<img src="${pageContext.request.contextPath}/img/mypage/cardImg_SILVER.png">
							</div>
							<div>
								<img src="${pageContext.request.contextPath}/img/mypage/boldCard2_SILVER.gif">
							</div>
						</div>  
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