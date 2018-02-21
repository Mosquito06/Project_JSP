<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 ㅣThe Shilla Hotel</title>
<link rel="stylesheet" type="text/css" href="css/common/reset.css">
<link rel="stylesheet" type="text/css" href="css/common/common.css">
<link rel="stylesheet" type="text/css" href="css/join/joinForm.css?v=2">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script> 
<script src="js/common/common.js"></script>
<script src="js/join/joinForm.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/common/header.jsp"/>
	
	<section>
	<div id="addr_bg"></div>
		<div id="join_wrap">
			<div id="join_title">
				<h1>회원가입</h1>
					<div id="wrap_home">
							<img src="${pageContext.request.contextPath}/img/common/locaton.gif" id="home"> > <span
								id="board">신라리워즈 가입</span>
					</div>	
			</div>
			<div id="join_title_info">
				<ul>
					<li>회원정보입력</li>
					<li>가입완료</li>
				</ul>	
			</div>
			
			<div id="info_insert">
				<h1>회원정보 입력</h1>
				<form action="join.do" method="post" id="join">
					<div id="info_basic">
						<div id="info_basic_title">
							<h1>기본 입력</h1>
							<h1><span class="star">*</span>표시 필수입력사항</h1>
						</div>
						<div id="info_basic_input">
							<p>
								<label><span class="star">*</span>성명(한글)</label>
								<input type="text" name="nameKo" style="ime-mode:active;" onkeyup="this.value=this.value.replace(/[^가-힣]/g,'');" class="import">
								<img src="img/join/x.png" class="x-btn">
								<span class="error">성명(이름)을 입력하세요(*필수)</span>
							</p>
							<p>
								<label><span class="star">*</span>성명(영문)</label>
								<span class="ename">First name(이름)</span>
								<input type="text" name="nameEn1" style="text-transform:uppercase; ime-mode:disabled;" onkeyup="this.value=this.value.replace(/[^a-zA-Z]/g,'');" class="import">
								<img src="img/join/x.png" class="x-btn">
								<span class="ename">Last name(성)</span>
								<input type="text" name="nameEn2" style="text-transform:uppercase; ime-mode:disabled;" onkeyup="this.value=this.value.replace(/[^a-zA-Z]/g,'');" class="import">
								<img src="img/join/x.png" class="x-btn">
								<span class="error">성명(영문) 입력(*필수)</span>
							</p>
							<p>
								<label><span class="star">*</span>생년월일</label>
								<span id="birth_select">
									<select name="birth_y" class="import2">
										<option value="">년도 선택</option>
									</select> 년 
									<select name="birth_m" class="import2">
										<option value="">월 선택</option>
									</select> 월 
									<select name="birth_d" class="import2">
										<option value="">일 선택</option>
									</select> 일
								</span>
								<span class="error">생년월일을 입력하세요(*필수)</span>
							</p>
							
								<p>
								<label><span class="star">*</span>이메일</label>
								<input type="text" name="email1" id="email1" class="import" style="ime-mode:disabled;" onkeyup="this.value=this.value.replace(/[^a-zA-Z0-9]/g,'');" ><img src="img/join/x.png" class="x-btn">
								@
								<input type="text" name="email2" id="email2" class="import" style="ime-mode:disabled;" onkeyup="this.value=this.value.replace(/[^a-zA-Z.]/g,'');"><img src="img/join/x.png" class="x-btn">
								<span id="email_select">
									<select id="sel_email">
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
								</span>
									<a href="#" id="email_btn"><img src="${pageContext.request.contextPath}/img/join/emailConfirm.gif"></a>
									<span class="error email_err">이메일 입력</span>
									<span id="email_duplicate" class="email_err">사용가능</span>
									<span id="email_duplicate_error" class="email_err">사용불가(중복)</span>
							</p>
							<p>
								<label><span class="star">*</span>휴대전화</label>
								<span id="p_select">
									<select name="p1">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="017">017</option>
									<option value="018">018</option>
									<option value="019">019</option>
								</select>
								</span>
								
								<input type="tel" name="p2" class="import" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');"><img src="img/join/x.png" class="x-btn">
								-
								<input type="tel" name="p3"  class="import" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');"><img src="img/join/x.png" class="x-btn">
								<span class="error">휴대전화를 입력하세요(*필수)</span>
							</p>
							<p>
								<label>자택전화</label>
								<span id="t_select">
										<select name="t1">
									<option value="">선택</option>
									<option value="02">02</option>
									<option value="031">031</option>
									<option value="032">032</option>
									<option value="033">033</option>
									<option value="041">041</option>
									<option value="042">042</option>
									<option value="043">043</option>
									<option value="044">044</option>
									<option value="051">051</option>
									<option value="052">052</option>
									<option value="053">053</option>
									<option value="054">054</option>
									<option value="055">055</option>
									<option value="061">061</option>
									<option value="019">062</option>
									<option value="062">063</option>
									<option value="064">064</option>
									<option value="0130">0130</option>
									<option value="080">080</option>
									<option value="070">070</option>
									<option value="0506">0506</option>
									<option value="0502">0502</option>
									<option value="0503">0503</option>
									<option value="0504">0504</option>
									<option value="0507">0507</option>
									<option value="0505">0505</option>
									<option value="0303">0303</option>
								</select>
								</span>
							
								<input type="tel" name="t2" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');"><img src="img/join/x.png" class="x-btn">
								-
								<input type="tel" name="t3" onkeyup="this.value=this.value.replace(/[^0-9]/g,'');"><img src="img/join/x.png" class="x-btn">
							</p>
							<p>
								<label>주소</label>
								<input type="text" name="addr1" readonly="readonly" id="zipcode"><a href="#" id="addr_btn"><img src="${pageContext.request.contextPath}/img/join/btnSchAddress.gif"></a><br>
								<input type="text" name="addr2" readonly="readonly" id="addr_main"><br>
								<input type="text" name="addr3" readonly="readonly" id="addr_detail">
							</p>
							
						</div>
					</div>
				<div id="web_join_info">
					<div id="web_join_info_title">
						<h1>웹사이트 비밀번호 입력</h1>
					</div>
					<div id="web_join_info_input">
						<p>
								<label><span class="star">*</span>아이디</label>
								<input type="text" name="id" class="import" style="ime-mode:disabled;" onkeyup="this.value=this.value.replace(/[^a-zA-Z0-9]/g,'');"><img src="img/join/x.png" class="x-btn">
								<a href="#" id="id_check_btn"><img src="${pageContext.request.contextPath}/img/join/idConfirm.gif"></a>
								<span id="id_info">5~12 이내 영문 또는 영문/숫자 조합</span>
									<span class="error id_errs">아이디를 확인하세요(*필수)</span>
									<span id="id_error" class="id_errs">사용가능한 아이디입니다.</span>
									<span id="id_error2" class="id_errs">중복 아이디입니다(사용불가)</span>
									<span id="click" class="id_errs">중복체크를 해주세요</span>
									<span id="id_rule_error" class="id_errs">영문 또는 영문/숫자만 가능</span>
												
						</p>
						<p>
								<label><span class="star">*</span>비밀번호</label>
								<input type="password" name="pw" class="import"><img src="img/join/x.png" class="x-btn">
									<img src="/Project_JSP/img/join/important.gif" id="pw_import">		
								<span class="error">비밀번호를 입력하세요(*필수)</span>
								<span id="pw_reg">사용가능한 비밀번호입니다</span>
								<span id="pw_reg_error">사용불가한 비밀번호입니다</span>
						</p>
						<p>
								<label><span class="star">*</span>비밀번호 확인</label>
								<input type="password" name="pw2" class="import" id="pw_ok"><img src="img/join/x.png" class="x-btn">
									<span class="error" id="noPw">비밀번호를 확인해주세요(*필수)</span>
									<span id="okPw">비밀번호가 일치합니다.</span>
						</p>
					</div>
				</div>
				</form>
				
			</div>
			<div id="sendBtn">
					<a href="#" id="join_btn"><img src="${pageContext.request.contextPath}/img/join/btnJoinSend.gif"></a>
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
	</section>
	<div id="pw_info">
		<p>비밀번호는 8~20자 이내여야 합니다</p>
		<p>최소한 한번의 대,소문자,숫자,특수기호가 모두 들어가야합니다</p>
		<p>특수기호는 '@!%*?&'만 허용됩니다</p>
		<p>동일한 숫자를 4번 이상 사용할 수 없습니다</p>
	</div>
	<jsp:include page="/WEB-INF/common/footer.jsp"/>

</body>
</html>