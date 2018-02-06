var onOff = true;
	$(function(){  
		$(".subNav").addClass("hide");
		$(".subBg").addClass("hide");
		
		$("#mainNav>li").mouseover(function() {
			$(this).find(".subNav").removeClass("hide");
			$(this).find(".subNav").addClass("active");   
			$(".subBg").removeClass("hide");
			$(".subBg").addClass("active");
		})
		
		$("#mainNav>li").mouseout(function() {
			$(this).find(".subNav").removeClass("active");
			$(this).find(".subNav").addClass("hide"); 
			$(".subBg").removeClass("active");
			$(".subBg").addClass("hide");
		})  
		
		
		$("#hotelSearch").click(function(){
			if(onOff){
				$(this).find("img").attr("src", "img/common/hotolIcon_ko_on.png");
				$("#hotelList").addClass("active");
				$("#hotelList").removeClass("hide");
				onOff = false;
			}else{
				$(this).find("img").attr("src", "img/common/hotolIcon.png");
				$("#hotelList").addClass("hide");
				$("#hotelList").removeClass("active");
				onOff = true;
			}
		})  
		$("#hotelSearch").focusout(function() {
			if(!onOff){
				$("#hotelList").addClass("hide");
				$("#hotelList").removeClass("active");
				$(this).find("img").attr("src", "img/common/hotolIcon.png");
				onOff = true;
			}
		})
	})