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
	href="${pageContext.request.contextPath}/css/mypage/profileUpdate.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mypage/profileUpdate.js"></script>
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
							고객님의 정보를 언제든지 확인, 변경하실 수 있습니다.
						</div>
						<div id="update_form">
							<div id="update_title">기본정보</div>
							<form action="profileUpdate.do" method="post">
								<table border="1">
									<tr class="bar">
										<th>성명(한글)</th>
										<td>${MEMBER.nameKo }</td>
									</tr>
									<tr class="bar">
										<th>성명(영문)</th>
										<td>${MEMBER.nameEn }</td>
									</tr>
									<tr class="bar">
										<th>아이디</th>
										<td>${MEMBER.id }</td>
									</tr>
									<tr class="bar">
										<th>이메일</th>
										<td>
											<input type="text" name="email1" onkeyup="this.value=this.value.replace(/[^a-zA-Z0-9]/g,'');">
											@
											<input type="text" name="email2" onkeyup="this.value=this.value.replace(/[^a-zA-Z.]/g,'');">
											<select id="e">
												<option value="">직접입력</option>
												<option value="naver.com">naver.com</option>
												<option value="hanmail.net">hanmail.net</option>
												<option value="hotmail.com">hotmail.com</option>
												<option value="nate.com">nate.com</option>
												<option value="yahoo.co.kr">yahoo.co.kr</option>
												<option value="empas.com">empas.com</option>
												<option value="dreamwiz.com">dreamwiz.com</option>
												<option value="freechal.com">freechal.com</option>
												<option value="lycos.co.kr">lycos.co.kr</option>
												<option value="korea.com">korea.com</option>
												<option value="gmail.com">gmail.com</option>
												<option value="hanmir.com">hanmir.com</option>
												<option value="paran.com">paran.com</option>
											</select>
											<a href="#" id="btnemail"><img src="${pageContext.request.contextPath}/img/join/emailConfirm.gif"></a>
											
										</td>
									</tr>
									<tr>
										<th>휴대전화</th>
										<td><input type="text" name="phone" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');"></td>
									</tr>
								</table>
								<script>
									$("input[name='phone']").val("${MEMBER.phone}");
								</script>
							</form>
							<div id="btn">
									<a href="#"><img src="${pageContext.request.contextPath}/img/mypage/btnChange.gif"></a>
									<a href="profile.do"><img src="${pageContext.request.contextPath}/img/mypage/btnCancel.gif"></a>
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