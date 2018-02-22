	var id_check=-1;	
	var no_pw = -1;
	var not_email = -1;
	$(function(){
	
		
	for(var i=1999;i>1899;i--){
		$("select[name='birth_y']").append("<option value='"+i+"'>"+i+"</option>");
	}
	for(var i=1;i<13;i++){
		$("select[name='birth_m']").append("<option value='"+i+"'>"+i+"</option>");
	}
	for(var i=1;i<32;i++){
		$("select[name='birth_d']").append("<option value='"+i+"'>"+i+"</option>");
	}
/*주소록 검색하기*/	
	$("#search_addr").click(function(){
		$.ajax({
			url:"post.do",
			type:"get",
			data:{"doro":$("#doro").val()},
			dataType:"json",
			success:function(json){
				console.log(json);
				
				$("#addr_content").empty();
				
				var data = "";
				
				if(json.length==0){
					data="<span id='no_search'>검색내역이 없습니다. 도로명 주소를 다시 입력해주세요</span>";
				}else{
					data = "<table id='addr_data'>";
					for(var i=0;i<json.length;i++){

						data+="<tr class='addr_sel'><th>"+json[i].zipCode+"</th>";
						data+="<td>"+json[i].sido+" "+json[i].sigungu+" "+json[i].doro+" "+json[i].building1+"</td></tr>";

					}
					data+="</table>";
				}
				$("#addr_content").append(data);
				
		
			}			
			
		})
		return false;
	})
	
	$("#addr_btn").click(function(){
		$("#addr_bg").css("display","block");
		$("#addr_box").css("display","block");
		
	})
	$("#addr_img > img").click(function(){
			$("#addr_box").css("display","none");
			$("#addr_bg").css("display","none");
		})

	$(document).on("mouseover",".addr_sel",function(){
		$(this).css("background-color","#fbfbfb");
	})
	
	$(document).on("mouseout",".addr_sel",function(){
		$(this).css("background-color","white");
	})
		
	$(document).on("click",".addr_sel",function(){
		var zipcode = $(this).find("th").text();
		var addr = $(this).find("td").text();
		
		$("#addr_box").css("display","none");
		$("#addr_bg").css("display","none");
		
		$("#zipcode").val(zipcode);
		$("#addr_main").val(addr);
		$("#addr_detail").removeAttr("readonly");
		$("#addr_detail").focus();
		
	})
	/*input에 focus가 가면 테두리 색으로 변경을 해준다*/
		$("input").each(function(i, obj) {
				var left ="";
				var top ="";
				var width="";
			
					
				$(obj).focus(function(){
					$(this).css("border","1px solid #3e2b2c");
					$(".x-btn").hide();
					left = $(this).position().left;
					top = $(this).position().top+5;
					width =$(this).outerWidth()-25;
					$(this).next("img").css('display',"block");
					$(this).next("img").css({"top":top,"left":left+width,"padding":"10px;"});
				
						
				
				});
					
				$(obj).blur(function(){
					
					$(this).css("border","1px solid #ccc");
						$("img").click(function(){
							$(this).css("display","block");
							$(this).prev().val("");
						});	
						
						
					})
				});
		/*email 체크하기*/
		$("#sel_email").change(function(){
			$("input[name='email2'").val($(this).val());
		});	
		
		$("#email_btn").click(function(){
			
			$(this).next(".error").css("display","none");
			
			if($("#email1").val()==""||$("#email2").val()==""){
				alert("이메일을 입력하세요");
				$("#email1").focus();
				return false;
			}
			$.ajax({
				url:"duplicateEmail.do",
				type:"get",
				data:{"email1":$("#email1").val(),
						"email2":$("#email2").val()},
						dataType:"json",
						success:function(data){
							if(data.email ==null){
								$("#email_duplicate").css("display","inline");
								$("#email_duplicate_error").css("display","none");
								not_email=1;
							}else{
								$("#email_duplicate").css("display","none");
								$("#email_duplicate_error").css("display","inline");
							}
						}
			})
			return false;
		})
		$(document).on("keyup","input[name='p2'],input[name='t2']",function(e){
			
			if($(this).val().length==4){
				$(this).nextAll("input").focus();
			}
	})

			
	$("input[name='pw']").keyup(function(){
		/*최소 대문자 하나와 소문자 하나, 숫자, 특수문자를 하나이상 포함해야한다.*/
		var reg =/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,20}$/;
		var password = $("input[name='pw']").val();
		var noNum = true;
	
		if(/(\w)\1\1/.test(password)){
			noNum=false;
		}
		
		if(reg.test(password)&&noNum){
			$("#pw_reg").css("display","inline");
			$("#pw_reg_error").css("display","none");
			$("#id_check_btn").attr("disable",true);
			no_pw=1;
		}else{
			$("#pw_reg").css("display","none");
			$("#pw_reg_error").css("display","inline");
		}
		
	})
	/*아이디 정규표현 검사*/
	$("input[name='id']").keyup(function(){
		$("#id_rule_error").prevAll(".error");
		var reg =/^(?=.*[A-Za-z])[A-Za-z0-9]{5,12}$/;
		var reg2 = /^[A-Za-z]{5,12}$/
		var id = $("input[name='id']").val();
		$(this).nextAll(".error, #id_error,#id_error2,#click").css("display","none");
		if(reg.test(id)||reg2.test(id)){
			$("#click").css("display","inline");
			$("#id_rule_error").css("display","none");
			idOk();
		}else{
			$("#id_rule_error").css("display","inline");
			$("#click").css("display","none");
			$("#id_check_btn").click(function(e){
				  e.preventDefault();
			})
		}
		
	})
		
	
	
	/*회원가입버튼을 눌렀을때 처리되는 예외사항과 기타 비밀번호 처리 */
		pwOk();		
	$("#join_btn").click(function(){
		$("#click,#pw_reg_error").css("display","none");
		var empty = emptyOk();
		var select =selectempty();
		if($("input[name='pw']").val()!= $("#pw_ok").val()){
			$("#okPw").css("display","none");
			$("#noPw").css("display","inline");	
			return false;
		}
		if(id_check==-1){
			alert("아이디 중복을 확인해주세요");
			return false;
		}
		if(not_email==-1){
			alert("이메일 중복을 확인해주세요");
			return false;
		}
		if(no_pw==-1){
			$("#pw_reg_error").css("display","inline");
			return false;
		}
		if(empty&&select){
			$("#join").submit();
			return true;
		}else{
			return false;
		}
	
	})	
	
	
	/*비밀번호 안내문*/
	$("#pw_import").hover(function() {
		var left = $(this).offset().left+30;
		var top = $(this).offset().top+3;
		$("#pw_info").css({"display":"block","left":left,"top":top});
	}, function() {
	 	$("#pw_info").css("display","none"); 
	}) 

	})
	
function emptyOk(){
		var error = false;
		$(".import").each(function(i,obj){
		
			if($(this).val()==""){
				$(this).nextAll(".error").css("display","inline");
				error =  false;
			}else{
				$(this).nextAll(".error").css("display","none");
				error =  true;
			}
		})	
		
		return error;

}
function idOk(){
	$("#id_check_btn").click(function(){
		
		$.ajax({
			url:"duplicateId.do",
			type:"get",
			data:{"id":$("input[name='id']").val()},
			dataType:"json",
			success:function(data){
				
				if(data.id ==null){
					$("#click").css("display","none");
					$("#id_error").css("display","inline");
					$("#id_error2").css("display","none");
					id_check=1;
				}
				else{
					$("#click").css("display","none");
					$("#id_error").css("display","none");
					$("#id_error2").css("display","inline");
				}
				console.log(data);
			}
		})
		return false;
	})	
}
function selectempty(){
	var error = false;
	$(".import2").each(function(i,obj){
		if($(this).val()==""){
			$(this).parent().nextAll(".error").css("display","inline");
			error =false;
		}else{
			$(this).parent().nextAll(".error").css("display","none");
			error =true;
		}
	})
	
	return error;
}
function pwOk(){

	$("#pw_ok").keyup(function(){
		if($("input[name='pw']").val()== $("#pw_ok").val()){
			$("#noPw").css("display","none");
			$("#okPw").css("display","inline");
		}else{
			$("#okPw").css("display","none");
			$("#noPw").css("display","inline");	
		}
	})
	
}

