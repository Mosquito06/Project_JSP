<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/activity/activityFormCheck.js"></script>
</head>
<body>
	<%@ include file="../../common/header.jsp"%>
	<section id="section">
		<div id="contentWrap">
			<%@ include file="admin_leftMenu.jsp"%>
			<div id="rightArea">
					<div id="wrap_title">
						<h1 id="title">액티비티 관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">액티비티 관리</span>
						</div>
					</div>
			<form action="${pageContext.request.contextPath}/adminActivityModify.do"
				id="addEventForm" method="post" enctype="multipart/form-data">
				<table id="editerTd"> 
					<tr>
						<td><span class="titleTxt">메뉴명</span><input type="text"
							name="title" class="inputTxt"></td>
					</tr>
					<tr>
						<td><span class="titleTxt">소개</span> <input type="text"
							name="introduce" class="inputTxt intro" /></td>
					</tr>
					<tr>
						<td>
							<span class="titleTxt">배너 이미지 업로드</span> 
							<input	type="file" name="imgBannerPath" class="inputTxt banner" id="imgBannerPath"/>
						</td>
					</tr> 
					<tr> 
						<td>
							<span class="titleTxt">갤러리 파일 목록</span>
							<ul>
								<li><img src="#" width="100" height="100"></li>
							</ul>
						</td>
					</tr>
					<tr>
						<td>
							<span class="titleTxt">메뉴 분류</span> 
							<select name="type">
								<option value="cammping">글램핑&캠핑</option>
								<option value="kidzone">키드존</option>
								<option value="fitness">피트니스</option>
							</select>
						</td>
					</tr> 
					<tr>
						<td colspan="2">  
							<div class="form-group">
								<textarea class="form-control" name="noticeContent"
									id="noticeContent" cols="100" rows="15"></textarea>
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
				<textarea name="hiddenContent" id="hiddenContent">
					</textarea>
			</form> 
			
		</div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>
