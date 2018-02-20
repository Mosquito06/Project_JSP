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
			 <%@ include file="leftMenu.jsp" %>
			 <div id="rightArea">
				<div id="wrap_title">
					<h1 id="title">갤러리</h1>
					<div id="wrap_home">
						<img src="../img/common/locaton.gif" id="home"> > 
						<span>갤러리 </span> > 
						<span id="board"> 동영상</span>
					</div>
				</div>
				<div> 
					내용 
				</div>
			 </div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp"/>
</body>
</html>    