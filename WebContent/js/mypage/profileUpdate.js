var not_email=-1;

$(function(){
	
	/*이메일 select 했을때, text에 값을 전해줌*/
	$("#e").change(function(){
		$("input[name='email2']").val($(this).val());
		not_email=-1;
	})
	
	/*input 태그에 focus가 왔을때 테두리 변화*/
	$("input[type='text']").focusin(function() {
		$(this).css("border","1px solid #727272");
	})
	
	$("input[type='text']").focusout(function() {
		$(this).css("border","1px solid #ccc");
	})
	$(document).on("input[name='email1'],input[name='email2']","keyup",function
			(){
		not_email=-1;
	})
	/*이메일 중복 확인*/
		$("#btnemail").click(function(){
		$.ajax({
			url:"duplicateEmail.do",
			type:"get",
			data:{"email1":$("#email1").val(),
					"email2":$("#email2").val()},
					dataType:"json",
					success:function(data){
						if(data.email ==null){
							alert("사용가능한 이메일 입니다");
							not_email=1;
						}else{
							if(data.email.id==$("#id").val()){
								alert("현재 회원님이 사용중인 아이디입니다(사용가능)");
								not_email=1;
							}else{
								alert("중복된 이메일 입니다.");
							}
							
						}
					
					}
		})
	})
	
	/*변경 버튼을 눌렀을때*/
	$("#updateBtn").click(function(){
	
		
		$(".err").css("display","none");
		var empty = emptyValue();
		var phone = "";
		
		if(empty){
			if(not_email==-1){
				alert("이메일 중복을 확인 해주세요");
				return false;
			}else{
				phone = phoneNum();
				if(phone){
					$.ajax({
						url:"profileUpdate.do",
						type:"post",
						data:{"id":$("#id").val(),
							"email1":$("#email1").val(),
							"email2":$("#email2").val(),
							"phone":$("#phone").val(),
							"home":$("#tel").val(),
							"addr1":$("#addr1").val(),
							"addr2":$("#addr2").val(),
							"addr3":$("#addr3").val()
						},
						dataType:"json",
						success:function(data){
							console.log(data);
						}
					})
					return false;
				}else{
					return false;
				}
			}
			
		}else{
			return false;
		}
	})
	

	
})


/*공백이 있는지 판단*/
function emptyValue(){
	var error = true;
	
	$(".import").each(function(i, obj) {
		if($(obj).val()==""){
			$(obj).nextAll(".err").css("display","block");
			$(obj).focus();
			error = false;
		}
	})
	
	return error;
}
/*폰번호의 길이로 합당한 폰번호인지 판단 최소 13자리는 사용해야함*/
function phoneNum(){
	var error = true;
	if($("input[name='phone']").val().length <10){
		alert("휴대전화를 확인해주세요(최소10자리 이상)");
		$(this).focus();
		error=false;
	}
	
	return error;

}
