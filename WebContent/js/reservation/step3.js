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
	
	
})
