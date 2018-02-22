<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 문의관리 | The Shilla Hotel</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminpage/admin_qna.css?v=4">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/adminpage/admin_qna.js?v=7"></script>
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
						<h1 id="title">문의관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">문의관리</span>
						</div>
					</div>
					<div>
					
					</div>
					<div id="qna_table">
					<div id="select_btn">
						<button id="incomplete">미완료내역</button>
						<button id="complete">완료내역</button>
						<button id="total_btn">전체보기</button>
						<div id="qna_select_search">
							<select id="sel_sel">
								<option value="id">아이디</option>
								<option value="name">성명</option>
							</select>
						<input type="text" id="select_basic">
						<a href="#" id="select_btn_ok"><img src="${pageContext.request.contextPath}/img/mypage/membershipBtnSch.gif"></a>
						</div>
						<p id="total">Total : ${client.size()}</p>
					</div>
					
						<table id="t1">
							<tr id="t1_title">
								<th id="t_num">문의번호</th>
								<th>아이디</th>
								<th>성명</th>
								<th id="t_title">제목</th>
								<th>휴대전화</th>
								<th>이메일</th>
								<th>작성일</th>
								<th>등급</th>
								<th>답변</th>
							</tr>
							<c:if test="${client.size() >0 }">
								<c:forEach items="${client}" var="item">
								<tr  class='data'>
									<td class="hiddenNum">${item.num }</td>
									<td>${item.id }</td>
									<td>${item.name }</td>
									<td>${item.title }</td>
									<td>${item.tel }</td>
									<td>${item.email }</td>
									<fmt:formatDate value="${item.date }" pattern="yyyy-MM-dd" var="item_date"/>
									<td>${item_date }</td>
									<td>${item.clientGrade }</td>
									<c:if test="${item.content == null }">
									<td>대기중</td>
									</c:if>
									<c:if test="${item.content !=null }">
									<td>완료</td>
									</c:if>
								</tr>
							</c:forEach>
							</c:if>
							<c:if test="${client.size() == 0 }">
								<tr class="data">
									<td colspan="9">문의 내역이 없습니다.</td>
								</tr>
							</c:if>
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