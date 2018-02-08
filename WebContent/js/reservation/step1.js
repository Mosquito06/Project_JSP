$(function(){
	
		// 로딩화면 구축
		$("#searchBtn").click(function(){
			$("section").addClass("backSetting");
			var $parent = $("div#container");
			startLoading($parent, "이용가능한 객실을 검색하는 중입니다.");
			
		})
		
		$(".importantImg").click(function(){
			var $parent = $("div#container");
			stopLoading($parent);
			$("section").removeClass("backSetting");
		})
	
		
		// 인원선택 버튼 이벤트
		$(".selectBtn .selectPlus img").click(function(){
			var imgPath = $(this).attr("src");
			var selectText = $(this).parents(".selectType").find(".selectText").text();
			var adultNum = Number($("#adultNum").text());
			var KidNum = Number($("#kidNum").text());
			var babyNum = Number($("#babyNum").text());
			
			if(imgPath.indexOf("selectPlus") > 0 && selectText == "성인"){
				adultNum++;
				$("#adultNum").text(adultNum);
			}else if(imgPath.indexOf("selectPlus") > 0 && selectText == "어린이"){
				KidNum++;
				$("#kidNum").text(KidNum);
			}else if(imgPath.indexOf("selectPlus") > 0 && selectText == "유아"){
				babyNum++;
				$("#babyNum").text(babyNum);
			}else if(imgPath.indexOf("noPlus") > 0){
				alert("객실 1실 당 성인과 소인 동반 시 최대 4인까지만 투숙 가능합니다.");
			}
			$(this).parents(".selectNum").find(".selectMinus img").attr("src", "/Project_JSP/img/reservation/selectMinus.png");
		
			var changeType = adultNum + KidNum + babyNum;
			
			if(changeType < 4){
				$(this).parents(".selectNum").find(".selectPlus img").attr("src", "/Project_JSP/img/reservation/selectPlus.png");
			}
			
			if(changeType >= 4){
				$(this).parents().find(".selectPlus img").attr("src", "/Project_JSP/img/reservation/noPlus.png");
			}
		})
		
		$(".selectBtn .selectMinus img").click(function(){
			var imgPath = $(this).attr("src");
			var selectText = $(this).parents(".selectType").find(".selectText").text();
			var adultNum = Number($("#adultNum").text());
			var KidNum = Number($("#kidNum").text());
			var babyNum = Number($("#babyNum").text());
			
		
			if(imgPath.indexOf("selectMinus") > 0 && selectText == "성인"){
				if(adultNum == 1){
					$("#adultNum").text(adultNum);
					$(this).parents(".selectNum").find(".selectMinus img").attr("src", "/Project_JSP/img/reservation/noMinus.png");
					return;
				}
				adultNum--;
				$("#adultNum").text(adultNum);
			}else if(imgPath.indexOf("selectMinus") > 0 && selectText == "어린이"){
				KidNum--;
				$("#kidNum").text(KidNum);
				if(KidNum == 0){
					$(this).parents(".selectNum").find(".selectMinus img").attr("src", "/Project_JSP/img/reservation/noMinus.png");
				}
			}else if(imgPath.indexOf("selectMinus") > 0 && selectText == "유아"){
				babyNum--;
				$("#babyNum").text(babyNum);
				if(babyNum == 0){
					$(this).parents(".selectNum").find(".selectMinus img").attr("src", "/Project_JSP/img/reservation/noMinus.png");
				}
			}
			var changeType = adultNum + KidNum + babyNum;
			
			if(changeType == 1){
				$(this).parents().find(".selectMinus img").attr("src", "/Project_JSP/img/reservation/noMinus.png");
				return;
			}
			
			if(changeType < 4){
				$(this).parents().find(".selectPlus img").attr("src", "/Project_JSP/img/reservation/selectPlus.png");
			}
		})
		
		// 어린이, 유아 안내문구
		$(".importantImg").eq(0).hover(function(){
			$("span.alertText").eq(0).css("display", "block");
		}, function(){
			$("span.alertText").eq(0).css("display", "none");
		})
		
		$(".importantImg").eq(1).hover(function(){
			$("span.alertText").eq(1).css("display", "block");
		}, function(){
			$("span.alertText").eq(1).css("display", "none");
		})
		
		
		
		
})