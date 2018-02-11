<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css?v=2">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/event/writeStyle.css?v=2">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/event/formCheck.js?a=1"></script>
</head>
<body>
	<%@ include file="../../common/header.jsp"%>
	<section id="section">
		<div id="contentWrap">
			<%@ include file="leftMenu.jsp"%>

			<form action="${pageContext.request.contextPath}/event/eventModify.do" id="addEventForm" method="post" enctype="multipart/form-data">
				
				
				<table id="editerTd">
					<tr>
						<td><span class="titleTxt">제목</span><input type="text"
							name="title" class="inputTxt" value="${event.eventTitle }"></td>
					</tr>
					<tr>
						<td><span class="titleTxt">시작 날짜</span> 
							<input type="date"	name="startDate" class="inputTxt date" 
							value='<fmt:formatDate value="${event.eventStartDay }" pattern="yyyy-MM-dd"/>'/> 
						
							<i class="bar">-</i> 
							<span class="titleTxt">종료 날짜</span> 
							<input type="date" name="endDate" class="inputTxt date" 
							value='<fmt:formatDate value="${event.eventEndDay }" pattern="yyyy-MM-dd"/>'/> 
						
						</td>
					</tr>
					<tr>
						<td><span class="titleTxt">이벤트 소개</span> 
						<input type="text" name="introduce" class="inputTxt intro" value="${event.eventIntroduce }"/></td>
					</tr>
					<tr>
						<td><span class="titleTxt">배너 이미지 업로드</span> <input
							type="file" name="imgpath" class="inputTxt banner" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="form-group">
								<textarea class="form-control" name="noticeContent"
									id="noticeContent" cols="100" rows="15">'${content.eventContent }'</textarea>
								<script>
									CKEDITOR.replace('noticeContent');
								</script>
							</div>
						</td>
					</tr>
					<tr>
						<td><input type="submit" value="저장" class="btn"> <input
							type="button" value="돌아가기" class="btn"></td>
					</tr>
				</table>
				
				<textarea name="hiddenContent" id="hiddenContent"></textarea>
				<textarea name="oldContent" id="oldContent" style="display:none;">${content.eventContent }</textarea>
				<input type="hidden" value="${event.eventNum }" name="no"/>
				<input type="hidden" value="${event.eventImgPath }" name="oldBanner"/>
			</form>
		</div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>
