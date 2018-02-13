<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 | 신라호텔</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/mypage/leftMenu.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script> 
<script src="js/common/common.js"></script>
<style>
#member_info{
	font-size: 13px;
	margin-top: 10px;
}
#member_info li{
	line-height: 20px;
}
#member_info li a{
color:#C2AA85;
font-weight: bold;
}
#question{
	border: none !important;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp"/>
		<jsp:include page="qna_form.jsp"></jsp:include>
		<section>
		
		</section>
	<jsp:include page="/WEB-INF/common/footer.jsp"/>
</body>
</html>