$(function(){
	// 화면 진입 시 초기 최종가격 합계 설정
	var ServiceCharge = Number($("#ServiceCharge").text().split(" 원")[0]);
	var Tax = Number($("#Tax").text().split(" 원")[0]);
	var finalPrice = Number($(".rightPriceBold").text().split(" 원")[0]);
	
	$("#finalPrice").text((ServiceCharge + Tax + finalPrice) + " 원" );
	
	
	// 가격 계산 함수
	function priceCal(){
		var basicPrice = Number($(".rightPriceBold").text().split(" 원")[0]);
		var priceArray = $(".sumPrice");
		var totalPrice = 0;

		for(var i = 0; i < priceArray.size(); i++){
			
			var css = $(priceArray[i]).parent().css("display");
			if(css == "block" || css == "inline"){
				totalPrice += Number($(priceArray[i]).text());
			}
		}
		
		totalPrice += basicPrice;
		$("#finalPrice").text(totalPrice + " 원");
		
	}
	
	
	// 옵션  select 
	$(document).on("click", ".optionCheckBox", function(){
		if($(this).prop("checked") == true){
			$(this).parents(".optionLi").find(".optionSelect").css("display", "inline");
			var optionName = $(this).next().text();
			var targetOption = $("span[id*='optionRightTextColor']");
			
			for(var i = 0; i <= targetOption.length; i++){
				
				if(optionName == $(targetOption[i]).text()){
					$("#optionRightTextColor" + (i+1)).css("display", "inline");
					$("#optionRightPrice"+(i+1)).css("display", "inline");
				}
			}
			
		}else if($(this).prop("checked") == false){
			$(this).parents(".optionLi").find(".optionSelect").css("display", "none");
			var optionName = $(this).next().text();
			var targetOption = $("span[id*='optionRightTextColor']");
			
			for(var i = 0; i <= targetOption.length; i++){
				
				if(optionName == $(targetOption[i]).text()){
					$("#optionRightTextColor" + (i+1)).css("display", "none");
					$("#optionRightPrice"+(i+1)).css("display", "none");
				}
			}
		}
		
		priceCal();
	})
	
	// 옵션  change
	$(".optionSelect").change(function(){
		var optionPrice = Number($(this).parents(".optionLi").find(".optionFinalPrice").text().split(" 원")[0]);
		var optionNum = Number($(this).val());

		var optionName = $(this).parents(".optionLi").find(".optionName").text().split(" 원")[0];
		var targetOption = $("span[id*='optionRightTextColor']");
		
		for(var i = 0; i <= targetOption.length; i++){
			if(optionName == $(targetOption[i]).text()){
				$("#optionRightPrice"+(i+1)).html("<span class='sumPrice'>" + (optionPrice * optionNum) + "</span> 원");
			}
		}
		
		priceCal();
	
	})
		
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
	
	// 왼쪽 DIV 버튼
	$("#leftBtn img").click(function(){
		location.href = "step1.do";
	})
	
	
	// 비회원 로그인
	$("#rightBtns img:eq(0)").click(function(){
		locationStep3();
	})
	
	// 회원 로그인
	$("#rightBtns img:eq(1)").click(function(){
		var loginText = $("#headNav > ul > li:eq(0)").text();
		if(loginText == "로그인"){
			$("#login").css("display", "block");
		}else{
			locationStep3();
		}
		
		
	})
	
	$("#closeLogin img").click(function(){
		$("#login").css("display", "none");
	})
	
	// 로그인 버튼
	$("#loginDiv img").click(function(){
		
		var id = $("input[name='id']").val();
		var pw = $("input[name='pw']").val();
		
		if(id == null || id == ""){
			alert("아이디를 입력해주세요.");
			$("input[name='id']").focus();
			return;
		}
		
		if(pw == null || pw == ""){
			alert("비밀번호를 입력해주세요.");
			$("input[name='pw']").focus();
			return;
		}
		
		$.ajax({
			url: "/Project_JSP/reservLogin.do?id=" + id + "&pw=" + pw,
			type : "get",
			dataType : "json",
			success : function(data){
				console.log(data);
				
				if(data.error1){
					alert(data.error1);
				}
				
				if(data.error3){
					alert(data.error3);
				}
				
				if(data.success){
					locationStep3();
				}
				
			}
		})
	})	
	
	// 예약 초기화 버튼
	$("#resetSpan").click(function(){
		location.replace("step1.do");
	})
	
	function locationStep3(){
		var checkIn = $("#thirdDiv div").eq(0).find(".rightText").text();
		var checkOut = $("#thirdDiv div").eq(1).find(".rightText").text();
		var stay = $("#thirdDiv div").eq(2).find(".rightText").text();
		var stayNum = $("#thirdDiv div").eq(3).find(".rightText").text();
		var roomInfo = $("#fourthDiv").find(".rightText").eq(0).text();
		var clientReq = $(".formBottom").eq(0).find("input").val();
		var roomImg = $("#fourthDiv img").attr("src");
		var priceArray = $(".sumPrice");
		var Option = "";

		
		for(var i = 0; i < priceArray.size(); i++){
			var css = $(priceArray[i]).parent().css("display");
			if(css == "block" || css == "inline"){
				Option += $(priceArray[i]).parent().prev().text() + "," + $(priceArray[i]).text() + "/";
			}
		}

		var basicPrice = $(".rightPriceBold").text().split(" 원")[0];
		var finalPrice = $("#finalPrice").text().split(" 원")[0];
		
		location.href = "step3.do?checkIn=" + checkIn + "&checkOut=" +checkOut + "&stay=" +stay + "&stayNum=" +stayNum + "&roomInfo=" +roomInfo + "&Option=" +Option + 
		"&finalPrice=" +finalPrice + "&clientReq=" +clientReq + "&roomImg=" + roomImg + "&basicPrice=" + basicPrice;
	}
	
})