<%@page import="Project_JSP.dto.Activity"%>
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
<style type="text/css">
	#readTable{
		width: 100%;
	}
	#editerTd tr{
			border-bottom: 1px solid #cdcbbe;
	}
	#editerTd tr:FIRST-CHILD{
			border-top: 1px solid #cdcbbe;
	} 
	#editerTd th{
	    background-color: #faf9f4;
	    font-size: 13px;
	    font-weight: bold;
	    color: #666666;
	    vertical-align: middle;
	}
	#editerTd th,td{
		text-align:center;
		vertical-align:middle; 
		padding:15px 0;
	}
	#galList{
		width:100%;
		height:70px;
		overflow: auto;
	}  
	#galList li{
		float: left;
		margin-right: 10px;
	} 
	.contentTd{
		margin: 0;
		text-align: left;
		vertical-align: top;
	}
</style>
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
						<th width="12.5%">번호</th>
						<td width="12.5%">${activity.num }</td>
						<th width="12.5%">메뉴명</th>
						<td width="12.5%"><input type="text" name="title" value="${activity.name }"></td>
						<th width="12.5%">메뉴 분류</th>
						<td width="12.5%">
							<select name="type">
								<option value="cammping">글램핑&캠핑</option>
								<option value="kidzone">키드존</option>
								<option value="fitness">피트니스</option>
							</select>
						</td>
					</tr>
					<tr> 
						<th colspan="1">소개</th>
						<td colspan="5"><input type="text"	name="introduce" style="width: 94%;" value='${activity.introduce }'/></td>
					</tr>
					<tr>
						<th colspan="1">배너 이미지</th>
						<td colspan="5">							 
							<input	type="file" name="imgBannerPath" id="imgBannerPath" style="float: left;  margin-left: 10px;" />
						</td>
					</tr>
					<tr> 
						<th colspan="6">
							갤러리 파일 목록
						</th>
					</tr> 
					<tr>
						<td colspan="6">
							<ul id="galList">
								<c:if test="${fileNames != null }">
									<c:forEach var="file" items="${fileNames }">
									<c:if test="${file != activity.imgPath }">
										<li><img src="${file }" width="150" /></li>
									</c:if>
									</c:forEach> 
								</c:if>
							</ul>
						</td>
					</tr>
					<tr> 
						<th colspan="6">상세 내용</th>
					</tr> 
					<tr> 
						<td colspan="6">  
							<div class="form-group">
								<textarea class="form-control" name="noticeContent"
									id="noticeContent" cols="100" rows="15">${content.content }</textarea>
								<script>
									CKEDITOR.replace('noticeContent');
								</script>
							</div>
						</td>  
					</tr>
					<tr>
						<td colspan="6"><input type="submit" value="저장" class="btn"> <input
							type="button" value="돌아가기" class="btn"></td>
					</tr>
				</table>
				<textarea name="hiddenContent" id="hiddenContent">
				</textarea>					
				<textarea name="oldContent" id="oldContent" style="display: none;">
					${content.content }
				</textarea>
				<input type="hidden" value="${activity.num }" name="no" /> 
				<input type="hidden" value="${activity.imgPath }" name="oldBanner" />
				<% 
					Activity activity =(Activity)request.getAttribute("activity");
					
					session.setAttribute("actNo", activity.getNum());
				%>
			</form>
			
		</div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>
