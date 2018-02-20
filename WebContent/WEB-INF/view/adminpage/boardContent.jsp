<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="../css/common/common.css">

<link rel="stylesheet" type="text/css"
	href="../css/adminpage/board_content.css?v=1">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../js/common/common.js"></script>

<script type="text/javascript">
	$(function(){
		$("#btn_del").click(function(){
			var mId= "${MEMBER.id}";
			var nId= "${NONMEMBER.id}";
			var dId = "${board.id}";
			if(mId == dId || nId == dId){
				var ask = confirm("정말 삭제하시겠습니까?");
				if(ask){
					location.href="content.do?no=${board.num}&set=2";
				}
			}else{
				alert("삭제권한이 없습니다.");
				return false;
			}
			
			return false;
		});
		
		$(".update_btn").click(function(){
			$(".hide").hide();
			var mId= "${MEMBER.id}";
			var nId= "${NONMEMBER.id}";
			var cId = $(this).parent().parent().find(".commentId").val();
			
			if(mId == cId || nId == cId){
				$(this).parent().parent().next().show();
			}else{
				alert("수정권한이 없습니다.");
				return false;
			}
			
			return false;
		});
		
		$(".del_btn").click(function(){
			var mId= "${MEMBER.id}";
			var nId= "${NONMEMBER.id}";
			var cId = $(this).parent().parent().find(".commentId").val();
			var no = $(this).find(".item_no").val();
			if(mId == cId || nId == cId){

				location.href="commentSet.do?num="+no+"&no=${board.num}&set=1&page=1";
			}else{
				alert("삭제권한이 없습니다.");
				return false;
			}
			
			return false;
		});
		
		$("#btn_update").click(function(){
			var mId= "${MEMBER.id}";
			var nId= "${NONMEMBER.id}";
			var dId = "${board.id}";
			if(mId == dId || nId == dId){
				
				location.href="content.do?no=${board.num}&set=1";
				
			}else{
				alert("수정권한이 없습니다.");
				return false;
			}
			
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
				<jsp:include page="leftMenu.jsp" />
				<div id="rightArea">
					<div id="wrap_title">
						<h1 id="title">후기 게시판</h1>
						<div id="wrap_home">
							<img src="../img/common/locaton.gif" id="home"> > <span
								id="board">후기게시판</span>
						</div>
					</div>


					<div id="wrap_content">
						<input type="hidden" value="${board.id}" id="board_id">
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
							<a href="free_board.do" class="btn_style">목록보기</a> 
							<a href="" class="btn_style" id="btn_update">글수정</a>
							<a href="#" class="btn_style" id="btn_del">삭제</a>
						</div>
						<div> 
						
							<c:if test="${comment.size() !=0}">
							<p id="comment_">댓글목록</p>
								<table id="comment_table">
									<c:forEach items="${comment}" var="item">
										<tr>
											<td class="t1"><input type="hidden" value="${item.id}" class="commentId">${item.content}</td>
											<td class="t2"><span class="t_title">${item.writer}</span>님</td>
											<td class="t3">작성일 : <fmt:formatDate value="${item.time}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
											
											<td class="t4"><a href="" class="update_btn btn_style2">수정</a></td>
											<td class="t5">
												<a href="" class="del_btn btn_style2">
													<input type="hidden" value="${item.num}" class="item_no">
													
												X</a>
											
											</td>
										</tr>
										<tr class="hide">
											<td colspan="5">
												<div class="wrap_comment">
													<form method="get" action="commentSet.do">
														<p>댓글수정</p>
														<label>이름</label>
														<input type="text" name="up_name" class="name" value="${item.writer}">
														<input type="text" name="up_content" class="textarea" value="${item.content}">
														<input type="hidden" name="no" value="${board.num}">
														<input type="hidden" name="set" value="2">
														<input type="hidden" name="page" value="1">
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
						<c:if test="${MEMBER != null || NONMEMBER !=null}">
							<div class="wrap_comment">
								
								<p>댓글달기</p>
									
								<form method="get" action="comment.do">
									<label>이름</label>
									<input type="hidden" name="set" value="1">
									<c:if test="${NONMEMBER !=null }">
										<input type="text" name="name" class="name" value="${NONMEMBER.nameKo}" readonly="readonly">
										<input type="hidden" name="id" value="${NONMEMBER.id}">
									</c:if>
									<c:if test="${MEMBER !=null }">
										<input type="text" name="name" class="name" value="${MEMBER.nameKo}" readonly="readonly">
										<input type="hidden" name="id" value="${MEMBER.id}">
									</c:if>
									<input type="text" name="content" class="textarea">
									<input type="hidden" name="no" value="${board.num}">
									<input type="submit" class="btn_style" value="보내기" id="sClick">
								</form>
							</div>
						</c:if>
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