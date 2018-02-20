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
	href="${pageContext.request.contextPath }/css/common/common.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/adminpage/board_content.css?v=1">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common/common.js"></script>

<script type="text/javascript">
	$(function(){
		$("#btn_del").click(function(){
			var ask = confirm("정말 삭제하시겠습니까?");
			if(ask){
				location.href="adminBoardContent.do?no=${board.num}&set=2";
			}
			return false;
		});
		
		$(".update_btn").click(function(){
			$(".hide").hide();
			$(this).parent().parent().next().show();
			return false;
		});
		 
		
		
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
				<jsp:include page="admin_leftMenu.jsp" />
				<div id="rightArea">
					<div id="wrap_title">
						<h1 id="title">후기관리</h1>
						<div id="wrap_home">
							<img
								src="${pageContext.request.contextPath}/img/common/locaton.gif"
								id="home"> > <span id="board">관리자</span> > <span
								id="board">후기관리</span>
						</div>
					</div>


					<div id="wrap_content">
					
						<h1 id="b_title">${board.title}</h1>
						<div id="wrap_div">
							<ul id="wrap_name">
								<li class="f_li">작성자</li>
								<li>${board.name}</li>
							</ul>
							<ul id="wrap_date">
								<li class="f_li">날짜</li>
								<li><fmt:formatDate value="${board.date}"
										pattern="yyyy-MM-dd" /></li>
							</ul>
							<ul id="wrap_no">
								<li class="f_li">조회수</li>
								<li>${board.check}</li>
							</ul>
						</div>
						<div id="content_wrap">
							<c:if test="${board.path != '0'}">
								<p><img src="${board.path}"></p>
							</c:if>
							<p>${content.content}</p>
						</div>
						<div id="wrap_btn_style">
							<a href="adminBoard.do" class="btn_style">목록보기</a> 
							
							<a href="#" class="btn_style" id="btn_del">삭제</a>
						</div>
						<div> 
						
							<c:if test="${comment.size() !=0}">
							<p id="comment_">댓글목록</p>
								<table id="comment_table">
									<c:forEach items="${comment}" var="item">
										<tr>
											<td class="t1">${item.content}</td>
											<td class="t2"><span class="t_title">${item.writer}</span>님</td>
											<td class="t3">작성일 : <fmt:formatDate value="${item.time}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
											
											<td class="t4"><a href="" class="update_btn btn_style2">수정</a></td>
											<td class="t5"><a href="board/commentSet.do?num=${item.num}&no=${board.num}&set=1&page=2" class="btn_style2">X</a></td>
										</tr>
										<tr class="hide">
											<td colspan="5">
												<div class="wrap_comment">
													<form method="get" action="board/commentSet.do">
														<p>댓글수정</p>
														<label>이름</label>
														<input type="text" name="up_name" class="name" value="${item.writer}">
														<input type="text" name="up_content" class="textarea" value="${item.content}">
														<input type="hidden" name="no" value="${board.num}">
														<input type="hidden" name="set" value="2">
														<input type="hidden" name="page" value="2">
														<input type="hidden" name="num" value="${item.num}">
														<input type="submit" class="btn_style" value="수정">
													</form>
												</div>
											</td>
										</tr>
									</c:forEach>
								</table>
							</c:if>
							
						</div>
						<div class="wrap_comment">
							
							<p>댓글달기</p>
								
							<form method="get" action="board/comment.do">
								<label>이름</label>
								<input type="hidden" name="set" value="2">
								<input type="text" name="name" class="name" value="관리자" readonly="readonly">
								<input type="text" name="content" class="textarea">
								
								<input type="hidden" name="no" value="${board.num}">
								
								<input type="submit" class="btn_style" value="보내기">
							</form>
						</div>
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