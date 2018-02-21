<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 | 문의관리 | 답변  |The Shilla Hotel</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminpage/admin_qna_reply.css?v=3">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/adminpage/admin_qna_read.js"></script>
</head>
<body>
	<div> 
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp" />
		</header>

		<section>
			<div id="contentWrap">
				<jsp:include page="admin_leftMenu.jsp" />
				<div id="rightArea">
					<div id="wrap_title">
						<h1 id="title">문의내용</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">문의 관리</span> > <span id="board">문의내용</span>
						</div>
					</div>
					<div>
					<span class="t1_title">고객 문의 글</span>
						<table id='t1'>
						<tr>
								<th>제목</th>
								<td colspan="7" class="left_article">${client.title }</td>
								<th>등록일시</th>
								<fmt:formatDate value="${client.date }" pattern="yyyy-MM-dd" var="enrollDate"/>
								<td>${enrollDate }</td>
						</tr>
						
							<tr>
								<th>아이디</th>
								<c:if test="${client.id !=null}">
								<td>${client.id }</td>
								</c:if>
								<c:if test="${client.id ==null}">
									<td>비회원</td>
								</c:if>
								<th>이름</th>
								<td>${client.name }</td>
								<th>휴대전화</th>
								<td>${client.tel }</td>
								<th>이메일</th>
								<td id="email">${client.email }</td>
								<th>고객등급</th>
								<td id="clientGrade">${client.clientGrade }</td>
							</tr>
							<tr>
								<th class="left_title">문의 내용</th>
								<td colspan="9" id="qna_content" class="left_article">${content.content }</td>
								<c:if test="${client.path !=null}">
									<script>
									var path = "${client.path}";
									var img = path.substring(path.lastIndexOf("/")+1);

									if(img !="null"){
										$("#qna_content").prepend("<img src='${pageContext.request.contextPath}/"+path+"'><br>");
										
									}
									</script>
								</c:if>
							</tr>
						</table>
					</div>
					<c:if test="${reply.content ==null }">
						<div id="noAnswer">
							<span id="no_title">답변 하기</span>
							<div id="replycontent">
								<textarea rows="5" cols="90" id="reply_text"></textarea>
								<div id="btn">
								<input type="hidden" value="${reply.num }" id="hiddenNum">
									<a href="#" id="sendBtn"><img src="${pageContext.request.contextPath}/img/login/popFindIdBtnSubmit.gif"></a>
									<a href="#" id="clear"><img src="${pageContext.request.contextPath}/img/login/popFindIdBtnCancel.gif"></a>
								</div>
							
							</div>
							
						</div>
					</c:if>
					
					<c:if test="${reply.content !=null }">
					<div id="answer">
						<span class="t1_title">답변</span>
						<table id="t2">
							<tr>
								<th  class="left_title" id="answer_title">답변 내용</th>
								<td colspan="9" class="left_article">${reply.content}</td>
							</tr>
						</table>
					</div>
					
					</c:if>
					
					<div id="listBtn">
						<a href="adminQnA.do"><img src="${pageContext.request.contextPath}/img/mypage/btnGoList.gif"></a>
					</div>
				</div>
			</div>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp" />
		</footer>
	</div>
</body>
</html>