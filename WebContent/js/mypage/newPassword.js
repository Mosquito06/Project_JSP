$(function(){
	var emptyerr = true;
	
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
	
	$("#changeBtn").click(function(){
		$("#error,#ok").css("display","none");
		
		$("input").each(function(i,obj){
			if($(obj).val()==""){
			alert("비밀번호를 모두 입력해주세요");
			return false;
		}
	})
	
	$.ajax({
						
		url:"newPassword.do",
		type:"post",
		data:{"id":$("#clientId").val(),
				"pw":$("#oldPassword").val(),
				"newPw":$("#newPassword").val()},
		dataType:"json",
		success:function(data){
				if(data==true){
					alert("비밀번호가 변경되었습니다");
					$("#f").submit();
				}else{
					alert("현재 비밀번호가 일치하지 않습니다");
					$("#oldPassword").val("");
					$("#newPassword").val("");
					$("#pwConfirm").val("");
					return false;
				}
			}
		})
	
	})
})
	/*비밀번호 확인창*/
	function newPwConfirm(){

		$("#pwConfirm").keyup(function(){
			if($("#newPassword").val()==$("#pwConfirm").val()){
				$("#error").css("display","none");
				$("#ok").css("display","inline");
			}else{
				$("#error").css("display","inline");
				$("#ok").css("display","none");
			}
		})
	}