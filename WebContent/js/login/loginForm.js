
$(function(){
	var screen = $(document).height();
	
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
		$("#title_find_id").html("");
		$("#input_info").css("display","block");
		$("#original_btn").css("display","block");
		$("#after_find_id_btn").css("display","none");
		$("#find_info").empty();
		$("#pop_id_err").html("");
		$("#title_find_id").html("");
		$("input").each(function(i,obj){
			$(obj).val("");
		})
		return false;
	})
	
	$(document).on("click","#close_pop",function(){
		$("#pop_search_id").css("display","none");
		$("#bodybg").css("display","none");
		$("#title_find_id").html("");
		$("#input_info").css("display","block");
		$("#original_btn").css("display","block");
		$("#after_find_id_btn").css("display","none");
		$("#find_info").empty();
		$("#pop_id_err").html("");
		$("#title_find_id").html("");
		$("input").each(function(i,obj){
			$(obj).val("");
		})
		return false;
	})
	$(document).on("click","#pop_search_pw_btn",function(){
		$("#pop_search_pw").css("display","block");
		$("#close").trigger("click");
		$("#bodybg").css({"display":"block","height":screen});
	})
	/*비밀번호 찾기에서 x이미지 또는 취소 버튼을 눌렀을때 */
	$(document).on("click",".close_pop_pw",function(){
		$("#bodybg").css("display","none");
		$("#pop_search_pw").css("display","none");
		$(".pw_input_import").each(function(i,obj){
			$(obj).val("");
			
		})
	})
	/*로그인 화면에서 비밀번호 찾기 버튼을 눌렀을때*/
	$("#searchPw").click(function(){
		$("#pop_search_pw").css("display","block");
		$("#bodybg").css({"display":"block","height":screen});
		return false;
	})
	/*비밀번호 찾기 화면에서 아이디 찾기 화면으로 넘어가기*/
	$(document).on("click","#other_search",function(){
		$(".close_pop_pw").trigger("click");
		$("#pop_search_id").css("display","block");
		$("#bodybg").css({"display":"block","height":screen});
		return false;
	})
	/*아이디 찾기 버튼을 클릭했을때*/
	$("#searchId").click(function(){
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
					if(data.client==null){
						$("#pop_id_err").html("<br>*가입된 정보가 없습니다. 입력한 정보를 확인해주세요.");
					}else{
						$("#pop_id_err").html("");
						$("#title_find_id").html("<p>신라리워즈 아이디찾기 결과는 아래와 같습니다.</p>");
						$("#input_info").css("display","none");
						$("#original_btn").css("display","none");
						$("#after_find_id_btn").css("display","block");
						$("#find_info").append("<span id='find_name'>"+data.client.nameEn+"</span><br><br>"
												+"<span>ID - </span><span id='find_id'>["+data.client.id+"]</span>");
					}
				}
						
			})
		}
		
		return false;
		
	})
	/*임시 비밀번호 보내는거 확인하는 절차*/
	$(document).on("click","#send_email_btn",function(){
		$.ajax({
			url:"tempPqssword.do",
			type:"get",
			data:{	"id":$("#pw_id").val(),
					"nameEn1":$("#pw_en1").val(),
					"nameEn2":$("#pw_en2").val(),
					"email":$("#pw_email").val()},
			dataType:"json",
			success:function(data){
				if(data.client==null){
					alert("회원정보가 없습니다");
				}else{
					
				}
					console.log(data);
			
			}
			
		})
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

