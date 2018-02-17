$(function(){
	//달력
	var month = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];
	var sElement = document.getElementById("start-calendar");
	var sCalendar = jsCalendar.new(sElement);
	
		//시작 달력
	$("#reservationBtnDiv input").eq(0).click(function(){
		$("#end-calendar").css("display", "none");
		$("#start-calendar").addClass("auto-jsCalendar material-theme shilla");
		$("#start-calendar").css("display", "block");
	})
	
	$("#reservationBtnDiv img").eq(2).click(function(){
		$("#end-calendar").css("display", "none");
		$("#start-calendar").addClass("auto-jsCalendar material-theme shilla");
		$("#start-calendar").css("display", "block");
	})
	
	sCalendar.onDateClick(function(event, date){
			$("#end-calendar").css("display", "none");
			var eDayArray = $("#reservationBtnDiv input").eq(1).val().split("-");
			if(eDayArray != ""){
				var eYear = Number(eDayArray[0]);
				var eMonth = Number(eDayArray[1]);
				var eDay = Number(eDayArray[2]);

				if(date.getFullYear() > eYear || Number(month[date.getMonth()]) > eMonth || date.getDate() > eDay){
					alert("시작 날짜를 다시 선택해주세요.");
					return; 
				} 
			}
			
			var setDateString = "";
			setDateString += date.getFullYear() + "-" + month[date.getMonth()];
			var date = date.getDate();
			if(date >= 1 && date < 10){
				setDateString += "-0"+ date;
			}else{
				setDateString += "-" + date;
			}
			
			$("#reservationBtnDiv input").eq(0).val(setDateString);
			$("#start-calendar").css("display", "none");
		});
	
		//끝 달력
	var eElement = document.getElementById("end-calendar");
	var eCalendar = jsCalendar.new(eElement);
	
	$("#reservationBtnDiv input").eq(1).click(function(){
		$("#start-calendar").css("display", "none");
		$("#end-calendar").addClass("auto-jsCalendar material-theme shilla");
		$("#end-calendar").css("display", "block");
	})
	
	$("#reservationBtnDiv img").eq(3).click(function(){
		$("#start-calendar").css("display", "none");
		$("#end-calendar").addClass("auto-jsCalendar material-theme shilla");
		$("#end-calendar").css("display", "block");
	})
	
	eCalendar.onDateClick(function(event, date){
			$("#start-calendar").css("display", "none");
			var sDayArray = $("#reservationBtnDiv input").eq(0).val().split("-");
			if(sDayArray == ""){
				alert("시작날짜를 선택하세요.");
				$("#start-calendar").addClass("auto-jsCalendar material-theme shilla");
				$("#start-calendar").css("display", "block");
				$("#end-calendar").css("display", "none");	
				return;
			}
						
			var sYear = Number(sDayArray[0]);
			var sMonth = Number(sDayArray[1]);
			var sDay = Number(sDayArray[2]);

			if(date.getFullYear() < sYear || Number(month[date.getMonth()]) < sMonth || date.getDate() < sDay){
				alert("시작 날짜보다 이전 날짜를 선택할 수 없습니다.");
				return; 
			} 
			
			var setDateString = "";
			setDateString += date.getFullYear() + "-" + month[date.getMonth()];
			var date = date.getDate();
			if(date >= 1 && date < 10){
				setDateString += "-0"+ date;
			}else{
				setDateString += "-" + date;
			}
			
			$("#reservationBtnDiv input").eq(1).val(setDateString);
			$("#end-calendar").css("display", "none");
	});
	
	// 전제 조회 버튼
	$("#reservationBtnDiv img").eq(1).click(function(){
		alert(1);
	})
	
	
	// 조회 버튼
	$("#reservationBtnDiv img").eq(4).click(function(){
		alert(4);
	})
	

	
	
	
})