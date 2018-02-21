<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css?ver=1">

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<style>
#wrap_img{
 	margin-bottom:20px; 
}
table{
	
	width:800px;
	margin:0 auto;
	border-top:2px solid #432c10;
	
}
th{
	
	border-bottom: 1px solid #ddd;
	padding:10px;
	font-weight: bold;
	font-size: 13px;
	background: #faf9f4;
	color:#666;
	vertical-align: middle;
	
}
td{
	
	border-bottom:1px solid #ddd;
	padding:15px;
	font-size: 13px;
	
}
</style>
</head>

<body>

	<div>
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp" />
		</header>

		<section>
			<div id="contentWrap">
				<jsp:include page="leftMenu.jsp" />
				<div id="rightArea">

					<div id="wrap_title">
						<h1 id="title">호텔정보</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath }/img/common/locaton.gif" id="home"> > <span
								id="board">호텔정보</span>
						</div>	
					</div>
					<div id="wrap_img">
						<img src="${pageContext.request.contextPath }/img/info/hotel.gif">
					</div>
					<div>
						<table>
							<tr>
								<th>개관일</th>
								<td>1990년 7월 1일(중측동 개관 : 1998.7.1)</td>
							</tr>
							<tr>
								<th>주소</th>
								<td>대구광역시 남구 중앙대로 220, 3층(대명동, 다산빌딩)</td>
							</tr>
							<tr>
								<th>대표전화</th>
								<td>Tel.053-477-5580 Fax.053-722-0840</td>
							</tr>
							<tr>
								<th>홈페이지</th>
								<td>http://www.shilla.net/daegu</td>
							</tr>
							<tr>
								<th>부지면적</th>
								<td>26.404평(87, 283㎡), 연건평 16,912평(56,126㎡), 건축면적 4,617평(15,294㎡)</td>
							</tr>
							<tr>
								<th>객실수</th>
								<td>429실</td>
							</tr>
							<tr>
								<th>레스토랑</th>
								<td>한식, 일식, 양식당, 로비라운지, 바</td>
							</tr>
							<tr>
								<th rowspan="2">부대시설</th>
								<td>6개의 식당과 바, 8개의 연회장, 카지노, 스파, 피트니스센터</td>
							</tr>
							<tr>
								<td>실내외 수영장, 사우나, 여행사, 렌터카, 기념품점, 테디베어 샵, 제주 특산물 판매점</td>
							</tr>
							<tr>
								<th>건축</th>
								<td>외관설계 미국WATG사, 시공 : 삼성종합건설</td>
							</tr>
							<tr>
								<th>인테리어</th>
								<td>프랑스 OGAWA & FERRE社</td>
							</tr>
							<tr>
								<th>조경설계</th>
								<td>미국 BELT COLLINS社, 시공 : 삼성 에버랜드</td>
							</tr>
							<tr>
								<th>교통안내</th>
								<td>대구국제공항으로부터 약 50분 소요되며 공항 리무진버스(600번), 택시 등 이용</td>
							</tr>
							<tr>
								<th>주변명소</th>
								<td>수성못, 이랜드, 강정보, 팔공산, 동성로, 한일극장</td>
							</tr>
							<tr>
								<th>제휴호텔</th>
								<td>일본 오꾸라 호텔, 인도 Taj호텔 제휴</td>
							</tr>
							
							
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