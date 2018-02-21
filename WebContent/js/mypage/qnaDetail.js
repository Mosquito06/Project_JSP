$(function(){
	
	$(".answer_t").click(function(){
		
		if($(this).text()=="답변 ∨"){
			$(this).text("답변 ^");
			$("#hiddenTable").show();
		}else{
			$(this).text("답변 ∨");
			$("#hiddenTable").hide();
		}
	})
})