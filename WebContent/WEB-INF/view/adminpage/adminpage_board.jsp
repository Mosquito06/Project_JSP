<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/adminpage/free_board.css?v=1">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/adminpage/admin_board.js?v=12"></script>
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
						<h1 id="title">후기관리</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">관리자</span> > <span id="board">후기관리</span>
						</div>
					</div>
					
					<div>
						<form action="adminBoard.do" method="post">
						
						<table>
							<tr>
								<th></th>
								<th id="th1">번호</th>
								<th id="th2">제목</th>
								<th id="th3">작성자</th>
								<th id="th4">작성일</th>
								<th id="th5">조회</th>
							</tr>

							<c:if test="${error != null}">
								<tr>
									<td class="td1" colspan="6">게시물이 존재하지 않습니다.</td>

								</tr>
							</c:if>
							<c:if test="${boardList != null}">
								<c:forEach var="item" items="${boardList}">
									<tr>
										<td class="check"><input type="checkbox" value="${item.num}"></td>
										<td class="td1">${item.num}</td>
										<td class="td2"><a href="adminBoardContent.do?no=${item.num}&set=0">${item.title}</a></td>
										<td class="td3">${item.name}</td>
										<td class="td4"><fmt:formatDate value="${item.date}"
												pattern="yyyy-MM-dd" /></td>
										<td class="td5">${item.check}</td>
									</tr>
								</c:forEach>

							</c:if>
							<tr>
								<td class="td1" colspan="6" id="page_num"><script
										type="text/javascript">
								
									if(${change} ==1 ){
										for(var i=0;i<(${page}+1); i++){
											$("#page_num").append("<a href='adminBoard.do?page_num="+i+"'>  "+(i+1)+"  </a>");
										}
									}else{
										
										
											$("#page_num").append("<span>1</span>");
										
									}
								</script></td>
							</tr>
						</table>
						<div id="wrap_btn_style">
							<a href="adminBoard.do" class="btn_style">목록보기</a> 
							
							<a href="" class="btn_style" id="del_btn">삭제</a>
						</div>

						<div id="search_form">
							<div id="wrap_search">
								<select name="search_type">

									<option>제목</option>
									<option>작성자</option>
									<option>아이디</option>
								</select> <input type="text" name="search" id="search">
							</div>

							<input type="submit" value="검 색" id="btn_search">
						</div>

					</form>
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