<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="../css/common/common.css?ver=1">
<link rel="stylesheet" type="text/css"
	href="../css/adminpage/write_board.css?v=2">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="../js/common/common.js"></script>
<script type="text/javascript">
	$(function(){
		$("#select_email").change(function(){
			if($(this).val() != '직접입력'){
				$("#com").val($(this).val());
			}else{
				$("#com").val("");
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
							<img src="../img/common/locaton.gif" id="home"> > <span
								id="board">후기게시판</span>
						</div>


					</div>

					<form action="content.do" method="post">
						<input type="hidden" name="no" value="${board.num }">
						<table id="wrap_form">
							<tr>
								<th><span class="dot">*</span>제목</th>
								<td><input type="text" name="title" value="${board.title}"></td>
							</tr>
							<tr id="content">
								<th><span class="dot">*</span>내용</th>
								<td><textarea rows="7" cols="" name="content">${content.content}</textarea></td>
							</tr>
							<tr>
								<th><span class="dot">*</span>성명</th>
								<td><input type="text" name="name" value="${board.name}"></td>
							</tr>
							<tr>
								<th><span class="dot">*</span>이메일</th>
								<td><input type="text" name="email1"value="${email1}">
								<span id="email_">@ </span><input type="text" name="email2" id="com" value="${email2}">
								<select name="email3" id="select_email">
									<option>직접입력</option>
									<option>naver.com</option>
									<option>hanmail.net</option>
									<option>hotmail.com</option>
									<option>nate.com</option>
									<option>yahoo.co.kr</option>
									<option>empas.com</option>
									<option>gmail.com</option>
								</select></td>
							</tr>
							<tr>
								<th><span class="dot">*</span>휴대전화</th>
								<td><input type="tel" name="tell" value="${board.tel}"></td>
							</tr>
							
						</table>

							
						
						<div id="wrap_sub_btn">
							<input type="submit" value="수정" id="submit">
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