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
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/css/common/common.css?v=1">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath }/css/event/writeStyle.css?v=18">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<style type="text/css">
	#readTable{
		width: 100%;
	}
	#readTable tr{
			border-bottom: 1px solid #cdcbbe;
	}
	#readTable tr:FIRST-CHILD{
			border-top: 1px solid #cdcbbe;
	}
	#readTable th{
	    background-color: #faf9f4;
	    font-size: 13px;
	    font-weight: bold;
	    color: #666666;
	    vertical-align: middle;
	}
	#readTable th,td{
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
<script>
	$(function(){
		$(document).ready(function(){ 
			var mySlider =  $('.slider').bxSlider({
		    	pager : false,
		    	controls : false,
		    	maxSlides: 3,
		    	moveSlides: 1,
		    	auto : true,
		    	pause : 3000 
		    });
		    
		    $(".prev").click(function(e){
		    	 e.preventDefault();
		    	 mySlider.goToPrevSlide();
		    	 return false; 
		    })
		    
		    $(".next").click(function(e){
		    	 e.preventDefault();
		    	 mySlider.goToNextSlide();
		    	 return false;
		    })
		  });
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
						<h1 id="title">갤러리 관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">갤러리 관리</span>
						</div>
					</div>
				<div class="eventContent">
					
					<div class="btnWrap">
						<!-- ▽ 관리자 전용 버튼 -->
						<div>
							<a href="${pageContext.request.contextPath }/adminActivityModify.do?no=${activity.num}" class="mod btn">수정하기</a> 
						</div>
						<!-- △ 관리자 전용 버튼 -->
						<a href="${pageContext.request.contextPath }/adminActivityList.do" class="btn">목록보기</a>
					</div>
					<table id="readTable">
						<tr>
							<th width="12.5%">번호</th>
							<td width="12.5%">${activity.num }</td>  
							<th width="12.5%">메뉴명</th>
							<td width="12.5%">${activity.name }</td> 
							<th width="12.5%">분류</th>
							<td width="12.5%">${activity.type }</td>   
						</tr>
						<tr> 
							<th colspan="1" width="12.5%">메뉴 소개</th>
							<td colspan="5">${activity.introduce }</td> 
						</tr>
						<tr>   
							<th colspan="1" width="12.5%">배너 이미지</th> 
							<td colspan="5" > 
								<img src="${activity.imgPath }" width="300">
							</td> 
						</tr> 
						<tr>
							<th colspan="6">갤러리</th> 
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
							<th colspan="6">상세내용</th>
						</tr>  
						<tr>
							<td colspan="6" class='contentTd'>
								${content.content }
							</td>
						</tr> 
					</table>
					
					<div class="btnWrap">
						<!-- ▽ 관리자 전용 버튼 -->
						<div>
							<a href="${pageContext.request.contextPath }/adminActivityModify.do?no=${activity.num}" class="mod btn">수정하기</a> 
						</div>
						<!-- △ 관리자 전용 버튼 -->
						<a href="${pageContext.request.contextPath }/adminActivityList.do" class="btn">목록보기</a>
					</div>
				</div>
			
			</div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp" />
</body>
</html>