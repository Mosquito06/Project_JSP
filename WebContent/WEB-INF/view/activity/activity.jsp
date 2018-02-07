<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/activity/style.css">

<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
</head>  
<body>
	<%@ include file="../../common/header.jsp" %>
	<section id="section">  
		<div id="contentWrap">
			 <div id="leftArea">
			 	<div id="lnbWrap">
			 		<h2 class="title">액티비티</h2>
			 		<ul class="leftMenu">
			 			<li class="bMenu">
			 				<a><span>글램핑 & 캠핑</span></a>
			 				<ul class="sMenu">
			 					<li><a href="#">글램핑 빌리지</a></li>
			 					<li><a href="#">캠핑 빌리지</a></li>
			 				</ul>
			 			</li>
			 			<li class="bMenu">
			 				<a href="#" class="noBorder"><span>레저 전문가 서비스</span></a>  
			 			</li>
			 			<li class="bMenu">  
			 				<a ><span>키즈 시설</span></a>
			 				<ul class="sMenu">
			 					<li><a href="#">키즈 캐빈</a></li>
			 					<li><a href="#">키즈 아일랜드</a></li>
			 					<li><a href="#">짐보리 클럽</a></li>
			 					<li><a href="#">G.X.룸</a></li>
			 				</ul>
			 			</li>
			 			<li class="bMenu">
			 				<a><span>피트니스</span></a>
			 				<ul class="sMenu">
			 					<li><a href="#">사우나</a></li> 
			 					<li><a href="#">실내체육관</a></li>
			 					<li><a href="#">조깅코스</a></li>
			 				</ul>
			 			</li>
			 			<li class="bMenu noBorder">
			 				<a href="#" class="noBorder"><span>와인 파티</span></a>
			 			</li>
			 			<li class="bMenu noBorder">
			 				<a href="#" class="noBorder"><span>갤러리 투어</span></a>
			 			</li>
			 			<li class="bMenu noBorder">
			 				<a href="#" class="noBorder"><span>숨비정원</span></a>
			 			</li>
			 			<li class="bMenu noBorder">
			 				<a href="#" class="noBorder"><span>플레이스테이션 게임 존</span></a>
			 			</li>
			 		</ul>
			 	</div>
			 	
			 </div>
			 
			 <div id="rightArea">
				 <p>콘텐트 넣으세요</p>
			 </div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp"/>
</body>
</html>    