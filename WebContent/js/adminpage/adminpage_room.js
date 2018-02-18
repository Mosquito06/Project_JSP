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
				
				$("#TableDiv tr.roomInfoTr").remove();
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
							
				$(data).each(function(i, roomInfo){
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
								
				$("#TableDiv tr.roomInfoTr").remove();
				
				if(data == "Empty"){
					$("#TotalDiv").text("Total : 0");
					$("#TableDiv table").append(
						"<tr class='emptyTr'>" +
						"	<td colspan='6'>객실을 추가하거나, 검색 조건을 선택하세요.</td>" +
						"</tr>"
					);
					return;
				}	
								
				$("#TotalDiv").text("Total : " + data.length);
				$("#TableDiv tr.emptyTr").remove();
				
				$(data).each(function(i, roomInfo){
					$("#TableDiv table").append(
						"<tr class='roomInfoTr'>" +
						"	<td>" + roomInfo.roomNum + "</td>" +
						"	<td>" + roomInfo.roomInfoNum.roomGrade + "</td>" +
						"	<td>" + roomInfo.roomInfoNum.roomInfoName + "</td>" +
						"	<td>" + roomInfo.roomInfoNum.roomSize + "</td>" +
						"	<td>" + roomInfo.roomInfoNum.bedType + " / " + roomInfo.roomInfoNum.viewType + "</td>" +
						"	<td>" + roomInfo.roomPrice + "</td>" +
						"<tr>"
					);
				})
				
				
				
				
				
			}
		})
	})
	
})