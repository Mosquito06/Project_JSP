$(function(){
	// 객실 등급 select
	$("#adminRoomBtnDiv select").eq(0).change(function(){
		var roomGrade = $(this).val();
		$.ajax({
			url : "/Project_JSP/adminRoomSearch.do?select=1&roomGrade=" + roomGrade,
			type : "get",
			dataType : "json",
			success : function(data){
				console.log(data);
				
				$("#TableDiv tr[class*='roomInfo']").remove();
				$("#TableDiv tr.emptyTr").remove();
				$("#TotalDiv").text("Total : 0");
				
				$("#adminRoomBtnDiv select").eq(1).empty();
				$("#adminRoomBtnDiv select").eq(1).append(
					"<option>선택하세요.</option>"
				);
				
				$("#TableDiv table").append(
					"<tr class='emptyTr'>" +
					"	<td colspan='6'>객실을 추가하거나, 검색 조건을 선택하세요.</td>" +
					"</tr>"
				);
							
				$(data.result).each(function(i, roomInfo){
					$("#adminRoomBtnDiv select").eq(1).append(
						"<option>" + roomInfo.roomInfoNum.roomInfoName + "</option>"
					);
				})
			}
		})
	})
	
	// 객실 명 select
	$("#adminRoomBtnDiv select").eq(1).change(function(){
		var roomGrade = $("#adminRoomBtnDiv select").eq(0).val();
		var roomName = $(this).val();
		
		$.ajax({
			url : "/Project_JSP/adminRoomSearch.do?select=2&roomGrade=" + roomGrade + "&roomName=" + roomName,
			type : "get",
			dataType : "json",
			success : function(data){
				console.log(data);
								
				$("#TableDiv tr[class*='roomInfo']").remove();
				
				if(data.result == "Empty"){
					$("#TotalDiv").text("Total : 0");
					$("#TableDiv table").append(
						"<tr class='emptyTr'>" +
						"	<td colspan='6'>객실을 추가하거나, 검색 조건을 선택하세요.</td>" +
						"</tr>"
					);
					return;
				}	
								
				$("#TotalDiv").text("Total : " + data.result.length);
				$("#TableDiv tr.emptyTr").remove();
				var roomFolder = "";
				
				$(data.result).each(function(i, roomInfo){
					roomFolder = roomInfo.roomInfoNum.roomImg;
					$("#TableDiv table").append(
						"<tr class='roomInfoTr'>" +
						"	<td>" + roomInfo.roomNum + "</td>" +
						"	<td>" + roomInfo.roomInfoNum.roomGrade + "</td>" +
						"	<td>" + roomInfo.roomInfoNum.roomInfoName + "</td>" +
						"	<td>" + roomInfo.roomInfoNum.roomSize + "</td>" +
						"	<td>" + roomInfo.roomInfoNum.bedType + " / " + roomInfo.roomInfoNum.viewType + "</td>" +
						"	<td>" + roomInfo.roomPrice + "</td>" +
						"</tr>" +
						"<tr class='roomInfoImg" + roomInfo.roomNum + "'>" +
						"	<th>객실 이미지</th>" +
						"	<td colspan='5'></td>" +
						"</tr>" +
						"<tr class='roomInfoBtn"+ roomInfo.roomNum + "'>" +
						"	<th>예약 이미지</th>" +
						"	<td colspan='2' class='reservImg'><img src='/Project_JSP/img/reservation/room/" + roomInfo.roomInfoNum.reservationImg + "'></td>" +
						"	<td colspan='3'>" +
						"		<img src='/Project_JSP/img/adminpage/btnConfirm.png'>" +
						"		<img src='/Project_JSP/img/adminpage/btnUpdate.png'>" +
						"		<img src='/Project_JSP/img/adminpage/btnDelete.png'>" +
						"	</td>" +
						"</tr>"
					);
				})
				
				$(data.imgList).each(function(i, img){
					$("#TableDiv table tr[class*='roomInfoImg'] td").append(
						"<img src='/Project_JSP/img/room/"+ roomFolder + "/" + img +"'>"
					)
				})
			}
		})
	})
	
	// 추가 버튼
	$(document).on("click", "#adminRoomTableDiv img:eq(1)", function(){
		location.replace("/Project_JSP/adminRoomAdd.do");
	})
	
	
	// 테이블 내 행 클릭
	$(document).on("click", "tr.roomInfoTr", function(){
		var index = $(this).find("td").eq(0).text();
		var imgCss = $(".roomInfoImg" + index).css("display");
		var btnCss = $(".roomInfoBtn" + index).css("display");
		if(imgCss == "none" || btnCss == "none"){
			$(".roomInfoImg" + index).css("display", "table-row");
			$(".roomInfoBtn" + index).css("display", "table-row");
		}else if(imgCss == "table-row" || btnCss == "table-row"){
			$(".roomInfoImg" + index).css("display", "none");
			$(".roomInfoBtn" + index).css("display", "none");
		}
	})
	
	// 테이블 내 확인 버튼
	$(document).on("click", "img[src*='Confirm']", function(){
		var btnIndex = "." + $(this).parents("tr").attr("class");
		var imgIndex = "." + $(this).parents("tr").prev().attr("class");
		$(btnIndex).css("display", "none");
		$(imgIndex).css("display", "none");
	})
	
	
})