<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 수정 | 개인정보 | MyPage | The shilla Hotel</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/leftMenu.css">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/profile.css">
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
						<h1 id="title">프로필 수정</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> >My Page> 개인정보 > <span
								id="board">프로필 수정</span>
						</div>	
					</div>
					<div id="content">
						<div id="title_info">
							 <span id="name">${MEMBER.nameEn }님</span> 의 정보를 안전하게 보호하기 위해 비밀번호를 다시 한번 확인합니다.
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