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
	href="${pageContext.request.contextPath }/css/event/writeStyle.css?v=62">	
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
			<%@ include file="admin_leftMenu.jsp"%>
			<div id="rightArea">
					<div id="wrap_title">
						<h1 id="title">이벤트 관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">이벤트 관리</span>
						</div>
					</div>
				<div class="cntEvent">
					<!-- 관리자 전용 버튼 -->
					<div class="btnWrap">
						<a href="${pageContext.request.contextPath }/adminEventWrite.do" class="btn">이벤트 등록 하기</a>
					</div>
					 
					<div class="eventTitle">
						<p>EVENT</p>	
					</div>
					<ul class="eventList">
						
						<c:if test="${exist != null }">
							<li class="noEvent outBox">
								<div class="innerBox">
									진행중인 이벤트가 없습니다.
								</div>
							</li>
						</c:if>
						
						<c:if test="${list != null }">
							<c:forEach var="item" items="${list}">
								<li class="outBox">  
									<div  class="innerBox">
										<a href="${pageContext.request.contextPath}/adminEventRead.do?no=${item.eventNum}" class="eventLink">
											<img  src="${item.eventImgPath}" class="eventBanner">
										</a>  
										<div class="eventInfo"> 
											<h3 class="tit">
												<a href="${pageContext.request.contextPath}/adminEventRead.do?no=${item.eventNum}" class="smTitle">${item.eventTitle }</a>
											</h3>
											<p class="eventDate">
												<fmt:formatDate value="${item.eventStartDay }" pattern="yyyy-MM-dd"/>
												 ~  
												<fmt:formatDate value="${item.eventEndDay }" pattern="yyyy-MM-dd"/></p>
											<p class="eventIntro">${item.eventIntroduce }</p>
										</div>
									</div>   
								</li>
							</c:forEach>
						</c:if>
					</ul>
				</div>
			</div>
		</div> 
	</section>
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>
