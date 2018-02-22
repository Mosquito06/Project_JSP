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
	
	$("#qnaRecordDelBtn").click(function(){
		var del = confirm("문의내역을 삭제하시겠습니까?");
		
		if(del){
			$.ajax({
				url:"qnaDelete.do",
					type:"get",
					data:{"qnaNum":$("#hiddenQnaNum").val()},
					success:function(){
						alert("문의글이 삭제되었습니다");
						location.href="qnaRecord.do";
					}
			})
		}
		return false;
	})
})