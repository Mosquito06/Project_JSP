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
			<%@ include file="leftMenu.jsp"%>

			
				<div class="cntEvent">
					<div class="eventTitle">
						<p>EVENT</p>	
					</div>
					<ul class="eventList">
						
						<c:if test="${exist != null }">
							<li class="noEvent">
								<div class="innerBox">
									진행중인 이벤트가 없습니다.
								</div>
							</li>
						</c:if>
						
						<c:if test="${list != null }">
							<c:forEach var="item" items="${list}">
								<li class="outBox">  
									<div  class="innerBox">
										<a href="#" class="eventLink">
											<img  src="#" class="eventBanner">
										</a>  
										<div class="eventInfo">
											<h3 class="tit">
												<a href="#" class="smTitle">${item.eventTitle }</a>
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
