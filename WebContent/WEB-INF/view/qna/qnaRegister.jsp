<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객의견접수완료 | The Shilla Hotel</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/qna/qnaboard.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/qna/qnaForm.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp" />
	<section>
	<div id="contentWrap">
		<jsp:include page="leftMenu.jsp" />
		<div id="rightArea">

					<div id="wrap_title">
						<h1 id="title">문의하기</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">접수완료</span>
						</div>
					</div>
					<div id="register_wrap">
						<h1>고객님의 문의가 접수 되었습니다.</h1>
						<h2>고객님의 문의가 접수 되었습니다.</h2>
						<h3>*답변까지는 최소 2~7일 소요됩니다. 만족스러운 서비스를 제공하는 신라호텔이 되도록 노력하겠습니다.</h3>
						
						<a href="qna.do"><button>추가 문의하기</button></a>
					</div>
		</div>
	</div>
	</section>
	<jsp:include page="/WEB-INF/common/footer.jsp" />
</body>
</html>