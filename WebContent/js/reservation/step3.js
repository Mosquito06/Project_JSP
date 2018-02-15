$(function(){
	// 요청사항 및 유의사항 접기
	$(".arrowSpan img").click(function(){
		var imgPath = $(this).attr("src");
		if(imgPath.indexOf("upArrow") > 0){
			$(this).parents(".additionForm").find(".formBottom").css("display", "none");
			$(this).attr("src", "/Project_JSP/img/reservation/downArrow.png");
		}else if(imgPath.indexOf("downArrow") > 0){
			$(this).parents(".additionForm").find(".formBottom").css("display", "block");
			$(this).attr("src", "/Project_JSP/img/reservation/upArrow.png");
		}
	})
	
	// 로그인 상태일 시 투숙자 정보 입력 input 불가
	var loginText = $("#headNav > ul > li:eq(0)").text();
	if(loginText == "로그아웃"){
		$("input[id='name(kor)']").attr("disabled", "disabled");
		$("input[id='name(eng)']").attr("disabled", "disabled");
		$("input[id='email']").attr("disabled", "disabled");
		$("input[name='firstName']").attr("disabled", "disabled");
		$("input[name='lastName']").attr("disabled", "disabled");
		$("#clientInfoDiv select").attr("disabled", "disabled");
		$("input[id='tel']").attr("disabled", "disabled");
	}
	
	
	// 예약 초기화 버튼
	$("#resetSpan").click(function(){
		location.replace("step1.do");

	})
	
	// 필수입력 사항 입력여부 확인
	$("#rightBtn img").click(function(){
		if($("input[name='name']").val() == ""){
			$("input[name='name']").focus();
			alert("성명(한글)을 입력해주세요.");
			return;
		}
		
		if($("input[name='firstName']").val() == ""){
			$("input[name='firstName']").focus();
			alert("성명(영문)을 입력해주세요.");
			return;
		}
		
		if($("input[name='lastName']").val() == ""){
			$("input[name='lastName']").focus();
			alert("성명(영문)을 입력해주세요.");
			return;
		}
		
		if($("input[id='email']").val() == ""){
			$("input[id='email']").focus();
			alert("이메일을 입력해주세요.");
			return;
		}
		
		if($("input[id='tel']").val() == ""){
			$("input[id='tel']").focus();
			alert("전화번호를 입력해주세요.");
			return;
		}
		
		if($("input[id='cardNum']").val() == ""){
			$("input[id='cardNum']").focus();
			alert("카드번호를 입력해주세요.");
			return;
		}
		
		if($("#clientRight select:eq(1)").val() == "월"){
			$("#clientRight select:eq(1)").focus();
			alert("만기일을 입력해주세요.");
			return;
		}
		
		if($("#clientRight select:eq(2)").val() == "년"){
			$("#clientRight select:eq(2)").focus();
			alert("만기일을 입력해주세요.");
			return;
		}
		
		if($("#agreeLeft .agreeRadio input").eq(0).prop("checked") == false){
			alert("필수정보에 동의해주세요.");
			return;
		}
		
		if($("#agreeRight .agreeRadio input").eq(0).prop("checked") == false){
			alert("필수정보에 동의해주세요.");
			return;
		}
		
		
	})
	
	
	
	
	
})
