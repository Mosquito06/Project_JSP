<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	href="${pageContext.request.contextPath}/css/mypage/secession.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mypage/secession.js"></script>
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
							 <span id="name">${MEMBER.nameEn }님</span> 의 정보를 안전하게 보호하기 위해 비밀번호를 다시 한번 확인합니다.
						</div>
						<div id="pw_confirm">
							<table border="1">
								<tr>
									<th class="id">신라리워즈 아이디</th>
									<td class="id">${MEMBER.id }</td>
								</tr>
								<tr>
									<th>비밀번호</th>
									<td>
									<form id="secessionStep1" action="secession.do" method="post">
										<input type="hidden" name="id" value=${MEMBER.id }>
										<input type="password" name="pw">
									</form>
										
									</td>
								</tr>
							</table>
							<c:if test="${error !=null }">
								<span id="err">${error }</span>
								<script>
									$("input[type='password']").focus();
								</script>
							</c:if>
						</div>
						<div id="btn">
							<a href="#" id="btnConfirm"><img src="${pageContext.request.contextPath}/img/mypage/btnConfirm.gif"></a>
						</div>
					</div>
						
				</div>
			</div>
	</section>
	<jsp:include page="/WEB-INF/common/footer.jsp" />
</body>
</html>