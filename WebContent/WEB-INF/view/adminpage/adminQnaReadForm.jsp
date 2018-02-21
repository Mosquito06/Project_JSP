<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/adminpage/admin_qna.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/adminpage/admin_qna.js"></script>
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
						<table>
							<tr>
								<th>아이디</th>
								<td>${client.id }</td>
								<th>이름</th>
								<td>${client.name }</td>
								<th>휴대전화</th>
								<td>${client.tel }</td>
								<th>이메일</th>
								<td>${client.email }</td>
								<th>고객등급</th>
								<td>${client.clientGrade }</td>
								<th>등록일시</th>
								<fmt:formatDate value="${client.date }" pattern="yyyy-MM-dd" var="enrollDate"/>
								<td>${enrollDate }</td>
							</tr>
							<tr>
								<th>문의 내용</th>
								<td colspan="12" id="qna_content">${content.content }</td>
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
					<div>
						<textarea rows="5" cols="50" id="reply"></textarea>
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