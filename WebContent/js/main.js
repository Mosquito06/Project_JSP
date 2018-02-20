var actSlideInterval;
var actSlide;

$(function(){
	var mainVis;
	$.ajax({
		url:"index.do",
		type:"get",
		data:{"no":3},
		dataType:"json",  
		success:function(json){  
			console.log(json);
			$.each(json.banner,function(i,obj){
				var img = "<div><a href='" + obj.linkPath
				+ "'><img src='" + obj.imgPath
		        + "'></a></div>"; 

			   $(".mainVisual").append(img);  
			});				 
			
			mainVis =  $('.mainVisual').bxSlider({
				mode: 'fade',
		    	pager : false,
		    	controls : false,
		    	auto : true,
		    	pause : 5000
		    });
			 
			var eventSize = Object.keys(json.event).length;
			  
			for(var i=0; i<3; i++){	 			
				var event = json.event[--eventSize];
				if(eventSize < 0){
					break; 
		 		} 
				var no = event.eventNum;
				var imgPath = event.eventImgPath;
				var startDate = new Date(event.eventStartDay);
				var endDate = new Date(event.eventEndDay);
				
				var sYear = startDate.getFullYear();
				var sMonth = startDate.getMonth()+1;
				var sDate = startDate.getDate()
				var sFullDate = sYear + "-" + sMonth + "-"+ sDate;
					
				var eYear = endDate.getFullYear();
				var eMonth = endDate.getMonth()+1;
				var eDate = endDate.getDate()
				var eFullDate = eYear + "-" + eMonth + "-" + eDate;
				var box = $("<div class='contentBox'>");
				
				var img = "<a href='"+contextPath+"/event/eventread.do?no="+no+"'>";
					img += "<img src='"+imgPath+"'/>";
					img += "</a>"; 
				var div = "<div class='tit'>";
					div	+= "<h3>"+event.eventTitle+"</h3>";
					div	+= "<p>"+event.eventIntroduce+"</p>";
					div	+= "<p>"+sFullDate + "~" + eFullDate+"</p>";
					div	+= "</div>";
					
				 box.append(img);
				 box.append(div);
				 
				 $(".conBox").append(box); 
			}
		}			 
	}) 
	
	
	//메인 비주얼 	
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
	
	//액티비티 슬라이드 
	actSlide =  $('.activitySlide').bxSlider({
				mode: 'fade',
		    	pager : false,
		    	controls : false,
		    	auto : false
		 });
	
	
	actSildeInterval();
	
	var totalSlide = actSlide.getSlideCount();	
	
	$(".maxSlide").text(totalSlide);
	var slide = actSlide.getCurrentSlide()+1;
	$(".showSlide").text(slide);
	 
	$(".act_prev").click(function(e){
		 e.preventDefault();
		 actSlide.goToPrevSlide();
		 var slide = actSlide.getCurrentSlide()+1;
		 $(".showSlide").text(slide);
		 clearInterval(actSlideInterval);
		 actSildeInterval();
		 return false; 
	})
		     
	$(".act_next").click(function(e){
		 e.preventDefault();
		 actSlide.goToNextSlide();
		 var slide = actSlide.getCurrentSlide()+1;
		 $(".showSlide").text(slide);
		 clearInterval(actSlideInterval);
		 actSildeInterval();
		 return false;
	})
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
		var now = new Date(); 
		now.setHours(0);
		now.setMinutes(0);
		now.setSeconds(0);
		now.setMilliseconds(0);   
		 
		date.setHours(0);
		date.setMinutes(0);
		date.setSeconds(0); 
		date.setMilliseconds(0); 

		if((date-now) < -1){ 
			alert("과거로 돌아갈 수는 없습니다.");
			return;  
		}  
		
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
			alert("체크인 날짜를 먼저 선택하셔야 합니다.");
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
	
	//최대 인원수 
	var maxPeople = 4;
	
	/*성인 인원 선택*/ 
	$(".rsSel_ad>li").click(function(e){
		e.preventDefault();  
		var idx = $(this).index();
	
		$(".chdSelect option").removeAttr("selected");
		$(".sChdSelect option").removeAttr("selected");
		$(".adSelect option").removeAttr("selected"); 
		
		$(".chdSelect option").eq(0).attr("selected","selected");
		$(".sChdSelect option").eq(0).attr("selected","selected"); 
		$(".adSelect option").eq(idx).attr("selected","selected"); 
  
		console.log("선택한 li >" + idx);		
		console.log("선택한 성인인원수 >" + $(".adSelect option").eq(idx).val()); 
		console.log("선택한 성인인원수 >" + $(".adSelect option:selected").val());
		
		$(".rsSel_ad").siblings(".rsBox").html($(this).text() + "<i class='arr'></i> "); 
		$(".rsSel_ch").siblings(".rsBox").html($(".rsSel_ch li:eq(0)").text() + "<i class='arr'></i> "); 
		$(".rsSel_lch").siblings(".rsBox").html($(".rsSel_lch li:eq(0)").text() + "<i class='arr'></i> "); 

		 
		$('.rsSel_ad').css("display","none");
		
		$(".rsSel_ch li").css("display","none");
		$(".rsSel_lch li").css("display","none");   
		
		var index = 0;
		for(var i = idx; i<maxPeople; i++){
			$(".rsSel_ch li").eq(index).css("display","block");
			$(".rsSel_lch li").eq(index).css("display","block"); 
			index++;
		}
	})    
	
	$(".rsSel_ch>li").click(function(e){
		e.preventDefault();
		var idx = $(this).index();
		
		$(".chdSelect option").removeAttr("selected");
		$(".chdSelect option").eq(idx).attr("selected","selected");  
		$(".rsSel_ch").siblings(".rsBox").html($(this).text() + "<i class='arr'></i> "); 
		
		$('.rsSel_ch').css("display","none");		
		
		var selCh = idx ; 
		var adIndex = $(".adSelect option:selected").index()+1;
		var remainingNum = (maxPeople-(adIndex+selCh));
		
		console.log("성인 인원수"+adIndex); 
		console.log("남은 인원수"+remainingNum);
		if(remainingNum > 4){
			alert("객실 1실 당 성인과 소인 동반 시 최대 4인까지만 투숙 가능합니다.");
		} 
		
		$(".rsSel_lch li").css("display","none");   
		
		var index = 0;    
		for(var i = 0; i<remainingNum+1; i++){
			$(".rsSel_lch li").eq(index).css("display","block"); 
			index++;  
		}
	})  
	
	$(".rsSel_lch>li").click(function(e){ 
		e.preventDefault();
		var idx = $(this).index();  
		
		$(".sChdSelect option").removeAttr("selected");
		$(".sChdSelect option").eq(idx).attr("selected","selected"); 
		$(".rsSel_lch").siblings(".rsBox").html($(this).text() + "<i class='arr'></i> "); 
	
		$('.rsSel_lch').css("display","none");
		
		var selSch = idx ;
		var adIndex = $(".adSelect option:selected").index()+1;
		
		
		var remainingNum = (maxPeople-(adIndex+selSch));
		console.log("성인 인원수"+adIndex); 
		console.log("남은 인원수"+remainingNum);
		if(remainingNum > 4){
			alert("객실 1실 당 성인과 소인 동반 시 최대 4인까지만 투숙 가능합니다."); 
		}
		 
		$(".rsSel_ch li").css("display","none");   
		
		var index = 0;  
		for(var i = 0; i<remainingNum+1; i++){
			$(".rsSel_ch li").eq(index).css("display","block"); 
			index++;    
		}
	})
	
	$(".resBtn").click(function(e){
		e.preventDefault();
		
		var chckIn = $("#ckin").val();
		var chckOut = $("#ckout").val();
		var adult = $(".adSelect option:selected").val(); 
		var child = $(".chdSelect option:selected").val(); 
		var sChild= $(".sChdSelect option:selected").val();
		
		if(chckIn == "" ||chckOut == "" || adult == ""  || child == "" || sChild == ""  ){
			alert("모두 선택한뒤 검색하세요.");
			return; 
		}
		
		console.log(chckIn); 
		console.log(chckOut);
		console.log(adult);
		console.log(child);
		console.log(sChild);
		
		location.href = contextPath+"/step1.do?chckIn="+chckIn+"&chckOut="+chckOut+"&adult="+adult+"&child="+child+"&sChild="+sChild;  
	})  
	
}) 

function actSildeInterval(){
	actSlideInterval = setInterval(function(){
		actSlide.goToNextSlide();
		var slide = actSlide.getCurrentSlide()+1;
		$(".showSlide").text(slide);
	}, 5000);
}
 

	

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