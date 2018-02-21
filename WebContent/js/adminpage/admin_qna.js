$(function(){
	
	$(document).on("click",".data",function(){
		
		var num = $(this).find(".hiddenNum").text();
		
		location.href="adminQnaRead.do?num="+num;
	})
})