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
						<h1 id="title">연락처</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath }/img/common/locaton.gif" id="home"> > <span
								id="board">연락처</span>
						</div>	
					</div>
					<div>
						<img src="${pageContext.request.contextPath }/img/adminpage/tell1.gif">
					</div>
					<div>
						<img src="${pageContext.request.contextPath }/img/adminpage/tell3.gif">
					</div>
					<div>
						<img src="${pageContext.request.contextPath }/img/adminpage/tell2.gif">
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