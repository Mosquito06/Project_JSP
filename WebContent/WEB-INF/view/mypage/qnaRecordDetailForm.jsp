<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 내역 | My Page |The Shilla Hotel</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/leftMenu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/qnaDetail.css?v=4">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mypage/qnaDetail.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp" />
	<section>
		<div id="contentWrap">
				<jsp:include page="mypageLeftMenu.jsp" />
				<div id="rightArea">
					<div id="wrap_title">
						<h1 id="title">문의내역</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> >My Page> <span
								id="board">문의 내역</span>
						</div>	
					</div>
					<span id="info1">회원님께서 문의하신 내역과 답변을 확인하실 수 있습니다.</span>
					
					<div id="qnaRecordContent">
					
						<div id="qna_table">
						<span class="t">문의내역</span>
							<table border="1">
							<tr>
								<th>제목</th>
								<td id="qna_title" class="all_title">${qnaboard.title}</td>
								<th>등록일자</th>
								<fmt:formatDate value="${qnaboard.date }" pattern="yyyy-MM-dd" var="qna_date"/>
								<td id="qna_date" class="all_date">${qna_date}</td>
							</tr>
							<tr>
								<th><span class="content_label">내용</span></th>
								<td colspan="3" id="qna_content" >${qnaContent.content }</td>
								<c:if test="${qnaboard.path !=null}">
									<script>
									var path = "${qnaboard.path}";
									var img = path.substring(path.lastIndexOf("/")+1);
									if(img !="null"){
										$("#qna_content").prepend("<img src='${pageContext.request.contextPath}/"+path+"'><br>");
										
									}
									</script>
									
								</c:if>
							
							</tr>
							</table>
						</div>
						
						<div id="answer_table">
						<span class="t answer_t">답변 ∨</span>
							<table border="1" id="hiddenTable">
								<tr>
									<th>답변여부</th>
									<c:if test="${reply.content ==null }">
										<td id="qna_answer">답변대기</td>
									</c:if>
									<c:if test="${reply.content !=null }">
										<td id="qna_answer">답변완료</td>
									</c:if>
									<th>답변일</th>
									<c:if test="${reply.time ==null }">
										<td id="qna_answer_date" class="all_date"></td>
									</c:if>
									<c:if test="${reply.time !=null }">
									<fmt:formatDate value="${reply.time }" pattern="yyyy-MM-dd" var="reply_date"/>
										<td id="qna_answer_date" class="all_date">${reply_date }</td>
									</c:if>
								</tr>
								<tr>
									<th><span class="content_label">답변내용</span></th>
									<c:if test="${reply.content ==null }">
										<td id="qna_reply_content" colspan="3"></td>
									</c:if>
									<c:if test="${reply.content !=null }">
										<td id="qna_reply_content" colspan="3">${reply.content }</td>
									</c:if>
								</tr>
							</table>
						</div>
						
						<div id="listBtn">
							<a href="qnaRecord.do"><img src="${pageContext.request.contextPath}/img/mypage/btnGoList.gif"></a>
						</div>
					</div>
				</div>
			</div>
	</section>
	<jsp:include page="/WEB-INF/common/footer.jsp"/>
</body>
</html>