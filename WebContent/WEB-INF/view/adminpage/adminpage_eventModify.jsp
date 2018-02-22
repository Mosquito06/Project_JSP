<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/css/common/common.css?v=2">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/css/event/writeStyle.css?v=8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/reservation/step1.css?a=dd">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/reservation/jsCalendar.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/reservation/jsCalendar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/reservation/jsCalendar.lang.de.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/event/formCheck.js?a=3"></script>
<script>
	$(function(){
		var date = new Date("<fmt:formatDate value="${event.eventStartDay }" pattern="yyyy-MM-dd"/>");
		var endDate = new Date("<fmt:formatDate value="${event.eventEndDay }" pattern="yyyy-MM-dd"/>");
		
		// 시작 시 날짜 설정
		$("#sYear").text(date.getFullYear());
		$("#sMonth").text(month[date.getMonth()]);

		$("#eYear").text(endDate.getFullYear());
		$("#eMonth").text(month[endDate.getMonth()]);
		
		$("#sDay").text(date.getDate());
		
		$("#eDay").text(endDate.getDate()); 
	})
</script>
</head>
<body>
	<%@ include file="../../common/header.jsp"%>
	<section id="section">
		<div id="contentWrap">
			<%@ include file="admin_leftMenu.jsp"%>
			<div id="rightArea">
					<div id="wrap_title">
						<h1 id="title">이벤트 관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">이벤트 관리</span>
						</div>
					</div>
			<form action="${pageContext.request.contextPath}/adminEventModify.do"
				id="addEventForm" method="post" enctype="multipart/form-data">


				<table id="editerTd">
					<tr> 
						<td><span class="titleTxt">제목</span><input type="text"
							name="title" class="inputTxt" value="${event.eventTitle }"></td>
					</tr>
					<tr>
						<td><span class="titleTxt">시작 날짜</span>
							<div class="dateBox sDate">
								<div id="sYear" class="year"></div> 
								-
								<div id="sMonth" class="month"></div>
								-
								<div id="sDay" class="day"></div>
							</div> <input type="date" name="startDate" class="date" id="startDate"
							value='<fmt:formatDate value="${event.eventStartDay }" pattern="yyyy-MM-dd"/>' />

							<i class="bar">-</i> <span class="titleTxt">종료 날짜</span>
							<div class="dateBox eDate">
								<div id="eYear" class="year"></div>
								-
								<div id="eMonth" class="month"></div>
								-
								<div id="eDay" class="day"></div>
							</div> <input type="date" name="endDate" class="date" id="endDate"
							value='<fmt:formatDate value="${event.eventEndDay }" pattern="yyyy-MM-dd"/>' />

						</td>
					</tr>
					<tr>
						<td><span class="titleTxt">이벤트 소개</span> <input type="text"
							name="introduce" class="inputTxt intro"
							value="${event.eventIntroduce }" /></td>
					</tr>
					<tr>
						<td><span class="titleTxt">배너 이미지 업로드</span> <input
							type="file" name="imgpath" class="inputTxt banner" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="form-group">
								<textarea class="form-control" name="noticeContent"
									id="noticeContent" cols="100" rows="15">${content.eventContent }</textarea>
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
				<textarea name="oldContent" id="oldContent" style="display: none;">
					${content.eventContent }
				</textarea>
				<input type="hidden" value="${event.eventNum }" name="no" /> 
				<input type="hidden" value="${event.eventImgPath }" name="oldBanner" />
			</form>
			
			<div id="start-calendar" class="calendar"></div>
			<div id="end-calendar" class="calendar"></div>
		</div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>
