/**
 * 
 */
$(function(){
	/*input에 포커스가 갔을때 border에 효과를 줌 */
	$("input[type='password']").focusin(function() {
		$(this).css("border","1px solid #727272");
	})
	
	$("input[type='password']").focusout(function() {
		$(this).css("border","1px solid #ccc");
	})
	
	/*취소 버튼을 눌렀을 때 input value를 clear*/
	$("#cancel").click(function(){
		$("input").each(function(i,obj){
			$(obj).val("");
		})
	})
	
	newPwConfirm();
	
	
})
/*비밀번호 확인창*/
function newPwConfirm(){

	$("#pwConfirm").keyup(function(){
		if($("#newPasswords").val()==$("#pwConfirm").val()){
			$("#error").css("display","none");
			$("#ok").css("display","inline");
		}else{
			$("#error").css("display","inline");
			$("#ok").css("display","none");
		}
	})

}