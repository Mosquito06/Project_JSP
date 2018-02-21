<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="leftArea">
			 	<div id="lnbWrap">
			 		<h2 class="title">마이페이지</h2>
			 		<ul class="leftMenu">
			 			<c:if test="${sessionScope.MEMBER != null }">
			 			<li class="bMenu">
			 				<a href="mypage.do" class="noBorder" id="grade"><span>신라리워즈 등급</span></a>  
			 			</li>
			 			</c:if>
			 			<li class="bMenu">
			 				<a href="myReservation.do" class="noBorder"><span>예약확인/취소</span></a>  
			 			</li>
			 			<c:if test="${sessionScope.MEMBER != null }">
			 			<li class="bMenu">
			 				<a href="#"><span>개인정보</span></a>
			 				<ul id="member_info">
			 					<li id="profile"><a href="profile.do">프로필 수정</a></li>
			 					<li id="password"><a href="newPassword.do">비밀번호 변경</a></li>
			 					<li id="secession"><a href="secession.do">신라리워즈 탈회 요청</a></li>
			 				</ul>  
			 			</li>
			 			<li class="bMenu" id="question">
			 				<a href="#"><span>문의내역</span></a>
			 				<ul id="member_info">
			 					<li><a href="qna.do">문의하기</a></li>
			 					<li><a href="qnaRecord.do" id="qnaRecord">문의내역 확인</a></li>
			 				</ul>  
			 			</li>
			 			<li class="bMenu">
			 				<a href="${pageContext.request.contextPath }/board/free_board.do" class="noBorder"><span>후기게시판</span></a>  
			 			</li>
						</c:if>
			 		</ul>
			 	</div>
</div>