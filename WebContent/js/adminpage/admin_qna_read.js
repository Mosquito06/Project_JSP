$(function(){
	/*취소버튼 눌렀을때 답변글 지우기*/
	$("#clear").click(function(){
		$("#reply_text").val("");
		return false;
	})
	/*답변글에 border css*/
	$("textarea").focusin(function() {
		$(this).css("border","1px solid #3e2b2c");
	})
	$("textarea").focusout(function() {
		$(this).css("border","1px solid #ccc");
	})
	
	/*답변을 추가하는 것*/
	$("#sendBtn").click(function(){
		if($("#reply_text").val()==""){
			alert("답변을 입력하세요.");
			return false;
		}
		
		var reply=$("#reply_text").val().replace(/(?:\r\n|\r|\n)/g, '<br />');
		
		$.ajax({
			url:"replyUpdate.do",
			type:"get",
			data:{"num":$("#hiddenNum").val(),
					"email":$("#email").text(),
					"clientGrade":$("#clientGrade").text(),
					"reply":reply},
			dataType:"json",
			success:function(data){
						alert("고객 문의에 응답하였습니다.");
						location.href="adminQnA.do";
				}
		})
		
	})
})