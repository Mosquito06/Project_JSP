<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css?v=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/event/writeStyle.css?v=16">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"  
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/common/common.js"></script>
</head>
<body>
	<%@ include file="../../common/header.jsp"%>
	<section id="section">

			<div id="contentWrap">
				<%@ include file="leftMenu.jsp"%>
				<div class="eventContent">
					<div class="btnWrap">
						<div>
							<a href="#" class="mod">수정하기</a> 
							<a href="#" class="del">삭제하기</a> 
						</div>
						<a href="#">목록보기</a>
					</div>
					<div class="contentWrap">${content.eventContent }</div>
					<div class="btnWrap">
						<div>
							<a href="#" class="mod">수정하기</a> 
							<a href="#" class="del">삭제하기</a>  
						</div>
						<a href="#">목록보기</a>
					</div>
				</div>
			
			<c:if test="${list != null }">
				<div class="otherEventWrap">
					<div class="otherEvent">
						<img
							src="${pageContext.request.contextPath }/img/event/otherEvent.gif">
					</div>
					
					<div class="eventSlide">
					<a href="#" class="prev sBtn"><</a>
					<a href="#" class="next sBtn">></a>
					<c:forEach var="item" items="${list}">
						<div class="slideWrap">
							<div class="imgBox">
								<a href="${pageContext.request.contextPath}/event/eventread.do?no=${item.eventNum}"	class="smTitle">
									<img src="${item.eventImgPath}">
								</a>
							</div>
							
							<div class="infoBox">
									<h3 class="sTit">
										<a href="${pageContext.request.contextPath}/event/eventread.do?no=${item.eventNum}"	class="smTitle">${item.eventTitle }</a>
									</h3>
									<p class='sDate'>
										<fmt:formatDate value="${item.eventStartDay }" pattern="yyyy-MM-dd" />
										~
										<fmt:formatDate value="${item.eventEndDay }" pattern="yyyy-MM-dd" />
									</p>
								</div>
							</div>
						</div>
					</c:forEach> 
				</div>
			</c:if>
			</div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>