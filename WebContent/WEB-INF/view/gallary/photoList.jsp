<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/gallary/slick.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/gallary/photoStyle.css?v=2">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/gallary/slick.min.js"></script>
<script> 
	$(function(){     
		var type = "<%=request.getParameter("showGalType") %>"; 
		switch (type) { 
			case "ALL": 
				$(".tab-list li").eq(0).find("a").addClass("on");
			break;
			case "ROOM":
				$(".tab-list li").eq(1).find("a").addClass("on");				
			break;
			case "DINING":
				$(".tab-list li").eq(2).find("a").addClass("on");											
				break;
			case "ACTIVITY": 
				$(".tab-list li").eq(3).find("a").addClass("on");											
			break;
			case "RETREAT":
				$(".tab-list li").eq(4).find("a").addClass("on");			
			break;
			case "ETC": 
				$(".tab-list li").eq(5).find("a").addClass("on");
			break;
			default:
				$(".tab-list li").eq(0).find("a").addClass("on");						
			break;
		}
		
	
		
		var slide = $('.slide-nav-wrap').slick({
			  slidesToShow: 6,
			  slidesToScroll: 1,
			  dots: false, 
			  arrows: false, 
			  centerMode: true, 
			  asNavFor: '.slideWrap', 
			  focusOnSelect: true 
			});  
		 
		$('.slideWrap').slick({  
			  slidesToShow: 1,
			  slidesToScroll: 1, 
			  initialSlide: 1,
			  arrows: false, 
			  asNavFor: '.slide-nav-wrap'
	    });  
		  
		$(".next").click(function(){
			$('.slideWrap').slick("slickNext");
			return false; 
		}) 
		
		$(".prev").click(function(){
			$('.slideWrap').slick("slickPrev");
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
</head>
<body>
	<%@ include file="../../common/header.jsp" %>
	<section id="section">  
		<div id="contentWrap"> 
			 <%@ include file="leftMenu.jsp" %>
			 <div id="rightArea"> 
				<div id="wrap_title">
					<h1 id="title">갤러리</h1>
					<div id="wrap_home">
						<img src="../img/common/locaton.gif" id="home"> > 
						<span>갤러리 </span> > 
						<span id="board"> 사진</span>
					</div>
				</div>
				<div>
					<div id="tab">
						<ul class="tab-list"> 
							<li><a href="${pageContext.request.contextPath }/gallery/photolist.do?showGalType=ALL">전체</a></li>
							<li><a href="${pageContext.request.contextPath }/gallery/photolist.do?showGalType=ROOM">객실</a></li>
							<li><a href="${pageContext.request.contextPath }/gallery/photolist.do?showGalType=DINING">다이닝</a></li>
							<li><a href="${pageContext.request.contextPath }/gallery/photolist.do?showGalType=ACTIVITY">액티비티</a></li>
							<li><a href="${pageContext.request.contextPath }/gallery/photolist.do?showGalType=RETREAT">부대시설</a></li>
							<li><a href="${pageContext.request.contextPath }/gallery/photolist.do?showGalType=ETC">기타</a></li>
						</ul> 
					</div>
					<div id="gallery">  
						<div class="image-wrapper"> 
							<div class="slideWrap">
								<c:if test="${list!=null}"> 
								<script>
									console.log("dsfafsd");
						 		</script>
									<c:forEach var="item" items="${list}">
										<div class="slide"> 
											<img src="${item.path }">
											<div class="titleWrap">
												<strong>${item.name }</strong> 
												<p>${item.content }<span class='sCount'></span></p> 
											</div> 
										</div>  
									</c:forEach>
								</c:if> 
							</div>
							<a href="#" class="prev sbtn">이전</a>
							<a href="#" class="next sbtn">이후</a> 
						</div>
						<div class="slide-controls">
							<span class="total">Total 888</span>
							<div class="control-btn-wrap">
								<span class="slideShow-go">go</span>
								<span class="slideShow-stop">stop</span>
							</div>
						</div>
						
						<div class="slide-nav"> 
							<div class="slide-nav-wrap">
							<c:if test="${list!=null }">
								<c:forEach var="item" items="${list}">
									<div class="navItem">						
										
										<a href="#" class='navImg'>
											<img src="${item.path }"> 								
										</a>
										<span class="tit on">${item.name }</span>
									</div>
								</c:forEach>
							</c:if> 
							</div>
							<a href="#" class="prev sbtn">이전</a>
							<a href="#" class="next sbtn">이후</a>			
						</div>
					</div>
				</div> 
			 </div>
		</div>
	</section>
	<jsp:include page="../../common/footer.jsp"/>
</body>
</html>    