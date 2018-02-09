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
	href="../css/common/common.css?ver=1">

<link rel="stylesheet" type="text/css"
	href="../css/adminpage/board_content.css?v=3">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../js/common/common.js"></script>

<script type="text/javascript">
	$(function(){
		$("#btn_del").click(function(){
			var ask = confirm("정말 삭제하시겠습니까?");
			if(ask){
				location.href="content.do?no=${board.num}&set=2";
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
							<p>${content.content}</p>
						</div>
						<div id="wrap_btn_style">
							<a href="free_board.do" class="btn_style">목록보기</a> 
							<a href="content.do?no=${board.num}&set=1" class="btn_style" id="btn_update">글수정</a>
							<a href="#" class="btn_style" id="btn_del">삭제</a>
						</div>
						<div>
							<p>댓글달기</p>
							<textarea >
							</textarea>
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