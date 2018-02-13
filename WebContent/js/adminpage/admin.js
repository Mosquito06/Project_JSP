$(function(){
	var month = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];
	var sElement = document.getElementById("start-calendar");
	var sCalendar = jsCalendar.new(sElement);
	
	
	
	var date = new Date();
	
	// 시작 시 날짜 설정
	
	if(date.getDate() >= 1 && date.getDate() < 10){
		$("#sDay").text("0"+ date.getDate());
		
	}else{
		$("#sDay").text(date.getDate());
		
	}
	$("#eDay").text(Number($("#sDay").text()) + 1);
	
	
	
	
	$("#sDay").click(function(){
		$("#end-calendar").css("display", "none");
		$("#start-calendar").addClass("auto-jsCalendar material-theme shilla");
		$("#start-calendar").css("display", "block");
	})
	
	sCalendar.onDateClick(function(event, date){
		var sDate="";
		
		$("#end-calendar").css("display", "none");
		
		sDate+=date.getFullYear();
		
		sDate+="-"+month[date.getMonth()];
		var date = date.getDate();
		if(date >= 1 && date < 10){
			$("#sDay").text("0"+date);
			sDate+="-"+"0"+date;
		}else{
			$("#sDay").text(date);
			sDate+="-"+date;
		}
		$("#start-calendar").css("display", "none");
		$("#sDay").val(sDate);
	});
	
	var eElement = document.getElementById("end-calendar");
	var eCalendar = jsCalendar.new(eElement);
	
	$("#eDay").click(function(){
		$("#start-calendar").css("display", "none");
		$("#end-calendar").addClass("auto-jsCalendar material-theme shilla");
		$("#end-calendar").css("display", "block");
	})
	
	eCalendar.onDateClick(function(event, date){
		var eDate="";
		$("#start-calendar").css("display", "none");
		var sYear = Number($("#sYear").text());
		var sMonth = Number($("#sMonth").text());
		var sDay = Number($("#sDay").text());
		
		if(date.getFullYear() < sYear || Number(month[date.getMonth()]) < sMonth || date.getDate() < sDay){
			alert("체크인 날짜보다 이전 날짜를 선택할 수 없습니다.");
			return;
		}
					
		
		eDate+=date.getFullYear();
		eDate+="-"+month[date.getMonth()];
		
		var date = date.getDate();
		if(date >= 1 && date < 10){
			$("#eDay").text("0"+date);
			eDate+="-0"+date;
		}else{
			$("#eDay").text(date);
			eDate+="-"+date;
		}
		$("#end-calendar").css("display", "none");
		$("#eDay").val(eDate);
	});
	
	
	$("#search_user").css("display","none");
	$("#set_type").val("1");
	
	
	
	
	$(".search_type").change(function(){
		var set = $(this).val();
		if(set == 1){
			$("#search_user").css("display","none");
			$("#search_date").css("display","block");
			$("#set_type").val("1");
		}else if(set == 2){
			$("#search_date").css("display","none");
			$("#search_user").css("display","block");
			$("#set_type").val("2");
		}
	
	})
	
	
	
	
	
	
})