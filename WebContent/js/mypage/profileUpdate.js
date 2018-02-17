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
							"addr1":$("#zipcode").val(),
							"addr2":$("#addr_main").val(),
							"addr3":$("#addr_detail").val()
						},
						dataType:"json",
						success:function(data){
							alert("프로필이 수정되었습니다.");
							
							var email = data.client.email;
							var email1 = email.substring(0, email.indexOf("@"));
							var email2 = email.substring(email.indexOf("@")+1);
							$("#email1").val(email1);
							$("#email2").val(email2);
							
							var address =data.client.address;
							var zipcode = address.substring(0, address.indexOf("/"));
							var address1 = address.substring(address.indexOf("/")+1,address.lastIndexOf("/"));
							var address2 = address.substring(address.lastIndexOf("/")+1);
							
							$("#zipcode").val(zipcode);
							$("#addr_main").val(address1);
							$("#addr_detail").val(address2);
							
							$("#phone").val(data.client.phone);
							$("#tel").val(data.client.home);
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
	
	/*주소록*/
	
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
	
	$("#addressBtn").click(function(){
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
		$("#addr_detail").val("");
		$("#addr_detail").removeAttr("readonly");
		$("#addr_detail").focus();
		
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
