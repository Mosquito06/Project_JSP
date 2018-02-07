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

</head>
<body>
	<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
	<%@ include file="../../common/header.jsp" %>

	<div class="form-group">
		<label for="noticeContent">내용</label>
		<textarea class="form-control" name="noticeContent" id="noticeContent"
			cols="50" rows="15"></textarea>
		<script>
			CKEDITOR.replace('noticeContent');
		</script>
	</div>
	
	<jsp:include page="../../common/footer.jsp"/>
</body>
</html>