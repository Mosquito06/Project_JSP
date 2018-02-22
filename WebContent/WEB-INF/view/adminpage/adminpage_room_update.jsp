<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css" href="css/adminpage/adminpage_room_add.css?v=ddd">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="js/adminpage/adminpage_room_update.js?a=ddd"></script>
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
						<div id="adminRoomTableDiv">
							<div>
								<img src="/Project_JSP/img/adminpage/adminRoomText2.png"> 
							</div>
							<div id="TotalDiv">

							</div>
							<div id="TableDiv">
								<form id="registerForm" action="/Project_JSP/adminRoomAdd.do" method="post" enctype="multipart/form-data">
									<table>
										<tr>
											<th>객실</th>
											<td><input type="text" name="room_num" value="${roomNum }" id="room_num" disabled="disabled"></td>
											<th>객실명</th>
											<td><input type="text" name="room_info_name" id="room_info_name" value="${roomInfoName }"></td>
											<th>객실크기</th>
											<td><input type="text" name="room_size" id="room_size" value="${roomSize }"></td>									
										</tr>
										<tr>	
											<th>등급</th>
											<td>
												<select name="roomGrade" id="roomGrade">
													<c:forEach var="item" items="${roomGradeArr }">
														<c:choose>
															<c:when test="${item == roomGrade }">
																<option selected="selected">${item }</option>
															</c:when>
															<c:otherwise>
																<option >${item }</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</select>
											</td>
											<th>침대타입</th>
											<td>
												<select name="bedType" id="bedType">
													<c:forEach var="item" items="${bedTypeArr }">
														<c:choose>
															<c:when test="${item == bedType }">
																<option selected="selected">${item }</option>
															</c:when>
															<c:otherwise>
																<option >${item }</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</select>
											</td>
											<th>전망</th>
											<td>
												<select name="viewType" id="viewType">
													<c:forEach var="item" items="${viewTypeArr }">
														<c:choose>
															<c:when test="${item == viewType }">
																<option selected="selected">${item }</option>
															</c:when>
															<c:otherwise>
																<option >${item }</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</select>
											</td>
										</tr>
										<tr>
											<th>가격(1박당)</th>
											<td><input type="text" name="room_price" id="room_price" value="${roomPrice }"></td>
											<th>객실 이미지<br>
												<span class="redText">*</span><span class="smallText">최대 4개</span>
											</th>
											<td>
												<img src="/Project_JSP/img/adminpage/btnChoice.png">
												<input type="file" name="roomImg" multiple="multiple" id="roomList" style="display:none;">
												<input type="hidden" name="roomImgUpload" id="roomImgUpload">
												<input type="hidden" name="roomImgDelete" id="roomImgDelete">
											</td>
											<th>예약 이미지<br>
												<span class="redText">*</span><span class="smallText">최대 1개</span>
											</th>
											<td>
												<img src="/Project_JSP/img/adminpage/btnChoice.png">
												<input type="file" name="reservImg" id="reservList" style="display:none;">
												<input type="hidden" name="reservImgUpload" id="reservImgUpload">
												<input type="hidden" name="reservImgDelete" id="reservImgDelete">
											</td>
										</tr>
										<tr>
											<th colspan="6">객실 이미지</th>
										</tr>
										<tr>
											<td colspan="6">
												<ul class="roomImg_wrap">
													<c:forEach var="item" items="${roomImgName}" varStatus="status">
														<li>
															<div class="roomImgDiv">
																<img src="/Project_JSP/img/room/${roomInfoName }/${item}" data-file="${item }" id="roomImgDiv_${status.count }">
															</div>
															<div class="roomImgbtn">
																<img src='/Project_JSP/img/adminpage/btnDelete.png'>
															</div>
														</li>
													</c:forEach>									
												</ul>
											</td>
										</tr>
										<tr>
											<th colspan="6">예약 이미지</th>
										</tr>
										<tr>
											<td colspan="6">
												<ul class="reservImg_wrap">
													<c:forEach var="item" items="${reservImgName}" varStatus="status">
														<li>
															<div class="reservImgDiv">
																<img src="/Project_JSP/img/room/${roomInfoName }/${item}" data-file="${item }" id="reservImgDiv_${status.count }">
															</div>
															<div class="reservImgbtn">
																<img src='/Project_JSP/img/adminpage/btnDelete.png'>
															</div>
														</li>
													</c:forEach>	
												
												</ul>
											</td>
										</tr>
										<tr>
											<td colspan="6">
												<img src="/Project_JSP/img/adminpage/btnUpdateV2.png">
												<input type="submit" id="registerRoom" style="display:none;">
												<img src="/Project_JSP/img/adminpage/cancelBtn.png"> 
											</td>
										</tr>
					
									</table>
								</form>
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