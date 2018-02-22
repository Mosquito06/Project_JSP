//달력 배열
var month = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];

$(function() {
	var submit = false;

	$("#addEventForm").submit(function() {
		submit = true;
		
		if(checkExistsValue()){
			alert("내용을 입력해 주세요.");
			return false;
		}else {
			var content = CKEDITOR.instances.noticeContent.getData();
			$("#hiddenContent").val(content);
		}
		
	});
	var backClick = false;

	$("input[type='button']").click(function() {
		backClick = true;
		if (!checkExistsValue()) {
			var res = confirm("저장하지 않고 나가겠습니까?");
			if (res) {
				location.replace(contextPath + "/fileDelete.do");
			} else {
				backClick = false;
			}
		} else {
			history.go(-1);
		}
	});

	window.onbeforeunload = function(evt) {
		if (!checkExistsValue() && !backClick && !submit) {
			$.ajax({
				url : contextPath + "/fileDelete.do",
				type : "get",
				dataType : "xml"
			});
			return "";
		}
	};
	
	// 달력
	var sElement = document.getElementById("start-calendar");
	var sCalendar = jsCalendar.new(sElement);
	
	var date = new Date();
	
	$("#sYear").text(date.getFullYear());
	$("#sMonth").text(month[date.getMonth()]);
	
	$("#eYear").text(date.getFullYear());
	$("#eMonth").text(month[date.getMonth()]);
	if(date.getDate() >= 1 && date.getDate() < 10){
		$("#sDay").text("0"+ date.getDate());
	}else{
		$("#sDay").text(date.getDate());
	}
	$("#eDay").text(Number($("#sDay").text()) + 1);
	$("#startDate").val(date.getFullYear()+"-"+month[date.getMonth()]+"-"+date.getDate());
	$("#endDate").val(date.getFullYear()+"-"+month[date.getMonth()]+"-"+(date.getDate()+1));
	
	$(".sDate").click(function(){
		$("#start-calendar").addClass("auto-jsCalendar material-theme shilla");
		$("#start-calendar").css("display", "block");
		$("#end-calendar").css("display", "none");
	});
	
	sCalendar.onDateClick(function(event, date){
		$("#end-calendar").css("display", "none");
		$("#sYear").text(date.getFullYear());
		$("#sMonth").text(month[date.getMonth()]);
		var day = date.getDate();
		var inDay = "";
		if(day >= 1 && day < 10){
			$("#sDay").text("0"+day);
			inDay = "0"+day;
			console.log(inDay);
		}else{
			$("#sDay").text(day);
			inDay = day;
		}
		
		var dateStr = date.getFullYear()+"-"+month[date.getMonth()]+"-"+ inDay;
		console.log(dateStr);
		$("#startDate").val(dateStr);
		$("#start-calendar").css("display", "none");
	});
	
	var eElement = document.getElementById("end-calendar");
	var eCalendar = jsCalendar.new(eElement);
	
	$(".eDate").click(function(){
		$("#end-calendar").addClass("auto-jsCalendar material-theme shilla");
		$("#end-calendar").css("display", "block");
		$("#start-calendar").css("display", "none");
	});
	
	eCalendar.onDateClick(function(event, date){
		$("#start-calendar").css("display", "none");
		var sYear = Number($("#sYear").text());
		var sMonth = Number($("#sMonth").text());
		var sDay = Number($("#sDay").text());
		
		if(date.getFullYear() < sYear || Number(month[date.getMonth()]) < sMonth || date.getDate() < sDay){
			alert("시작 날짜보다 이전 날짜를 선택할 수 없습니다.");
			return;
		}
					
		$("#eYear").text(date.getFullYear());
		$("#eMonth").text(month[date.getMonth()]);
		var day = date.getDate();
		var inDay = "";
		if(day >= 1 && day < 10){ 
			$("#eDay").text("0"+day);
			inDay = "0"+day;
			console.log(inDay);
		}else{
			$("#eDay").text(day);
			inDay = day;
		}
		
		var dateStr = date.getFullYear()+"-"+month[date.getMonth()]+"-"+inDay;
		console.log(dateStr);
		$("#endDate").val(dateStr);
		$("#end-calendar").css("display", "none");
	}); 

})


function checkExistsValue() {
	var content = CKEDITOR.instances.noticeContent.getData();
	
	$('input[type]').each(function(i,obj){
		console.log($(this).val())
		if($(this).val() == ""){
			$(this).focus();
			return false;
		}
	})
	
	
	
	if (content.length > 0) {
		return false;
	}

	return true;
}