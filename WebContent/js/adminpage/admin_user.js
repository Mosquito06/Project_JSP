$(function(){
	
	
	$("#t1 tr td").not(".check").click(function(){
		var num=$(this).parent().find(".client_num").html();
		location.href="adminUser_read.do?num="+num;
	});
	
})