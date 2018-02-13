
$(function(){
	
	//메인 비주얼 	
	$(document).ready(function(){
		var mainVis =  $('.mainVisual').bxSlider({
			mode: 'fade',
	    	pager : false,
	    	controls : false,
	    	auto : true,
	    	pause : 5000
	    });
	    
	    $(".prev").click(function(e){
	    	 e.preventDefault();
	    	 mainVis.goToPrevSlide();
	    	 return false; 
	    })
	    
	    $(".next").click(function(e){
	    	 e.preventDefault();
	    	 mainVis.goToNextSlide();
	    	 return false;
	    })
	  });
	
	//달력
	var month = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];
	var sElement = document.getElementById("start-calendar");
	var sCalendar = jsCalendar.new(sElement);
	
	
	var date = new Date();
	
	$("#ckin, #ckin+span").click(function(){
		$("#start-calendar").addClass("auto-jsCalendar material-theme shilla");
		$("#start-calendar").toggle();
		$("#end-calendar").css("display", "none");	
		$(".rsSelect").css("display", "none");
		resActive(0);	
	})
	
	sCalendar.onDateClick(function(event, date){
		var sDate = "";
		$("#end-calendar").css("display", "none");
		sDate += date.getFullYear() + "-";
		sDate += month[date.getMonth()] + "-";
		var date = date.getDate();
		if(date >= 1 && date < 10){
			sDate += "0"+ date;
		}else{
			sDate += date;
		}
		$("#ckin").val(sDate);
		$("#start-calendar").css("display", "none");
	});
	
	var eElement = document.getElementById("end-calendar");
	var eCalendar = jsCalendar.new(eElement);
	
	$("#ckout, #ckout+span").click(function(){
		$("#end-calendar").addClass("auto-jsCalendar material-theme shilla");
		$("#end-calendar").toggle();
		$("#start-calendar").css("display", "none");
		$(".rsSelect").css("display", "none");
		resActive(1);
	})
	
	eCalendar.onDateClick(function(event, date){
		var eDate = "";
		$("#start-calendar").css("display", "none");
		
		var sDate = new Date($("#ckin").val());
		sDate.setHours(0);
		sDate.setMinutes(0);
		sDate.setMilliseconds(0);
		if($("#ckin").val() == ""){
			alert("체크인 날짜보다 먼저 선택하셔야 합니다.");
			return;
		}
		
		if((date-sDate) < 0){
			alert("체크인 날짜보다 이전 날짜를 선택할 수 없습니다.");
			return;
		} 
		
		eDate += date.getFullYear() + "-";
		eDate += month[date.getMonth()] + "-";
		var date = date.getDate();
		if(date >= 1 && date < 10){
			eDate += "0"+ date;
		}else{
			eDate += date;
		}
		$("#ckout").val(eDate);
		$("#end-calendar").css("display", "none");
	});
	
	/*셀렉트 선택창 띄우기*/
	$(".rsBox").click(function(){
		var index = $(this).parent("li").index();    
		
		$(".selList>li").not(".selList>li:eq("+index+")").find(".rsSelect").css("display", "none");
		$("#start-calendar, #end-calendar").css("display", "none");
		$(this).siblings(".rsSelect").toggle(); 
		
		resActive(index-1);
	}) 
	
	
	/*성인 인원 선택*/ 
	$(".rsSel_ad>li").click(function(){
		var idx = $(this).index();
		$(".adSelect option").removeAttr("selected");
		$(".adSelect option").eq(idx).attr("selected","selected");
		$(".rsSel_ad").siblings(".rsBox").html($(this).text() + "<i class='arr'></i> "); 
		
		$(".rsSel_ch").siblings(".rsBox").html($(".rsSel_ch li:eq(0)").text() + "<i class='arr'></i> "); 
		$(".rsSel_lch").siblings(".rsBox").html($(".rsSel_lch li:eq(0)").text() + "<i class='arr'></i> "); 
		$('.rsSel_ad').css("display","none");
		
		var chIndex = $(".chdSelect option:selected").index();
		var sChIndex = $(".sChdSelect option:selected").index();
		
		
	})
	
	$(".rsSel_ch>li").click(function(){
		var idx = $(this).index();
		
		$(".chdSelect option").removeAttr("selected");
		$(".chdSelect option").eq(idx).attr("selected","selected");  
		$(".rsSel_ch").siblings(".rsBox").html($(this).text() + "<i class='arr'></i> "); 
	
		$('.rsSel_ch').css("display","none");		 
	})
	
	$(".rsSel_lch>li").click(function(){ 
		var idx = $(this).index();
		
		
		$(".sChdSelect option").removeAttr("selected");
		$(".sChdSelect option").eq(idx).attr("selected","selected"); 
		$(".rsSel_lch").siblings(".rsBox").html($(this).text() + "<i class='arr'></i> "); 
	
		$('.rsSel_lch').css("display","none");
	})
	
}) 

function resActive(position){
	var startPos = [165.97,165.97,131.98,131.98,131.98];
	var pos = 240;
	for(var i=0; i<position; i++){
		pos += startPos[i];
	}
	
	$(".resActive").css({
		"left" : pos+"px",
		"width" : startPos[position]+"px",
		"display" : "block"
	});	
}