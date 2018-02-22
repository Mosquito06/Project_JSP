<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/activity/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/gallary/slick.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/gallary/slick.min.js"></script>
<style>
	#galleryWrapper{
		margin-bottom: 25px;
	}
	.image-wrapper{  
		position: relative;
	}
	.sbtn{   
		display:block;
		width:60px;
		height:94px;
		text-indent: -9999px;
		position: absolute;
		top: 189.5px;
		margin-top: -47px; 
	}
	.slideWrap{
		width: 100%;
		overflow: hidden;
		position:relative;
	}
	.prev{ 
	background: url("/Project_JSP/img/gallary/slidePrev.png") no-repeat;
	left:0; 
	} 
	 
	.next{  
		background: url("/Project_JSP/img/gallary/slideNext.png") no-repeat;
		right: 0px;
	} 
	.prev:HOVER {
		background-position-y: -100px;
	}
	
	.next:HOVER {
		background-position-y: -100px;
	}
	.slide-nav{
		margin-top:2px;
		width: 100%;
		overflow: hidden;	
		position: relative;
	}
	.slide-nav-wrap{
		width: 100%;
		overflow: hidden;
	}
	.slide-nav .sbtn{
		top:0;
		margin: 0px; 
		z-index: 999;
	}
	.navImg {
		display:block;
		width:100%;
		overflow: hidden;
		position: relative;
	}
	.navImg:hover .coverBg{
		border:3px solid gray;
		box-sizing:border-box;
		display: none;
	}
	.navImg img{
		width: 100%; 
	}
	.coverBg{
		display:inline-block;
		position:absolute;
		z-index:9999;
		width: 100%;
		height: 100%;
		background: rgba(0,0,0,0.5);
	} 
</style>
</head>  
<script>  
	$(function(){  
		
		var slide = $('.slide-nav-wrap').slick({
			  slidesToShow: 4,
			  slidesToScroll: 1,
			  dots: false, 
			  arrows: false,  
			  centerMode: false,  
			  asNavFor: '.slideWrap', 
			  focusOnSelect: true 
			});  
		  
		$('.slideWrap').slick({
			  slidesToShow: 1,
			  slidesToScroll: 1, 
			  arrows: false , 
			  asNavFor: '.slide-nav-wrap' 
	    });  
		
		$(".slideWrap").slick("slickCurrentSlide");
		
		var idx = $(".slideWrap").slick("slickCurrentSlide")+1;
		var size = 0;

		<c:forEach var="item" items="${list}">
			size++;
		</c:forEach> 
		$(".totalCount").text(size);
		 
		$(".sCount").text(idx); 
		
		$(".next").click(function(e){ 
			e.preventDefault();
			$('.slideWrap').slick("slickNext");
			var idx = $(".slideWrap").slick("slickCurrentSlide")+1;
			$(".sCount").text(idx); 
			return false;   
		})  
		
		$(".prev").click(function(e){ 
			e.preventDefault();
			$('.slideWrap').slick("slickPrev");
			var idx = $(".slideWrap").slick("slickCurrentSlide")+1;
			$(".sCount").text(idx);
			return false;
		})
		
		$(".slideShow-go").click(function(){
			$('.slideWrap').slick("slickPlay");
			return false; 
		})
		$(".slideShow-stop").click(function(){
			$('.slideWrap').slick("slickPause");
			return false;
		})
	})   
</script>
<body>
	<%@ include file="../../common/header.jsp" %>
	<section id="section">  
		<div id="contentWrap">		
			<%@ include file="leftMenu.jsp" %>
			 
			<div id="rightArea">
				<div id="wrap_title" style="margin-bottom: 0px;">
					<h1 id="title">${activity.name }</h1>
					<div id="wrap_home">
						<img src="${pageContext.request.contextPath }/img/common/locaton.gif" id="home"> > 
						<span id="board">액티비티</span>
						>
						<span id="board">${activity.name }</span>
					</div>
				</div> 
			 
				<div id="galleryWrapper"> 
					<div>
						 <div class="image-wrapper"> 
							<div class="slideWrap">
								<c:if test="${list!=null}">  
									<c:forEach var="item" items="${list}">		 								
										<c:if test="${item != activity.imgPath }">
											<div class="slide"> 
												<img src="${item }">
											</div>    
										</c:if>
									</c:forEach>
								</c:if> 
							</div>
							<a href="#" class="prev sbtn">이전</a> 
							<a href="#" class="next sbtn">이후</a>  
						</div>						
						<div class="slide-nav"> 
							<div class="slide-nav-wrap">
							<c:if test="${list!=null }">
								<c:forEach var="item" items="${list}">								
									<c:if test="${item != activity.imgPath }">
										<div class="navItem">				
											<a href="#" class='navImg'>
												<span class="coverBg"></span>
												<img src="${item }"> 								
											</a>
										</div>
									</c:if>
								</c:forEach>
							</c:if> 
							</div>	
						</div>
					</div>
				</div>
				
				<div id="detailWrapper"> 
					${content.content } 
				</div> 
			 </div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp"/>
</body>
</html>    