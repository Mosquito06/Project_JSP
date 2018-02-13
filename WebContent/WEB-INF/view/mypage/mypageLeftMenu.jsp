<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="leftArea">
			 	<div id="lnbWrap">
			 		<h2 class="title">마이페이지</h2>
			 		<ul class="leftMenu">
			 			<li class="bMenu">
			 				<a href="#" class="noBorder"><span>예약 확인/취소</span></a>  
			 			</li>
			 			<li class="bMenu">
			 				<a href="#"><span>개인정보</span></a>
			 				<ul id="member_info">
			 					<li><a href="#">프로필 수정</a></li>
			 					<li><a href="#">비밀번호 변경</a></li>
			 					<li><a href="#">시라리워즈 탈회 요청</a></li>
			 				</ul>  
			 			</li>
			 			<li class="bMenu" id="question">
			 				<a href="#"><span>문의내역</span></a>  
			 			</li>
			 			<li class="bMenu">
			 				<a href="${pageContext.request.contextPath }/board/free_board.do" class="noBorder"><span>후기게시판</span></a>  
			 			</li>

			 		</ul>
			 	</div>
</div>