
$(function(){
	/*회원일때와 비회원일때 다른 화면화면*/
/*	if($("#no").attr("checked") =="checked"){
		$("#no_member").show();
		$("#member").hide();
		$("#info2").hide();
	}*/
	$("input[type='radio']").change(function(e) {
		$("error,error1").hide();
		if($(this).val()=="MEMBER"){
			$("#member").show();
			$("#no_member").hide();
			$("admin").hide();
			$("#info2").show();
		}else if($(this).val()=="NONMEMBER"){
			$("#no_member").show();
			$("#member").hide();
			$("admin").hide();
			$("#info2").hide();
		}else if($(this).val()=="ADMIN"){
			$("#no_member").hide();
			$("#member").hide();
			$("admin").show();
			$("#info2").hide();
			$("#info").find("h2").text("관리자를 위한 화면입니다");
			$("#info").find("h3").text("회원,비회원 님은 다른 페이지를 이용해주세요");
		}
	})
	
	$("input").each(function(i, obj) {
		$(obj).focusin(function(e) {
			$(this).css("border","1px solid #3e2b2c");

		});
		$(obj).blur(function(e) {
			
			$(this).css("border","1px solid #ccc");
		});
	});
})

