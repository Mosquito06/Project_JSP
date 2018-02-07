<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/adminpage/free_board.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/common/common.js"></script>
</head>
<body>

	<div>
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp"/>
		</header>
			
		<section>
			<div id="wrap_title">
				<h1 id="title">게시판</h1>
				
			</div>
			<form>
				<table>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>작성일</th>
						<th>조회</th>
					</tr>
				</table>
			</form>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp"/>
		</footer>
	</div>
</body>
</html>