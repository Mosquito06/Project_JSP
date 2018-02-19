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
<link rel="stylesheet" type="text/css" href="css/adminpage/adminpage_room_add.css?v=dd">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="js/adminpage/adminpage_room_add.js?a=dd"></script>

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
								<table>
									<tr>
										<th>객실</th>
										<td><input type="text"></td>
										<th>객실명</th>
										<td><input type="text"></td>
										<th>객실크기</th>
										<td><input type="text"></td>									
									</tr>
									<tr>	
										<th>등급</th>
										<td>
											<select>
												<option>선택하세요.</option>
												<option>STANDARD</option>
												<option>PREMIER</option>
												<option>SUITE</option>
											</select>
										</td>
										<th>침대타입</th>
										<td>
											<select>
												<option>선택하세요.</option>
												<option>SINGLE</option>
												<option>DOUBLE</option>
												<option>TWIN</option>
												<option>FAMILYTWIN</option>
											</select>
										</td>
										<th>전망</th>
										<td>
											<select>
												<option>선택하세요.</option>
												<option>MOUNTAIN</option>
												<option>GARDEN</option>
												<option>OCEAN</option>
											</select>
										</td>
									</tr>
									<tr>
										<th>가격(1박당)</th>
										<td><input type="text"></td>
										<th>객실 이미지<br>
											<span class="redText">*</span><span class="smallText">최대 4개</span>
										</th>
										<td>
											<img src="/Project_JSP/img/adminpage/btnChoice.png">
											<input type="file" name="imgPath" id="roomList" style="display:none;">
										</td>
										<th>예약 이미지<br>
											<span class="redText">*</span><span class="smallText">최대 1개</span>
										</th>
										<td>
											<img src="/Project_JSP/img/adminpage/btnChoice.png">
											<input type="file" name="imgPath" id="reservList" style="display:none;">
										</td>
									</tr>
									<tr>
										<th colspan="6">객실 이미지</th>
									</tr>
									<tr>
										<td colspan="6">
											<ul class="roomImg_wrap">
												<li>
													<img src="/Project_JSP/img/room/Standard/1.jpg">
												</li>
											</ul>
										</td>
									</tr>
									<tr>
										<th colspan="6">예약 이미지</th>
									</tr>
									<tr>
										<td colspan="6">
											<ul class="reservImg_wrap">
												
											</ul>
										</td>
									</tr>
									<tr>
										<td colspan="6">
											<img src="/Project_JSP/img/adminpage/registerBtn.png">
											<img src="/Project_JSP/img/adminpage/cancelBtn.png"> 
										</td>
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