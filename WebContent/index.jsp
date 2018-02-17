<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>누구나 한번쯤 꿈꾸는 일상으로부터의 탈출 |대구신라호텔</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/main.css?v=29"> 
<link rel="stylesheet" type="text/css" href="css/reservation/jsCalendar.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/common/common.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript" src="js/reservation/jsCalendar.js"></script>
<script type="text/javascript" src="js/reservation/jsCalendar.lang.de.js"></script>
<script type="text/javascript" src="js/main.js?v=24"></script>  
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
			 	</div> 
			</div> 
			
			<div class="bannerWrap">
			 	<div class="banContent"> 
			 	
			 	</div>
			</div>
		</div>
	</section>
	<jsp:include page="WEB-INF/common/footer.jsp"/>
</body>
</html>