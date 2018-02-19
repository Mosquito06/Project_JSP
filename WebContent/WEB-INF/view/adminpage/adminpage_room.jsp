<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/adminpage/adminpage_room.css?v=ddd">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="js/adminpage/adminpage_room.js?a=dd"></script>

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
						<h1 id="title">객실관리</h1>
						<div id="wrap_home">
							<img src="/Project_JSP/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">객실관리</span>
						</div>
					</div>
					
					<div id="adminRoomTextDiv">
						<img src="/Project_JSP/img/adminpage/adminRoomText.png">
					</div>
					
					<div id="adminRoomMainDiv">
						<div id="adminRoomBtnDiv">
							<img src="/Project_JSP/img/adminpage/SearchText.png">
							<select id="roomGradeSelect">
								<option>선택하세요.</option>
								<option>STANDARD</option>
								<option>PREMIER</option>
								<option>SUITE</option>
							</select>
							<select id="roomNameSelect">
								<option>선택하세요.</option>
							</select>
						</div>
						
						<div id="adminRoomTableDiv">
							<div>
								<img src="/Project_JSP/img/adminpage/adminRoomText2.png"> 
								<img src="/Project_JSP/img/adminpage/registerBtn.png">
							</div>
							<div id="TotalDiv">
								Total : 0	
							</div>
							<div id="TableDiv">
								<table>
									<tr>
										<th>객실</th>
										<th>등급</th>
										<th>객실명</th>
										<th>객실크기</th>
										<th>침대타입/전망</th>
										<th>가격(1박)</th>
									</tr>
									<tr class="emptyTr">
										<td colspan="6">객실을 추가하거나, 검색 조건을 선택하세요.</td>
									</tr>
								</table>
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