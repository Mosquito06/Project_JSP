<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/common/reset.css">
<link rel="stylesheet" type="text/css" href="../css/common/common.css">
<link rel="stylesheet" type="text/css"
	href="../css/adminpage/free_board.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../js/common/common.js"></script>
</head>
<body>

	<div>
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp" />
		</header>

		<section>
			<div id="wrap_title">
				<h1 id="title">게시판</h1>
				<div id="wrap_home">
					<img src="../img/common/locaton.gif" id="home">
					> <span id="board">게시판</span>
				</div>
				
				
			</div>
			<form>
				<table>
					<tr>
						<th id="th1">번호</th>
						<th id="th2">제목</th>
						<th id="th3">글쓴이</th>
						<th id="th4">작성일</th>
						<th id="th5">조회</th>
					</tr>
					
					<!-- <tr>
						<td class="td1">11233</td>
						<td class="td2"><a href="#">게시판 테스트중</a></td>
						<td class="td3">이강현</td>
						<td class="td4">2018.02.07</td>
						<td class="td5">1</td>
					</tr> -->
					<c:if test="${boardList == null}">
						<tr>
							<td class="td1" colspan="5">게시물이 존재하지 않습니다.</td>
							
						</tr>
					</c:if>
					<c:if test="${boardList != null}">
						<c:forEach var="item" items="${boardList}">
							<tr>
								<td class="td1">${item.num}</td>
								<td class="td2"><a href="#">${item.title}</a></td>
								<td class="td3">${item.name}</td>
								<td class="td4">${item.date}</td>
								<td class="td5">${item.check}</td>
							</tr>
						</c:forEach>
						
					</c:if>
					
				</table>
				<div id="search_form">
					<div id="wrap_search">
						<select>
							<option>제목&내용</option>
							<option>제목</option>
							<option>내용</option>
							<option>글쓴이</option>
						</select>
						 
						<input type="text" name="search" id="search">
					</div>
					
					<input type="submit" value="검 색" id="btn_search">
				</div>
			</form>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp" />
		</footer>
	</div>
</body>
</html>