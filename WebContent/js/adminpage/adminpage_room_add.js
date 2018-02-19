$(function(){
	// 객실 이미지 선택 버튼
	$("#TableDiv img:eq(0)").click(function(){
		 $("#roomList").trigger('click'); 
	})
	
	
	// 예약 이미지 선택 버튼
	$("#TableDiv img:eq(1)").click(function(){
		 $("#reservList").trigger('click'); 
	})
	
	
})