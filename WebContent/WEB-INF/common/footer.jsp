<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	footer{
		width:100%;
		font-family: Dotum,"돋움",sans-serif;
	}
	#footer_up{
		width:100%;
		background-color: #f1e3c4;
		height:172px;
		overflow: hidden;
	}
	#footer_up #footer_wrap{
		width:1200px;
		margin: 0 auto;
	}
	#footer_wrap #logo{
		width:250px;
		height:172px;
		background: url("img/logo.jpg") no-repeat center left;
		float:left;
	}
	#footer_up #content{
		float:right;
		height:162px;
		width:950px;
		margin:10px 0px;
		overflow: hidden;
	}
	#footer_up #content #content_logo{
		width:100%;
		height:62px;
		border-bottom:1px solid #C2C2C2;
		background: url("img/logo2.jpg") no-repeat;
	}
	#footer_up #content #cont{
		margin-top: 10px;
	}
	#footer_up #content #addr{
		font-size: 11px;
		width:280px;
		float: left;
		margin-right: 20px;
		margin-top: 10px;
	}
	#footer_up #cont #ul_link{
		margin-top: 20px;
		width:750px;
	}
	#footer_up #content #ul_link a{
		text-decoration: none;
		color:#856f56;
		font-size: 12px;
	}	
	#footer_up #cont #ul_link dl{
		margin: 0px;
	}
	#footer_up #cont #ul_link dl:FIRST-CHILD{
		padding-top: 5px;
	}
	#footer_up #content #ul_link dt{
		color:#856f56;
		font-weight: bold;
		width:80px;
	}
	#footer_up #content #ul_link dt,dd{
		font-size: 12px;
		float:left;
		height:10px;
		line-height:10px;
	}
	#footer_up #content #ul_link dd{
		width:70px;
		margin:0px;
		border-right:1px solid #C2C2C2;
		text-align: center;
	}
	#footer_up #content #ul_link dd:LAST-CHILD{
		border:none;
	}
	#footer_up #cont{
		position: relative;
	}
	#footer_up #cont #sns {
		width:150px;
		height:170px;
		position: absolute;
		right:0px;
		top:0px;
	}
	#footer_up #cont #sns dt{
		font-size: 16px;
		font-weight: bold;
		color:#856f56;
	}
	#footer_up #content #sns img{
		width:30px;
		height:30px;
	}
	#footer_up #content #sns dl{
		margin:0px;
		width:100%;
	}
	#footer_up #content #sns dd{
		margin-left:0px;
		float:left;
		width:50px;
		padding-top: 10px;
	}
	#footer_down_choice, #footer_down_info{
		width:1200px;
		margin: 0 auto;
	}
	#footer_down_choice{
		padding:20px 0px;
	}
	#footer_down_choice ul{
		list-style: none;
		 overflow: hidden; 
		width:800px !important;
		padding:0px;
		margin:0px;
	
	}
	#footer_down_choice ul li{
		float: left;
		 border-right:1px solid #BDBDBD; 
		text-align: center;
			height:15px;
		line-height: 10px; 
	}
	#footer_down_choice ul li:LAST-CHILD{
		border:none;
	}
	#footer_down_choice ul li a{
		text-decoration: none;
		display:block; 
		font-size: 14px;
	}
	#footer_down_choice #choice1, #choice2{
		width:100px;
		color:black;
	}
	#footer_down_choice #choice3{
		width:140px;
		color:#E0B94F;
	}
	#footer_down_choice #choice4{
		width:180px;
		color:#BDBDBD;
	}
	#footer_down_choice #choice5{
		width:190px;
		color:#BDBDBD;
	}
	#footer_down_info{
		color: #BDBDBD;
		border-top:1px solid #BDBDBD;
		padding:20px 0px;
		font-size: 13px;
	}
	#footer_down_info #ju{
		font-size: 10px;
	}
	#footer_down_info #copyright{
		color:#ABABAB;
		font-size: 12px;
	}
</style>
	<div id="footer">
		<div id="footer_up">
			<div id="footer_wrap">
				<div id="logo">
				</div>
				<div id="content">
					<div id="content_logo"></div>
					<div id="cont">
						<div id="addr"><span id="ju2">(주) </span>호텔신라<br>
							 대구광역시 남구 중앙대로 220, 3층(대명동, 다산빌딩)<br>
							 Tel.053-477-5580 Fax.053-722-0840
						</div>
						<div id="ul_link">
							<dl>
								<dt>소개</dt>
								<dd><a href="#">호텔소개</a></dd>
								<dd><a href="#">호텔정보</a></dd>
								<dd><a href="#">층별안내도</a></dd>
								<dd><a href="#">오시는길</a></dd>
							</dl>
							<br>
					
							<dl>
								<dt>고객문의</dt>
								<dd><a href="#">연락처</a></dd>
								<dd><a href="#">FAQ</a></dd>
								<dd><a href="#">문의하기</a></dd>
							</dl>
						</div>
						<div id="sns">
							<dl>
								<dt>SNS</dt>
								<dd><a href="https://www.facebook.com/theshillajeju"><img src="img/facebookIcon.png"></a></dd>
								<dd><a href="http://blog.naver.com/shillajeju_"><img src="img/blogicon.png"></a></dd>
								<dd><a href="https://plus.google.com/116571259877956708092"><img src="img/googleIcon.png"></a></dd>
							</dl>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="footer_down">
		<div id="footer_down_choice">
			<ul>
				<li><a href="#" id="choice1">회사소개 </a></li>
				<li><a href="#" id="choice2">사이트맵 </a></li>
				<li><a href="#" id="choice3">개인정보처리방침 </a></li>
				<li><a href="#" id="choice4">이메일 무단 수집 금지 </a></li>
				<li><a href="#" id="choice5">영상정보처리기기 운영방침</a></li>
			</ul>
		</div>
		<div id="footer_down_info">
			<span id="ju">(주) </span>호텔신라 대구광역시 남구 중앙대로 220, 3층(대명동, 다산빌딩) Tel.053-477-5580 Fax.053-722-0840 사업자번호:123-123-1234  대표이사 정영화<br>
			<span id="copyright">Copyright (C) HOTEL SHILLA CO.,LTD.ALL Rights Reserved.</span>	
		</div>
	</div>
</div>
    