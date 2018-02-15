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
	href="${pageContext.request.contextPath }/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminpage/adminUser.css?v=1">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/adminpage/admin_user.js"></script>
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
						<h1 id="title">회원관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">회원관리</span>
						</div>
					</div>
					<div id="wrap_admin_btn">
						<a href="" class="btn_admin">관리자추가</a>
						
						<a href="" class="btn_admin">블랙리스트추가</a>
						<a href="" class="btn_admin">삭제</a>
					</div>
					<div>

						<table id="t1">
							<tr>
								<th></th>
								<th>고객번호</th>
								<th>아이디</th>
								<th>성명</th>
								<th>성명(영)</th>
								<th>생년월일</th>
								<th>이메일</th>
								<th>휴대전화</th>
								<th>자택전화</th>
								<th>주소</th>
								<th>등급</th>
							</tr>
							<c:forEach items="${client}" var="item">
								<tr>
									<td class="check"><input type="checkbox"></td>
									<td class="client_num">${item.clientNum}</td>
									<td>${item.id}</td>
									<td>${item.nameKo}</td>
									<td>${item.nameEn}</td>
									<td><fmt:formatDate value="${item.birth}" pattern="yyyy.MM.dd"/></td>
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