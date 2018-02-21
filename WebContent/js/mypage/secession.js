$(function(){
	/*input에 포커스가 갔을때 border에 효과를 줌 */
	$("input[type='password']").focusin(function() {
		$(this).css("border","1px solid #727272");
	})
	
	$("input[type='password']").focusout(function() {
		$(this).css("border","1px solid #ccc");
	})
	
	$("#btnConfirm").click(function(){
		$("#error").css("display","none");
		
		if($("input[type='password']").val()==""){
			alert("비밀번호를 입력하세요");
			$("input[type='password']").focus();
			return false;
		}
		$("#secessionStep1").submit();
		return false;
	})
})