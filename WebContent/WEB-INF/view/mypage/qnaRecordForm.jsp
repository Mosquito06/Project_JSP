<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 내역 | My Page |The Shilla Hotel</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/leftMenu.css?v=2">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/qnaRecord.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/common.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp" />
	<section>
		<div id="contentWrap">
				<jsp:include page="mypageLeftMenu.jsp" />
				<div id="rightArea">

					<div id="wrap_title">
						<h1 id="title">문의내역</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> >My Page> <span
								id="board">문의 내역</span>
						</div>	
					</div>
					<span></span>
					<div>
					
						<table>
							<tr>
								<th></th>
							</tr>
						</table>
					</div>
				
				</div>
				
			</div>
	</section>
	<jsp:include page="/WEB-INF/common/footer.jsp"/>
</body>
</html>