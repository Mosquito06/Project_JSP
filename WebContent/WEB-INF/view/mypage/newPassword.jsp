<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 | 개인정보 | MyPage |The Shilla Hotel</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/leftMenu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/newPassword.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mypage/newPassword.js"></script>
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
						<h1 id="title">비밀번호 변경</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> >My Page>개인정보> <span
								id="board">비밀번호 변경</span>
						</div>	
					</div>
					<div id="content">
						<div id="title_info">
							고객님의 정보를 언제든지 확인, 변경하실 수 있습니다.
						</div>	
						<div id="newPw">
							<table border="1">
								<tr class="bar">
									<th>현재 비밀번호</th>
									<td><input type="password" name="oldPw"></td>
								</tr>
								<tr class="bar">
									<th>새 비밀번호</th>
									<td><input type="password" name="newPw" id="newPassword"></td>
								</tr>
								<tr>
									<th>새 비밀번호 확인</th>
									<td>
										<input type="password" name="newPwConfirm" id="pwConfirm">
										<span id="error">비밀번호가 일치하지 않습니다</span>
										<span id="ok">비밀번호가 일치합니다</span>
									</td>
									
								</tr>
							</table>
						</div>
						<div id="btn">
							<a href="#"><img src="${pageContext.request.contextPath}/img/mypage/btnChange2.gif"></a>
							<a href="#" id="cancel"><img src="${pageContext.request.contextPath}/img/mypage/btnCancel.gif"></a>
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