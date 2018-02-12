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
				$("#addr_content").empty();
				var data="";
				console.log(json);
				
				if(json.length==0){
					data="<ul>";
					data +="<li>검색 결과가 없습니다.</li>";
					data+="</ul>";
				}else{
					for(var i=0;i<json.length;i++){
						data="<ul>";
						data+="<li>"+json[i].zipCode+"</li>";
						data+="<li>"+json[i].sido+" "+json[i].sigungu+" "+json[i].doro+" "+json[i].building1+"</li>";

						data+="</ul>";

						$("#addr_content").append(data);
					}
					
				}
			
			
				

			}			
			
		})
	})
	
	$("#addr_btn").click(function(){
		$("#addr_bg").css("display","block");
		$("#addr_box").css("display","block");
		
	})
	
	
	
	/*input에 focus가 가면 테두리 색으로 변경을 해준다*/
		$("input").each(function(i, obj) {
				var left ="";
				var top ="";
				var width="";
			
					
				$(obj).focus(function(){
					$(this).css("border","1px solid #3e2b2c");
					$("img").hide();
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
		
		$(document).on("keydown","input[name='p2'],input[name='p3'],input[name='t2'],input[name='t3']",function(e){
			
			if($(this).val().length==4){
				e.preventDefault();
			}
	})
		
		
	})
	


