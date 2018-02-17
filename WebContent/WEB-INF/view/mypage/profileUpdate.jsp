<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필 수정 | 개인정보 | MyPage | The shilla Hotel</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/leftMenu.css">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/mypage/profileUpdate.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mypage/profileUpdate.js?v=1"></script>
</head>
<body>
	<div>
		<header>
			<jsp:include page="/WEB-INF/common/header.jsp" />
		</header>

		<section>
			<div id="contentWrap">
				<jsp:include page="mypageLeftMenu.jsp" />
				<div id="rightArea">

					<div id="wrap_title">
						<h1 id="title">프로필 수정</h1>
						<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> >My Page> 개인정보 > <span
								id="board">프로필 수정</span>
						</div>	
					</div>
					<div id="content">
						<div id="title_info">
							고객님의 정보를 언제든지 확인, 변경하실 수 있습니다. (추가적인 변경사항은 문의하기를 이용해주세요)
						</div>
						<div id="update_form">
							<div id="update_title">기본정보</div>
							<form action="profileUpdate.do" method="post" id="update">
								<table border="1">
									<tr class="bar">
										<th>성명(한글)</th>
										<td>${MEMBER.nameKo }</td>
									</tr>
									<tr class="bar">
										<th>성명(영문)</th>
										<td>${MEMBER.nameEn }</td>
									</tr>
									<tr class="bar">
										<th>생년월일</th>
										<fmt:formatDate value="${MEMBER.birth }" pattern="yyyy.MM.dd" var="birth"/>
										<td>${birth }</td>
									</tr>
									<tr class="bar">
										<th>아이디</th>
										<td>${MEMBER.id }</td>
									</tr>
									<tr class="bar">
										<th>이메일</th>
										<td>
											<input type="text" name="email1" onkeyup="this.value=this.value.replace(/[^a-zA-Z0-9]/g,'');" id="email1" class="import">
											@
											<input type="text" name="email2" onkeyup="this.value=this.value.replace(/[^a-zA-Z.]/g,'');" id="email2" class="import">
											<select id="e">
												<option value="">직접입력</option>
												<option value="naver.com">naver.com</option>
												<option value="hanmail.net">hanmail.net</option>
												<option value="hotmail.com">hotmail.com</option>
												<option value="nate.com">nate.com</option>
												<option value="yahoo.co.kr">yahoo.co.kr</option>
												<option value="empas.com">empas.com</option>
												<option value="dreamwiz.com">dreamwiz.com</option>
												<option value="freechal.com">freechal.com</option>
												<option value="lycos.co.kr">lycos.co.kr</option>
												<option value="korea.com">korea.com</option>
												<option value="gmail.com">gmail.com</option>
												<option value="hanmir.com">hanmir.com</option>
												<option value="paran.com">paran.com</option>
											</select>
											<a href="#" id="btnemail"><img src="${pageContext.request.contextPath}/img/join/emailConfirm.gif"></a>
											<p class="err">*이메일을 입력해주세요(필수항목)</p>
										</td>
									</tr>
									<tr class="bar">
										<th>휴대전화</th>
										<td><input type="text" name="phone" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');" class="import" id="phone">
											<p class="err">*휴대전화를 입력해주세요(필수항목)</p>
										</td>
									</tr>
									<tr class="bar">
										<th>자택번호</th>
										<td>
											<input type="text" name="home" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');" id="tel">
										</td>
									</tr>
									<tr>
										<th>주소</th>
										<td>
											<input type="text" name="addr1" readonly="readonly" id="zipcode"><a href="#" id="addressBtn"><img src="${pageContext.request.contextPath}/img/join/btnSchAddress.gif"></a><br>
											<input type="text" name="addr2" readonly="readonly" id="addr_main"><br>
											<input type="text" name="addr3" readonly="readonly" id="addr_detail">
										</td>
									</tr>
									
								</table>
								<input type="hidden" id="id" value="${MEMBER.id }">
								<script>
									$("input[name='phone']").val("${MEMBER.phone}");
									$("input[name='home']").val("${MEMBER.home}");
									var email ="${MEMBER.email}";
									var email1 = email.substring(0, email.indexOf("@"));
									var email2 = email.substring(email.indexOf("@")+1);
										$("input[name='email1']").val(email1);
										$("input[name='email2']").val(email2);
									var address="${MEMBER.address}";
									var zipcode = address.substring(0, address.indexOf("/"));
									var address1 = address.substring(address.indexOf("/")+1,address.lastIndexOf("/"));
									var address2 = address.substring(address.lastIndexOf("/")+1);
									
									$("input[name='addr1']").val(zipcode);
									$("input[name='addr2']").val(address1);
									$("input[name='addr3']").val(address2);
								</script>
							</form>
							<div id="btn">
									<a href="#" id="updateBtn"><img src="${pageContext.request.contextPath}/img/mypage/btnChange.gif"></a>
									<a href="profile.do"><img src="${pageContext.request.contextPath}/img/mypage/btnCancel.gif"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
				<div id="addr_box">
			<div id="addr_title">
				<h1>주소 찾기</h1>
				<div id='addr_img'>
					<img src="/Project_JSP/img/join/popLayerBtnClose.gif">
				</div>
			</div>
				<div id="addr_input">
					<label>도로명 주소</label>
					<input type="text" id="doro" placeholder="도로명 입력" style="ime-mode:active;" onkeyup="this.value=this.value.replace(/[^가-힣]/g,'');">
					<a href="#" id="search_addr"><img src="${pageContext.request.contextPath}/img/join/popAdressSchAddSchBtn.gif"></a>
				</div>
				<div id="addr_content">
				</div>
			</div>
			<div id="addr_bg"></div>
		</section>
		<footer>
			<jsp:include page="/WEB-INF/common/footer.jsp" />
		</footer>
	</div>
</body>
</html>