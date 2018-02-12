<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
 var contextPath = "${pageContext.request.contextPath }";
</script>
<div id="headerWrap">   
		<div id="header">
			<div id="hotelSearch">
				<a href="#" class="openList"><img src="${pageContext.request.contextPath }/img/common/hotolIcon.png"></a>
				<ul id="hotelList" class="hide">
					<li><a href="#" class="selTitle">The Shilla</a></li>
					<li><a href="#">서울신라호텔</a></li>
					<li><a href="#">제주신라호텔</a></li>
					<li><a href="#" class="selTitle">Shilla Stay</a></li>
					<li><span class="stayHead">서울 강북</span></li>
					<li><a href="#">신라스테이 광화문</a></li>
					<li><a href="#">신라스테이 마포</a></li>  
					<li><a href="#">신라스테이 서대문</a></li>
					<li><span class="stayHead">서울 강남</span></li> 
					<li><a href="#">신라스테이 역삼</a></li>
					<li><a href="#">신라스테이 서초</a></li>  
					<li><a href="#">신라스테이 서초</a></li>
					<li><a href="#">신라스테이 구로</a></li>  
					<li><span class="stayHead">전국</span></li>
					<li><a href="#">신라스테이 동탄</a></li>
					<li><a href="#">신라스테이 천안</a></li>  
					<li><a href="#">신라스테이 울산</a></li>
					<li><a href="#">신라스테이 해운대</a></li>
					<li><a href="#">신라스테이 제주</a></li>
				</ul>
			</div>

			<h1 id="head_logo"><a href="${pageContext.request.contextPath }/index.jsp"><img src="${pageContext.request.contextPath }/img/common/logo.jpg"></a></h1>
			<div id="headNav"> 
				<ul>  
					<li><a href="${pageContext.request.contextPath }/login.do">로그인</a></li>
					<li><a href="#">신라리워즈 가입</a></li>
					<li><a href="#">예약확인</a></li>
					<li><a href="${pageContext.request.contextPath }/admin.do">관리자</a></li>
				</ul>
			</div>  
		</div>
		
		<div id="header_gnb">
			<div id="navWrap"> 
			<ul id="mainNav">
				<li><a href="#">스페셜 오퍼</a>
					<ul class="subNav">
						<li><a href="#">객실패키지</a></li>
						<li><i class="line"></i></li>
						<li><a href="${pageContext.request.contextPath }/event/eventlist.do">이벤트</a></li>
					</ul>
				</li>
				<li><a href="#">객실</a>
					<ul class="subNav">
						<li><a href="#">스탠다드</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">프리미어</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">스위트</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">전체 객실 보기</a></li>
					</ul>
				</li>
				<li><a href="#">다이닝</a>
					<ul class="subNav">
						<li><a href="#">레스토랑</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">라운지 & 바</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">베이커리</a></li>
					</ul>
				</li>
				<li><a href="#">액티비티</a>
					<ul class="subNav">
						<li><a href="#">글램핑 & 캠핑</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">레저 전문간 서비스</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">키즈 시설</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">피트니스</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">와인파티</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">갤러리 투어</a></li>						
						<li><i class="line"></i></li>
						<li><a href="#">숨비정원</a></li>						
						<li><i class="line"></i></li>
						<li><a href="#">플레이스테이션 게임 존</a></li>
					</ul>  
				</li>
				<li><a href="#">부대시설</a>
					<ul class="subNav">
						<li><a href="#">숨비 스파 존</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">카바나</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">스파</a></li>
						<li><i class="line"></i></li> 
						<li><a href="#">라운지 예스</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">연회장</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">비즈니스</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">아케이드</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">렌터카</a></li>
					</ul> 
				</li>
				<li><a href="#">갤러리</a>
					<ul class="subNav">
						<li><a href="#">사진</a></li>
						<li><i class="line"></i></li>
						<li><a href="#">동영상</a></li>
					</ul>
				</li>
			</ul>
			
			<a href="${pageContext.request.contextPath }/step1.do" id="reservationBtn">
				예약
			</a>			
		</div>
		<div class="subBg">
		</div>
		</div>
		
	</div>