<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/reservation/common.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/common/common.js"></script>
</head>
<body>
	<div>
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp"/>
		</header>
		<section id="main">
			<table>
				<tr>
					<th>STEP1 날짜/인원/객실 선택</th>
					<th class="noSelect">STEP1 옵션 선택</th>
					<th class="noSelect">STEP1 고객 정보 입력</th>
					<th class="noSelect">STEP1 예약 완료</th>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp"/>
		</footer>
	</div>
</body>
</html>