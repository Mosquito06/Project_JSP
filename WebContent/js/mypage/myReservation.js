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
	
	// 전제 버튼
	$("#reservationBtnDiv img").eq(1).click(function(){
		$.ajax({
			url : "/Project_JSP/AllSearchReserv.do",
			type : "get",
			dataType : "json",
			success: function(data){
				console.log(data);
				
				if(data == "Empty"){
					return;
				}
							
				$(".reservationTr").remove();
				$("tr[class*=roomInfo]").remove();
				$("#TotalDiv").text("Total : " + data.length);
				$("#TableDiv .emptyTr").remove();
				
				$(data).each(function(i, reserv){
					var sDate = getFormatDate(new Date(reserv.checkIn))
					var eDate = getFormatDate(new Date(reserv.checkOut));
					var payDate = getFormatDate(new Date(reserv.payDate));
					
					var status = reserv.state;
					status = status == "RESERVE" ? "예약" : status == "CANCEL"? "취소" : "완료";
					setReservInfo(reserv, sDate, eDate, payDate, status);
					
				})
			}
		})
	})
	
	
	$(document).on("click", "tr.reservationTr", function(){
		var index = $(this).find("td").eq(0).text();
		var css = $(".roomInfo" + index).css("display");
		if(css == "none"){
			$(".roomInfo" + index).css("display", "table-row");
		}else if(css == "table-row"){
			$(".roomInfo" + index).css("display", "none");
		}
	})
	
	// 테이블 내 확인 버튼
	$(document).on("click", "img[src*='Confirm']", function(){
		var index = "." + $(this).parents("tr").attr("class");
		$(index).css("display", "none");
	})
	
	// 테이블 내 취소 버튼
	$(document).on("click", "img[src*='Cancel']", function(){
		var index = $(this).parents("tr").prev().prev().prev().prev().find("td:eq(0)").text().trim();
				
		var check = confirm("정말로 취소하시겠습니까?");
		if(check){
			$.ajax({
				url : "/Project_JSP/CancelReserv.do?index=" + index,
				type : "get",
				dataType : "json",
				success: function(data){
					console.log(data);
					alert("취소되었습니다.");
					
					$(".reservationTr").remove();
					$("tr[class*=roomInfo]").remove();
					
					if(data == "Empty"){
						$("#TotalDiv").text("Total : 0");
						$("#TableDiv table").append(
							"<tr class='emptyTr'>" +
							"	<td colspan='6'>자료가 없습니다.</td>" +
							"</tr>"
						);
						return;
					}								

					$("#TotalDiv").text("Total : " + data.length);
					$("#TableDiv .emptyTr").remove();
					
					$(data).each(function(i, reserv){
						var sDate = getFormatDate(new Date(reserv.checkIn))
						var eDate = getFormatDate(new Date(reserv.checkOut));
						var payDate = getFormatDate(new Date(reserv.payDate));
						
						var status = reserv.state;
						status = status == "RESERVE" ? "예약" : status == "CANCEL"? "취소" : "완료";
						setReservInfo(reserv, sDate, eDate, payDate, status);
						
					})
				}
			})
		}
	})
	
	// 조회 버튼
	$("#reservationBtnDiv img").eq(4).click(function(){
		var sDate = $("#reservationBtnDiv input").eq(0).val().split("-")[0] + 
		$("#reservationBtnDiv input").eq(0).val().split("-")[1] + 
		$("#reservationBtnDiv input").eq(0).val().split("-")[2];
		var eDate = $("#reservationBtnDiv input").eq(1).val().split("-")[0] + 
		$("#reservationBtnDiv input").eq(1).val().split("-")[1] + 
		$("#reservationBtnDiv input").eq(1).val().split("-")[2];
		
		if($("#reservationBtnDiv input").eq(0).val() == "" || $("#reservationBtnDiv input").eq(1).val() == ""){
			alert("조회할 날짜를 선택하세요.");
			return;
		}
		
		location.href = "/Project_JSP/DateSearchReserv.do?sDate=" + sDate + "&eDate=" + eDate;
	})
	
	function getFormatDate(date){
		var month = ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"];
		var Year = date.getFullYear();
		var Month = month[date.getMonth()];
		var Date = date.getDate();
		Date = Date >= 10? Date : "0" + Date;
		return Year + "." + Month + "." + Date;
	}	
	
	function setReservInfo(reserv, sDate, eDate, payDate, status){
		if(status == "예약"){
			$("#TableDiv table").append(
				"<tr class='reservationTr'>" +
				"	<td>" + reserv.reservationNum + "</td>" +
				"	<td>대구신라호텔</td>" +
				"	<td>" + "[" + reserv.roomNum.roomInfoNum.roomGrade +"] " + reserv.roomNum.roomInfoNum.roomInfoName + "</td>" +
				"	<td>" + sDate + "</td>" +
				"	<td>" + eDate + "</td>" +
				"	<td>" + status + "</td>" +
				"</tr>" +
				"<tr class='roomInfo"+ reserv.reservationNum + "'>" +
				"	<th>투숙인원</th>" +
				"	<td colspan='2'>"+ reserv.personnel +"</td>" +
				"	<th>침대타입/전망</th>" +
				"	<td colspan='2'>"+ reserv.roomNum.roomInfoNum.bedType + " / " + reserv.roomNum.roomInfoNum.viewType + "</td>" +
				"</tr>" +
				"<tr class='roomInfo"+ reserv.reservationNum + "'>" +
				"	<th>요구사항</th>" +
				"	<td colspan='2'>"+ reserv.clientReq +"</td>" +
				"	<th>선택옵션</th>" +
				"	<td colspan='2'>"+ reserv.option +"</td>" +
				"</tr>" +
				"<tr class='roomInfo"+ reserv.reservationNum + "'>" +
				"	<th>예약일</th>" +
				"	<td colspan='2'>"+ payDate +"</td>" +
				"	<th>최종가격</th>" +
				"	<td colspan='2'>"+ reserv.totalPrice +"</td>" +
				"</tr>" +
				"<tr class='roomInfo"+ reserv.reservationNum + "'>" +
				"	<td colspan='6'>" +
				"	<img src='/Project_JSP/img/mypage/btnConfirm.gif'>" +
				"	<img src='/Project_JSP/img/mypage/btnCancel.png'>" +
				"	</td>" +
				"</tr>"
				);
		}else{
			$("#TableDiv table").append(
				"<tr class='reservationTr'>" +
				"	<td>" + reserv.reservationNum + "</td>" +
				"	<td>대구신라호텔</td>" +
				"	<td>" + "[" + reserv.roomNum.roomInfoNum.roomGrade +"] " + reserv.roomNum.roomInfoNum.roomInfoName + "</td>" +
				"	<td>" + sDate + "</td>" +
				"	<td>" + eDate + "</td>" +
				"	<td>" + status + "</td>" +
				"</tr>" +
				"<tr class='roomInfo"+ reserv.reservationNum + "'>" +
				"	<th>투숙인원</th>" +
				"	<td colspan='2'>"+ reserv.personnel +"</td>" +
				"	<th>침대타입/전망</th>" +
				"	<td colspan='2'>"+ reserv.roomNum.roomInfoNum.bedType + " / " + reserv.roomNum.roomInfoNum.viewType + "</td>" +
				"</tr>" +
				"<tr class='roomInfo"+ reserv.reservationNum + "'>" +
				"	<th>요구사항</th>" +
				"	<td colspan='2'>"+ reserv.clientReq +"</td>" +
				"	<th>선택옵션</th>" +
				"	<td colspan='2'>"+ reserv.option +"</td>" +
				"</tr>" +
				"<tr class='roomInfo"+ reserv.reservationNum + "'>" +
				"	<th>예약일</th>" +
				"	<td colspan='2'>"+ payDate +"</td>" +
				"	<th>최종가격</th>" +
				"	<td colspan='2'>"+ reserv.totalPrice +"</td>" +
				"</tr>" +
				"<tr class='roomInfo"+ reserv.reservationNum + "'>" +
				"	<td colspan='6'>" +
				"	<img src='/Project_JSP/img/mypage/btnConfirm.gif'>" +
				"	</td>" +
				"</tr>"
			);
		}
	}
})