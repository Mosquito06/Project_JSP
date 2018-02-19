
$(function(){
	/*회원일때와 비회원일때 다른 화면화면*/
	if($("#no").attr("checked") =="checked"){
		$("#no_member").show();
		$("#member").hide();
		$("#info2").hide();
		$("#admin").hide();
	}
	if($("#ad").attr("checked")=="checked"){
		$("#no_member").hide();
		$("#member").hide();
		$("#info2").hide();
		$("#admin").show();
	}
	
	$("input[type='radio']").change(function(e) {
		$(".error,.error1").hide();
		if($(this).val()=="MEMBER"){
			$("#member").show();
			$("#no_member").hide();
			$("#admin").hide();
			$("#info2").show();
		}else if($(this).val()=="NONMEMBER"){
			$("#no_member").show();
			$("#member").hide();
			$("#admin").hide();
			$("#info2").hide();
		}else if($(this).val()=="ADMIN"){
			$("#no_member").hide();
			$("#member").hide();
			$("#admin").show();
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
	
	$("#admin_btn").click(function(){
		$("#admin_form").submit();
		return false;
	})

	$("#nomember_btn").click(function(){
		$("#no_member_form").submit();
		return false;
	})

	$("#member_btn").click(function(){
		$("#member_form").submit();
		return false;
	})
	
	$("#close").click(function(){
		$("#pop_search_id").css("display","none");
		$("#bodybg").css("display","none");
		$("input").each(function(i,obj){
			$(obj).val("");
		})
		return false;
	})
	/*아이디 찾기 버튼을 클릭했을때*/
	$("#searchId").click(function(){
		var screen = $(document).height();
		$("#headerWrap").css("z-index","1");
		$("#pop_search_id").css("display","block");
		$("#bodybg").css({"display":"block","height":screen});
		return false;
	})
	/*모두 입력하고 아이디 찾기 했을때*/
	$("#search_id").click(function(){
		
		var empty = isEmpty();
		
		if(!empty){
			alert("이름,이메일을 모두 입력해야 합니다.");
			return false;
		}
		
		if(empty){
			$.ajax({
				url:"findId.do",
				type:"get",
				data:{"email":$("#email_id").val(),
					"nameEn2":$("#en1").val(),
					"nameEn1":$("#en2").val()},
				dataType:"json",
				success:function(data){
					console.log(data);
				}
						
			})
		}
		
		return false;
		
	})
	
	
	
})

function isEmpty(){
	var err = true;
	$(".search_id_input").each(function(i,obj){
		if($(obj).val()==""){
			err=false;
		}
		
	})
	return err;
}

