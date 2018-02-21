<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/adminpage/free_board.css?v=2">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>
<script type="text/javascript">
	$(function(){
		$("#writeDo").click(function(){
			var mId= "${MEMBER.id}";
			var nId= "${NONMEMBER.id}";
			if(mId != "" || nId != ""){
				location.href="write_board.do";
				
				return false;
			}else{
				alert("로그인하세요");
				return false;
			}
			
			
		})
	})
</script>
</head>

<body>

	<div>
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp" />
		</header>

		<section>
			<div id="contentWrap">
				<jsp:include page="leftMenu.jsp" />
				<div id="rightArea">

					<div id="wrap_title">
						<h1 id="title">후기 게시판</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath }/img/common/locaton.gif" id="home"> > <span
								id="board">후기게시판</span>
						</div>


					</div>

					<form action="free_board.do" method="post">

						<table>
							<tr>
								
								<th id="th1">번호</th>
								<th id="th2">제목</th>
								<th id="th3">작성자</th>
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
							<c:if test="${error != null}">
								<tr>
									<td class="td1" colspan="5">게시물이 존재하지 않습니다.</td>

								</tr>
							</c:if>
							
							<c:if test="${boardList != null}">
								<c:forEach var="item" items="${boardList}">
									<tr>
										
										<td class="td1">${item.num}</td>
										<td class="td2"><a href="content.do?no=${item.num}&set=0">${item.title}</a></td>
										<td class="td3">${item.name}</td>
										<td class="td4"><fmt:formatDate value="${item.date}"
												pattern="yyyy-MM-dd" /></td>
										<td class="td5">${item.check}</td>
									</tr>
								</c:forEach>

							</c:if>
							<tr>
								<td class="td1" colspan="5" id="page_num"><script
										type="text/javascript">
								
									if(${change} ==1 ){
										for(var i=0;i<(${page}+1); i++){
											$("#page_num").append("<a href='free_board.do?page_num="+i+"'>  "+(i+1)+"  </a>");
										}
									}else{
										
										for(var i=0;i<(${page}+1); i++){
											$("#page_num").append((i+1));
										}
									}
								</script></td>
							</tr>
						</table>
						<div id="wrap_btn_style">
							<a href="free_board.do" class="btn_style">목록보기</a> 
							<a href=""
								class="btn_style" id="writeDo">글쓰기</a>
						</div>

						<div id="search_form">
							<div id="wrap_search">
								<select name="search_type">

									<option>제목</option>
									<option>작성자</option>
								</select> <input type="text" name="search" id="search">
							</div>

							<input type="submit" value="검 색" id="btn_search">
						</div>

					</form>
				</div>
			</div>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp" />
		</footer>
	</div>
</body>
</html>