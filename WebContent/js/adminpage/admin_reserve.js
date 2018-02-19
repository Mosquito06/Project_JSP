$(function(){
	

	
		
	$("#del_list").click(function(){
		var leng = $(".check input:checked").length;

		if(leng==0){
			alert("삭제내용이 없습니다.");
			return false;
		}
		var yes=confirm("정말 삭제 하시겠습니까?");
		if(!yes){
			return false;
		}
		
		var str = "";
		$(".check input:checked").each(function(i){
			str += $(this).val()+",";
		})
		location.href="adminReserveDelete.do?set=2&list="+str;
	
		return false;
		
	})
	
	
	
})