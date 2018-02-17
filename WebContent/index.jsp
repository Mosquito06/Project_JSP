<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>누구나 한번쯤 꿈꾸는 일상으로부터의 탈출 |대구신라호텔</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/main.css?v=30"> 
<link rel="stylesheet" type="text/css" href="css/reservation/jsCalendar.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/common/common.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="js/reservation/jsCalendar.js"></script>
<script type="text/javascript" src="js/reservation/jsCalendar.lang.de.js"></script>
<script type="text/javascript" src="js/main.js?v=25"></script>  
</head>   
<body>  
	<%@ include file="WEB-INF/common/header.jsp" %>   
	<section>         
		<div id="visualWrap">    
			<div class="mainVisual">
				
			</div>
			<div class="visContent">
				<a href="#" class="prev mVisBtn">이전</a>
				<a href="#" class="next mVisBtn">이후</a>
				 
				<div class="reserveWrap"> 
					<div class="selArea"> 
						<ul class="selList">
							<li class="hotelLi">
								대구신라호텔    
							</li>
							<li>
								<input type="text" name="ckin" id="ckin" placeholder="체크인">
								<span class="btnCal"></span> 
								<div id="start-calendar"></div>
							</li>
							<li>
								<input type="text" name="ckout" id="ckout" placeholder="체크인">
								<span class="btnCal"></span>
								<div id="end-calendar"></div>    
							</li>
							<li>
								<select class="adSelect selectAll"> 
									<option value="1">성인  1</option>  
									<option value="2">성인  2</option>   
									<option value="3">성인  3</option>
									<option value="4">성인  4</option> 
								</select>
								<div class="rsBox"> 
									성인 
									<i class="arr"></i>    
								</div>      
								<ul class="rsSelect rsSel_ad">   
									<li><a href="#">성인  1</a></li>  
									<li><a href="#">성인  2</a></li>
									<li><a href="#">성인  3</a></li>  
									<li><a href="#">성인  4</a></li> 
								</ul>
							</li>
							<li>  
								<select class="chdSelect selectAll">
									<option value="0">어린이 0</option>
									<option value="1">어린이 1</option>
									<option value="2">어린이 2</option>
									<option value="3">어린이 3</option>
								</select>
								<div class="rsBox">어린이
									<i class="arr"></i>   
								</div>
								<ul class="rsSelect rsSel_ch">       
									<li><a href="#">어린이  0</a></li>   
									<li><a href="#">어린이  1</a></li>
									<li><a href="#">어린이  2</a></li>  
									<li><a href="#">어린이  3</a></li>
								</ul>  
							</li>
							<li>
								<select class="sChdSelect selectAll">
									<option value="0">유아 0</option>
									<option value="1">유아 1</option>
									<option value="2">유아 2</option>  
									<option value="3">유아 3</option>
								</select>
								<div class="rsBox">유아 
									<i class="arr"></i>  
								</div>
								<ul class="rsSelect rsSel_lch">   
									<li><a href="#">유아  0</a></li>
									<li><a href="#">유아  1</a></li>
									<li><a href="#">유아  2</a></li>  
									<li><a href="#">유아 3</a></li>
								</ul>
							</li>
						</ul>
						<span class="wranMsg">
							<i class="wranIcon"></i>
							<span class="wranMsgInner">
								어린이 : 37개월 이상~만 12세 이하
								<br>
								유아 : 36개월 이하
								<i class="wranArr"></i>
							</span>							
						</span>   
						<a href="#" class="resBtn"> 
							검색 
						</a>
						
						
						<div class="resActive">
							
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="mainContent">
			<div class="bannerWrap">
			 	<div class="banContent">
			 		<div class="titleWrap"> 
			 			<h2><img src="/Project_JSP/img/main/eventTit.gif"></h2>
			 			<a href="/Project_JSP/event/eventlist.do"><img src="/Project_JSP/img/main/btnOfferMore.gif"></a> 
			 		</div>
			 		<div class="conBox">
			 			
			 		</div> 
			 	</div>   
			</div>
			
			<div class="bannerWrap bannerBgColor">
			 	<div class="banContent">
			 		<div class="activitySlide">
			 			<div class="content">
					 		<div class="leftContent">	
					 			<h2>레저 전문가 서비스</h2>
					 			<h3 class="aTit">딸기 따기</h3>
					 			<p>내용 들어가기내용 들어가기내용 들어가기내용 들어가기<br>용 들어가기내용 들어가기내용 들어가기 </p>
					 			<a href="#" class="actMore"><img src="/Project_JSP/img/main/btnPackMore.gif"/></a>
					 		</div>
					 		<div class="rightContent">
					 			<img src="#"/>  
					 		</div>
			 			</div> 
			 			
			 			<div class="content">
					 		<div class="leftContent">	
					 			<h2>레저 전문가 서비스</h2>
					 			<h3 class="aTit">22222</h3>
					 			<p>내용 들어가기내용 들어가기내용 들어가기내용 들어가기<br>용 들어가기내용 들어가기내용 들어가기 </p>
					 			<a href="#" class="actMore"><img src="/Project_JSP/img/main/btnPackMore.gif"/></a>
					 		</div>
					 		<div class="rightContent">
					 			<img src="#"/>   
					 		</div>
			 			</div> 
			 			
			 			<div class="content">
					 		<div class="leftContent">	
					 			<h2>레저 전문가 서비스</h2>
					 			<h3 class="aTit">33333333</h3>
					 			<p>내용 들어가기내용 들어가기내용 들어가기내용 들어가기<br>용 들어가기내용 들어가기내용 들어가기 </p>
					 			<a href="#" class="actMore"><img src="/Project_JSP/img/main/btnPackMore.gif"/></a>
					 		</div>
					 		<div class="rightContent">
					 			<img src="#"/>  
					 		</div>
			 			</div> 
			 			
			 			<div class="content">
					 		<div class="leftContent">	
					 			<h2>레저 전문가 서비스</h2>
					 			<h3 class="aTit">444444</h3>
					 			<p>내용 들어가기내용 들어가기내용 들어가기내용 들어가기<br>용 들어가기내용 들어가기내용 들어가기 </p>
					 			<a href="#" class="actMore"><img src="/Project_JSP/img/main/btnPackMore.gif"/></a>
					 		</div>
					 		<div class="rightContent">
					 			<img src="#"/>  
					 		</div> 
			 			</div> 
			 		</div> 
			 		<div class="actBtnWrap">
			 			<a href="#" class="act_prev actBtn"></a> 
			 			<p>
			 				<span class="showSlide">3</span>
			 				<span class="split">/</span>
			 				<span class='maxSlide'>3</span>
			 			</p>
			 			<a href="#" class="act_next actBtn"></a>
			 		</div>
			 	</div> 
			</div> 
			
			<div class="bannerWrap">
			 	<div class="banContent rewardsWrap"> 
			 		<h2 class="rwTitle"><img src="/images/ko/seoul/main/rwTitle.gif" alt="신라리워즈"></h2>
			 		<ul class="rwDesc">
						<li class="first"><a href="#"><img src="/images/ko/seoul/main/rwDesc1.gif"></a></li>
						<li><a href="#"><img src="/images/ko/seoul/main/rwDesc2.gif"></a></li>
						<li class="last"><a href="#"><img src="/images/ko/seoul/main/rwDesc3.gif"></a></li>
					</ul>
					<div class="rwBenefit">
						<img src="/images/ko/jeju/main/rwBenefit.gif">
						<a href="http://www.shillahotels.com/membership/offers/benefits/memBenefitsIndex.do"><img src="/images/ko/jeju/main/btnRwMore.gif"></a>
					</div>
					<div class="rwJoin">
							<img src="/images/ko/seoul/main/rwCard.png">
							<a href="#" class="btnRwJoin"><img src="/images/ko/jeju/main/btnRwJoin.gif"></a>
					</div>
			 	</div>
			</div>
		</div>
	</section>
	<jsp:include page="WEB-INF/common/footer.jsp"/>
</body>
</html>