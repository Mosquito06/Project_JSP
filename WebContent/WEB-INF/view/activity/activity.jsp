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
<style>
	#rightArea{
		height:500px;
		background: #ddd;
	}
</style>
</head>  
<body>
	<%@ include file="../../common/header.jsp" %>
	<section id="section">  
		<div id="contentWrap">
			 <%@ include file="leftMenu.jsp" %>
			 
			 <div id="rightArea">
				 <p>콘텐트 넣으세요</p>
			 </div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp"/>
</body>
</html>    