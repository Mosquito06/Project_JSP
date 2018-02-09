$(function(){

	/*input에 focus가 가면 테두리 색으로 변경을 해준다*/
	
		$("input").each(function(i, obj) {
			var left ="";
			var top ="";
			var width="";
		$(obj).focusin(function(e) {
			$(this).css("border","1px solid #3e2b2c");
			
			if($(obj).val()==""){
				$(obj).keydown(function(e) {
					left = $(this).position().left;
					top = $(this).position().top+5;
					width =$(this).outerWidth();
					alert(width);
					$(this).next().show();
					$(this).next().css({"top":top,"left":left+width});
				})
			}else if($(this).val()!=""){
				left = $(this).position().left;
				top = $(this).position().top+5;
				width =$(this).width();
				$(this).next().show();
			}
			
		});
		
		$(obj).blur(function(e) {
			$(this).css("border","1px solid #ccc");
			$(this).next().hide();
		});
	});
	/*email 체크하기*/
		$("#sel_email").change(function(){
			$("input[name='email2'").val($(this).val());
		});
	
})