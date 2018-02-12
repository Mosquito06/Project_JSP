$(function(){
	// 화면 진입 시 초기 최종가격 합계 설정
	var ServiceCharge = Number($("#ServiceCharge").text().split(" 원")[0]);
	var Tax = Number($("#Tax").text().split(" 원")[0]);
	var finalPrice = Number($("#finalPrice").text().split(" 원")[0]);
	
	$("#finalPrice").text((ServiceCharge + Tax + finalPrice) + " 원" );
	
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
					$("#finalPrice").text(Number($("#finalPrice").text().split(" 원")[0]) + 
							Number($("#optionRightPrice"+(i+1)).text().split(" 원")[0]) + " 원");
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
					$("#finalPrice").text(Number($("#finalPrice").text().split(" 원")[0]) - 
							Number($("#optionRightPrice"+(i+1)).text().split(" 원")[0]) + " 원");
				}
			}
		}
	})
	
	// 옵션  change
	$(".optionSelect").change(function(){
		var optionPrice = Number($(this).parents(".optionLi").find(".optionFinalPrice").text().split(" 원")[0]);
		var optionNum = Number($(this).val());
		
		var optionName = $(this).parents(".optionLi").find(".optionName").text().split(" 원")[0];
		var targetOption = $("span[id*='optionRightTextColor']");
		
		for(var i = 0; i <= targetOption.length; i++){
			if(optionName == $(targetOption[i]).text()){
				$("#optionRightPrice"+(i+1)).text((optionPrice * optionNum) + " 원");
			}
		}

		$("#finalPrice").text(Number($("#finalPrice").text().split(" 원")[0]) + 
				(optionPrice * optionNum) + " 원");
		
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
	
	$("#rightBtns img:eq(0)").click(function(){
		alert("비회원");
	})
	
	$("#rightBtns img:eq(1)").click(function(){
		alert("회원");
	})
	
	// 예약 초기화 버튼
	$("#resetSpan").click(function(){
		location.replace("step1.do");
	})
	
	
	
	
})